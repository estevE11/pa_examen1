package examen;

import org.w3c.dom.Node;

public interface Acb<T extends Comparable<T>> {
	void Inserir(T e) throws Exception;
	void Esborrar(T e) throws Exception;
	boolean Membre(T e);
	T Arrel() throws Exception;
	Acb<T> FillEsquerre();
	Acb<T> FillDret();
	boolean ArbreBuit();
	void Buidar();
}
