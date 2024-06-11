package org.example;

public class UserData{
    private String email = "";
    private String date = "";
    private String firstName = "";
    private String secondName = "";
    private String modifyYear = "";

    public UserData(){

    }
    public UserData(String email, String date, String firstName, String secondName, String modifyYear){
        this.email = email;
        this.date = date;
        this.firstName = firstName;
        this.secondName = secondName;
        this.modifyYear = modifyYear;
    }







    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getString() {
        return this.email+";"+this.date+";"+this.firstName+";"+this.secondName;
    }

    public int getYear() {
        return Integer.parseInt(modifyYear);
    }
}
