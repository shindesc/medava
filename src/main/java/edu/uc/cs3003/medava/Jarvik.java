package edu.uc.cs3003.medava;

public class Jarvik implements Shippable {
    private String serialNumber;

    // Constructor to initialize the serial number of the device
    public Jarvik(String deviceSerialNumber) {
        serialNumber = deviceSerialNumber;
    }

    @Override
    public String getMedicineName() {
        return "Jarvik Artificial Heart";
    }

    @Override
    public MedicineSchedule getSchedule() {
        return MedicineSchedule.Uncontrolled; // Represents an uncontrolled device
    }

    @Override
    public boolean isTemperatureRangeAcceptable(Double lowTemperature, Double highTemperature) {
        // Check if the temperature range is acceptable for the Jarvik Artificial Heart
        return (30.0 <= lowTemperature && highTemperature <= 90.0);
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}



