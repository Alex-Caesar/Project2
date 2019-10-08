import java.io.IOException;
import java.util.ArrayList;

public class PosAvg extends MesoInherit
{
	private String stID;
	MesoStation Meso;
	
	public PosAvg(String stID) throws IOException  {
		super(new MesoStation(stID));
		this.stID=stID;
		this.Meso= new MesoStation(stID);
	}
	
	public String indexOfStationAV(int statAv,ArrayList<MesoStation> stations)	{
		//pre String
		String out="This index is average of ";
		
		//stations for av n+1
		MesoStation tempStat =stations.get(statAv -1);
		String tempStr= tempStat.getStID();
		out=out.concat(tempStr);
		
		out=out.concat(" and ");
		
		tempStat =stations.get(statAv +1);
		tempStr= tempStat.getStID();
		out=out.concat(tempStr);
		
		out=out.concat(", ");
		
		//stations for av n+2
		tempStat =stations.get(statAv -2);
		tempStr= tempStat.getStID();
		out=out.concat(tempStr);

		out=out.concat(" and ");
		
		tempStat =stations.get(statAv +2);
		tempStr= tempStat.getStID();
		out=out.concat(tempStr);

		out=out.concat(", and so on.");
		
		return out;
	}
	
	
	public int indexOfStation (String id , ArrayList<MesoStation> stations) {
		//to be returned
		int stationNum=0;
		//loop for finding stat
		int index=0;
		while(index<stations.size()) {
			
			String tempStat=(stations.get(index)).getStID();
		
			if(tempStat==id) {
			stationNum=index;	
			}
			
			index++;
		}
		
		return stationNum;
	}
	
	/*	
	@Override
	public void toString() {
		
	int indexFind=indexOfStation();
	String stat=stations.
	
		
	}
	*/
	
}
