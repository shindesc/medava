package edu.uc.cs3003.medava;


public class Hospital {
    private String name;

    public Hospital(String hospitalName) {
        name = hospitalName;
    }

    void receive(Transporter t) {
        while (!t.isEmpty()) {
            // Updated to remove unnecessary cast
            Shippable unloaded = t.unload(); 

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











