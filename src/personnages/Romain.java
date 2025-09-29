package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipements = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int sauvForce = force;
		force -= forceCoup;
		if (force < 1) {
			parler("J'abandonne !");
		} else {
			parler("A�e");
		}
		assert force < sauvForce;
		assert isInvariantVerified();
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}
	
	private void equiperAnn(Equipement piece) {
		equipements[nbEquipements]=piece;
		nbEquipements++;
		System.out.println("Le soldat "+nom+" s'équipe avec un "+piece);
	}

	public void sEquiper(Equipement piece) {
		switch (nbEquipements) {
		case 2:
			System.out.println("Le soldat "+nom+" est deja bien equipe !");
		case 1:{
			if (equipements[0]==piece) {
				System.out.println("Le soldat "+nom+" possede deja un "+piece);
			} else {
				equiperAnn(piece);
			}
		}
		case 0:{
			equiperAnn(piece);
		}
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		//minus.sEquiper(Equipement.BOUCLIER);
		//minus.sEquiper(Equipement.CASQUE);
	}
}
