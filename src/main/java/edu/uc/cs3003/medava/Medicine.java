package edu.uc.cs3003.medava;

public class Medicine {
    // Field to store the name of the medicine
    private String mMedicineName;

    // Constructor to initialize the medicine name
    public Medicine(String medicineName) {
        this.mMedicineName = medicineName;
    }

    // Getter to access the medicine name
    public String getMedicineName() {
        return mMedicineName;
    }

    // Method to check if the temperature range is acceptable for the medicine
    public boolean isTemperatureRangeAcceptable(Double lowTemperature, Double highTemperature) {
        if (this.minimumTemperature() <= lowTemperature &&
                highTemperature <= this.maximumTemperature()) {
            return true;
        }
        return false;
    }

    // Default implementation of minimum temperature
    public double minimumTemperature() {
        return 0.0;
    }

    // Default implementation of maximum temperature
    public double maximumTemperature() {
        return 100.0;
    }
}


