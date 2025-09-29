package personnages;

public class Village {
	private static final int NB_MAX_VILLAGEOIS = 30;

	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois = new Gaulois[NB_MAX_VILLAGEOIS];

	public Village(String nom, Gaulois chef) {
		this.nom = nom;
		this.chef = chef;
		chef.setVillage(this);
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois++] = gaulois;
		gaulois.setVillage(this);
	}

	public Gaulois trouverVillageois(int num) {
		if (num > nbVillageois) {
			System.out.println("Il n'y a pas autant de villageois dans le village !");
			return null;
		}
		Gaulois gaulois = villageois[num - 1];
		if (gaulois == null) {
			System.out.println("Il n'y a pas autant de villageois dans le village !");
		}
		return gaulois;
	}

	public void afficherVillage() {
		System.out.println("Dans le village " + nom + " de chef " + chef + " vivent :");
		for (int i = 1; i <= nbVillageois; i++) {
			System.out.println(trouverVillageois(i));
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village vi = new Village("Village des Irréductibles", abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		vi.ajouterVillageois(asterix);
		Gaulois gaulois = vi.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = vi.trouverVillageois(2);
		System.out.println(gaulois);
		vi.afficherVillage();
		Gaulois obelix = new Gaulois("Obélix", 25);
		vi.ajouterVillageois(obelix);
		vi.afficherVillage();
		Gaulois doublepolemix = new Gaulois("Doublepolemix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
	}
}
