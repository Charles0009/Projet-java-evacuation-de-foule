
package finale;


import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.JPanel;

/**
 * <b> Modele est la classe représentant le modèle de notre simulation.</b>
 * <p>
 * Un modèle est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un entier qui définit le nombre d'individus.</li>
 * <li>Un entier qui définit le nombre d'étages.</li>
 * <li>Un entier qui définit la largeur du panel sur lequel on va afficher.</li>
 * <li>Un entier qui définit la hauteur du panel sur lequel on va afficher.</li>
 * <li>Un Deque d'Etages contenant chaque étage du modèle.</li>
 * <li>Un Deque d'Individus contenant les individus du modèle.</li>
 * <li>Un Panel sur lequel nous allons afficher notre modèle.</li>
 * </ul>
 * </p>
 * 
 * @author Antoine
 *
 */
public class Modele {
	/**
	 * Le nombre d'individus dans le modèle.
	 * 
	 * @see Modele#getNbIndividus()
	 */
	int nbIndividus;
	
	/**
	 * Le nombre d'étages dans le modèle.
	 * 
	 * @see Modele#getNbEtages()
	 */
	int nbEtages;
	/**
	 * La largeur du panel de notre modèle.
	 * 
	 * @see Modele#getWidth()
	 */
	int width;
	/**
	 * La hauteur du panel de notre modèle.
	 * 
	 * @see Modele#getHeight()
	 */
	int height;
	/**
	 * Les étages de notre modèle.
	 * 
	 * @see Modele#getEtages()
	 */
	Deque<Etages> etages = new ArrayDeque<>();
	/**
	 * Les individus de notre modèle.
	 * 
	 * @see Modele#getIndividus()
	 */
	Deque<Individus> individus;
	/**
	 * Le panel dans lequel nous allons afficher notre simulation.
	 * 
	 * @see Modele#getPan()
	 */
	private JPanel pan;
	
	public Parametre para;
	
	/**
	 * Constructeur Modele.
	 * <p>
	 * On construit un modèle en créant en premier lieu le panel acceuillant notre modele.
	 * On créée ensuite les étages de notre modèle et enfin les individus.
	 * </p>
	 * 
	 * @param nbIndividus   Le nombre d'individus qu'on met dans notre modèle.
	 * @param nbEtages  	Le nombre d'étages de notre modèle.
	 * @param pan			Le panel acceuillant notre modèle.
	 * 
	 * @see Modele#individus
	 * @see Modele#nbEtages
	 * @see Modele#pan
	 */
	public Modele(JPanel pan, Parametre para) {
		System.out.println("	Création du Modele : " + this);
		this.pan = pan;
		this.para = para;
		this.height = this.pan.getHeight();
		this.width = this.pan.getWidth();
		
		this.nbEtages = this.para.nbEtages;
		this.nbIndividus = this.para.nbPersonnes;
			
		
		createEtages(nbEtages);
		createIndividus(nbIndividus);
		System.out.println("	Modele creé.");
	}
	
	/**
	 * Retourne la valeur du nombre d'individus.
	 * 
	 * @return La valeur du nombre d'individus.
	 */
	public int getNbIndividus() {
		return this.nbIndividus;
	}
	/**
	 * Retourne les individus du modèle.
	 * 
	 * @return Les individus de notre modèle.
	 */
	public Deque<Individus> getIndividus(){
		return this.individus;
	}
	/**
	 * Retourne la valeur du nombre d'étages.
	 * 
	 * @return La valeur du nombre d'étages.
	 */
	public int getNbEtages() {
		return this.nbEtages;
	}
	/**
	 * Retourne l'étage rez-de-chaussée.
	 * 
	 * @return L'étage du rez-de-chaussée.
	 */
	public Etages getEtagesRDC(){
		return this.etages.getFirst();
	}
	/**
	 * Retourne la valeur de la largeur du panel.
	 * 
	 * @return La largeur du panel.
	 */
	public int getWidth() {
		return this.width;
	}
	/**
	 * Retourne la valeur de la hauteur du panel.
	 * 
	 * @return La hauteur du panel.
	 */
	public int getHeight() {
		return this.height;
	}
	/**
	 * Retourne les étages de notre modèle.
	 * 
	 * @return Les étages de notre modèle.
	 */
	public Deque<Etages> getEtages(){
		return this.etages;
	}
	/**
	 * Retourne le panel de notre modèle.
	 * 
	 * @return Le panel de notre modèle.
	 */
	public JPanel getPan() {
		return this.pan;
	}
	
	/**
	 * Met à jour la valeur de la largeur du panel.
	 * 
	 * @param w La nouvelle valeur de largeur du panel.
	 */
	public void setWidth(int w) {
		this.width = w;
	}
	/**
	 * Met à jour la valeur de la hauteur du panel.
	 * 
	 * @param w La nouvelle valeur de hauteur du panel.
	 */
	public void setHeight(int h) {
		this.height = h;
	}
	/**
	 * Créer le nombre d'étage demandé à l'aide du constructeur Etages.
	 * 
	 * @param nbEtages		Le nombre d'étages à créer.
	 * @return un Deque d'Etages contenant les étages du modèle.
	 */
	public void createEtages(int nbEtages) {
		for(int i = 0 ; i< this.nbEtages ; i++) {
			Etages e = new Etages(i,this);
			this.etages.add(e);
		}
	}
	/**
	 * Créer le nombre d'individus demandé à l'aide du constructeur Individus.
	 * 
	 * @param nbIndividus	Le nombre d'individus à créer.
	 * @return un Deque d'Individus contenant les individus du modèle.
	 */
	public void createIndividus(int nbIndividus) {
		System.out.println("		Creation de " + nbIndividus + " individus dans le modèle: " + this);
		int nbEtages = this.nbEtages;
		for(int i = 0; i < nbIndividus ; i++) {
			int niveau = (int)(Math.random()*(nbEtages+0.1));
			for(Etages e : etages) {
				if(e.niveau == niveau) {
					e.individus_in_etage.add(new Individus(e , this));
				}
			}
		}
	}
	
}



