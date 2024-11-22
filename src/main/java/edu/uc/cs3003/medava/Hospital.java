package edu.uc.cs3003.medava;

public class Hospital {
    private String name;

    public Hospital(String hospitalName) {
        name = hospitalName;
    }

    void receive(Transporter t) {
        while (!t.isEmpty()) {
            Medicine unloaded = t.unload();
            System.out.println(String.format("Receiving %s off the %s transporter.", unloaded.getMedicineName(), t.getTransporterName()));
        }
    }

    public String getName() {
        return name;
    }
}
