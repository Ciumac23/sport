
/*
 * Clasa reprezinta o echipa cu campurile respective pentru a identifica o echipa
 */
public class Team implements Observer {
	private String teamName;
	private String typeOfSport;
	private String gender;
	private int numberOfPlayers;
	private ArrayListP p;
	private int place = 0;
	private int points;
	private Observable observable = null;
	
	public String getTypeOfSport() {
		return typeOfSport;
	}
	public void setTypeOfSport(String type) {
		this.typeOfSport = type;
	}
	public String getName() {
		return teamName;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getGender() {
		return gender;
	}
	public int getPlace() {
		return place;
	}
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public ArrayListP getPlayers() {
		return p;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public Team(Observable observable) {
		this.observable = observable;
	}
	public Team(String name, String gender, int number) {
		this.teamName = name;
		this.gender = gender;
		this.numberOfPlayers = number;
		this.p = new ArrayListP(number);
	}
	@Override
	public void update() {
		//cand s-a jucat toate meciurile
		System.out.println("Echipa " + this.getName() + " a ocupat locul " + this.getPlace());
	}
}

/*
 * clasa ArrayTeam va colecta toate echipele create intr-un singur vector
 * pentru a putea accesa usor echipele
 * Design patternul Singleton
 */
class ArrayTeam {
	private int size;
	private static Team instanceOf = null;
	private static Team[] array;
	
	private ArrayTeam() {
		this.size = 0;
		ArrayTeam.array = new Team[50];
	}
	public static ArrayTeam getInstance() {
		if (instanceOf == null) {
			new ArrayTeam();
		}
		return new ArrayTeam();
	}
	
	public void addTeam(Team t) {
		array[size] = t;
		size++;
	}
	public void displayTeams() {
		for (Team t : array) {
			if (t != null) {
				System.out.print("{teamName: " + t.getName() + ", gender: " + t.getGender() 
				+ ", numberOfPlayers: " + t.getNumberOfPlayers() + ", players: [" );
				t.getPlayers().displayPlayers();
				System.out.println("]}");
			}
		}
	}
	public Team getTeamByName(String name) {
		for (int i=0; i < size; i++) {
			if (name.equals(array[i].getName()))
				return array[i];
		}
		return null;
	}
}