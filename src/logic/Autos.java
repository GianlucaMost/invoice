package logic;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Autos {
	
	List<Auto> auto = new LinkedList<Auto>();
	 @XmlElement( name = "auto" )
	public List<Auto> getAuto(){
		return auto;
		
	}
	public void setAuto(List<Auto> auto){
		this.auto = auto;
	}
	
}
