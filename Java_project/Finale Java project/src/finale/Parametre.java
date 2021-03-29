package finale;

import java.util.ArrayList;
import java.util.List;
/**
 * <b> Parametre est la classe où l'on recupere les donnes utilisateur 
 * avant de les envoyer au calcul puis a l'affichage</b>
 * <p>
 * La classe est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un int de retour du nombre de portes au RDC</li>
 * <li>Une liste de retour du nombre d'obstacles pour chaque etage</li>
 * <li>Une liste de retour du nombre d'escaliers pour chaque etage</li>
 * <li>Un int du nombre de personnes</li>
 * <li>Un int du nombre d'etages</li>
 * </ul>
 * </p>
 * 
 * @author Charles
 *
 */
public class Parametre {
	/**
	 * Le nombre recupere du slider des personnes
	 * 
	 * @see Parametre#nbPersonnes
	 */
	int nbPersonnes;
	/**
	 * Le nombre de sorties au RDC
	 * 
	 * @see Parametre#nbOut
	 */
	int nbOut;
	/**
	 * Le nombre d'etages
	 * 
	 * @see Parametre#nbEtages
	 */
	int nbEtages;
	/**
	 * La liste des escalier a chaques etages
	 * 
	 * @see Parametre#nbEscaliers
	 */
	List<Integer> nbEscaliers = new ArrayList<>();
	/**
	 * La liste des obstacles a chaques etages+rdc
	 * 
	 * @see Parametre#nbObstacles
	 */
	List<Integer> nbObstacles = new ArrayList<>();
	/**
	 * Constructeur Parametre
	 * <p>
	 * On enregistre les valeurs entrees par l'utilisateur et on renvoie vers le calcul
	 * </p>
	 * 
	 * @see Parametre()
	 */
	 public Parametre(){
		this.nbOut = 1;
		this.nbPersonnes = 10;
		this.nbEtages = 1;
		this.nbObstacles.add(0);
		for(int i =0 ; i < 7 ; i++) {
			this.nbEscaliers.add(1);
			this.nbObstacles.add(0);
		}
	}
	
	/**
	 * getter du nombre de sorties de secours
	 * 
	 * @see Parametre#getNbOut()
	 */
	public int getNbOut () {
		return this.nbOut;
	}
	/**
	 * getter du nombre de personnes
	 * 
	 * @see Parametre#getNbPersonnes()
	 */
	public int getNbPersonnes () {
		return this.nbPersonnes;
	}
	/**
	 * getter de la liste des escaliers selon les etages 
	 * 
	 * @see Parametre#getNbEscaliersInStage(int)
	 */
	public int getNbEscaliersInStage(int niveau){
		return this.nbEscaliers.get(niveau);
	}
	/**
	 * getter de la liste des obstacles selon les etages 
	 * 
	 * @see Parametre#getNbObstaclesInStage(int)
	 */
	public int getNbObstaclesInStage(int niveau){
		return this.nbObstacles.get(niveau);
	}
	/**
	 * setter du nombre de sorties de secours
	 * 
	 * @see Parametre#getNbOut()
	 */
	public void setNbOut (int nbOut) {
		this.nbOut = nbOut;
	}
	/**
	 * setter du nombre de personnes
	 * 
	 * @see Parametre#getNbPersonnes()
	 */
	public void setNbPersonnes (int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}
	/**
	 * setter de la liste des escaliers selon les etages 
	 * 
	 * @see Parametre#getNbEscaliersInStage(int)
	 */
	public void setNbEscaliersInStage(int nbEscaliers , int niveau) {
		this.nbEscaliers.set(niveau-1, nbEscaliers);
	}
	/**
	 * setter de la liste des obstacles selon les etages 
	 * 
	 * @see Parametre#getNbObstaclesInStage(int)
	 */
	public void setNbObstaclesInStage(int nbObstacles , int niveau) {
		this.nbObstacles.set(niveau, nbObstacles);	
	}
	

}



