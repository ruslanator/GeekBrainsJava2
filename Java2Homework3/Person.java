package Java2Homework3;

public class Person {
    private String phone;
    private String email;

    public Person(String phone, String email){
        this.phone = phone;
        this.email = email;
    }
    public void setPhone(String a){
        phone = a;
    }
    public String getPhone(){
        return phone;
    }
    public void setEmail(String a){
        email = a;
    }
    public String getEmail(){
        return email;
    }

}
