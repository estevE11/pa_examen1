package examen;

public class Plastic extends ContenidorBrossa {
private int reciclat;
public Plastic(String codi, float tara, Ubicacio situacio, int any) {
 super(ContenidorBrossa.groc, codi, tara, situacio, any);
 reciclat = 0;
 }
public int getReciclat() { return reciclat;}
public void buidat(double quilos) { 
/* incrementa l'atribut reciclat tenint en compte els quilos de buidat
del paràmetre i el rendiment del tipus de contenidor */
 }
}
