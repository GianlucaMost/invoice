package logic;

public class Steuerinformationen {
 private static final Steuerinformationen Steuer = new Steuerinformationen();
 
 private Steuerinformationen(){
	 System.out.println("Steruerinformatioen erstellt");
 }
 public static Steuerinformationen getInfos(){
	 return Steuer;
 }
}
