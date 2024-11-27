package edu.uc.cs3003.medava;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Hospital {
    private String name;

    public Hospital(String hospitalName) {
        name = hospitalName;
    }

    void receive(Transporter t) {
        while (!t.isEmpty()) {
            try {
                Object unloaded = t.unload();
                Method getScheduleMethod = unloaded.getClass().getMethod("getSchedule");
                MedicineSchedule getScheduleMethodResult = (MedicineSchedule) getScheduleMethod.invoke(unloaded);
                Method getMedicineNameMethod = unloaded.getClass().getMethod("getMedicineName");
                String getMedicineNameMethodResult = (String) getMedicineNameMethod.invoke(unloaded);

                System.out.println(String.format("Checking whether Hospital can receive %s.", getMedicineNameMethodResult));
                if (getScheduleMethodResult != MedicineSchedule.Uncontrolled) {
                    System.out.println(String.format("Hospital cannot receive controlled substances and %s is a %s.",
                            getMedicineNameMethodResult, getScheduleMethodResult.asString()));
                } else {
                    System.out.println(String.format("Accepted a shipment of %s.", getMedicineNameMethodResult));
                }
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                // If reflection fails, assume item cannot be received
                System.out.println("Item cannot be received due to missing required methods.");
            }
        }
    }

    public String getName() {
        return name;
    }
}









