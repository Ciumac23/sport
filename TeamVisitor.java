
public class TeamVisitor implements Visitor {
	public int bestScore(Team team) {
		int maxim = 0;
		for (Player p : team.getPlayers().getList()) {
			if ( maxim < p.getScore() ) {
				maxim = p.getScore();
			}
		}
		return maxim;
	}
	public int worstScore(Team team) {
		int minim = 99999;
		for (Player p : team.getPlayers().getList()) {
			if ( minim > p.getScore() ) {
				minim = p.getScore();
			}
		}
		return minim;
	}
	public int sumOfScores(Team team) {
		int sum = 0;
		for (Player p : team.getPlayers().getList()) {
			sum += p.getScore();
		}
		return sum;
	}
	public int visit(FootballTeam team) {
		if ( team.getGender().equals("masculin")) {
			int result = 2 * bestScore(team) + (sumOfScores(team)-bestScore(team));
			return result;
		} else {
			int result = 2 * worstScore(team) + (sumOfScores(team)-worstScore(team));
			team.setPoints(result);
			return result;			
		}
	}
	public int visit(BasketballTeam team) {
		int sum = 0;
		int players = 0;
		for (Player p : team.getPlayers().getList()) {
			sum += p.getScore();
			players++;
		}
		team.setPoints(sum/players);
		return sum/players;
	}
	public int visit(HandballTeam team) {
		int sum = 0;
		int prod = 1;
		if ( team.getGender().equals("masculin")) {
			for (Player p : team.getPlayers().getList()) {
				sum += p.getScore();
			}
			team.setPoints(sum);
			return sum;
		} else {
			for (Player p : team.getPlayers().getList()) {
				prod *= p.getScore();
			}
			team.setPoints(prod);
			return prod;
		}
	}
}

interface Visitor {
	public int visit(FootballTeam team);
	public int visit(BasketballTeam team);
	public int visit(HandballTeam team);
}