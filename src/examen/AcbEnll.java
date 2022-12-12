package examen;

public class AcbEnll implements Acb<ContenidorBrossa> {
	private class NodeA {
		Object inf; //La classe Capitol la trobaràs més endavant
		NodeA esq, drt;
		public NodeA(Object m, NodeA e, NodeA d) {
			inf = m;
			esq = e;
			drt = d;
		}
	}

	@Override
	public void Inserir(ContenidorBrossa e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Esborrar(ContenidorBrossa e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Membre(ContenidorBrossa e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContenidorBrossa Arrel() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acb<ContenidorBrossa> FillEsquerre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acb<ContenidorBrossa> FillDret() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ArbreBuit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Buidar() {
		// TODO Auto-generated method stub
		
	}


}