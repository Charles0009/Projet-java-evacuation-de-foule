

package finale;

/**
 * <b> Escaliers est la classe représentant un objet escalier dans dans un
 * étage.</b>
 * <p>
 * Un Escaliers est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un entier qui définit la position de l'objet selon l'axe des
 * abscisses.</li>
 * <li>Un entier qui définit la position de l'objet selon l'axe des
 * ordonnées.</li>
 * <li>Un entier qui définit la hauteur de l'objet.</li>
 * <li>Un entier qui définit la largeur de l'objet.</li>
 * <li>Un étage qui définit l'étage de départ de l'escalier.</li>
 * <li>Un étage qui définit l'étage d'arrivé de l'escalier.</li>
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
	 * La position de l'escalier selon l'axe des ordonnées.
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
	 * L'étage de départ de l'escalier.
	 * 
	 * @see Escaliers#getEtageA()
	 */
	public Etages etageD;
	/**
	 * L'étage d'arrivée de l'escalier.
	 * 
	 * @see Escaliers#getEtageB()
	 */
	public Etages etageA;

	/**
	 * Constructeur Escalier.
	 * <p>
	 * A la construction d'un objet Escaliers on donne la position du coin en haut à
	 * gauche de l'objet, sa hauteur et largeur et son étage de départ et d'arrivée.
	 * </p>
	 * 
	 * @param x       La valeur sur l'axe des abscisses du coin en haut à gauche de
	 *                l'objet.
	 * @param y       La valeur sur l'axe des ordonnées du coin en haut à gauche de
	 *                l'objet.
	 * @param largeur La valeur de la largeur de l'escalier.
	 * @param hauteur La valeur de la hauteur de l'escalier.
	 * @param etageD  L'Etages de départ de l'escalier.
	 * @param etageA  L'Etages d'arrivée de l'escalier.
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
	 * Retourne l'étage de départ de l'escalier.
	 * 
	 * @return L'objet Etages correspondant à l'étage de départ de l'escalier.
	 */
	public Etages getEtageA() {
		return this.etageD;
	}
	/**
	 * Retourne l'étage d'arrivée de l'escalier.
	 * 
	 * @return L'objet Etages correspondant à l'étage d'arrivée de l'escalier.
	 */
	public Etages getEtageB() {
		return this.etageA;
	}

	/**
	 * Met à jour la valeur x de l'escalier.
	 * 
	 * @param x La nouvelle valeur en x du coin en haut à gauche de l'escalier.
	 */
	public void set(int x) {
		if (x < 0) {
			System.out.println("Position de ligne entrée négative");
		} else {
			this.x = x;
		}
	}
	/**
	 * Met à jour la valeur y de l'escalier.
	 * 
	 * @param y La nouvelle valeur en y du coin en haut à gauche de l'escalier.
	 */
	public void setY(int y) {
		if (y < 0) {
			System.out.println("Position de ligne entrée négative");
		} else {
			this.y = y;
		}
	}
	/**
	 * Met à jour la valeur de la largeur de l'escalier.
	 * 
	 * @param largeur La nouvelle valeur de la largeur de l'escalier.
	 */
	public void setLargeur(int maLargeur) {
		if (maLargeur < 0) {
			System.out.println("Largeur entrée négative");
		} else {
			this.largeur = maLargeur;
		}
	}
	/**
	 * Met à jour la valeur de la hauteur de l'escalier.
	 * 
	 * @param hauteur La nouvelle valeur de la hauteur de l'escalier.
	 */
	public void setHauteur(int maHauteur) {
		if (maHauteur < 0) {
			System.out.println("Hauteur entrée négative");
		} else {
			this.hauteur = maHauteur;
		}
	}
	/**
	 * Met à jour l'objet Etages correspondant à l'étage de départ de l'escalier.
	 * 
	 * @param etageD Le nouvel Etages servant d'étage de départ à l'escalier.
	 */
	public void setEtageA(Etages etageD) {
		this.etageD = etageD;
	}
	/**
	 * Met à jour l'objet Etages correspondant à l'étage d'arrivée de l'escalier.
	 * 
	 * @param etageA Le nouvel Etages servant d'étage d'arrivée à l'escalier.
	 */
	public void setEtageB(Etages etageA) {
		this.etageA = etageA;
	}
}



