package logic;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ersatzteile {
	
	List<Ersatzteil> ersatzteil = new LinkedList<Ersatzteil>();
	 @XmlElement( name = "ersatzteil" )
	public List<Ersatzteil> getErsatzteil(){
		return ersatzteil;
		
	}
	public void setErsatzteil(List<Ersatzteil> ersatzteil){
		this.ersatzteil = ersatzteil;
	}
	
}
