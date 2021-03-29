package imports_prog;

/**
 * <b> Escaliers est la classe repr�sentant un objet escalier dans dans un
 * �tage.</b>
 * <p>
 * Un Escaliers est caract�ris� par les informations suivantes :
 * <ul>
 * <li>Un entier qui d�finit la position de l'objet selon l'axe des
 * abscisses.</li>
 * <li>Un entier qui d�finit la position de l'objet selon l'axe des
 * ordonn�es.</li>
 * <li>Un entier qui d�finit la hauteur de l'objet.</li>
 * <li>Un entier qui d�finit la largeur de l'objet.</li>
 * <li>Un �tage qui d�finit l'�tage de d�part de l'escalier.</li>
 * <li>Un �tage qui d�finit l'�tage d'arriv� de l'escalier.</li>
 * </ul>
 * </p>
 * 
 * @author Antoine
 *
 */

public class Escaliers {
	/**
	 * La position de l'escalier selon l'axe des abscisses.
	 * 
	 * @see Escaliers#getX()
	 */
	public int x;
	/**
	 * La position de l'escalier selon l'axe des ordonn�es.
	 * 
	 * @see Escaliers#getY()
	 */
	public int y;
	/**
	 * La hauteur de l'escalier.
	 * 
	 * @see Escaliers#getHauteur()
	 */
	public int hauteur;
	/**
	 * La largeur de l'escalier.
	 * 
	 * @see Escaliers#getLargeur()
	 */
	public int largeur;
	/**
	 * L'�tage de d�part de l'escalier.
	 * 
	 * @see Escaliers#getEtageA()
	 */
	public Etages etageD;
	/**
	 * L'�tage d'arriv�e de l'escalier.
	 * 
	 * @see Escaliers#getEtageB()
	 */
	public Etages etageA;

	/**
	 * Constructeur Escalier.
	 * <p>
	 * A la construction d'un objet Escaliers on donne la position du coin en haut �
	 * gauche de l'objet, sa hauteur et largeur et son �tage de d�part et d'arriv�e.
	 * </p>
	 * 
	 * @param x       La valeur sur l'axe des abscisses du coin en haut � gauche de
	 *                l'objet.
	 * @param y       La valeur sur l'axe des ordonn�es du coin en haut � gauche de
	 *                l'objet.
	 * @param largeur La valeur de la largeur de l'escalier.
	 * @param hauteur La valeur de la hauteur de l'escalier.
	 * @param etageD  L'Etages de d�part de l'escalier.
	 * @param etageA  L'Etages d'arriv�e de l'escalier.
	 * 
	 * @see Escaliers#x
	 * @see Escaliers#y
	 * @see Escaliers#largeur
	 * @see Escaliers#hauteur
	 * @see Escaliers#etageD
	 * @see Escaliers#etageA
	 */
	public Escaliers(int x, int y, int largeur, int hauteur, Etages etageD, Etages etageA) {
		System.out.println("						Creation de l'escalier : " + this);
		this.x = x;
		this.y = y;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.etageD = etageD;
		this.etageA = etageA;
	}

	/**
	 * Retourne la position en x de l'escalier.
	 * 
	 * @return La valeur de la position en x de l'escalier.
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * Retourne la position en y de l'escalier.
	 * 
	 * @return La valeur de la position en y de l'escalier.
	 */
	public int getY() {
		return this.y;
	}
	/**
	 * Retourne la hauteur de l'escalier.
	 * 
	 * @return La valeur de la hauteur de l'escalier.
	 */
	public int getHauteur() {
		return this.hauteur;
	}
	/**
	 * Retourne la largeur de l'escalier.
	 * 
	 * @return La valeur de la largeur de l'escalier.
	 */
	public int getLargeur() {
		return this.largeur;
	}
	/**
	 * Retourne l'�tage de d�part de l'escalier.
	 * 
	 * @return L'objet Etages correspondant � l'�tage de d�part de l'escalier.
	 */
	public Etages getEtageA() {
		return this.etageD;
	}
	/**
	 * Retourne l'�tage d'arriv�e de l'escalier.
	 * 
	 * @return L'objet Etages correspondant � l'�tage d'arriv�e de l'escalier.
	 */
	public Etages getEtageB() {
		return this.etageA;
	}

	/**
	 * Met � jour la valeur x de l'escalier.
	 * 
	 * @param x La nouvelle valeur en x du coin en haut � gauche de l'escalier.
	 */
	public void set(int x) {
		if (x < 0) {
			System.out.println("Position de ligne entr�e n�gative");
		} else {
			this.x = x;
		}
	}
	/**
	 * Met � jour la valeur y de l'escalier.
	 * 
	 * @param y La nouvelle valeur en y du coin en haut � gauche de l'escalier.
	 */
	public void setY(int y) {
		if (y < 0) {
			System.out.println("Position de ligne entr�e n�gative");
		} else {
			this.y = y;
		}
	}
	/**
	 * Met � jour la valeur de la largeur de l'escalier.
	 * 
	 * @param largeur La nouvelle valeur de la largeur de l'escalier.
	 */
	public void setLargeur(int maLargeur) {
		if (maLargeur < 0) {
			System.out.println("Largeur entr�e n�gative");
		} else {
			this.largeur = maLargeur;
		}
	}
	/**
	 * Met � jour la valeur de la hauteur de l'escalier.
	 * 
	 * @param hauteur La nouvelle valeur de la hauteur de l'escalier.
	 */
	public void setHauteur(int maHauteur) {
		if (maHauteur < 0) {
			System.out.println("Hauteur entr�e n�gative");
		} else {
			this.hauteur = maHauteur;
		}
	}
	/**
	 * Met � jour l'objet Etages correspondant � l'�tage de d�part de l'escalier.
	 * 
	 * @param etageD Le nouvel Etages servant d'�tage de d�part � l'escalier.
	 */
	public void setEtageA(Etages etageD) {
		this.etageD = etageD;
	}
	/**
	 * Met � jour l'objet Etages correspondant � l'�tage d'arriv�e de l'escalier.
	 * 
	 * @param etageA Le nouvel Etages servant d'�tage d'arriv�e � l'escalier.
	 */
	public void setEtageB(Etages etageA) {
		this.etageA = etageA;
	}
}
