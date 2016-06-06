package logic;

public class Steuerinformationen {
 private static final Steuerinformationen Steuer = new Steuerinformationen();
 
 private Steuerinformationen(){
	 System.out.println("Steuerinformatioen erstellt");
 }
 public static Steuerinformationen getInfos(){
	 return Steuer;
 }
}
