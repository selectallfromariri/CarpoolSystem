/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vehicleapp;

/**
 *
 * @author harir
 */
public class VehicleApp {

    /**
     * @param args the command line arguments
     */
    
    private String type;
    private String transmission;
    private String powerTrain;
    private static int speed;
    
    public VehicleApp(){
        type = null;
        transmission = null;
        powerTrain = null;
        speed = 60;
    }
    
    public VehicleApp(String type, String transmission, String powerTrain){
        this.type = type;
        this.powerTrain = powerTrain;
        this.transmission = transmission;
        this.speed = 60;
    }
    
    public String getType(){
        return type;
    }
    public String getTransmission(){
        return transmission;
    }
    public String getPowerTrain(){
        return powerTrain;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setTransmission(String transmission){
        this.transmission = transmission;
    }
    public void setPowertrain(String powerTrain){
        this.powerTrain = powerTrain;
    }
    public int accelerate(){
        speed += 10;
        return speed;
    }
    public int brake(){
        speed -= 5;
        return speed;
    }
    public int getRoadTaxPrice(){
        if (type.equals("Car")){
            if(powerTrain.equals("Gasoline")) return 200;
            else if(powerTrain.equals("Hybrid")) return 100;
            else if(powerTrain.equals("Electric")) return 50;
               
        }else if(type.equals("SUV") || (type.equals("MPV"))){
            if(powerTrain.equals("Gasoline")) return 300;
            else if(powerTrain.equals("Hybrid")) return 150;
            else if(powerTrain.equals("Electric")) return 100;
            
        }else if(type.equals("Lorry")){
            return 400; 
        }
        return 0;
    }
    public int autoAccelerate(int accelerate){
        for(int i = 0; i < accelerate; i++){
            speed += 10;
        }
        return speed;
    }
    public int autobrake(int brake){
        for(int j = 0; j < brake; j++){
            speed -= 10;
        }
        return speed;
    }
}
