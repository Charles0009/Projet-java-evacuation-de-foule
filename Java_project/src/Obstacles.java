package imports_prog;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b> Obstacles est la classe repr�sentant un objet obstacle dans un �tage.</b>
 * <p>
 * Un Obstacles est caract�ris� par les informations suivantes :
 * <ul>
 * <li>Un entier qui d�finit la position de l'objet selon l'axe des
 * abscisses.</li>
 * <li>Un entier qui d�finit la position de l'objet selon l'axe des
 * ordonn�es.</li>
 * <li>Un entier qui d�finit la largeur de l'objet.</li>
 * <li>Un entier qui d�finit la hauteur de l'objet.</li>
 * <li>Un �tage auquel est attach� l'obstacle.</li>
 * </ul>
 * </p>
 * 
 * @author Antoine
 *
 */
public class Obstacles {
	/**
	 * La position de l'obstacle selon l'axe des abscisses.
	 * 
	 * @see Escaliers#getX()
	 */
	private int x;
	/**
	 * La position de l'obstacle selon l'axe des ordonn�es.
	 * 
	 * @see Escaliers#getY()
	 */
	private int y;
	/**
	 * La largeur de l'obstacle.
	 * 
	 * @see Escaliers#getLargeur()
	 */
	private int largeur;
	/**
	 * La hauteur de l'obstacle.
	 * 
	 * @see Escaliers#getHauteur()
	 */
	private int hauteur;
	/**
	 * L'Etages auquel est rattach� l'obstacle.
	 * 
	 * @see Escaliers#getEtage()
	 */
	Etages etage;

	/**
	 * Constructeur Obstacles.
	 * <p>
	 * A la construction d'un objet Obstacles on donne la position du coin en haut �
	 * gauche de l'objet, sa hauteur et largeur et l'�tage auquel il est rattach�.
	 * </p>
	 * 
	 * @param x       La valeur sur l'axe des abscisses du coin en haut � gauche de
	 *                l'objet.
	 * @param y       La valeur sur l'axe des ordonn�es du coin en haut � gauche de
	 *                l'objet.
	 * @param largeur La valeur de la largeur de l'obstacle.
	 * @param hauteur La valeur de la hauteur de l'obstacle.
	 * @param etage   L'Etages auquel est attach� l'obstacle.
	 * 
	 * @see Obstacles#x
	 * @see Obstacles#y
	 * @see Obstacles#largeur
	 * @see Obstacles#hauteur
	 * @see Obstacles#etage
	 */
	public Obstacles(int x, int y, int largeur, int hauteur, Etages etage) {
		System.out.println("					Creation de l'obsatcle: " + this);
		this.x = x;
		this.y = y;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.etage = etage;
	}

	/**
	 * Retourne la position en x de l'obstacle.
	 * 
	 * @return La valeur de la position en x de l'obstacle.
	 */
	public int getx() {
		return this.x;
	}

	/**
	 * Retourne la position en y de l'obstacle.
	 * 
	 * @return La valeur de la position en y de l'obstacle.
	 */
	public int gety() {
		return this.y;
	}

	/**
	 * Retourne la hauteur de l'obstacle.
	 * 
	 * @return La valeur la hauteur de l'obstacle.
	 */
	public int getHauteur() {
		return this.hauteur;
	}

	/**
	 * Retourne la largeur de l'obstacle.
	 * 
	 * @return La valeur la largeur de l'obstacle.
	 */
	public int getLargeur() {
		return this.largeur;
	}

	/**
	 * Retourne l'Etages de l'obstacle.
	 * 
	 * @return L'Etages auquel l'obstacle est attach�.
	 */
	public Etages getEtage() {
		return this.etage;
	}

	/**
	 * Met � jour la valeur x de l'obstacle.
	 * 
	 * @param x La nouvelle valeur en x du coin en haut � gauche de l'obstacle.
	 */
	public void setx(int x) {
		if (x < 0) {
			System.out.println("Position de ligne entr�e n�gative");
		} else {
			this.x = x;
		}

	}

	/**
	 * Met � jour la valeur y de l'obstacle.
	 * 
	 * @param y La nouvelle valeur en y du coin en haut � gauche de l'obstacle.
	 */
	public void sety(int y) {
		if (y < 0) {
			System.out.println("Position de colonne entr�e n�gative");
		} else {
			this.y = y;
		}
	}

	/**
	 * Met � jour la valeur de la largeur de l'obstacle.
	 * 
	 * @param largeur La nouvelle valeur de largeur de l'obstacle.
	 */
	public void setLargeur(int largeur) {
		if (largeur < 0) {
			System.out.println("Largeur entr�e n�gative");
		} else {
			this.largeur = largeur;
		}
	}

	/**
	 * Met � jour la valeur de la hauteur de l'obstacle.
	 * 
	 * @param hauteur La nouvelle valeur de hauteur de l'obstacle.
	 */
	public void setHauteur(int hauteur) {
		if (hauteur < 0) {
			System.out.println("Hauteur entr�e n�gative");
		} else {
			this.hauteur = hauteur;
		}
	}

	/**
	 * Transforme un obstacle en deux obstacles s�par� par un trou de largeur
	 * demand�. Sert � faire des passages pour les individus entre les salles.
	 * 
	 * @param largeur La largeur du trou.
	 * @return un Deque d'Obstacles contenant le mur en deux parties avec un trou
	 *         d'une largeur largeur.
	 */
	public Deque<Obstacles> createVoid(int largeur) {
		Deque<Obstacles> result = new ArrayDeque<>();
		int hauteur = (int) (10 + Math.random() * (this.etage.h - 20 - largeur));
		Obstacles ob1 = new Obstacles(this.getx(), this.gety(), this.getLargeur(), hauteur, this.getEtage());
		Obstacles ob2 = new Obstacles(this.getx(), this.gety() + hauteur + largeur, this.getLargeur(),
				this.getHauteur() - (this.gety() + hauteur + largeur), this.getEtage());
		result.add(ob1);
		result.add(ob2);
		return result;
	}
}
