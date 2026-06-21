/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Driver extends Student {
    private String driver_id;
    private String driver_license;
    private boolean approved;
    private ArrayList<Carpool> myCarpools;
    private Car kereta;

    public Driver(String driver_id, String driver_license, String student_id, String student_name, String phone_num, String password, String numplate, String model, String color) {
        super(student_id, student_name, phone_num, password);
        this.driver_id = "DRV" + driver_id;
        this.driver_license = driver_license;
        this.approved = false;
        this.kereta = new Car(numplate, model, color);
        this.myCarpools = new ArrayList<>();
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public ArrayList<Carpool> getMyCarpools() {
        return myCarpools;
    }

    public void setMyCarpools(ArrayList<Carpool> myCarpools) {
        this.myCarpools = myCarpools;
    }

    public void addCarpoolDriver(Carpool post){
        myCarpools.add(post);
    }
    
    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriver_license() {
        return driver_license;
    }

    public void setDriver_license(String driver_license) {
        this.driver_license = driver_license;
    }
    
    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Driver ID : " + driver_id);
        System.out.println("License   : " + driver_license);
        System.out.println("Approved  : " + (approved ? "Approved" : "Pending"));
        System.out.println("--- Car ---");
        kereta.displayCarInfo();
    }

    public Car getKereta() {
        return kereta;
    }

    public void setKereta(Car kereta) {
        this.kereta = kereta;
    }
    
    public String getRole(){
        String role = "Driver";
        return role;
    }
    
    public void updateProfile(String student_name,String phonenum,String newPlate, String newModel, String newColor){
        updateName(student_name);
        updatePhone(phonenum);
        kereta.updateCar(newPlate, newModel, newColor);
        System.out.println("Driver Profile updatedd succesfully");
        displayProfile();
    }
    
    
}
