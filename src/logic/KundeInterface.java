package logic;

import java.util.List;

/**
 * Created by gianlucamost on 02.05.16.
 */
public interface KundeInterface {
    public int getKundennr();
    public void setKundennr(int kundennr);
    public String getAdresse();
    public void setAdresse(String adresse);
    public List<Auto> getAutoList();
//    public void setAutoList(List<Auto> autoList);
    public void addAuto(Auto car);
}
