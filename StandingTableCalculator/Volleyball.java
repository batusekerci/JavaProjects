

public class Volleyball extends Sports {
	
	
	
	public void fix(String name1 , String score) {
		switch(score) {
		case "3:0":
		case "3:1":
			super.setWinPoint(3);
			super.setLosePoint(0);
			break;
		case "3:2":
			super.setWinPoint(2);
			super.setLosePoint(1);
			break;
		default:
			System.out.println("Impossible");
		
		}
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
		
		else {
			firstTeamRes[0] +=1;
			secondTeamRes[2] +=1;
			firstTeamRes[3] +=i;
			firstTeamRes[4] +=j;
			firstTeamRes[5] +=super.getWinPoint();
	}
		
		
}
	writeToFile("volleyball.txt",firstTeamRes[0],firstTeamRes[2],firstTeamRes[3],firstTeamRes[4],secondTeamRes[5]);
}
