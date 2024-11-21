package edu.uc.cs3003.medava;

import java.util.List;
import java.util.ArrayList;
public class Transporter {

   // Field to store the name of the transporter
    private String mTransporterName;

    // Field to store the goods (medicines) being transported
    public List<Medicine> goods;

    // Constructor to initialize the transporter name
    public Transporter(String transporterName) {
        this.mTransporterName = transporterName;
    }

    // Getter to access the transporter name
    public String getTransporterName() {
        return mTransporterName;
    }

    // Instance initializer to initialize the goods list
    {
        goods = new ArrayList<Medicine>();
    }

    // Method to simulate shipping the goods
    public void ship() {
        // Do some shipping!
    }
}
