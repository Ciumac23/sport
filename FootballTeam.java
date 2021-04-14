
public class FootballTeam extends Team implements Visitable {
	public FootballTeam(String name, String gender, int num) {
		super(name, gender, num);
		this.setTypeOfSport("football");
	}
	

	@Override
	public void accept(TeamVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}