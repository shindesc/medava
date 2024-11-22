package edu.uc.cs3003.medava;

public class Hospital {
    private String name;

    public Hospital(String hospitalName) {
        name = hospitalName;
    }

    void receive(Transporter t) {
        while (!t.isEmpty()) {
            Object unloaded = t.unload();
            if (unloaded instanceof Medicine) {
                Medicine medicine = (Medicine) unloaded;
                System.out.println(String.format("Checking whether Hospital can receive %s.", medicine.getMedicineName()));
                if (medicine.getSchedule() != MedicineSchedule.Uncontrolled) {
                    System.out.println(String.format("Hospital cannot receive controlled substances and %s is a %s.",
                            medicine.getMedicineName(), medicine.getSchedule().asString()));
                } else {
                    System.out.println(String.format("Accepted a shipment of %s.", medicine.getMedicineName()));
                }
            } else if (unloaded instanceof Jarvik) {
                Jarvik device = (Jarvik) unloaded;
                System.out.println(String.format("Accepted a shipment of %s with serial number %s.", device.getMedicineName(), device.getSerialNumber()));
            }
        }
    }

    public String getName() {
        return name;
    }

    public boolean send(Transporter t) {
        Medicine advil = new Ibuprofen();
        if (t.load(advil)) {
            System.out.println(String.format("Sending %s on the %s transporter.", advil.getMedicineName(), t.getTransporterName()));
        } else {
            System.out.println(String.format("Cannot load %s on to the %s transporter.", advil.getMedicineName(), t.getTransporterName()));
            return false;
        }

        Medicine activase = new Thrombolytic();
        if (t.load(activase)) {
            System.out.println(String.format("Sending %s on the %s transporter.", activase.getMedicineName(), t.getTransporterName()));
        } else {
            System.out.println(String.format("Cannot load %s on to the %s transporter.", activase.getMedicineName(), t.getTransporterName()));
            return false;
        }

        Medicine oxycontin = new Oxycodone();
        if (t.load(oxycontin)) {
            System.out.println(String.format("Sending %s on the %s transporter.", oxycontin.getMedicineName(), t.getTransporterName()));
        } else {
            System.out.println(String.format("Cannot load %s on to the %s transporter.", oxycontin.getMedicineName(), t.getTransporterName()));
            return false;
        }

        Jarvik heart = new Jarvik("01j9a9lk71");
        if (t.load(heart)) {
            System.out.println(String.format("Sending %s on the %s transporter.", heart.getMedicineName(), t.getTransporterName()));
        } else {
            System.out.println(String.format("Cannot load %s on to the %s transporter.", heart.getMedicineName(), t.getTransporterName()));
            return false;
        }

        return true;
    }
}



