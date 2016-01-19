
public class Waffe {
	private enum Waffentyp { Hand, Kurzschwert, Schwert, Speer, Dreizack, Peitsche };
	Waffentyp _typ;
	
	private Waffe(Waffentyp typ) {
		_typ = typ;
	}
	
	public int calcTrefferPunkte(){
		Wuerfel w6 = new Wuerfel(6);
		switch (_typ) {
			case Peitsche:
				return w6.wuerfle() + 1;
			case Kurzschwert:
				return w6.wuerfle() + 2;
			case Speer:
				return w6.wuerfle() + 3;
			case Schwert:
				return w6.wuerfle() + 4;
			case Dreizack:
				return w6.wuerfle() + 5;
			default:
				return w6.wuerfle();
		}
	}
	
	public static Waffe createWaffe() {
		Wuerfel w6 = new Wuerfel(6);
		switch (w6.wuerfle()) {
			case 2:
				return new Waffe(Waffentyp.Kurzschwert);
			case 3:
				return new Waffe(Waffentyp.Speer);
			case 4:
				return new Waffe(Waffentyp.Schwert);
			case 5:
				return new Waffe(Waffentyp.Dreizack);
			case 6:
				return new Waffe(Waffentyp.Peitsche);
			default:
				return new Waffe(Waffentyp.Hand);
		}
	}

	public String toString()
	{
		return ""+_typ;
	}
}
