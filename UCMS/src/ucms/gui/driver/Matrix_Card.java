/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms.gui.driver;

import javax.swing.Icon;

/**
 *
 * @author User
 */
public class Matrix_Card {
    Icon icon;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    String title,values,desc;

    public Matrix_Card() {
    }

    public Matrix_Card(Icon icon, String title, String values, String desc) {
        this.icon = icon;
        this.title = title;
        this.values = values;
        this.desc = desc;
    }
    
    
}
