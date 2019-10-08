import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MesoInherit extends MesoAbstract
{
	private ArrayList<MesoStation> stations;
	
	public MesoInherit(MesoStation Meso) throws IOException{
		//readIn
		readIn("Mesonet.txt");
		
		//creating objects to return
		PosAvg posavg=new PosAvg();
		LetterAvg letteravg=new LetterAvg();
		
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
    	
    	tempRead=tempRead.substring(4,8);
    	MesoStation MesoTemp=new MesoStation(tempRead);
    	getStations().add(i, MesoTemp);
    	i++;
    	
    	tempRead=mesonetRead.readLine();
    	
    	}
    	
    	mesonetRead.close();
    }
	
	public int getIndexCity(String city) {
		
		MesoStation tempStat=new MesoStation(city);
		int indexCity=tempStat.findStation(city,stations);
		
		return indexCity;
	}
	

	public ArrayList<MesoStation> getStations() {
		return stations;
	}

	public void setStations(ArrayList<MesoStation> stations) {
		this.stations = stations;
	}
	
	
	
	
	
	
}
