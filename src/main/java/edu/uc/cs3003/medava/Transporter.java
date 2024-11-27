package edu.uc.cs3003.medava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Transporter {

    private String mTransporterName;
    private List<Object> goods;
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

    public boolean load(Object itemToLoad) {
        try {
            Method isTemperatureRangeAcceptableMethod = itemToLoad.getClass().getMethod("isTemperatureRangeAcceptable",
                    Double.class, Double.class);
            boolean resultOfMethodCall = (boolean) isTemperatureRangeAcceptableMethod.invoke(itemToLoad,
                    Double.valueOf(mLowTemperature), Double.valueOf(mHighTemperature));
            if (resultOfMethodCall) {
                System.out.println(String.format("Adding a %s to the transporter.", 
                        itemToLoad.getClass().getMethod("getMedicineName").invoke(itemToLoad)));
                goods.add(itemToLoad);
            }
            return resultOfMethodCall;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            return false;
        }
    }

    public Object unload() {
        return goods.isEmpty() ? null : goods.remove(0);
    }

    public boolean isEmpty() {
        return goods.isEmpty();
    }
}






