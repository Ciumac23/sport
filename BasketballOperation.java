/*
 * Clasa care implementeaza design patternul Strategy pentru calcularea scorului
 */
public class BasketballOperation implements Strategy{
	@Override
	public void calculatePoints(BasketballCompetitions competition) {
		for(Team t : competition.getTeams()) {
			if (t != null) {
				int sum = 0;
				for (Player p : t.getPlayers().getList()) {
					sum += p.getScore();
				}
				t.setPoints(sum/t.getNumberOfPlayers());
			}
		}
	}	
}
class HandballOperation extends BasketballOperation {
	public void calculatePoints(HandballCompetitions competition) {
		for(Team t : competition.getTeams()) {
			if (t != null) {
				int sum = 0;
				int prod = 1;
				if ( competition.getGender().equals("masculin")) {
					for (Player p : t.getPlayers().getList()) {
						sum += p.getScore();
					}
					t.setPoints(sum);
				} else {
					for (Player p : t.getPlayers().getList()) {
						prod *= p.getScore();
					}
					t.setPoints(prod);
				}
			}
		}
	}
}
class FootballOperation extends BasketballOperation {
	
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
	public void calculatePoints(FootballCompetitions competition) {
		// TODO Auto-generated method stub
		for(Team t : competition.getTeams()) {
			if (t != null) {
				if ( t.getGender().equals("masculin")) {
					int result = 2 * bestScore(t) + (sumOfScores(t)-bestScore(t));
					t.setPoints(result);
				} else {
					int result = 2 * worstScore(t) + (sumOfScores(t)-worstScore(t));
					t.setPoints(result);		
				}
			}
		}
	}
	
}