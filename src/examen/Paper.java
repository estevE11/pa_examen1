package examen;

public class Paper extends ContenidorBrossa {
private long reciclat;
public Paper(String codi, float tara, Ubicacio situacio, int any) {
 super(ContenidorBrossa.blau, codi, tara, situacio, any);
 reciclat = 0;
 }
public void buidat(double quilos) {
/*incrementa l'atribut reciclat tenint en compte els quilos de buidat
del paràmetre i el rendiment del tipus de contenidor */
 }
public long getReciclat() {
 return reciclat;
 }
}
