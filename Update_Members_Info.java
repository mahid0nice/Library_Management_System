//package Library_Management_System;

public class Update_Members_Info {
    private String firstname;
    private String lastname;
    private String contactnumber;
    private String gmail;
    private String date_of_birth;
    private String blood_group;
    private String permanent_address;
    private String home_address;
    private String fathers_name;
    private String Mothers_name;
    private String membership;

    Update_Members_Info(String firstname,String lastname,String contactnumber,String gmail,String date_of_birth,String blood_group,String permanent_address,String home_address,String fathers_name,String Mothers_name,String membership){
        this.firstname= firstname;
        this.lastname= lastname;
        this.contactnumber=contactnumber;
        this.gmail= gmail;
        this.date_of_birth = date_of_birth;
        this.blood_group =blood_group;
        this.fathers_name = fathers_name;
        this.Mothers_name= Mothers_name; 
        this.membership = membership;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public String getFirstname(){
        return firstname;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public String getLastname(){
        return lastname;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }
    public String getContactnumber() {
        return contactnumber;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public String getGmail() {
        return gmail;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }
    public String getBlood_group() {
        return blood_group;
    }

    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }
    public String getPermanent_address() {
        return permanent_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }
    public String getHome_address() {
        return home_address;
    }

    public void setFathers_name(String fathers_name) {
        this.fathers_name = fathers_name;
    }
    public String getFathers_name() {
        return fathers_name;
    }

    public void setMothers_name(String Mothers_name) {
        this.Mothers_name = Mothers_name;
    }
    public String getMothers_name() {
        return Mothers_name;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }
    public String getMembership() {
        return membership;
    }
    }
    
    

