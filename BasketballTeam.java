
public class BasketballTeam extends Team implements Visitable {
	public BasketballTeam(String name, String gender, int num) {
		super(name, gender, num);
		this.setTypeOfSport("basketball");
	}
	@Override
	public void accept(TeamVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}