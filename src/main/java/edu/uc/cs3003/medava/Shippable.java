public interface Shippable {
    boolean isTemperatureRangeAcceptable(int low, int high);
    String getMedicineName();
    MedicineSchedule getSchedule();
}


