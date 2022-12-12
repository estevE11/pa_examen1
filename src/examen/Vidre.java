package examen;

public class Vidre extends ContenidorBrossa {
private double reciclat;
public Vidre(String codi, float tara, Ubicacio situacio, int any) {
 super(ContenidorBrossa.verd, codi, tara, situacio, any);
 reciclat = 0;
 }
public double getReciclat() {
 return reciclat;
 }
public void buidat(double quilos) {
/* incrementa l'atribut reciclat tenint en compte els quilos de buidat
del paràmetre i el rendiment del tipus de contenidor */
 }
}