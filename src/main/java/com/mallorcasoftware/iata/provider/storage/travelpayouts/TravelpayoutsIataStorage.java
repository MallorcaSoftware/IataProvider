package com.mallorcasoftware.iata.provider.storage.travelpayouts;

import com.google.gson.Gson;
import com.mallorcasoftware.iata.provider.model.IataData;
import com.mallorcasoftware.iata.provider.storage.memory.MemoryIataStorage;
import com.mallorcasoftware.iata.provider.storage.travelpayouts.param.Airport;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TravelpayoutsIataStorage extends MemoryIataStorage {
    private ArrayList airportList;

    public TravelpayoutsIataStorage(InputStream inputStream) {
        Gson gson = new Gson();
        Airport[] airports = (Airport[]) gson.fromJson(new InputStreamReader(inputStream), Airport[].class);
        this.airportList = new ArrayList(Arrays.asList(airports));
        this.init();
    }

    private void init() {
        List<IataData> iataDataList = new ArrayList();
        Iterator i$ = this.airportList.iterator();

        while (i$.hasNext()) {
            Airport airport = (Airport) i$.next();
            IataData iataData = new IataData();
            iataData.setName(airport.getName());
            iataData.setIata(airport.getCode());
            iataData.setLatitude(airport.getCoordinates().getLat());
            iataData.setLongitude(airport.getCoordinates().getLon());
            iataData.setCity(airport.getCityCode());
            iataData.setCountry(airport.getCountryCode());
            iataDataList.add(iataData);
        }

        this.setIataDataList(iataDataList);
    }
}