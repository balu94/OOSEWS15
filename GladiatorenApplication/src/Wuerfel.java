import java.util.Random;

public class Wuerfel {
	
	
	private int _seiten;
		
	
	public Wuerfel(int Anzseiten){
		
		 _seiten= Anzseiten ;
		
	}
	
	public int wuerfle(){
		
		return (int) (_seiten *Math.random()+1);
	}

	public static void main (String [] args){
	    // Code zum Testen der Würfel	
		Wuerfel w6= new Wuerfel(6);
		
		System.out.println("Test W6:");
		for (int i=0;i<10;i++)
			System.out.println(w6.wuerfle());
		
		Wuerfel w20 = new Wuerfel(20);
		System.out.println("\n\nTest W20:\n");
		for (int i=0;i<10;i++)
			System.out.println(w20.wuerfle());
		
	}




}