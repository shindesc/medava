package edu.uc.cs3003.medava;

public interface Shippable {
    MedicineSchedule getSchedule();
    String getMedicineName();
    boolean isTemperatureRangeAcceptable(Double lowTemperature, Double highTemperature);
}
