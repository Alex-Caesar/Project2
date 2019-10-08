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
	
	
	public LetterAvg(){
		super();
		this.c=c;
		stations=super.getStations();
		stID=super.getStID();
		this.createCharArray();
		this.createAsciiArray();
		asciiAV=new int[2];
	}
	/*
	public LetterAvg() {
		// TODO Auto-generated constructor stub
		super();
		stations=super.getStations();
	}
	*/
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
		//vals to find
		double charAverage=0;
		int asciiCeil=0;
		int asciiFloor=0;
		int asciiAv=0;
		char asciiAvChar='a';
		//loop for adding ascii
		for(int i=0;i<length;i++) {
			charAverage+=asciiVals[i];
		}
		//average computation
		charAverage/=4;
		//Math function for vals
		asciiCeil=(int)Math.ceil(charAverage);
		asciiCeil=(int)Math.floor(charAverage);
		//determining average
		if(charAverage%10>0.5) {
			asciiAv=asciiCeil;
		}
		else {
			asciiAv=asciiFloor;
		}
		//finding average char
		//asciiAvChar=Character.toString((char)asciiAv);
		asciiAvChar=(char)asciiAv;
		//giving asciiAv data
		asciiAV[0]=asciiCeil;
		asciiAV[1]=asciiFloor;
		asciiAV[3]=asciiAv;
	}
	public ArrayList<MesoStation> getStations() {
		return stations;
	}
	public char getC() {
		return c;
	}
	public String getStID() {
		return stID;
	}
	public char[] getCharArray() {
		return charArray;
	}
	public int getLetterAvg() {
		return letterAvg;
	}
	public int[] getAsciiVals() {
		return asciiVals;
	}
	public int[] getAsciiAV() {
		return asciiAV;
	}
	public int getLength() {
		return length;
	}
	
	
}
