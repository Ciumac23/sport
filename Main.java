import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


public class Main {

    @SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
    		if (args[0].equals("inscriere")) {
    			ArrayTeam t = ArrayTeam.getInstance();
    			File file = new File(args[1]);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                	String firstString = scanner.nextLine();
                	String[] tokens = firstString.split(", ");
                	Team team = SimpleTeamFactory.createTeam(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                	for(int i=0; i < Integer.parseInt(tokens[3]); i++) {
                		String players = scanner.nextLine();
                		String[] playerTokens = players.split(", ");
                		team.getPlayers().addPlayer(playerTokens[0], Integer.parseInt(playerTokens[1]));
                	}
                	t.addTeam(team);
                }
                t.displayTeams();
    		}
    		if (args[0].equals("competitie")) {
    			ArrayTeam t = ArrayTeam.getInstance();
    			File file = new File(args[1]);
    			File file2 = new File(args[2]);
                Scanner scanner = new Scanner(file);
				Scanner scanner2 = new Scanner(file2);
				Team team = null;
                while (scanner.hasNextLine()) {
                	String firstString = scanner.nextLine();
                	String[] tokens = firstString.split(", ");
                	team = SimpleTeamFactory.createTeam(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                	for(int i=0; i < Integer.parseInt(tokens[3]); i++) {
                		String players = scanner.nextLine();
                		String[] playerTokens = players.split(", ");
                		team.getPlayers().addPlayer(playerTokens[0], Integer.parseInt(playerTokens[1]));
                	}
                	t.addTeam(team);
                }
                String competitionString = scanner2.nextLine();
               	String[] tokens = competitionString.split(", ");
               	BasketballCompetitions bsk = null;
               	//HandballCompetitions hnd = null;
               		if (tokens[0].equals("basketball")) {
                		bsk = new BasketballCompetitions(tokens[1]);
                		while(scanner2.hasNextLine()) {
                			String firstString = scanner2.nextLine();
                			Team competitionTeam = t.getTeamByName(firstString);
                			bsk.addTeams(competitionTeam);
                			Context context = new Context(new BasketballOperation());		
                		    context.executeStrategy(bsk);
                		    bsk.setPlaces();
                		    bsk.addObserver(competitionTeam);
                		}
                		bsk.displayWinners();
                      	bsk.notifyObserver();
                	}
               		if (tokens[0].equals("handball")) {
               			bsk = new HandballCompetitions(tokens[1]);
                		while(scanner2.hasNextLine()) {
                			String firstString = scanner2.nextLine();
                			Team competitionTeam = t.getTeamByName(firstString);
                			bsk.addTeams(competitionTeam);
                			Context context = new Context(new HandballOperation());		
                		    context.executeStrategy(bsk);
                		    bsk.setPlaces();
                		    bsk.addObserver(competitionTeam);
                		}
                		bsk.displayWinners();
                		bsk.notifyObserver();
                	}
               		if (tokens[0].equals("football")) {
                		bsk = new FootballCompetitions(tokens[1]);
                		while(scanner2.hasNextLine()) {
                			String firstString = scanner2.nextLine();
                			Team competitionTeam = t.getTeamByName(firstString);
                			bsk.addTeams(competitionTeam);
                			Context context = new Context(new FootballOperation());		
                		    context.executeStrategy(bsk);
                		    bsk.setPlaces();
                		    bsk.addObserver(competitionTeam);
                		}
                		bsk.displayWinners();
                      	bsk.notifyObserver();
                	}
    		}
    }
}