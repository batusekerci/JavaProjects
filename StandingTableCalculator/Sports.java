import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Sports {
	Sports(){}
	private int winPoint;
	private int losePoint;
	
	public int getWinPoint(){
		return winPoint;
	}
	public void setWinPoint(int win) {
		this.winPoint=win;
	}
	public int getLosePoint(){
		return losePoint;
	}
	public void setLosePoint(int lose) {
		this.losePoint=lose;
	}
	
	public int average(int atıl, int yen){
		return atıl-yen;
	}
	public static void writeToFile(String file,String f,int a,int b , int d, int e,int k) throws FileNotFoundException, UnsupportedEncodingException {     //write to txt method
		
		PrintWriter writer = new PrintWriter(file, "UTF-8");
		writer.println("1."+"\t"+f+"\t"+"3"+"\t"+3+"\t"+a+"\t"+b+"\t"+d+":"+e+"\t"+k+"\n"+
				"2."+"\t"+f+"\t"+"3"+"\t"+2+"\t"+a+"\t"+b+"\t"+d+":"+e+"\t"+k+"\n"+
				"3."+"\t"+f+"\t"+"3"+"\t"+1+"\t"+a+"\t"+b+"\t"+d+":"+e+"\t"+k+"\n"+
				"4."+"\t"+f+"\t"+"3"+"\t"+0+"\t"+a+"\t"+b+"\t"+d+":"+e+"\t"+k);
		
		writer.close();
	}
}
