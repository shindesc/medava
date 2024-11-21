package edu.uc.cs3003.medava;

public class Medicine {
    private String name;
    private String manufacturer;
    private String expirationDate;
    private int quantity;

  // Constructor
    public Medicine(String name, String manufacturer, String expirationDate, int quantity) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
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
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}


