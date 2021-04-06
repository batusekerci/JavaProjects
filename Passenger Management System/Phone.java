public class Phone{
    private String countrycode;
    private String code;
    private String number;
    private String type;
    Phone(String countrycode, String code, String number, String type){
        this.countrycode = countrycode;
        this.code = code;
        this.number = number;
        this.type = type;
    }
    Phone(String code, String number, String type){
        this.type = type;
        this.code = code;
        this.countrycode= "+90";
        this.number = number;

    }
    Phone(){
        countrycode="";
        code="";
        number="";
        type="";

    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void display(){
        System.out.println(type+ " Phone:"+code+""+countrycode+""+number);
    }
}