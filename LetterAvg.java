import java.util.ArrayList;

public class LetterAvg extends PosAvg	//extends MesoInherit 
{
	private ArrayList<MesoStation> stations;
	char c;
	public LetterAvg(char c){
		super();
		this.c=c;
		stations=super.getStations();
	}

	public LetterAvg() {
		// TODO Auto-generated constructor stub
		super();
		stations=super.getStations();
	}

	public String numberOfStationWithLetterAvg() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
