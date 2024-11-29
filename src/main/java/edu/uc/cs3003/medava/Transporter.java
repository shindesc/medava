package edu.uc.cs3003.medava;

import java.util.ArrayList;
import java.util.List;

public class Transporter {

    private String mTransporterName;
    private List<Shippable> goods;
    private double mLowTemperature;
    private double mHighTemperature;

    public Transporter(String transporterName, double lowTemp, double highTemp) {
        this.mTransporterName = transporterName;
        this.mLowTemperature = lowTemp;
        this.mHighTemperature = highTemp;
        this.goods = new ArrayList<>();
    }

    public String getTransporterName() {
        return mTransporterName;
    }

    public void ship() {
        // Optional implementation for actual shipping operations
    }

    public boolean load(Shippable itemToLoad) {
        if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
            System.out.println(String.format("Sending %s on the %s transporter.", 
                    itemToLoad.getMedicineName(), mTransporterName));
            goods.add(itemToLoad);
            return true;
        }
        return false;
    }

    public Shippable unload() {
        return goods.isEmpty() ? null : goods.remove(0);
    }

    public boolean isEmpty() {
        return goods.isEmpty();
    }
}







