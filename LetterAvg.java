import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LetterAvg extends PosAvg // extends MesoInherit
{

	private ArrayList<MesoStation> stations;
	private ArrayList<MesoStation> statsForToString;
	String LetterstID;
	char c;
	char[] charArray;
	int letterAvg;
	int[] asciiVals;
	int[] asciiAV;
	int length;
	char asciiAvChar;

	public LetterAvg(String stID) throws IOException {
		// super();
		this.stations = new ArrayList<MesoStation>(10);
		try {
			this.readIn("Mesonet.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.LetterstID = stID;
		this.length = 4;
		this.charArray = new char[length];
		this.asciiVals = new int[length];
		this.asciiAV = new int[length];
		this.createCharArray();
		this.createAsciiArray();
		this.getletterAvg();

	}

	public LetterAvg(char c) throws IOException {
		this.stations = new ArrayList<MesoStation>(10);
		this.stations = new ArrayList<MesoStation>(1);
		try {
			this.readIn("Mesonet.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.c = c;

	}

	public void readIn(String filename) throws IOException {
		// creating BufferReader
		BufferedReader mesonetRead = new BufferedReader(new FileReader(filename));

		// read in to get rid of first five line
		String tempRead = mesonetRead.readLine();
		tempRead = mesonetRead.readLine();
		tempRead = mesonetRead.readLine();
		tempRead = mesonetRead.readLine();

		// while loop for reading in and making players
		int i = 0;
		while (tempRead != null) {
			/*
			 * if(i>=stations.length) { stations=expandArray(stations); }
			 */

			tempRead = tempRead.substring(1, 5);
			MesoStation MesoTemp = new MesoStation(tempRead);
			stations.add(i, MesoTemp);
			i++;

			tempRead = mesonetRead.readLine();

		}
	}

	public int numberOfStationWithLetterAvg() throws IOException {
		// TODO Auto-generated method stub

		int amount = 0;
		int size4loop = stations.size();

		for (int i = 0; i < size4loop; i++) {
			String temp = (stations.get(i)).getStID();
			char temper = temp.charAt(0);

			int threshhold = Character.compare(c, temper);

			if (threshhold == 0) {
				
				++amount;
				
				MesoStation addIn=stations.get(i);
				statsForToString.set(i,addIN);
			}
		}

		return amount;
	}

	public void createCharArray() {
		charArray[0] = LetterstID.charAt(0);
		charArray[1] = LetterstID.charAt(1);
		charArray[2] = LetterstID.charAt(2);
		charArray[3] = LetterstID.charAt(3);
	}

	public void createAsciiArray() {
		asciiVals[0] = (int) charArray[0];
		asciiVals[1] = (int) charArray[1];
		asciiVals[2] = (int) charArray[2];
		asciiVals[3] = (int) charArray[3];
	}

	public void getletterAvg() {
		// vals to find
		double charAverage = 0;
		int asciiCeil = 0;
		int asciiFloor = 0;
		int asciiAvNum = 0;
		// loop for adding ascii
		for (int i = 0; i < length; i++) {
			charAverage += asciiVals[i];
		}
		// average computation
		charAverage /= 4;
		// Math function for vals
		asciiCeil = (int) Math.ceil(charAverage);
		asciiFloor = (int) Math.floor(charAverage);
		// determining average
		if (charAverage % 100 >= 0.5) {
			asciiAvNum = asciiCeil;
		} else {
			asciiAvNum = asciiFloor;
		}
		// finding average char
		char lastChar = ((char) asciiAvNum);
		// giving asciiAv data
		asciiAV[0] = asciiCeil;
		asciiAV[1] = asciiFloor;
		asciiAV[2] = lastChar;

		this.letterAvg = asciiAvNum;
		this.asciiAvChar = lastChar;
	}

	public int[] getAsciiAV() {
		return asciiAV;
	}

	public char getAsciiAvChar() {
		return asciiAvChar;
	}

	@Override
	public String toString() {
		String out ="\n"+"They are:"+"\n";
		for(int i=0;i<statsForToString.size();++i) {
			String temp=(stations.get(i)).getStID();
			out.concat(temp + "\n");
		}
		
		return out;
	}
	
	
	
	
}
