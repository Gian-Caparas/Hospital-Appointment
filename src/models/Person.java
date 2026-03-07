package models;

public class Person {
    private String Name;
    private int Age;
    private String Gender;
    private String ContactNumber;

    public Person(String Name, int Age, String Gender, String ContactNumber){
        this.Name = Name;
        this.Age = Age;
        this.Gender = Gender;
        this.ContactNumber = ContactNumber;
    }

    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }

    public int getAge(){
        return Age;
    }
    public void setAge(int Age){
        this.Age = Age;
    }

    public String getGender(){
        return Gender;
    }
    public void setGender(String Gender){
        this.Gender = Gender;
    }

    public String getContactNumber(){
        return ContactNumber;
    }
    public void setContactNumber(String ContactNumber){
        this.ContactNumber = ContactNumber;
    }



}
