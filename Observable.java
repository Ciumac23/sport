/*
 * Interfata pentru design patternul Observable
 * cu metodele notify care notifica echipele din clasament
 */
public interface Observable {
	public void notifyObserver();
	public void removeObserver(Observer o);
	public void addObserver(Observer o);
}

interface Observer {
	public void update();
}