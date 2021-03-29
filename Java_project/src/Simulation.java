package imports_prog;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

public class Simulation {
	// VARIABLES
	Modele m;
	List<List<List<List<Integer>>>> simulation = new ArrayList<>();
	List<Integer> people_inside = new ArrayList<>();
	double time = 0;
	
	//CONSTRUCTEUR
	public Simulation(Modele m) {
		System.out.println("	D�marrage de la simulation");
		this.m = m;
		this.simulation = Simulate(this.m);
		System.out.println("	Fin de la simulation");
	}
	
	//GETTERS
	
	public List<List<List<List<Integer>>>> getSimulation(){
		return this.simulation;
	}
	public double getTime(){
		return this.time;
	}
	public List<Integer> getNbPeopleInside(){
		return this.people_inside;
	}
	
	
	//METHODE
	
	public List<List<List<List<Integer>>>> Simulate(Modele m){
		List<List<List<List<Integer>>>> simulation = new ArrayList<>();
		
		for(int k = 0; k < m.nbEtages ; k++) {
			List<List<List<Integer>>> liste = new ArrayList<>();
			simulation.add(liste);
		}

		int nbPeople = m.nbIndividus;
		double fS = 70.0;
		double fR = 0.1;
		double distanceInterraction = 200;
		double timeBetween2Etages = 6.0;
		double MaxTimeOfCalculus = 180;
		int time=0;
		
		while(nbPeople > 0 && time <= MaxTimeOfCalculus*60) {
			System.out.println("		Temps calcul�: " + time/60 + "s. Il reste " + nbPeople + " individus");
			for(Etages e : m.etages) {
				List<List<Integer>> liste = new ArrayList<>();
				simulation.get(e.niveau).add(liste);
				System.out.println("				"+e+" niv: " + e.niveau);
				Deque<Individus> individus = e.individus_in_etage;
				Deque<Individus> individusToRemove = new ArrayDeque<>();
				int id_individu = -1;
				for(Individus p : individus) {
					id_individu++;
					List<Integer> liste2 = new ArrayList<>();
					simulation.get(e.niveau).get(time).add(liste2);
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
								nbPeople -= 1;
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
							
							if(D < distanceInterraction && D != 0 && q.isInStairs == null) {
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
					}
					p.x += p.dx;
					p.y += p.dy;
					simulation.get(e.niveau).get(time).get(id_individu).add((int)(p.x));
					simulation.get(e.niveau).get(time).get(id_individu).add((int)(p.y));
					System.out.println("					" + p + ": x = " + p.x + " , y = " + p.y );
					
				}
				// SUPRESSION DES INDIVIDUS SORTANT OU CHANGEANT
				for(Individus p : individusToRemove) {
					individus.remove(p);
				}
				e.individus_in_etage = individus;
			}
			time++;
		}
		return simulation;
	}
}
