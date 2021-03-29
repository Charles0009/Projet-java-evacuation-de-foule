import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b> Etages est la classe qui contient des escaliers, des obstacles et des issues.</b>
 * <p>
 * Un Etages est caract�ris� par les informations suivantes :
 * <ul>
 * <li>Un entier qui d�finit le niveau de l'�tage.</li>
 * <li>Un entier qui d�finit le nombre d'escaliers.</li>
 * <li>Un entier qui d�finit le nombre d'obstacles.</li>
 * <li>Un entier qui d�finit le nombre d'issues.</li>
 * <li>Un Deque d'obstacle qui contient tout les obstacles de l'�tage.</li>
 * <li>Un Deque d'escalier qui contient tout les escaliers de l'�tage.</li>
 * <li>Un Deque d'issues qui contient toutes les issues de l'�tage.</li>
 * <li>Un Modele.</li>
 * <li>Un Deque d'individus qui contient tout les individus de l'�tage.</li>
 * </ul>
 * </p>
 * 
 * @author Antoine
 *
 */

public class Etages {
	/**
	 * La valeur du niveau de l'�tage. Cet entier est unique.
	 * 
	 * @see Etages#getNiveau()
	 */
	public int niveau;
	/**
	 * Le nombre d'escaliers dans l'�tage.
	 * 
	 * @see Escaliers#getNbEscaliers()
	 */
	private int nbEscaliers;
	/**
	 * Le nombre d'obstacles dans l'�tage.
	 * 
	 * @see Escaliers#getNbObstacles()
	 */
	private int nbObstacles;
	/**
	 * Le nombre d'issues dans l'�tage.
	 * 
	 * @see Escaliers#getNbIssues()
	 */
	private int nbIssues = 0;
	/**
	 * L'ensemble des obstacles dans l'�tage.
	 * 
	 * @see Escaliers#getObstacles()
	 */
	Deque<Obstacles> obstacles;
	/**
	 * L'ensemble des escaliers dans l'�tage.
	 * 
	 * @see Escaliers#getEscaliers()
	 */
	Deque<Escaliers> escaliers;
	/**
	 * L'ensemble des issues dans l'�tage.
	 * 
	 * @see Escaliers#getIssues()
	 */
	Deque<Issues> issues;
	/**
	 * Le mod�le de notre simulation.
	 * 
	 * @see Escaliers#getModele()
	 */
	Modele modele;
	/**
	 * L'ensemble des individus dans l'�tage.
	 * 
	 * @see Escaliers#getIndividus()
	 */
	Deque<Individus> individus_in_etage = new ArrayDeque<>();
	
	int w;
	int h;
	
	/**
	 * Constructeur Etages.
	 * <p>
	 * A la construction d'un �tage, on affecte un niveau � l'�tage qui est unique. On test si 
	 * l'�tage est le rez-de-chauss�e ou non. Si c'est le rez-de-chauss�e, on affecte une valeur
	 * non nulle au nombre d'issues. Sinon on affecte la valeur 4 au nombre d'escaliers.
	 *  Ensuite, on g�n�re les obstacles puis les escaliers et enfin les issues.
	 * </p>
	 * 
	 * @param niveau  La valeur du niveau de l'�tage.
	 * @param modele  Le modele de notre simulation.
	 * 
	 * @see Etages#niveau
	 * @see Etages#modele
	 */
	public Etages(int niveau , Modele modele) {
		System.out.println("		Creation de l'�tage: " + this );
		this.niveau = niveau;
		this.modele = modele;
		this.w = modele.getWidth();
		this.h = modele.getHeight();
		this.nbObstacles = 0;
		if(niveau == 0) {
			this.nbEscaliers = 0;
			this.nbIssues = (int)(1 + Math.random()*(3));
		} else {
			this.nbEscaliers = 4;
		}
		System.out.println("			Creation des obstacles");
		this.obstacles = createAllObstacles();
		System.out.println("			Creation des escaliers");
		this.escaliers = createEscaliers();
		System.out.println("			Creation des issues");
		this.issues = createIssues();
	}
	
	/**
	 * Retourne la valeur du niveau de l'�tage.
	 * 
	 * @return La valeur du niveau de l'�tage.
	 */
	public int getNiveau() {
		return this.niveau;
	}
	/**
	 * Retourne le Deque d'obstacles de l'�tage.
	 * 
	 * @return Les obstacles de l'�tage.
	 */
	public Deque<Obstacles> getObstacles(){
		return this.obstacles;
	}
	/**
	 * Retourne la valeur du nombre d'escaliers.
	 * 
	 * @return La valeur du nombre d'escaliers.
	 */
	public int getNbEscaliers() {
		return this.nbEscaliers;
	}
	/**
	 * Retourne la valeur du nombre d'issues.
	 * 
	 * @return La valeur du nombre d'issues.
	 */
	public int getNbIssues() {
		return this.nbIssues;
	}
	/**
	 * Retourne la valeur du nombre d'obstacles.
	 * 
	 * @return La valeur du nombre d'obstacles.
	 */
	public int getNbOstacles() {
		return this.nbObstacles;
	}
	public int getw() {
		return this.w;
	}
	/**
	 * Retourne le modele de la simulation.
	 * 
	 * @return Le modele de la simulation.
	 */
	public Modele getModele() {
		return this.modele;
	}
	/**
	 * Retourne le Deque d'issues de l'�tage.
	 * 
	 * @return Les issues de l'�tage.
	 */
	public Deque<Issues> getIssues(){
		return this.issues;
	}
	/**
	 * Retourne le Deque d'escaliers de l'�tage.
	 * 
	 * @return Les escaliers de l'�tage.
	 */
	public Deque<Escaliers> getEscaliers(){
		return this.escaliers;
	}
	/**
	 * Retourne le Deque d'individus de l'�tage.
	 * 
	 * @return Les individus de l'�tage.
	 */
	public Deque<Individus> getIndividus(){
		return this.individus_in_etage;
	}
	
	/**
	 * Met � jour la valeur du nombre d'escaliers de l'�tage.
	 * 
	 * @param nbEscaliers La nouvelle valeur du nombre d'escaliers de l'�tage.
	 */
	public void setNbEscaliers(int nbEscaliers) {
		this.nbEscaliers = nbEscaliers;
	}
	/**
	 * Met � jour la valeur du nombre d'obstacles de l'�tage.
	 * 
	 * @param nbObstacles La nouvelle valeur du nombre d'obstacles de l'�tage.
	 */
	public void setNbObstacles(int nbObstacles) {
		this.nbObstacles = nbObstacles;
	}
	
	/**
	 * Cette m�thode sert � g�n�rer un Deque d'Issues pour notre �tage.
	 * On v�rifie d'abord que l'�tage consid�r� est le rez-de-chauss�e.
	 * Ensuite on cr�e nos issues en fonction du nombre d'issues demand�.
	 * La place des issues et fixe.
	 * 
	 * @return un Deque d'Issues contenant entre une et quatre issues.
	 */
	public Deque<Issues> createIssues(){
		Deque<Issues> result = new ArrayDeque<>();
		if(this.niveau == 0) {
			int nbIssues = this.nbIssues;
			for(int i = 0; i < nbIssues; i++) {
				if(i==0) {
					Issues issue = new Issues((int)(modele.getWidth()/2)-25, 10 , 50, 50);
					result.add(issue);
				}
				if(i==1) {
					Issues issue = new Issues(modele.getWidth() - 10 - 50, (int)(modele.getHeight()/2) - 25, 50, 50);
					result.add(issue);
				}
				if(i==2) {
					Issues issue = new Issues((int)(modele.getWidth()/2)-25, modele.getHeight()-10-50, 50, 50);
					result.add(issue);
				}
				if(i==3) {
					Issues issue = new Issues(10, (int)(modele.getHeight()/2) - 25, 50, 50);
					result.add(issue);
				} 
			}
		}
		return result;
	}
	/**
	 * Cette m�thode sert � r�pondre � la question : la place est-elle occup�e par un obstacle;,
	 * escalier ou issue? 
	 * 
	 * @param x		  la position en x (en haut � gauche) de la place � v�rifier.
	 * @param y		  la position en y (en haut � gauche) de la place � v�rifier.
	 * @param taille  la taille de la place qu'il faut v�rifier.
	 * 
	 * @return un boolean indiquant si la position donn�e est occup�e pour la taille donn�e.
	 */
	public boolean isFree(int x, int y, double taille) {
		int t = (int)taille;
		Deque<Obstacles> obstacles = this.obstacles;
		for(Obstacles o : obstacles) {
			if((x + t > o.getx())&&(x < o.getx() + o.getLargeur())&&(y + t > o.gety())&&( y < o.gety() + o.getHauteur())) {
				return false;
			}
		}	
		return true;
	}
	
	/**
	 * Cette m�thode sert � g�n�rer un Deque d'Escaliers pour notre �tage.
	 * Les escaliers cr�es partent de l'�tage consid�r� et vont tous au rez-de-chauss�e.
	 * La place des escaliers est fixe.
	 * 
	 * @return un Deque d'Escaliers pour l'�tage.
	 */
	public Deque<Escaliers> createEscaliers(){
		Deque<Escaliers> result = new ArrayDeque<>();
		System.out.println("				Creation des escalier du niv : " + this.niveau);
		for(int i = 0; i < this.nbEscaliers; i++) {
			Etages b = this.modele.etages.getFirst();
			int taille = 30;
			Escaliers e = new Escaliers(10 + i%2*(this.w - 20 - taille), 10 + (int)(i/2)*(this.h - 20 - taille)  , taille ,  taille, this, b);
			result.add(e);
			System.out.println("						escalier cr�er");
			b.escaliers.add(e);
			}
		return result;
	}
	/**
	 * Cette m�thode sert � g�n�rer le Deque final d'obstacle de l'�tage en
	 * appellant les m�thodes servant � cr�er les obstacles.
	 * 
	 * @return le Deque d'Obstacle pour l'�tage.
	 */
	public Deque<Obstacles> createAllObstacles(){
		Deque<Obstacles> result = new ArrayDeque<>();
		System.out.println("				Creation des bordures");
		result = createMur(result);
		System.out.print("				");
		result = separateEtage(result);
		System.out.println("				Creation des " + this.nbObstacles + " simples obstacles");
		result = insertObstacle(result);
		return result;
	}
	/**
	 * Cette m�thode sert � g�n�rer un Deque d'obstacles pour l'�tage.
	 * Ces obstacles sont ensuite ins�r� dans le Deque mis en argument.
	 * 
	 * @param mesObstacles 
	 * @return Le deque d'obstacle contenant les nouveaux et anciens obstacles.
	 */
	public Deque<Obstacles> insertObstacle(Deque<Obstacles> mesObstacles){
		int nbObstacles = this.nbObstacles;
		for(int i = 0; i < nbObstacles; i++) {
			int h = (int)(10 + Math.random()*(100-10));
			int l = (int)(10 + Math.random()*(100-10));
			int x = (int)(Math.random()*(modele.getWidth()-l));
			int y = (int)(Math.random()*(modele.getHeight()-h));
			Obstacles o = new Obstacles(x, y, l, h, this);
			mesObstacles.add(o);
		}
		return mesObstacles;
	}
	/**
	 * Cette m�thode sert � g�n�rer un Deque d'obstacles pour l'�tage.
	 * Ce Deque d'obstacles est particulier : il contient les obstacles qui d�limitent l'�tage.
	 * Les murs sont en fait des obstacles de la taille de l'�tage.
	 * Ces murs sont ensuite ins�r� dans le Deque mis en argument.
	 * 
	 * @param mesObstacles 
	 * @return Le deque d'obstacle contenant les nouveaux et anciens obstacles.
	 */
	public Deque<Obstacles> createMur(Deque<Obstacles> mesObstacles){
		int e = 10;
		Obstacles murHaut = new Obstacles(0, 0, w , e, this);
		Obstacles murBas = new Obstacles(0, h - e, w, e, this);
		Obstacles murDroite = new Obstacles(w - e, 0, e, h, this);
		Obstacles murGauche = new Obstacles(0, 0, e, h, this);
		mesObstacles.add(murGauche);
		mesObstacles.add(murDroite);
		mesObstacles.add(murHaut);
		mesObstacles.add(murBas);
		return mesObstacles;
	}
	/**
	 * Cette m�thode sert � g�n�rer un Deque d'obstacles pour l'�tage.
	 * Les obstacles g�n�r�s dans cette m�thode sont des obstacles particuliers :
	 * ce sont des murs qui vont venir s�parer l'�tage en plusieurs salles.
	 * Ces murs ont un trou pour laisser passer les individus d'une salle � l'autre.
	 * Ces obstacles sont ensuite ins�r� dans le Deque mis en argument.
	 * 
	 * @param mesObstacles 
	 * @return Le deque d'obstacle contenant les nouveaux et anciens obstacles.
	 */
	public Deque<Obstacles> separateEtage(Deque<Obstacles> mesObstacles){
		int nbSalles;
		if(this.niveau == 0) {
			nbSalles = 1;
		} else {
			nbSalles = (int)(Math.random()*3)+1; // Un �tage contient une � quatre salles.
		}
		System.out.println("Creation de " + nbSalles + " salles");
		Deque<Integer> positionMur = new ArrayDeque<>();
		Deque<Double> repartition = new ArrayDeque<>();
		double sum = 0.0;
		double facteur = 1; /* Ce facteur fait varier la position des murs s�parateur
		plus ce facteur est grand, moins les positions vont varier.*/
		for(int i = 0; i<nbSalles; i++) {
			double k = Math.random() + facteur;
			sum += k;
			repartition.add(k);
		}
		repartition.removeLast();
		int a = 0;
		for (Double k : repartition) {
			int b = (int)((k/sum)*w) + a;
			positionMur.add(b);
			a = positionMur.getLast();
		}
		for (Integer x : positionMur) {
			Obstacles mur = new Obstacles(x, 0, 10, h, this);
			Deque<Obstacles> murs = mur.createVoid(50);
			mesObstacles.add(murs.getFirst());
			mesObstacles.add(murs.getLast());
		}
		return mesObstacles;
	}
}
