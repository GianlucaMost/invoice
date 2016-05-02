package logic;

/**
 * Created by gianlucamost on 02.05.16.
 */
public abstract class Rechnungsposition {

    private Rechnung rechnung;

    public Rechnungsposition(Rechnung rechnung) {
        this.rechnung = rechnung;
    }

    public Rechnung getRechnung() {
        return rechnung;
    }

    public void setRechnung(Rechnung rechnung) {
        this.rechnung = rechnung;
    }
}
