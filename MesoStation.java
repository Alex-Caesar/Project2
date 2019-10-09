import java.util.ArrayList;

/**
 * @author Mohammad Mukhtaruzzaman
 * @version 2019-09-18
*/
public class MesoStation 
{
	public String stID;
	
	public MesoStation(String stId)
	{
		this.stID = stId;
	}

	public String getStID() {
		return stID;
	}
	
	public int findStation(String id,ArrayList<MesoStation> stations) {
	
	int stationNum=0;
	
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
	
	
}