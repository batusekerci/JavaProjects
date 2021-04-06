
import java.text.ParseException;

public class Main {

    public static void main (String[] args) throws ParseException {

        Main m = new Main();
        PriceCalc tutu = new PriceCalc();
        String[] lines2 = ReadFromFile.readFile(args[0]);
        String[] lines1 = ReadFromFile.readFile(args[1]);
        for(String lineShop:lines2){
            String[] wordShop = lineShop.split("\\s+");
            double total =0;
            m.displayName(wordShop[0],wordShop[1]);
            for (String linePrice : lines1) {
                String[] wordPrice = linePrice.split("\\s+");
                DateControl cont = new DateControl();


                if (wordShop[2].equals(wordPrice[1]) && cont.control(wordShop[3], wordPrice[2], wordPrice[3])) {

                    for(int i=4 ;i<wordShop.length;i+=2){
                        if (wordShop[i].equalsIgnoreCase(wordPrice[0])) {
                            double a = Double.parseDouble(wordShop[i + 1]);
                            double b = Double.parseDouble(wordPrice[4]);
                            total += tutu.netPrice(a, b);
                            int z = (int) Math.round(a);

                            m.display(wordShop[i], wordPrice[4], z,total);
                        }}
                }

            }m.displayTotal(total);
        }

    }
    public void displayName(String d, String c){
        System.out.println("---"+d+" "+c+"---");
    }
    public void display(String k,String r,int y, double m){

        System.out.println(k+"\t"+r +"\t"+y +"\t"+ m);

    }
    public void displayTotal(double total){
        System.out.println("Total"+ "\t" + total);
    }
}