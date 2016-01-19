public class Gladiator
{
  private String _name;
  private int _at, _pa, _rs, _le;
  private Waffe _waffe;


  public Gladiator(String name)
  {
    Wuerfel w6= new Wuerfel(6);
    int w=w6.wuerfle();
    // System.out.println("Ausgabe w: "+w);
    // System.out.println(w6.wuerfle());
    _name = name;
    _at= w+5;
    _pa= w+5;
    _rs= 0;
    _le= w+30;
    _waffe = Waffe.createWaffe();
    // System.out.println("Gladiator mit Name "+_name+" erzeugt!");

  }

  public int calcTrefferPunkte() 
  {
    return _waffe.calcTrefferPunkte();
  }

/*  public static void main(String[] args)
  {
    Gladiator herkules = new Gladiator("herkules");
    System.out.println(herkules);

    for (int i=1; i<=10; i++) 
    {  
      System.out.printf("Test-Attacke:\t%b\n", herkules.attacke());
      System.out.printf("Test-Parade:\t%b\n", herkules.parade());
      System.out.printf("\n");
    }


    System.out.println("Nehme Schaden: "+herkules.nehmeSchaden(5));
    System.out.println(herkules);
  }
*/


  @Override // signalisiert Kompiler, dass Methode überschrieben wird. Schutzmechanismus
  public String toString()
  {
	  return this._name;
//	  return "_at: "+this._at+ " _pa: "+this._pa+" _rs: "+this._rs+" _le: "+this._le+" Waffe:"+this._waffe;
  }

  public boolean attacke()
  {
    Wuerfel w20 = new Wuerfel(20);
    int augensumme = w20.wuerfle();
    if(augensumme<=this._at) return true;
    return false;
  }

  // getter für Name  
  public String getName()
  {
    return this._name;
  }

  public boolean parade()
  {
    Wuerfel w20 = new Wuerfel(20);
    int augensumme = w20.wuerfle();
    if(augensumme<=this._pa) return true;
    return false;
  }

  public boolean nehmeSchaden(int tp)
  {
    // System.out.println("Trefferpunkte: "+tp);
    tp -= this._rs;
    this._le -= tp;
    // System.out.println("Lebensenergie nach Schaden: "+this._le);
    if(this._le<5)
    {
      System.out.println("");
      System.out.println(this._name+" ist kampfunfähig");
      return false;
    }
    if(this._le<=0)
    {
      System.out.println(this._name+" ist tot");
      return false;
    }
    return true;
  }
}