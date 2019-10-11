import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PosAvg extends MesoInherit {
	public String posStID;
	public MesoStation Meso;
	public ArrayList<MesoStation> stations;

	public PosAvg(String stID) throws IOException {
		// super(new MesoStation(stID));
		stations = new ArrayList<MesoStation>(10);
		this.readIn("Mesonet.txt");
		this.posStID = stID;
		this.Meso = new MesoStation(stID);

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

		mesonetRead.close();
	}

	public PosAvg() {
		// TODO Auto-generated constructor stub
		// super();
		this.posStID = stID;
		this.Meso = new MesoStation(stID);
		stations = super.getStations();
	}

	public String indexOfStationAV() {
		int statAv = this.indexOfStation();
		statAv--;
		
		// pre String
		String out = "This index is average of ";

		// stations for av n-1
		int oneStatAv=statAv-1;
		MesoStation tempStat = stations.get(oneStatAv);
		String tempStr = tempStat.getStID();
		out = out.concat(tempStr);
		
		out = out.concat(", ");

		// stations for av n+1
		int oneStatAvMinus=statAv+1;
		tempStat = stations.get(oneStatAvMinus);
		tempStr = tempStat.getStID();
		out = out.concat(tempStr);

		out = out.concat(" and ");
		
		// stations for av n-2
		int twostatAvMinus=statAv-2;
		tempStat = stations.get(twostatAvMinus);
		tempStr = tempStat.getStID();
		out = out.concat(tempStr);

		out = out.concat(", ");

		out = out.concat("and ");
		// stations for av n-2
		int twoStatAv=statAv+2;
		tempStat = stations.get(twoStatAv);
		tempStr = tempStat.getStID();
		out = out.concat(tempStr);
		
		out = out.concat(", and so on.");

		return out;
	}

	public int indexOfStation() {
		// to be returned
		int stationNum = 0;
		// loop for finding stat
		int index = 0;
		while (index < stations.size()) {

			String tempStat = (stations.get(index)).getStID();

			if (tempStat.equals(posStID)) {
				stationNum = index;
			}

			index++;
		}
		// accounting for zero indexed
		stationNum++;

		return stationNum;
	}

	@Override
	public String toString() {

		String outToString = this.indexOfStationAV();
		return outToString;
	}

}
