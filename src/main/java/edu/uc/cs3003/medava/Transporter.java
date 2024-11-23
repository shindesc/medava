package edu.uc.cs3003.medava;

import java.util.List;
import java.util.ArrayList;

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
        // Do some shipping!
    }

    public boolean load(Shippable itemToLoad) {
        if (itemToLoad.isTemperatureRangeAcceptable(mLowTemperature, mHighTemperature)) {
            System.out.println(String.format("Sending %s on the %s transporter.", itemToLoad.getMedicineName(), mTransporterName));
            return goods.add(itemToLoad);
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




