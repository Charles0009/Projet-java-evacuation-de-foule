/**
 * <b> Issues est la classe repr�sentant une issue de secours.</b>
 * <p>
 * Une issue est caract�ris�e par les informations suivantes :
 * <ul>
 * <li>Un entier qui d�finit la position de l'objet selon l'axe des
 * abscisses.</li>
 * <li>Un entier qui d�finit la position de l'objet selon l'axe des
 * ordonn�es.</li>
 * <li>Un entier qui d�finit la largeur de l'objet.</li>
 * <li>Un entier qui d�finit la hauteur de l'objet.</li>
 * </ul>
 * </p>
 * 
 * @author Antoine
 *
 */
public class Issues {
	/**
	 * La position de l'issue selon l'axe des abscisses.
	 * 
	 * @see Issues#getX()
	 */
	public int x;
	/**
	 * La position de l'issue selon l'axe des ordonn�es.
	 * 
	 * @see Issues#getY()
	 */
	public int y;
	/**
	 * La hauteur de l'issue.
	 * 
	 * @see Issues#getHauteur()
	 */
	public int hauteur;
	/**
	 * La largeur de l'issue.
	 * 
	 * @see Issues#getLargeur()
	 */
	public int largeur;

	/**
	 * Constructeur Issues.
	 * <p>
	 * A la construction d'un objet issue on donne la position du coin en haut �
	 * gauche de l'objet, sa hauteur et largeur.
	 * </p>
	 * 
	 * @param x       La valeur sur l'axe des abscisses du coin en haut � gauche de
	 *                l'objet.
	 * @param y       La valeur sur l'axe des ordonn�es du coin en haut � gauche de
	 *                l'objet.
	 * @param largeur La valeur de la largeur de l'issue.
	 * @param hauteur La valeur de la hauteur de l'issue.
	 * 
	 * @see Issues#x
	 * @see Issues#y
	 * @see Issues#largeur
	 * @see Issues#hauteur
	 */
	public Issues(int x, int y, int hauteur, int largeur) {
		this.x = x;
		this.y = y;
		this.hauteur = hauteur;
		this.largeur = largeur;
	}

	/**
	 * Retourne la position en x de l'issue.
	 * 
	 * @return La valeur de la position en x de l'issue.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Retourne la position en y de l'issue.
	 * 
	 * @return La valeur de la position en y de l'issue.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Retourne la hauteur de l'issue.
	 * 
	 * @return La valeur de la hauteur de l'issue.
	 */
	public int getHauteur() {
		return this.hauteur;
	}

	/**
	 * Retourne la largeur de l'issue.
	 * 
	 * @return La valeur de la largeur de l'issue.
	 */
	public int getLargeur() {
		return this.largeur;
	}

	/**
	 * Met � jour la valeur x de l'issue.
	 * 
	 * @param x La nouvelle valeur en x du coin en haut � gauche de l'issue.
	 */
	public void set(int x) {
		if (x < 0) {
			System.out.println("Position de ligne entr�e n�gative");
		} else {
			this.x = x;
		}
	}

	/**
	 * Met � jour la valeur y de l'issue.
	 * 
	 * @param y La nouvelle valeur en y du coin en haut � gauche de l'issue.
	 */
	public void setY(int y) {
		if (y < 0) {
			System.out.println("Position de ligne entr�e n�gative");
		} else {
			this.y = y;
		}
	}

	/**
	 * Met � jour la valeur de la largeur de l'issue.
	 * 
	 * @param largeur La nouvelle valeur de la largeur de l'issue.
	 */
	public void setLargeur(int maLargeur) {
		if (maLargeur < 0) {
			System.out.println("Largeur entr�e n�gative");
		} else {
			this.largeur = maLargeur;
		}
	}

	/**
	 * Met � jour la valeur de la hauteur de l'issue.
	 * 
	 * @param hauteur La nouvelle valeur de la hauteur de l'issue.
	 */
	public void setHauteur(int maHauteur) {
		if (maHauteur < 0) {
			System.out.println("Hauteur entr�e n�gative");
		} else {
			this.hauteur = maHauteur;
		}
	}
}
