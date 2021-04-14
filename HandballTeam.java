
public class HandballTeam extends Team implements Visitable {
	public HandballTeam(String name, String gender, int num) {
		super(name, gender, num);
		this.setTypeOfSport("handball");
	}

	@Override
	public void accept(TeamVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}