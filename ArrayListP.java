import java.util.*;
/*
 * Clasa pentru lista de jucatori pentru fiecare echipa
 */
public class ArrayListP {
	private ArrayList<Player> list;
	private int size;
	public ArrayListP(int size) {
		this.list = new ArrayList<Player>(size);
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	public ArrayList<Player> getList() {
		return list;
	}
	public void addPlayer(String name, int score) {
		Player p = new Player(name, score);
		list.add(p);
	}
	public void displayPlayers() {
		int count = 1;
		int i = list.size();
		for(Player p : list) {
			if (p != null && i != count) {
				System.out.print("{name: " + p.getName() + ", score: " + p.getScore() + "}, ");
			}
			else {
				System.out.print("{name: " + p.getName() + ", score: " + p.getScore() + "}");
			}
			count++;
		}
	}
}