import java.util.ArrayList;

public class LetterAvg extends PosAvg	//extends MesoInherit 
{
	
	//private ArrayList<MesoStation> stations;
	String LetterstID;
	char c;
	char[] charArray;
	int letterAvg;
	int[] asciiVals;
	int[] asciiAV;
	int length;
	char asciiAvChar;
	
	public LetterAvg(String stID){
		//super();
		
		stations=super.getStations();
		this.LetterstID=stID;
		this.length=4;
		this.charArray=new char[length];
		this.asciiVals=new int[length];
		this.asciiAV=new int[length];
		this.createCharArray();
		this.createAsciiArray();

	}
	
	public LetterAvg(char c) {
		super();
		this.c=c;
		stations=super.getStations();
		this.LetterstID=super.getStID();
	}
	
	public int numberOfStationWithLetterAvg() {
		// TODO Auto-generated method stub
		int amount=0;
		
		for(int i=0;i<stations.size();i++) {
			String temp=(stations.get(i)).getStID();
			char temper=temp.charAt(0);
			temp=String.valueOf(temper);
			if(temp.equals(asciiAvChar)) {
			amount++;
			}
			}	
		
		return amount;
	}
	
	public void createCharArray() {
		charArray[0]=LetterstID.charAt(0);
		charArray[0]=LetterstID.charAt(1);
		charArray[0]=LetterstID.charAt(2);
		charArray[0]=LetterstID.charAt(3);
		/*
		for(int i=0;i<(charArray.length)-1;i++) {
		charArray[i]=stID.charAt(i);
		}	
		*/
	}
	
	public void createAsciiArray() {
		asciiVals[0]=(int)charArray[0];
		asciiVals[1]=(int)charArray[1];
		asciiVals[2]=(int)charArray[2];
		asciiVals[3]=(int)charArray[3];
		/*
		for(int i=0;i<length;i++) {
		asciiVals[i]=(int)charArray[i];
		}	*/
	}
	
	public void getletterAvg() {
		//vals to find
		double charAverage=0;
		int asciiCeil=0;
		int asciiFloor=0;
		int asciiAvNum=0;
			//this.asciiAvChar='a';
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
			asciiAvNum=asciiCeil;
		}
		else {
			asciiAvNum=asciiFloor;
		}
		//finding average char
		//asciiAvChar=Character.toString((char)asciiAv);
		asciiAvChar=(char)asciiAvNum;
		//giving asciiAv data
		asciiAV[0]=asciiCeil;
		asciiAV[1]=asciiFloor;
		asciiAV[2]=asciiAvNum;
		
		this.letterAvg=asciiAvNum;
	}
	public ArrayList<MesoStation> getStations() {
		return stations;
	}
	public String getStID() {
		return LetterstID;
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
	public char getAsciiAvChar() {
		return asciiAvChar;
	}

	public int getLength() {
		return length;
	}
	
	
}
