package com.mallorcasoftware.iata.provider;

import com.mallorcasoftware.iata.provider.model.IataData;
import com.mallorcasoftware.iata.provider.storage.IataStorage;
import com.mallorcasoftware.iata.provider.storage.openflights.OpenFlightsIataStorage;

public class Application {
    public static void main(String[] args) {
        System.out.println("IataProvider");

        IataStorage iataStorage = new OpenFlightsIataStorage(
            ClassLoader.class.getResourceAsStream("/airports.dat")
        );
        IataProvider iataProvider = new IataProvider(iataStorage);

        IataData eddh = iataProvider.getIataDataByIataCode("HAM");

        System.out.println(eddh);

        IataData nearestByLatLng = iataProvider.getNearestByLatLng(53.40F, 9.98F);

        System.out.println(nearestByLatLng);
    }
}
