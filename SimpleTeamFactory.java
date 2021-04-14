/*
 * Design patternul de Factory, verificarea tipului de sport si crearea instantei cu acel tip
 */
public class SimpleTeamFactory {
	public static Team createTeam(String type, String name, String gender, int num) {
		Team team = null;
		if (type.equals("football")) {
			team = new FootballTeam(name, gender, num);
		}
		else if (type.equals("handball")) {
			team = new HandballTeam(name, gender, num);
		}
		else if (type.equals("basketball")) {
			team = new BasketballTeam(name, gender, num);
		}
		return team;
	}
}