package com.fm.store.shipping;

import com.shippo.Shippo;
import com.shippo.exception.ShippoException;
import com.shippo.model.Address;
import com.shippo.model.Parcel;
import com.shippo.model.Shipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ShippingServiceTest {

    static boolean VERBOSE_TESTING = true;

    @BeforeEach
    void setUp() {
        Shippo.apiKey = "shippo_test_eb0d0fa28f4c2f193e78e044ec17b74d85423978";
        Shippo.apiVersion = "2018-02-08";
    }

    @Test
    void shipProducts() {
    }

    public static Object getDefaultObject() {
        Address addressFrom = (Address) createAddressFrom();
        Address addressTo = (Address) createAddressTo();
        Parcel parcel = (Parcel) createParcel();

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(parcel);

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("address_from", addressFrom.getObjectId());
        objectMap.put("address_to", addressTo.getObjectId());
        objectMap.put("parcels", parcels);
        objectMap.put("extra", "{\"signature_confirmation\": true}");
        objectMap.put("customs_declaration", null);
        objectMap.put("shipment_date", df.format(new Date()));
        objectMap.put("metadata", "Customer ID 123456");
        objectMap.put("async", false);

        try {
            Shipment testObject = Shipment.create(objectMap);
            return testObject;
        } catch (ShippoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object createAddressFrom() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("name", "Undefault New Wu");
        objectMap.put("company", "Shippo");
        objectMap.put("street1", "Ing. Alexandru Iacovache");
        objectMap.put("street_no", "5");
        objectMap.put("street2", null);
        objectMap.put("city", "Bucharest");
        objectMap.put("state", "CA");
        objectMap.put("zip", "94117");
        objectMap.put("country", "RO");
        objectMap.put("phone", "+40723187106");
        objectMap.put("email", "test@gmail.com");
        objectMap.put("is_residential", true);
        objectMap.put("metadata", "Customer ID 123456");

        try {
            Address testObject = Address.create(objectMap);
            return testObject;
        } catch (ShippoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object createAddressTo() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("name", "Second New Wu");
        objectMap.put("company", "Hippo");
        objectMap.put("street1", "965 Mission St");
        objectMap.put("street2", null);
        objectMap.put("city", "San Francisco");
        objectMap.put("state", "CA");
        objectMap.put("zip", "94103");
        objectMap.put("country", "US");
        objectMap.put("phone", "+40723187056");
        objectMap.put("email", "test@gmail.com");
        objectMap.put("is_residential", false);
        objectMap.put("metadata", "Customer ID 1234567");

        try {
            Address testObject = Address.create(objectMap);
            return testObject;
        } catch (ShippoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object createParcel() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("length", "5");
        objectMap.put("width", "5");
        objectMap.put("height", "5");
        objectMap.put("distance_unit", "cm");
        objectMap.put("weight", "2");
        objectMap.put("mass_unit", "kg");
        objectMap.put("template", null);
        objectMap.put("metadata", "Customer ID 123456");

        try {
            Parcel testObject = Parcel.create(objectMap);
            return testObject;
        } catch (ShippoException e) {
            e.printStackTrace();
        }
        return null;
    }
}