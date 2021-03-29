package finale;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

/**
 * <b> Simulation est la classe où l'on simule notre modèle.</b>
 * <p>
 * Une Simulation est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un Modele qui définit le modèle à partir duquel on simule.</li>
 * <li>Une liste de liste de liste de liste d'entier contenant
 * les données de notre simulation.</li>
 * <li>Une liste d'entier contenant .</li>
 * <li>Un double qui permet de chronométrer.</li>
 * </ul>
 * </p>
 * 
 * @author Antoine
 *
 */
public class Simulation {
	/**
	 * Le modèle de notre simulation.
	 * 
	 * @see Simulation#getModele()
	 */
	Modele modele;
	/**
	 * Les données de notre simulation.
	 * 
	 * @see Simulation#getData()
	 */
	List<List<List<List<Integer>>>> data = new ArrayList<>();
	//****
	List<Integer> people_inside = new ArrayList<>();
	/**
	 * Le temps de notre simulation.
	 * 
	 * @see Simulation#getTime()
	 */
	double time = 0;
	
	/**
	 * Constructeur Simulation.
	 * <p>
	 * On construit notre simulation en créant les données de notre simulation avec la
	 * méthode Simulate à partir de notre modèle.
	 * </p>
	 * 
	 * @param modele   		Le nombre d'individus qu'on met dans notre modèle.
	 * 
	 * @see Simulation#modele
	 */
	public Simulation(Modele modele) {
		System.out.println("	Démarrage de la simulation");
		this.modele = modele;
		this.data = Simulate(this.modele);
		System.out.println("	Fin de la simulation");
	}
	
	/**
	 * Retourne le modèle de la simulation.
	 * 
	 * @return Le modèle de notre simulation.
	 */
	public Modele getModele() {
		return this.modele;
	}
	/**
	 * Retourne les données de la simulation.
	 * 
	 * @return Les données de notre simulation.
	 */
	public List<List<List<List<Integer>>>> getData(){
		return this.data;
	}
	/**
	 * Retourne le temps passé dans la simulation.
	 * 
	 * @return Le temps passé dans la simulation.
	 */
	public double getTime(){
		return this.time;
	}
	//****
	public List<Integer> getNbPeopleInside(){
		return this.people_inside;
	}
	
	/**
	 * Simule le déplacement des individus dans le batiment modélisé.
	 * 
	 * @param m 		Le modèle de notre simulation.
	 * @return  une liste de liste de liste de liste d'entier correspondante
	 * 			aux données de notre simulation.
	 */
	public List<List<List<List<Integer>>>> Simulate(Modele m){
		//On crée notre liste vide qu'on va compléter au fur et mesure des calculs
		List<List<List<List<Integer>>>> data = new ArrayList<>();
		
		//On crée pour chaque étage de notre bâtiment une liste de liste de liste d'entiers
		for(int k = 0; k < m.getNbEtages() ; k++) {
			List<List<List<Integer>>> liste = new ArrayList<>();
			data.add(liste);
		}

		//On récupere et fixe les données de notre simulation
		int nbPeople = m.getNbIndividus();
		double fS = 70.0;
		double fR = 100;
		double distanceInterraction = 200;
		double timeBetween2Etages = 6.0;
		double MaxTimeOfCalculus = 240;
		int time=0;
		
		/**
		 * On crée la boucle où les calculs des positions des individus s'effectue.
		 * Tant que tous les individus ne sont pas sorti ou qu'un certain de temps
		 * de calcul n'est pas dépassé nous calculons les nouvelles positions
		 * des individus dans le batiment.
		 */
		while(nbPeople > 0 && time <= MaxTimeOfCalculus*60) {
			
			for(Etages e : m.etages) {
				List<List<Integer>> liste = new ArrayList<>();
				data.get(e.niveau).add(liste);
				Deque<Individus> individus = e.individus_in_etage;
				Deque<Individus> individusToRemove = new ArrayDeque<>();
				int id_individu = -1;
				for(Individus p : individus) {
					id_individu++;
					List<Integer> liste2 = new ArrayList<>();
					data.get(e.niveau).get(time).add(liste2);
					if(p.isInStairs == null) {
						double ddx = 0;
						double ddy = 0;
						// ALLER VERS UN ESCALIER OU UNE ISSUES
						if(e.niveau == 0) {
							// SORTIR
								//TROUVER L'ISSUE LA PLUS PROCHE
							Issues issueLaPlusProche = e.issues.getFirst();
							double dist = 10000;
							for(Issues s : e.issues) {
								double distance = Math.sqrt(Math.pow(p.x - s.x, 2) + Math.pow(p.y - s.y , 2));
								if(distance < dist) {
									issueLaPlusProche = s;
									dist = distance;
								}
							}
								// SE DIRIGER VERS L'ISSUE LA PLUS PROCHE
							double delta_x = issueLaPlusProche.x - p.x;
							double delta_y = issueLaPlusProche.y - p.y;
							double D = Math.sqrt(Math.pow(delta_x, 2)+ Math.pow(delta_y , 2));
							
							if(D < issueLaPlusProche.largeur) {
								individusToRemove.add(p);
								nbPeople += -1;
							} else {
								ddx += fS*delta_x/D;
								ddy += fS*delta_y/D;
							}
							
						} else {
							// ALLER VERS UN ESCALIER
								//TROUVER L'ESCALIER LE PLUS PROCHE
							Escaliers escalierLePlusProche = e.escaliers.getFirst();
							double dist = 10000;
							for(Escaliers es : e.escaliers) {
								double distance = Math.sqrt(Math.pow(p.x - es.x, 2) + Math.pow(p.y - es.y , 2));
								if(distance < dist) {
									escalierLePlusProche = es;
									dist = distance;
								}
							}
								//SE DIRIGER VERS L'ESCALIER LE PLUS PROCHE
							double delta_x = escalierLePlusProche.x - p.x;
							double delta_y = escalierLePlusProche.y - p.y;
							double D = Math.sqrt(Math.pow(delta_x, 2)+ Math.pow(delta_y , 2));
							
							if(D < escalierLePlusProche.largeur) {
								p.isInStairs = escalierLePlusProche;
								p.timeInStairs = 0;
							} else {
								ddx += fS*delta_x/D;
								ddy += fS*delta_y/D;
							}
						}
						
						// SE REPOUSSE ENTRE EUX
						for (Individus q : individus) {
							double delta_x = q.x - p.x;
							double delta_y = q.y - p.y;
							double D = Math.sqrt(Math.pow(delta_x, 2)+ Math.pow(delta_y , 2));
							
							if(D < distanceInterraction && D != 0) {
								ddx += -fR*delta_x/Math.pow(D, 3);
								ddy += -fR*delta_y/Math.pow(D, 3);
							}
						}
						
						// VITESSE MAX						
						double ndx = p.dx + ddx;
						double ndy = p.dy + ddy;
						double nv = Math.sqrt(Math.pow(ndx, 2) + Math.pow(ndy, 2));
						
						if (nv > p.vitesseMax) {
							p.dx = p.vitesseMax * (ndx/nv);
							p.dy = p.vitesseMax * (ndy/nv);
							
						} else {
							p.dx =ndx;
							p.dy =ndy;
						}
						
					} else {
						if(p.timeInStairs < timeBetween2Etages*60*(p.isInStairs.etageD.niveau - p.isInStairs.etageA.niveau)) {
							// ATTENDRE DANS LES ESCALIERS
							p.timeInStairs += 1;
						} else {
							// CHANGER DE NIVEAU
							p.isInStairs.etageA.individus_in_etage.add(p);
							p.isInStairs = null;
							individusToRemove.add(p);
						}
						p.dx = 0;
						p.dy = 0;
					}
					p.x += p.dx;
					p.y += p.dy;
					data.get(e.niveau).get(time).get(id_individu).add((int)(p.x));
					data.get(e.niveau).get(time).get(id_individu).add((int)(p.y));
					
				}
				// SUPRESSION DES INDIVIDUS SORTANT OU CHANGEANT
				for(Individus p : individusToRemove) {
					individus.remove(p);
				}
				e.individus_in_etage = individus;
			}
			time++;
		}
		return data;
	}
}