package examen;


public abstract class ContenidorBrossa implements Comparable<ContenidorBrossa> {
	public class Ubicacio {
		private String carrer;
		private int num;
	public Ubicacio(String carrer, int num) {
		 this.carrer = carrer;
		 this.num = num;
		 }
		public String getCarrer() { return carrer;}
		public int getNum() { return num;}
		public String toString() {return "Carrer: " + carrer + "número " + num;}
		public boolean equals(Object ubi) {
		if (ubi instanceof Ubicacio)
		return (((Ubicacio)ubi).carrer).equals(carrer) &&
		((Ubicacio)ubi).num==num;
		return false;
		}
		}

	private int color; //color del contenidor
private Ubicacio ubicacio; // Si està al magatzté un valor de null
private String codi; //identificador
private int any; //emmagatzema l'any de compra
protected float tara;
public final static int groc = 0;
public final static int marro = 1;
public final static int gris = 2;
public final static int verd = 3;
public final static int blau = 4;
public final static int nou = 0;
public final static int seminou = 1;
public final static int vell = 2;
public ContenidorBrossa(int color, String codi, float tara, Ubicacio on, int any) {
 // Suposa que el valor de tots els paràmetres és correcte.
 // Si on és null s’emmagatzema al magatzem de la població
 this.codi = codi;
 this.color = color;
 this.ubicacio = on;
 this.tara = tara;
this.any = any;
 }
public int getEstat() {
 if (any < 2000)
 return vell;
 if (any < 2015)
 return seminou;
 return nou;
 }
public String getCodi() {
 return codi;
 }
public String getTipusBrossa() {
 switch (color) {
 case marro:
 return "organic";
 case gris:
 return "rebuig";
 case blau:
 return "paper";
 case groc:
	 return "plastic";
 case verd:
 return "vidre";
 default:
 return "ERROR";
 }
 }
public Ubicacio getUbicacio() {
 return this.ubicacio;
 }
public String toString() {
 String s = "Codi: " + codi;
 if (ubicacio != null)
 s += "Ubicació: " + ubicacio.toString();
 else
 s += "Ubicació: retirat";
 s += "Tipus brossa " + getTipusBrossa();
 s += "Tara: " + tara;
 return s;
 }
public int compareTo(ContenidorBrossa o) {
 return codi.compareTo(o.codi);
 }
public abstract void buidat(double quilos);
}
