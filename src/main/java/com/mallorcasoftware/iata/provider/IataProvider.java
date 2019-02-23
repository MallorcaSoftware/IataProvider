package com.mallorcasoftware.iata.provider;

import com.mallorcasoftware.iata.provider.model.IataData;
import com.mallorcasoftware.iata.provider.storage.IataStorage;

public class IataProvider {
    private IataStorage iataStorage;

    public IataProvider(IataStorage iataStorage) {
        this.iataStorage = iataStorage;
    }

    public IataData getIataDataByIataCode(String iataCode) {
        return this.iataStorage.getIataDataByIataCode(iataCode);
    }

    public IataData getNearestByLatLng(float lat, float lng) {
        return this.iataStorage.getNearestByLatLng(lat, lng);
    }
}
