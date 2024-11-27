package edu.uc.cs3003.medava;

import java.util.List;
import java.util.ArrayList;

public class Transporter {

    // Field to store the name of the transporter
    private String mTransporterName;

    // Field to store the goods being transported (generic Object)
    private List<Object> goods;

    // Fields to store the acceptable temperature range
    private double mLowTemperature;
    private double mHighTemperature;

    // Constructor to initialize the transporter name and temperature range
    public Transporter(String transporterName, double lowTemp, double highTemp) {
        this.mTransporterName = transporterName;
        this.mLowTemperature = lowTemp;
        this.mHighTemperature = highTemp;
        this.goods = new ArrayList<>();
    }

    // Getter to access the transporter name
    public String getTransporterName() {
        return mTransporterName;
    }

    // Method to simulate shipping the goods
    public void ship() {
        // Do some shipping!
    }

    // Method to load an item into the transporter
    public boolean load(Object itemToLoad) {
        // Check if the item is a Medicine
        if (itemToLoad instanceof Medicine) {
            Medicine medicine = (Medicine) itemToLoad;
            if (medicine.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
                System.out.println(String.format("Adding a %s to the transporter.", medicine.getMedicineName()));
                goods.add(itemToLoad);
                return true;
            }
        }
        // Check if the item is a Jarvik device or other objects with temperature checks
        else if (itemToLoad instanceof Jarvik) {
            Jarvik device = (Jarvik) itemToLoad;
            if (device.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
                System.out.println(String.format("Adding a %s to the transporter.", device.getMedicineName()));
                goods.add(itemToLoad);
                return true;
            }
        }
        return false;
    }

    // Method to unload an item from the transporter
    public Object unload() {
        return goods.isEmpty() ? null : goods.remove(0);
    }

    // Method to check if the transporter is empty
    public boolean isEmpty() {
        return goods.isEmpty();
    }
}





