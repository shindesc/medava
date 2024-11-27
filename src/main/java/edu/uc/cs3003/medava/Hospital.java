package edu.uc.cs3003.medava;

public class Hospital {
    private String name;

    public Hospital(String hospitalName) {
        name = hospitalName;
    }

    // Refactored to use the Shippable interface instead of reflection
    void receive(Transporter t) {
        while (!t.isEmpty()) {
            // Use the Shippable interface to directly access the methods
            Shippable unloaded = (Shippable) t.unload();
            String medicineName = unloaded.getMedicineName();
            MedicineSchedule schedule = unloaded.getSchedule();

            System.out.println(String.format("Checking whether Hospital can receive %s.", medicineName));
            if (schedule != MedicineSchedule.Uncontrolled) {
                System.out.println(String.format("Hospital cannot receive controlled substances and %s is a %s.",
                        medicineName, schedule.asString()));
            } else {
                System.out.println(String.format("Accepted a shipment of %s.", medicineName));
            }
        }
    }

    public String getName() {
        return name;
    }
}










