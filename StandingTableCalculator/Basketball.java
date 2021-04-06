public class Basketball extends Sports{
	
	Basketball(){
		
	super.setWinPoint(2);
	super.setLosePoint(1);
	}
	public void fix(String name1 , String score){
		
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
			firstTeamRes[5] +=super.getLosePoint();
			firstTeamRes[1] =0;
				
		}
		else {
			firstTeamRes[0] +=1;
			secondTeamRes[2] +=1;
			firstTeamRes[3] +=i;
			firstTeamRes[4] +=j;
			firstTeamRes[5] +=super.getLosePoint();
			secondTeamRes[5] +=super.getLosePoint();
			secondTeamRes[1] =0;
	}
		writeToFile("basketball.txt",name1,firstTeamRes[0],firstTeamRes[1],firstTeamRes[2],firstTeamRes[3],firstTeamRes[4],firstTeamRes[5]);

}
		
	}
