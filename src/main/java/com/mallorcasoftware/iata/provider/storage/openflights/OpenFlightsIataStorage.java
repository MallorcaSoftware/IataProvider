package com.mallorcasoftware.iata.provider.storage.openflights;

import com.mallorcasoftware.iata.provider.model.IataData;
import com.mallorcasoftware.iata.provider.storage.memory.MemoryIataStorage;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OpenFlightsIataStorage extends MemoryIataStorage {
    private CSVReader csvReader;

    public OpenFlightsIataStorage(InputStream inputStream) {
        this.csvReader = new CSVReader(new InputStreamReader(inputStream));
        this.init();
    }

    private void init() {
        ArrayList iataDataList = new ArrayList();

        String[] data;
        try {
            while ((data = this.csvReader.readNext()) != null) {
                String airportName = data[1].replace("\"", "");
                String city = data[2].replace("\"", "");
                String country = data[3].replace("\"", "");
                String iataCode = data[4].replace("\"", "");
                String icao = data[5].replace("\"", "");
                String latitude = data[6];
                String longitude = data[7];
                if (!iataCode.isEmpty()) {
                    IataData iataData = new IataData();
                    iataData.setName(airportName);
                    iataData.setCity(city);
                    iataData.setCountry(country);
                    iataData.setIata(iataCode);
                    iataData.setIcao(icao);
                    iataData.setLatitude(Float.parseFloat(latitude));
                    iataData.setLongitude(Float.parseFloat(longitude));
                    iataDataList.add(iataData);
                }
            }
        } catch (IOException var11) {
            var11.printStackTrace();
        }

        this.setIataDataList(iataDataList);
    }
}
