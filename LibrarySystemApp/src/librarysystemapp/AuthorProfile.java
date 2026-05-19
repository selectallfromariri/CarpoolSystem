/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemapp;

/**
 *
 * @author harir
 */
public class AuthorProfile {
    private String authorName, country;
    
    public AuthorProfile(String authorName, String country){
        this.authorName = authorName;
        this.country = country;
        
    }
    
    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }
    
    public String getAuthorName(){
        return authorName;
    }
    
    public void setCountry(String country){
        this.country = country;
    } 
    public String getCountry(){
        return country;
    } 
    public boolean isLocalAuthor(){
        return authorName.equalsIgnoreCase("Malaysia");
    }
}
