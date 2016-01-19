public class Arena{
	
	IReporter _reporter;
	static boolean leben=true;
	private static String[] gladiatorenName ={"Spartacus","Didio","Hamas","Relio","Lucador","Siba","Zeso","Yugi","Herkules","Susa","Rallas","Ulas","Luca", "Midas","Loki","Thor","Superman","Zeus","Opus","Gerald"}; 
	
	Gladiator _glad1;
	
	Gladiator _glad2;
	
	Arena(IReporter rep){
		
		_reporter = rep;
		Wuerfel w20 = new Wuerfel(20);
		
		_glad1 = new Gladiator(gladiatorenName[w20.wuerfle()-1]);// Gebe mir von Gladiator den Index an der Stelle die gewürfelt worden ist
		_glad2 = new Gladiator(gladiatorenName[w20.wuerfle()-1]);
		
		if (_glad1.getName().equals(_glad2.getName())) //Hier: Die Namen vergleichen!
		{
			
			_glad1 = new Gladiator(gladiatorenName[w20.wuerfle()-1]);
		}
		System.out.println("Es kaempfen : "+ _glad1.getName()+ " vs "+ _glad2.getName());
		
	}
	
	public Gladiator getGlad1()
	{
		return _glad1;
	}
	
	public Gladiator getGlad2()
	{
		return _glad2;
	}
	
	public boolean starteKampfRunde(){
	
		Wuerfel w6 = new Wuerfel(6);
	
		if (_glad1.attacke()){
			System.out.println(_glad1.getName() + " attackiert");
			System.out.println();
			if(_glad2.parade()){
				System.out.println(_glad2.getName() + " kann blocken");
				System.out.println();
			}
			else {
				System.out.println(_glad2.getName() + " wird getroffen");
				System.out.println();
				
				// boolean treffer2=_glad2.nehmeSchaden(w6.wuerfle());
				
					if (_glad2.nehmeSchaden(w6.wuerfle())==false){
						return false;
						
				
				}
				
			}
		}
		else {
			System.out.println("------");
			System.out.println();
			
		}
		
		if (_glad2.attacke()){
			System.out.println(_glad2.getName() + " attackiert");
			System.out.println();
			if(_glad1.parade()){
				System.out.println(_glad1.getName() + " kann blocken");
				System.out.println();
			}
			else {
				System.out.println(_glad1.getName() + " wird getroffen");
				System.out.println();
				
				// boolean treffer=_glad1.nehmeSchaden(w6.wuerfle());
				
					if (_glad1.nehmeSchaden(w6.wuerfle())==false){
						return false;
						
					}
					
			}
		}
		else {
			System.out.println("------");
			System.out.println();
		}
		
		return true;
	}
	
	public void starteKampf(){
		
		
			while(starteKampfRunde()==true){
				try{
					Thread.sleep (1500); // 1,5s schlafen, um den Kampf "live" zu verfolgen
				} catch (Exception e){ } // Try-Catch ist nötig, dass Thread.sleep mittels throws-Direktive angibt eine InterruptedException zu werfen.
			}
		
	
	
	
	}
	
	
/*	public static void main ( String[] args){
		
//	   Arena a1 = new Arena ();

//   	   a1.starteKampf();

		
	}*/
	
}