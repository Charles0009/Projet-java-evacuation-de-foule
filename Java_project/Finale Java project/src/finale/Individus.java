package finale;
/**
 * <b> Individus est la classe qui représente les personnes de notre simulation.</b>
 * <p>
 * Un personnage est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un réel qui définit la position de l'individu selon l'axe des
 * abscisses.</li>
 * <li>Un réel qui définit la position de l'individu selon l'axe des
 * ordonnées.</li>
 * <li>Un réel qui définit le déplacement de la personne selon l'axe x </li>
 * <li>Un réel qui définit le déplacement de la personne selon l'axe y </li> 
 * <li>Un réel qui définit la taille de l'individu.</li>
 * <li>Un réel qui définit la vitesse max de l'individu.</li>
 * <li>Un entier qui définit le temps de réaction d'un individu.</li>
 * <li>Un Etages définissant dans quel étage évolue l'individu</li>
 * </ul>
 * </p>
 * 
 * @author Antoine
 *
 */
public class Individus {
	/**
	 * La position de l'individu selon l'axe des abscisses.
	 * 
	 * @see Individus#x
	 */
	public double x;
	/**
	 * La position de l'individu selon l'axe des ordonnées.
	 * 
	 * @see Individus#y
	 */
	public double y;
	/**
	 * Le déplacement de la personne selon l'axe x.
	 * 
	 * @see Individus#dx
	 */
	public double dx;
	/**
	 * Le déplacement de la personne selon l'axe y.
	 * 
	 * @see Individus#dy
	 */
	public double dy;
	/**
	 * La taille d'un individu.
	 * 
	 * @see Individus#taille
	 */
	public double taille;
	/**
	 * La vitesse maximale d'un individu.
	 * 
	 * @see Individus#vitesseMax
	 */
	public double vitesseMax;
	/**
	 * Le temps de réaction d'un individu.
	 * 
	 * @see Individus#tempsReaction
	 */
	int tempsReaction;
	/**
	 * L'étage dans lequel évolue l'individu
	 * 
	 * @see Individus#etage
	 */
	public Etages etage;
	/**
	 * Le modèle dans lequel la simulation se déroule.
	 * 
	 * @see Individus#modele
	 */
	public Modele modele;
	/**
	 * L'escalier dans lequel se trouve l'individu. Si l'individu n'est pas
	 * dans un escalier, la valeur est null
	 * 
	 * @see Individus#isInStairs
	 */
	public Escaliers isInStairs;
	/**
	 * Le temps passé dans l'escalier pour l'individu.
	 * 
	 * @see Individus#timeInStairs
	 */
	public int timeInStairs = 0;
	
	
	/**
	 * Constructeur Individus.
	 * <p>
	 * A la construction d'un individu on lui affecte une taille, un temps
	 * de réaction, une vitesee max, un déplacement et une position choisi
	 * de manière aléatoire.
	 * </p>
	 * 
	 * @param etage   L'étage dans lequel va évoluer notre individus.
	 * @param modele  Le modele de notre simulation.
	 * 
	 * @see Individus#etage
	 * @see Individus#modele
	 */
	public Individus(Etages etage , Modele modele) {
		System.out.println("				Creation de l'individu : " + this + " dans l'etage : " + etage + " niv: " + etage.niveau);
		this.taille = 8 + Math.random()*(12-8);//on fait varier nos tailles entre 8 et 12pixels
		this.modele = modele;
		this.etage = etage;
		int[] coords = randomCoord();
		this.x = coords[0];
		this.y = coords[1];
		this.vitesseMax = 0.8 + Math.random()*(1.5-0.8);
		this.dx = 2*Math.random() - 1;
		this.dy = 2*Math.random() - 1;		
		double V = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
		this.dx = Math.random()*vitesseMax*dx/V; 
		this.dy = Math.random()*vitesseMax*dy/V;
		this.tempsReaction = 3*60 + (int)(Math.random()*2*60);
		this.isInStairs = null;
	}
	
	// Getters
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getDX() {
		return this.dx;
	}
	public double getDY() {
		return this.dy;
	}
	public double getTaille() {
		return this.taille;
	}
	public double getVitesseMax() {
		return this.vitesseMax;
	}
	public int getTempsReaction() {
		return this.tempsReaction;
	}
	public Etages getEtage() {
		return this.etage;
	}

	// Setters
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setDX(double dx) {
		this.dx = dx;
	}
	public void setDY(double dy) {
		this.dy = dy;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}
	public void setVitesseMax(double vitesseMax) {
		this.vitesseMax = vitesseMax;
	}
	public void setTempsReaction(int tempsReaction) {
		this.tempsReaction = tempsReaction;
	}
	public void setEtage(Etages etage) {
		this.etage = etage;
	}
	
	/**
	 * Cette méthode sert à générer un tableau de deux valeurs entières aléatoires.
	 * Les deux entiers sont choisit pour être les coordonnées d'apparition d'un individu.
	 * Cette méthode vérifie alors que l'endroit d'apparition n'est pas occupé par
	 * un obstacle, un escalier où une issue.
	 * 
	 * @return un tableau contenant la position d'apparition de l'individu.
	 */
	public int[] randomCoord() {
		boolean isFree;
		int X = (int)(Math.random()*this.modele.getWidth());
		int Y = (int)(Math.random()*this.modele.getHeight());
		isFree = this.etage.isFree(X,Y,this.taille);
		while(!isFree) {	
			X = (int)(Math.random()*this.modele.getWidth());
			Y = (int)(Math.random()*this.modele.getHeight());
			isFree = this.etage.isFree(X,Y,this.taille);
		}
		int[] result = {X,Y};
		return result;
	}
}



