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
		stations=new ArrayList<MesoStation>(10);
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

	public String getStID() {
		return posStID;
	}

	
	public ArrayList<MesoStation> getStations() {
		return stations;
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

		// pre String
		String out = "This index is average of ";

		// stations for av n+1
		MesoStation tempStat = stations.get(statAv - 1);
		String tempStr = tempStat.getStID();
		out = out.concat(tempStr);

		statAv++;

		out = out.concat(" and ");

		tempStat = stations.get(statAv + 1);
		tempStr = tempStat.getStID();
		out = out.concat(tempStr);

		statAv--;

		out = out.concat(", ");

		// stations for av n+2
		tempStat = stations.get(statAv - 2);
		tempStr = tempStat.getStID();
		out = out.concat(tempStr);

		statAv++;
		statAv++;

		out = out.concat(" and ");

		tempStat = stations.get(statAv + 2);
		tempStr = tempStat.getStID();
		out = out.concat(tempStr);

		statAv--;
		statAv--;

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
		// System.out.println(outToString);
		return outToString;
	}

}
