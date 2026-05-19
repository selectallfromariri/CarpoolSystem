/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mycards;

import java.util.Scanner;

/**
 *
 * @author harir
 */
public class MyKad {

    Scanner sc = new Scanner(System.in);
    private String myKadNumber;

    public MyKad(String myKadNumber) {
        this.myKadNumber = myKadNumber;
    }

    public String readDay() {
        String day = myKadNumber.substring(2, 4);
        return day;
    }

    public String readMonth() {
        String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };
        char[] month = myKadNumber.toCharArray();
        String monthStr = "" + month[2] + month[3];

        int monthNum = Integer.parseInt(monthStr);
        return months[monthNum - 1];

    }

    public String readYear() {
        String year = myKadNumber.substring(0, 2);
        int years = Integer.parseInt(year);
        String tahun1 = "";
        if(years <= 25){
            return tahun1 = "20" + years;
        }else{
            return tahun1 = "19" + years;
        }
    }

    public String readPOB() {
        char[] pob = myKadNumber.toCharArray();

        if (pob[6] == '0' && pob[7] == '1') {
            return "Johor";
        } else if (pob[6] == '0' && pob[7] == '2') {
            return "Kedah";
        } else if (pob[6] == '0' && pob[7] == '3') {
            return "Kelantan";
        } else if (pob[6] == '0' && pob[7] == '4') {
            return "Melaka";
        } else if (pob[6] == '0' && pob[7] == '5') {
            return "Negeri Sembilan";
        } else if (pob[6] == '0' && pob[7] == '6') {
            return "Pahang";
        } else if (pob[6] == '0' && pob[7] == '7') {
            return "Penang";
        } else if (pob[6] == '0' && pob[7] == '8') {
            return "Perak";
        } else if (pob[6] == '0' && pob[7] == '9') {
            return "Perlis";
        } else if (pob[6] == '1' && pob[7] == '0') {
            return "Selangor";
        } else if (pob[6] == '1' && pob[7] == '1') {
            return "Terengganu";
        } else if (pob[6] == '1' && pob[7] == '2') {
            return "Sabah";
        } else if (pob[6] == '1' && pob[7] == '3') {
            return "Sarawak";
        } else if (pob[6] == '1' && pob[7] == '4') {
            return "Kuala Lumpur";
        } else if (pob[6] == '1' && pob[7] == '5') {
            return "Labuan";
        } else if (pob[6] == '1' && pob[7] == '6') {
            return "Putrajaya";
        } else {
            return "Unknown";
        }
    }

    public String readGender() {
        char[] gender = myKadNumber.toCharArray();
        String genderStr = "" + gender[11];
        int genderDigit = Integer.parseInt(genderStr);

        if (genderDigit % 2 == 0) {
            return "Female";
        } else {
            return "Male";
        }
    }

}

//050611140703
//14
