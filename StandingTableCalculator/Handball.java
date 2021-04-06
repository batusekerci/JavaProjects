/**Handball Class
 * 
 */

/**
 * @author Batu
 *
 */
public class Handball extends Sports{
	
	private int drawPoint=1;
	Handball(){
		
	super.setWinPoint(2);
	super.setLosePoint(0);
	
	}
public void fix(String name1 , String score) {
		
		int[] firstTeamRes= new int[6];
		int[] secondTeamRes= new int[6];
		String[] sco = score.split(":");
		int i = Integer.parseInt(sco[0]);
		int j = Integer.parseInt(sco[1]);
		if(i<j){
			secondTeamRes[0] +=1;
			firstTeamRes[2] +=1;
			secondTeamRes[3] +=j;
			secondTeamRes[4] +=i;
			secondTeamRes[5] +=super.getWinPoint();
		}
		else if(i==j){
			secondTeamRes[1] +=1;
			firstTeamRes[1] +=1;
			secondTeamRes[3] +=j;
			firstTeamRes[3] +=i;
			secondTeamRes[5] +=drawPoint;
			firstTeamRes[5] +=drawPoint;
		}
		else {
			firstTeamRes[0] +=1;
			secondTeamRes[2] +=1;
			firstTeamRes[3] +=i;
			firstTeamRes[4] +=j;
			firstTeamRes[5] +=super.getWinPoint();
	}
		
}writeToFile("handball.txt",firstTeamRes[0],firstTeamRes[2],firstTeamRes[3],firstTeamRes[4],secondTeamRes[5]);
	
}
