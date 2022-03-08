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
        Shipment shipment = createShipment();
        assertThat(shipment.getStatus()).isEqualTo("SUCCESS");
        Address addressTo = (Address) shipment.getAddressTo();
        assertThat(addressTo.getIsComplete()).isTrue();
    }

    public static Shipment createShipment() {
        Address addressFrom = createAddressFrom();
        Address addressTo = createAddressTo();
        Parcel parcel = createParcel();

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
        objectMap.put("shipment_date", df.format(new Date()));      // shipment_date -> 2021-06-29T17:17:11Z
        objectMap.put("metadata", "Customer ID 123456");
        objectMap.put("async", false);

        try {
            Shipment shipment = Shipment.create(objectMap);
            return shipment;
        } catch (ShippoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Address createAddressFrom() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("name", "From name");
        objectMap.put("company", "From company");
        objectMap.put("street1", "Aleea Rotunda");
        objectMap.put("street_no", "5");
        objectMap.put("street2", null);
        objectMap.put("city", "Bucharest");
        objectMap.put("zip", "032705");
        objectMap.put("country", "RO");
        objectMap.put("phone", "+40723444555");
        objectMap.put("email", "test@gmail.com");
        objectMap.put("metadata", "Customer ID 123456");

        try {
            Address address = Address.create(objectMap);
            return address;
        } catch (ShippoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Address createAddressTo() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("name", "To name");
        objectMap.put("company", "To company");
        objectMap.put("street1", "Strada Frigului");
        objectMap.put("street_no", "3");
        objectMap.put("street2", null);
        objectMap.put("city", "Bucharest");
        objectMap.put("zip", "040584");
        objectMap.put("country", "RO");
        objectMap.put("phone", "+40723777888");
        objectMap.put("email", "test2@gmail.com");
        objectMap.put("metadata", "Customer ID 123457");

        try {
            Address address = Address.create(objectMap);
            return address;
        } catch (ShippoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Parcel createParcel() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("length", "5");
        objectMap.put("width", "5");
        objectMap.put("height", "5");
        objectMap.put("distance_unit", "cm");
        objectMap.put("weight", "1");
        objectMap.put("mass_unit", "kg");
        objectMap.put("template", null);
        objectMap.put("metadata", "Customer ID 123456");

        try {
            Parcel parcel = Parcel.create(objectMap);
            return parcel;
        } catch (ShippoException e) {
            e.printStackTrace();
        }
        return null;
    }
}