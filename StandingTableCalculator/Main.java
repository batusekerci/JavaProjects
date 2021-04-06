
public class Main {
	
	public static void main(String[] args) {			// main method
		IceHockey ice= new IceHockey();
		Handball hand= new Handball();
		Basketball basket = new Basketball();
		Volleyball voley= new Volleyball();
		String[] lines = ReadFromFile.readFile(args[0]);
        for(String line:lines){
            String[] word = line.split("\\t");
            switch(word[0]) {
            case "I":
            	ice.fix(word[1], word[-1]);
            	break;
            case "H":
            	hand.fix(word[1], word[-1]);
            	break;
            case "B":
            	basket.fix(word[1],word[-1]);
            	break;
            case "V":
            	voley.fix(word[1], word[-1]);
            	
            	break;
            default:
            	System.out.println("No sport");
            }
            
            }
        
        
        
        
	}
	
	
	
}
	
	
