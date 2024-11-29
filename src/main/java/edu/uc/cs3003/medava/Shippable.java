package edu.uc.cs3003.medava;
import edu.uc.cs3003.medava.MedicineSchedule;

public interface Shippable {
    boolean isTemperatureRangeAcceptable(int low, int high);
    String getMedicineName();
    MedicineSchedule getSchedule();
}


