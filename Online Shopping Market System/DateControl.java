import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateControl {


    public boolean control(String date1 , String date2, String date3) throws ParseException {
            String date11=date1.replace(".","/");
            String date22=date2.replace(".","/");
            String date33=date3.replace(".","/");
            Date date111 = new SimpleDateFormat("dd/MM/yyyy").parse(date11);
            Date date222 = new SimpleDateFormat("dd/MM/yyyy").parse(date22);
            Date date333 = new SimpleDateFormat("dd/MM/yyyy").parse(date33);
            return isWithinRange(date111, date222 ,date333);


    }
    public boolean isWithinRange(Date testDate, Date startDate , Date endDate) {
        return !(testDate.before(startDate) || testDate.after(endDate));
    }

}
