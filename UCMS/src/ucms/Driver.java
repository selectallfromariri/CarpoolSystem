/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

/**
 *
 * @author User
 */
public class Driver extends Student {
    private String driver_id;
    private String driver_license;

    public Driver(String driver_id, String driver_license, String student_id, String student_name, String phone_num, String password) {
        super(student_id, student_name, phone_num, password);
        this.driver_id = "DRV" + driver_id;
        this.driver_license = driver_license;
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
    
    
}
