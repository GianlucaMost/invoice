package logic;

/**
 * Created by gianlucamost on 02.05.16.
 */
public abstract class Mensch {
	
	private String Name;
	private String Vorname;

	public Mensch() {
	}

    public Mensch(String name, String vorname) {
        Name = name;
        Vorname = vorname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }
}
