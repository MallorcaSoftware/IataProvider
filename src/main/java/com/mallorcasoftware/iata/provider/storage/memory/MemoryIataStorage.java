package com.mallorcasoftware.iata.provider.storage.memory;

import com.mallorcasoftware.iata.provider.model.IataData;
import com.mallorcasoftware.iata.provider.storage.IataStorage;

import java.util.*;

public class MemoryIataStorage implements IataStorage {
    private List<IataData> iataDataList = new ArrayList<IataData>();
    private Map<String, IataData> iataDataByIataCode = new HashMap<String, IataData>();

    public MemoryIataStorage() {
    }

    public MemoryIataStorage(List<IataData> iataDataList) {
        this.setIataDataList(iataDataList);
    }

    public List<IataData> getIataDataList() {
        return this.iataDataList;
    }

    public void setIataDataList(List<IataData> iataDataList) {
        this.iataDataList = iataDataList;
        this.init();
    }

    public IataData getIataDataByIataCode(String iataCode) {
        return (IataData)this.iataDataByIataCode.get(iataCode);
    }

    public IataData getNearestByLatLng(float lat, float lng) {
        IataData nearest = null;
        Iterator i$ = this.getIataDataList().iterator();

        while(i$.hasNext()) {
            IataData iataData = (IataData)i$.next();
            if (nearest == null) {
                nearest = iataData;
            } else if (this.distance((double)lat, (double)lng, (double)nearest.getLatitude(), (double)nearest.getLongitude()) > this.distance((double)lat, (double)lng, (double)iataData.getLatitude(), (double)iataData.getLongitude())) {
                nearest = iataData;
            }
        }

        return nearest;
    }

    private double distance(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 3958.75D;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2.0D);
        double sindLng = Math.sin(dLng / 2.0D);
        double a = Math.pow(sindLat, 2.0D) + Math.pow(sindLng, 2.0D) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double c = 2.0D * Math.atan2(Math.sqrt(a), Math.sqrt(1.0D - a));
        return earthRadius * c;
    }

    private void init() {
        this.iataDataByIataCode.clear();
        Iterator i$ = this.iataDataList.iterator();

        while(i$.hasNext()) {
            IataData iataData = (IataData)i$.next();
            this.iataDataByIataCode.put(iataData.getIata(), iataData);
        }

    }
}
