package examen;

public class Organic extends ContenidorBrossa {
private float reciclat; //sempre és un valor positiu
public Organic(String codi, float tara, Ubicacio situacio, int any) {
 super(ContenidorBrossa.marro, codi, tara, situacio, any);
 reciclat = 0;
 }
public void buidat(double quilos) {
/*incrementa l'atribut reciclat tenint en compte els quilos de buidat
del paràmetre i el rendiment del tipus de contenidor*/
 }
public float getReciclat() { return reciclat;}
}