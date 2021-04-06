public class Passenger{
    private String name;
    private String surname;
    private String gender;
    private Phone phone;
    Passenger(String name, String surname, String gender, Phone phone){
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phone = phone;

    }
    Passenger(){
        name="";
        surname="";
        gender="";
        phone = new Phone();
    }
    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void display(){
        System.out.println("name "+"surname"+"(" + gender +")" );
        phone.display();

    }
}