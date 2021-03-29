package imports_prog;


import java.util.ArrayDeque;
import java.util.Deque;

public class Modele {
	// Variables
	int nbIndividus, nbEtages;
	int width, height;
	public Deque<Etages> etages = new ArrayDeque<>();
	Deque<Individus> individus;
	private Panel pan;
	
	// Constructeur
	public Modele(int nbIndividus, int nbEtages , Panel pan) {
		System.out.println("	Cr�ation du Modele : " + this);
		this.pan = pan;
		this.height = this.pan.getHeight();
		this.width = this.pan.getWidth();
		
		this.nbEtages = nbEtages;
		this.nbIndividus = nbIndividus;
			
		
		createEtages(nbEtages);
		createIndividus(nbIndividus);
		System.out.println("	Modele cre�.");
	}
	
	// Getters
	public int getNbIndividus() {
		return this.nbIndividus;
	}
	public Deque<Individus> getIndividus(){
		return this.individus;
	}
	public int getNbEtages() {
		return this.nbEtages;
	}
	public Etages getEtagesRDC(){
		return this.etages.getFirst();
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public Deque<Etages> getEtages(){
		return this.etages;
	}
	
	// Setters
	public void setWidth(int w) {
		this.width = w;
	}
	public void setHeight(int h) {
		this.height = h;
	}
	// M�thodes
	public void createEtages(int nbEtages) {
		for(int i = 0 ; i< this.nbEtages ; i++) {
			Etages e = new Etages(i,this);
			this.etages.add(e);
		}
	}
	public void createIndividus(int nbIndividus) {
		System.out.println("		Creation de " + nbIndividus + " individus dans le mod�le: " + this);
		for(int i = 0; i < nbIndividus ; i++) {
			int niveau = (int)(Math.random()*this.nbEtages);
			for(Etages e : etages) {
				if(e.niveau == niveau) {
					e.individus_in_etage.add(new Individus(e , this));
				}
			}
		}
	}
	
}

