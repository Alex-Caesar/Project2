import java.util.ArrayList;

public class LetterAvg extends PosAvg	//extends MesoInherit 
{
	private ArrayList<MesoStation> stations;
	char c;
	String stID;
	char[] cArray;
	public LetterAvg(char c){
		super();
		this.c=c;
		stations=super.getStations();
		stID=super.getStID();
		this.createCharArray();
	}

	public LetterAvg() {
		// TODO Auto-generated constructor stub
		super();
		stations=super.getStations();
	}

	public String numberOfStationWithLetterAvg() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int findLength() {
		
		return 0;
	}
	
	public void createCharArray() {
		
		int length = stID.length();
		
		this.cArray=new char[length];
		
		for(int i=0;i<length;i++) {
		cArray[i]=stID.charAt(i);
		}
		
	}
	
}
