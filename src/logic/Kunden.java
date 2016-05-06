package logic;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Kunden {
	
	List<Kunde> kunde = new LinkedList<Kunde>();
	 @XmlElement( name = "kunde" )
	public List<Kunde> getKunde(){
		return kunde;
		
	}
	public void setKunde(List<Kunde> kunde){
		this.kunde = kunde;
	}
	
}
