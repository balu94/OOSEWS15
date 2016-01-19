public class Gladiator{

	private String _name;
	private int _at; // Attackewert
	private int _pa;//Paradewert
	private int _rs;//Rüstschutz
	private int _le;//Lebensenergie

	Gladiator(String Name){
		
		this._name = Name;
		
		_rs=0;
		
		Wuerfel w6= new Wuerfel(6);
		
		_at= 5+ w6.wuerfle();
		_pa= 5+ w6.wuerfle();
		_le= 30 + w6.wuerfle();
		
	}

	public boolean attacke(){		
		Wuerfel w20 = new Wuerfel(20);

		if (w20.wuerfle()<=_at){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	public boolean parade(){
		
		Wuerfel w20= new Wuerfel(20);
		
		if (w20.wuerfle()<=_pa){
			return true;
		}
		else{
			return false;
	
		}
	}
	
	public boolean nehmeSchaden(int tp){
	
		int sp= tp-_rs;
		
		_le = _le-sp;
		
		
		if (_le<5 && _le>0){
			System.out.println(_name+" ist kampfunfaehig");
			return false;
		}
		if (_le<=0){
			System.out.println(_name+" ist tot");
			return false;
		}
	
		return true;
	
	}
	
	public String getName(){
		return _name;
	}
	
	public static void main (String [] args){
        Gladiator g1 = new Gladiator ("Spartakus");
		Gladiator g2 = new Gladiator ("Commodus");
		
		//Alle Eigenschaften des ersten Gladiators
		System.out.printf ("%s: Attackewert - %d, Paradewert - %d, Lebenspunkte - %d. ", g1._name, g1._at, g1._pa, g1._le ); 
		//Alle Eigenschaften des zweiten Gladiators
		System.out.printf ("\n%s: Attackewert - %d, Paradewert - %d, Lebenspunkte - %d.\n ", g2._name, g2._at, g2._pa, g2._le );
		
		System.out.println ();
		
		
		if (g1.attacke() && !g2.parade()){
			g2.nehmeSchaden(10);
				
			System.out.println (g1._name + " attackiert erfolgreich -> " + "Lebensenergie: " + g1._le);  
			System.out.println (g2._name + " parade misslingt -> " + "Lebensenergie: " + g2._le);
		} else {
			g1.nehmeSchaden(10);
		
			System.out.println (g1._name + " parade misslingt -> " + "Lebensenergie: " + g1._le);  
			System.out.println (g2._name + " attackiert erfolgreich -> " + "Lebensenergie: " + g2._le);
		}
		
	}

	
}