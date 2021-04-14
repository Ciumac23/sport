import java.util.*;
/*
 * Competitia de basket, clasa data are o lista de echipe 
 * in care vor fi adaugate toate echipele pentru competitia de basket
 * si o lista de echipe care au castigat competitia, primele 3 echipe
 */
public class BasketballCompetitions implements Observable {
	private String typeOfSport = "basketball";
	private String gender;
	private LinkedList<Team> teams;
	private LinkedList<Observer> winners;
	
	public BasketballCompetitions(String gender) {
		this.gender = gender;
		this.teams = new LinkedList<Team>();
		this.winners = new LinkedList<Observer>();
	}
	public String getTypeOfSport() {
		return typeOfSport;
	}
	public String getGender() {
		return gender;
	}
	public LinkedList<Team> getTeams() {
		return teams;
	}
	public LinkedList<Observer> getWinners() {
		return winners;
	}
	public void addTeams(Team t) {
		if (t.getTypeOfSport().equals(this.getTypeOfSport()))
		teams.add(t);
	}
	public void displayTeams() {
		for (Team t : teams) {
			if (t != null)
			System.out.println("Team " + t.getName() + " took" + t.getPlace() + " place " + this.getTypeOfSport() + "score " + t.getPoints());
		}
	}
	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (Observer team : winners) {
			team.update();
		}
	}
	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		winners.remove(o);
	}
	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		winners.add(o);
	}
	public void setPlaces() {
		Collections.sort(teams, new SortByPoints());
		for(int i=0; i < teams.size(); i++) {
			teams.get(i).setPlace(i+1);
		}
	}
	public void displayWinners() {
		for(int i=0; i < 3; i++) {
			System.out.println(teams.get(i).getName());
		}
	}
}
/*
 * Clasa pentru competitia de fotbal, derivata clasei BasketCompetition
 */
class FootballCompetitions extends BasketballCompetitions {
	private String typeOfSport = "football";
	public FootballCompetitions(String gender) {
		super(gender);
	}
	public String getTypeOfSport() {
		return typeOfSport;
	}
}

/*
 * Clasa pentru competitia de handball, derivata clasei BasketCompetition
 */

class HandballCompetitions extends BasketballCompetitions {
	private String typeOfSport = "handball";
	public HandballCompetitions(String gender) {
		super(gender);
	}
	public String getTypeOfSport() {
		return typeOfSport;
	}
}
/*
 * Clasa care implementeaza interfata comparator pentru 
 * sortarea echipelor dupa scor si calificarea clasamentului
 */
class SortByPoints implements Comparator<Team>{
	 
    @Override
    public int compare(Team t1, Team t2) {
        if(t1.getPoints() < t2.getPoints()){
            return 1;
        } else {
            return -1;
        }
    }
}
	