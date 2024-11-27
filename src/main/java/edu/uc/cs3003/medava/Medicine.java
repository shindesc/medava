
package edu.uc.cs3003.medava;

import java.time.LocalDate;

public abstract class Medicine implements Shippable {
    private String name;
    private String manufacturer;
    private String expirationDate;
    private int quantity;
    private String mMedicineName;

    // Constructor to initialize all attributes
    public Medicine(String name, String manufacturer, String expirationDate, int quantity) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    // Constructor to initialize the medicine name
    public Medicine(String medicineName) {
        this.mMedicineName = medicineName;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getMedicineName() {
        return mMedicineName;
    }

    @Override
    public boolean isTemperatureRangeAcceptable(Double lowTemperature, Double highTemperature) {
        return this.minimumTemperature() <= lowTemperature && highTemperature <= this.maximumTemperature();
    }

    // Method to check if the medicine is expired
    public boolean isExpired() {
        // Assuming expirationDate is in the format "YYYY-MM-DD"
        LocalDate currentDate = LocalDate.now();
        LocalDate expDate = LocalDate.parse(expirationDate);
        return currentDate.isAfter(expDate);
    }

    // Method to update the quantity
    public void updateQuantity(int amount) {
        this.quantity += amount;
    }

    @Override
    public abstract MedicineSchedule getSchedule();

    // Default implementation of minimum temperature (removed @Override annotation)
    public double minimumTemperature() {
        return 0.0;
    }

    // Default implementation of maximum temperature (removed @Override annotation)
    public double maximumTemperature() {
        return 100.0;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}






