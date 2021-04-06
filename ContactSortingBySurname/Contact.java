public class Contact implements Comparable<Contact>{
    private String socialSecurityNumber;
    private String firstName;
    private  String lastName;
    private String phoneNumber;

    public Contact(String phoneNum, String name,String surname, String socialSecurityNum){
        socialSecurityNumber =socialSecurityNum;
        firstName=name;
        lastName=surname;
        phoneNumber=phoneNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public int compareTo(Contact input) {
        return phoneNumber.compareTo(input.getPhoneNumber());
    }


    @Override
    public String toString() {
        return phoneNumber + " " + firstName + " " + lastName + " " + socialSecurityNumber;
    }
}