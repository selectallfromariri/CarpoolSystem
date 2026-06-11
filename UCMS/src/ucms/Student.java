/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms;

/**
 *
 * @author User
 */
public abstract class Student {
    protected String student_id;
    protected String student_name;
    protected String phone_num;
    protected String password;

    public Student(String student_id, String student_name, String phone_num,String password) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.phone_num = phone_num;
        this.password = password;
    }
    
    public boolean loginStudent(String id, String pass){
        if (student_id.equalsIgnoreCase(id) && password.equals(pass)){
            return true;
        }
        else{
            return false;
        }
        
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name; 
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
    
    public void displayProfile() {
        System.out.println("=== Profile ===");
        System.out.println("ID    : " + student_id);
        System.out.println("Name  : " + student_name);
        System.out.println("Phone : " + phone_num);
    }
    
    abstract public String getRole();
    
    
}
