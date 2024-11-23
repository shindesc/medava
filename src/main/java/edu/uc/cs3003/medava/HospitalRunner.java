package edu.uc.cs3003.medava;

public class HospitalRunner {
    public static void main(String[] args) {
        Transporter transporter = new Transporter("Priority Dispatch", 2.0, 8.0);
        Pharmacy pharmacy = new Pharmacy(); // Use the no-argument constructor
        Hospital hospital = new Hospital("General Hospital");

        pharmacy.send(transporter);
        hospital.receive(transporter);
    }
}


