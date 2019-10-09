import java.io.IOException;
import java.util.ArrayList;

public class PosAvg extends MesoInherit
{
	public String posStID;
	public MesoStation Meso;
	public ArrayList<MesoStation> stations;
	
	public PosAvg(String stID) throws IOException {
		//super(new MesoStation(stID));
		this.posStID=stID;
		this.Meso= new MesoStation(stID);
		stations=super.getStations();
	}
	
	public String getStID() {
		return posStID;
	}

	public MesoStation getMeso() {
		return Meso;
	}

	public ArrayList<MesoStation> getStations() {
		return stations;
	}

	public PosAvg() {
		// TODO Auto-generated constructor stub
		//super();
		this.posStID=stID;
		this.Meso= new MesoStation(stID);
		stations=super.getStations();
	}

	public String indexOfStationAV()	{
		int statAv=this.indexOfStation();
		
		//pre String
		String out="This index is average of ";
		
		//stations for av n+1
		MesoStation tempStat =stations.get(statAv-1);
		String tempStr= tempStat.getStID();
		out=out.concat(tempStr);
		
		statAv++;
		
		out=out.concat(" and ");
		
		tempStat =stations.get(statAv+1);
		tempStr= tempStat.getStID();
		out=out.concat(tempStr);
		
		statAv--;
		
		out=out.concat(", ");
		
		//stations for av n+2
		tempStat =stations.get(statAv-2);
		tempStr= tempStat.getStID();
		out=out.concat(tempStr);
		
		statAv++;
		statAv++;

		out=out.concat(" and ");
		
		tempStat =stations.get(statAv+2);
		tempStr= tempStat.getStID();
		out=out.concat(tempStr);
		
		statAv--;
		statAv--;

		out=out.concat(", and so on.");
		
		return out;
	}
	
	
	public int indexOfStation () {
		//to be returned
		int stationNum=0;
		//loop for finding stat
		int index=0;
		while(index<stations.size()) {
			
			String tempStat=(stations.get(index)).getStID();
		
			if(tempStat.equals(posStID)) {
			stationNum=index;	
			}
			
			index++;
		}
		//accounting for zero indexed
		stationNum++;
		
		return stationNum;
	}
	
	
	@Override
	public String toString() {
	
	String outToString=this.indexOfStationAV();
	//System.out.println(outToString);
	return outToString;
	}
	
}
