import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MesoInherit extends MesoAbstract
{
	public ArrayList<MesoStation> stations;
	public String stID;
	PosAvg posavg;
	LetterAvg letteravg;
	
	public MesoInherit(MesoStation Meso) throws IOException{
		stations=new ArrayList<MesoStation>(10);
		//get stID
		this.stID=Meso.getStID();
		//readIn
		readIn("Mesonet.txt");
		
		//creating objects to return
		posavg=new PosAvg(stID);
		letteravg=new LetterAvg(stID);
		
	}
	
	public MesoInherit() {
		// TODO Auto-generated constructor stub
		super();
		stations=new ArrayList<MesoStation>(10);
	}


	public void readIn(String filename) throws IOException
    {
    	//creating BufferReader
    	BufferedReader mesonetRead=new BufferedReader(new FileReader(filename));
    	
    	//read in to get rid of first five line
    	String tempRead=mesonetRead.readLine();
    	tempRead=mesonetRead.readLine();
    	tempRead=mesonetRead.readLine();
    	tempRead=mesonetRead.readLine();
    	
  
    	//while loop for reading in and making players
    	int i=0;
    	while(tempRead!=null) {
    	/*	
    	if(i>=stations.length) {
    	stations=expandArray(stations);
    	}*/
    	
    	tempRead=tempRead.substring(1,5);
    	MesoStation MesoTemp=new MesoStation(tempRead);
    	stations.add(i, MesoTemp);
    	i++;
    	
    	tempRead=mesonetRead.readLine();
    	
    	}
    	
    	mesonetRead.close();
    }

	public ArrayList<MesoStation> getStations() {
		return stations;
	}


	@Override
	int[] calAverage() {
		// TODO Auto-generated method stub
		return letteravg.getAsciiAV();
	}

	@Override
	char letterAverage() {
		// TODO Auto-generated method stub
		char c= letteravg.getAsciiAvChar();
		return c;
	}
	
	
	
	
	
	
}
