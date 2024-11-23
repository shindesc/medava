package edu.uc.cs3003.medava;

public class Jarvik implements Shippable {
    private String serialNumber;

    public Jarvik(String deviceSerialNumber) {
        serialNumber = deviceSerialNumber;
    }

    @Override
    public String getMedicineName() {
        return "Jarvik Artificial Heart";
    }

    @Override
    public MedicineSchedule getSchedule() {
        return MedicineSchedule.Uncontrolled;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public boolean isTemperatureRangeAcceptable(Double lowTemperature, Double highTemperature) {
        return 30.0 <= lowTemperature && highTemperature <= 90.0;
    }
}



