import java.util.ArrayList;

public class LetterAvg extends PosAvg	//extends MesoInherit 
{
	
	private ArrayList<MesoStation> stations;
	char c;
	String stID;
	char[] charArray;
	int letterAvg;
	int[] asciiVals;
	int[] asciiAV;
	int length;
	
	
	public LetterAvg(char c){
		super();
		this.c=c;
		stations=super.getStations();
		stID=super.getStID();
		this.createCharArray();
		this.createAsciiArray();
		asciiAV=new int[length];
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
	
	public void createCharArray() {
		
		this.length = stID.length();
		
		this.charArray=new char[length];
		
		for(int i=0;i<length;i++) {
		charArray[i]=stID.charAt(i);
		}	
	}
	
	public void createAsciiArray() {
		
		this.length = stID.length();
		
		this.asciiVals=new int[length];
		
		for(int i=0;i<length;i++) {
		asciiVals[i]=(int)charArray[i];
		}	
	}
	
	public void getletterAvg() {
		
		int charAverage=0;
		int asciiCeil=0;
		int asciiFloor=0;
		int asciiAv=0;
		char asciiAvChar='a';
		
		for(int i=0;i<length;i++) {
			charAverage+=asciiVals[i];
		}
	}
	
	
}
