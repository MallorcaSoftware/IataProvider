package com.mallorcasoftware.iata.provider.storage;

import com.mallorcasoftware.iata.provider.model.IataData;

public interface IataStorage {
    IataData getIataDataByIataCode(String iatacode);

    IataData getNearestByLatLng(float lat, float lng);
}
