package examen;

import examen.ContenidorBrossa.Ubicacio;

public class Poblacio {
	private class nodeU {
		private Ubicacio inf;
		private int quants; // quants contenidors en la ubicació
		private nodeU seg;
		public nodeU(Ubicacio on, nodeU seg) {
			this.inf = on;
			this.quants = 0;
			this.seg = seg;
		}
		
		public void nouContenidor() {
			this.quants++;
		}

		public boolean eliminarContenidor() {
			this.quants--;
			return this.quants == 0;
		}
	}

	private nodeU ubicacions; //seqüència enllaçada d'ubicacions de la població
	 // on hi ha contenidors
	private AcbEnll contenidors[][];
	public Poblacio() {
		contenidors = new AcbEnll[6][3];
		for (int i = 0; i <contenidors.length; i++)
			for (int j = 0; j < contenidors[i].length; j++)
				contenidors[i][j] = new AcbEnll();
		ubicacions = null;
	}
	
	// Exercici 1
	public Ubicacio MesContenidors() {
		nodeU mesGran =  new nodeU(null, null);
		nodeU current = this.ubicacions;
		if(current == null) return null;
		while(current != null) {
			if(current.quants > mesGran.quants) {
				mesGran = current;
			}
			current = current.seg;
		}
		return mesGran.inf;
	}
	
	// Exercici 2
	public void afegirContenidor(ContenidorBrossa f) {
		String tipusBrossa = f.getTipusBrossa();
		
		AcbEnll arbre = this.getArbreOnVa(f);
		
		if(!arbre.Membre(f)) {
			try {
				arbre.Inserir(f);
				this.afegir_A_Ubicacio(f.getUbicacio());
			} catch (Exception e) {
			}
		}
		
	}
	
	private AcbEnll getArbreOnVa(ContenidorBrossa f) {
		if(f.getUbicacio() == null)
			return this.contenidors[5][f.getEstat()];
		
		switch(f.getTipusBrossa()) {
		case "organic":
			return this.contenidors[ContenidorBrossa.marro][f.getEstat()];
		case "rebuig":
			return this.contenidors[ContenidorBrossa.gris][f.getEstat()];
		case "paper":
			return this.contenidors[ContenidorBrossa.blau][f.getEstat()];
		case "plastic":
			return this.contenidors[ContenidorBrossa.groc][f.getEstat()];
		case "vidre":
			return this.contenidors[ContenidorBrossa.verd][f.getEstat()];
		default:
			return null;
		}
	}
	
	private void afegir_A_Ubicacio(Ubicacio u) {
		nodeU current = this.ubicacions;
		if(current == null) {
			current = new nodeU(u, null);
			current.nouContenidor();
			return;
		}
		
		while(current != null) {
			if(current.inf.equals(u)) {
				current.nouContenidor();
				return;
			}
			current = current.seg;
		}
		
		nodeU nou = new nodeU(u, null);
		nou.nouContenidor();
		current = new nodeU(current.inf, nou);
	}
	
	// Exercici 3
	public void eliminarContenidor(ContenidorBrossa f) {
		AcbEnll arbre = this.getArbreOnVa(f);
		if(arbre.ArbreBuit()) return;
		
		try {
			arbre.Esborrar(f);
			this.eliminar_De_Ubicacio(f.getUbicacio());
		} catch (Exception e) {
		}
	}
	
	private void eliminar_De_Ubicacio(Ubicacio u) {
		nodeU past = null;
		nodeU current = this.ubicacions;
		if(current == null) {
			return;
		}
		
		while(current != null) {
			if(current.inf.equals(u)) {
				if(current.eliminarContenidor()) {
					past.seg = current.seg;
					return;
				}
			}
			past = current;
			current = current.seg;
		}		
	}
	
	// Exercici 4
	public ContenidorBrossa mesReciclatOrganic(int estat) throws Exception{
		AcbEnll arbre = this.contenidors[ContenidorBrossa.marro][estat];
		return this.mesReciclatOrganic(arbre);
	}
	
	private ContenidorBrossa mesReciclatOrganic(AcbEnll arbre) {
		Organic mesGran = null;
		try {
			mesGran = (Organic) arbre.Arrel();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		if(arbre.FillDret() == null && arbre.FillEsquerre() == null) {
			return mesGran;
		}
		try {
			if(arbre.FillEsquerre() != null) {
				Organic contEsquerre = (Organic) mesReciclatOrganic((AcbEnll)arbre.FillEsquerre());
				if(contEsquerre.getReciclat() > mesGran.getReciclat()) {
					mesGran = contEsquerre;
				}
			}
			if(arbre.FillDret() != null) {
				Organic contDret = (Organic) mesReciclatOrganic((AcbEnll)arbre.FillDret());
				if(contDret.getReciclat() > mesGran.getReciclat()) {
					mesGran = contDret;
				}
			}
			return mesGran;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Exercici 5
	public String toString() {
		String res = "";
		
		int[] ordre = new int[] {
			ContenidorBrossa.verd,
			ContenidorBrossa.gris,
			ContenidorBrossa.marro,
			ContenidorBrossa.groc
		};
		
		for(int i = 0; i < ordre.length; i++) {
			AcbEnll arbre = this.contenidors[ordre[i]][ContenidorBrossa.vell];
			res += this.getStringArbre(arbre);
		}
		
		return res;
	}
	
	private String getStringArbre(AcbEnll arbre) {
		String res = arbre.toString();
		if(arbre.FillEsquerre() != null) res += getStringArbre((AcbEnll)arbre.FillEsquerre());
		if(arbre.FillDret() != null) res += getStringArbre((AcbEnll)arbre.FillDret());
		return res;
	}
	
	// Exercici 6
	public String menorCodi(int color) {
		String mesPetit = null;
		
		for(int i = 0; i < this.contenidors[color].length; i++) {
			AcbEnll current = this.contenidors[color][i];
			
			while(current !=  null) {
				try {
					String curr_codi = current.Arrel().getCodi();
					if(mesPetit == null || curr_codi.compareTo(mesPetit) < 0) {
						mesPetit = curr_codi;
					}
					current = (AcbEnll) current.FillEsquerre();
				} catch (Exception e) {
				}	
				
			}
		}
		return mesPetit;
	}
} 
