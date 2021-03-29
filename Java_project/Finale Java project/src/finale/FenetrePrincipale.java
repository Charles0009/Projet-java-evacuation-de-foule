package finale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * <b> FenetrePrincipale est la classe où l'on display notre modèle.</b>
 * <p>
 * La fenetre principale est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un JFrame de la fenetre principale. </li>
 * <li>Un JPanel principal contenant tout les autres JPanel.</li>
 * <li>Un int nombre de personne mini maxi et initial de personne .</li>
 * </ul>
 * </p>
 * 
 * @author Antoine
 *
 */
public class FenetrePrincipale extends JFrame{
	/**
	 * Le Panel de notre fenetre.
	 */
	JPanel pan_affi = new JPanel();
	/**
	 * Les parametres utilisateur de notre simulation
	 * 
	 * @see Parametre()
	 */
	 Parametre para = new Parametre();
	 /**
	 * Le Model de notre simulation
	 * 
	 * @see Modele()
	 */	 
	 Modele m = new Modele(pan_affi ,para);
	 /**
	  * Le Boolean de fin des calcul / debut affichage 
	  */	 
	 Boolean simulationReady = false;
	 /**
	  * Liste des etages de la classe Etage
	  * 
	  * @see Etage()
	  */
	 List<List<List<List<Integer>>>> data = new ArrayList<>();
	 /**
	  * Les parametres temporels de l'affichage 
	  */
	 int time = 0;
	 int dtime = 1;
	 int timeMax = 0;
	 /**
	  * L'etage a afficher 
	  */	 
	 int stageToObserve = 0;
	 /**
	  * Initialisation du nombre de personnes
	  */
	 public int nb_personnes;
	 /**
	  * Limites du slider nombre de personnes
	  */
	 static final int pers_MIN = 50;
	 static final int pers_MAX = 800;
	 static final int pers_INIT = 100;    //nombre initial de personnes 

	/**
	 * Constructeur FenetrePrincipale.
	 * <p>
	 * On construit notre fenetre en y incorporant les composants des autres classes
	 * </p>
	 * 
	 * @see FenetrePrincipale#main()
	 */
	 public FenetrePrincipale(){
	 /**
	  * Titre de l'interface
	  */		
	 this.setTitle("simulation de l'evacuation");
	 /**
	  * Rends la fenetre manipulable 
	  */
	 this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	 /**
	  * Mise en place de la position centre de la fentre
	  */
     this.setLocationRelativeTo(null);
     /**
	  * Arreter la cellule en fermeture 
	  */
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     /**
	  * Authorise la manipulation de la fenetre 
	  */
	 this.setResizable(true);
	 /**
	  * Mise en place du panel affichage 
	  */			    
	 this.pan_affi = new PanelAffi(this);
	 /**
	  * On crée Le conteneur parametre de controle de la simulation 
	  */	
	 JPanel pan_controle = new JPanel();
	 /**
	  * On définit le layout manager
	  */			  
	  pan_controle.setPreferredSize(new Dimension (380,600));
	  pan_controle.setLayout(new GridBagLayout());
	  /**
	   * On cree le titre de la commande 
	   */		    
	  JLabel titre_general = new JLabel("Rentrez vos instructions ", JLabel.CENTER);
	  titre_general.setAlignmentX(Component.CENTER_ALIGNMENT); 
	  JPanel pan_titre_logo = new JPanel();
	  pan_titre_logo.setPreferredSize(new Dimension(340, 40));
	  pan_titre_logo.add(titre_general);		 	    
	  /**
	   * On cree le slideur des personnes dans la simulation 
	   */			 	    
	  JLabel sliderLabel = new JLabel("Nombre de personnes dans la simulation: " + pers_INIT, JLabel.CENTER);
	  sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	  JSlider Slide = new JSlider(JSlider.HORIZONTAL,
									                 pers_MIN, pers_MAX, pers_INIT);
									    Slide.setPaintTicks(true);
									    Slide.setPaintLabels(true);
									    Slide.setMinorTickSpacing(50);
									    Slide.setMajorTickSpacing(100);
									    Slide.addChangeListener(new ChangeListener(){
									      public void stateChanged(ChangeEvent event){
									        sliderLabel.setText("Nombre de personnes dans la simulation: " + ((JSlider)event.getSource()).getValue());
									      }
									    });   
									 
	   Slide.addChangeListener(new ChangeListener(){
		   public void stateChanged(ChangeEvent event){
					 nb_personnes = (((JSlider)event.getSource()).getValue());
					 para.setNbPersonnes(nb_personnes);
		}
	   });  
									    
	   /**
	    * On cree les Panels du slider 
	    */								    
	   JPanel pan_slider_pers = new JPanel();
	   pan_slider_pers.setPreferredSize(new Dimension(340, 70));
	   pan_slider_pers.setLayout(new BorderLayout());
	   pan_slider_pers.add(Slide, BorderLayout.CENTER);
	   JPanel pan_titre_slider_pers = new JPanel();
	   pan_titre_slider_pers.setPreferredSize(new Dimension(340, 40));
	   pan_titre_slider_pers.setLayout(new BorderLayout());
	   pan_titre_slider_pers.add(sliderLabel, BorderLayout.CENTER);
	   JPanel pan_gene_pers = new JPanel();  
	   pan_gene_pers.setLayout (new GridLayout(2,1));
	   pan_gene_pers.add(pan_titre_slider_pers);
	   pan_gene_pers.add(pan_slider_pers);
	   pan_gene_pers.setPreferredSize(new Dimension (340,100));
												   				    
	   /**
	    * On importe le panel des boutons de controle principale 
	    */							
	   BoutonsControle pan_bouton_controle = new BoutonsControle();
	   pan_bouton_controle.BoutonsControle(this);
	   /**
	    * On cree un Bouton pour calculer les parametres de la simulations
	    * avant d'afficher 
	    */			 	    
	   JButton BoutonCalcul = new JButton("Calculer");
	   JPanel PanBoutonCalcul = new JPanel();
	   PanBoutonCalcul.setPreferredSize(new Dimension(40,20));
	   PanBoutonCalcul.add(BoutonCalcul);
	   /**
	    * On cree le JFrame de temps de l'evacuation
	    */
	   JFrame frame =new JFrame();
       frame.setLocationRelativeTo(null);
       frame.setSize(250,80);
       frame.setTitle("Duree de l'evacuation");
       frame.setResizable(false);
	   /**
	    * On implemente un actionListener pour le Bouton Calcul 
	    */		
	   BoutonCalcul.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent arg0) { 
					    		 setSimulationReady(false);
					    		 setModele(new Modele(getPanAffi(),getPara()));
					    		 Simulation simulation = new Simulation(getModele());
					    		 setTimeMax(simulation.getData().get(0).size());
					    		 setSimu(simulation.getData());
					    		 setSimulationReady(true);
					    		 JLabel LabelTemps = new JLabel ("Duree de l'evacuation: "+ (timeMax/60) + "secondes");
					    		 frame.getContentPane().add(LabelTemps, BorderLayout.CENTER);
					    		 frame.setVisible(true);
					     }
					    });			  
	   /**
	    * On cree un Panel titre pour le choix des etages 
	    */				    
	   JLabel titre_general_et = new JLabel("Choisissez le nombre d'etage et parametrez-les :", JLabel.CENTER);
	   titre_general_et.setAlignmentX(Component.CENTER_ALIGNMENT); 
	   JPanel pan_titre_et = new JPanel();
	   pan_titre_et.setLayout(new GridLayout(2,1));
	   pan_titre_et.setPreferredSize(new Dimension(340, 58));
	   pan_titre_et.add(titre_general_et);
	   pan_titre_et.add(PanBoutonCalcul);
	   /**
	    * On cree le JComboBox du nombre d'etages 
	    */			 	    
	   ChoixEtage pan_affi_choix_etages = new ChoixEtage (this);
	   pan_affi_choix_etages.get_Jpan_instructions_etages();
	   JPanel retour1 = new JPanel();
	   retour1.add(pan_affi_choix_etages.get_Jpan_instructions_etages());
	   retour1.setPreferredSize(new Dimension(340,400));
	   /**
	    * On met en place les elements entre eux
	    */	
	   GridBagConstraints gbc1 = new GridBagConstraints(); //L'objet servant à positionner les composants
	   gbc1.gridx = 0;
	   gbc1.gridy = 0;
	   gbc1.gridheight = 1;
	   gbc1.gridwidth = 3;
	   gbc1.fill = GridBagConstraints.BOTH;
	   gbc1.gridwidth = GridBagConstraints.REMAINDER;
	   /**
	    * On place le titre
	    */
	   pan_controle.add(pan_titre_logo,gbc1);
	   gbc1.gridx = 0;
	   gbc1.gridy = 1;
	   gbc1.gridheight = 1;
	   gbc1.gridwidth = 3;
	   /**
	    * On place les boutons de controle
	    */
	   pan_controle.add(pan_bouton_controle.RetourBoutons(),gbc1);
	   gbc1.gridx = 0;
	   gbc1.gridy = 2;
	   gbc1.gridheight = 1;
	   gbc1.gridwidth = 3;
	   /**
	    * On place les boutons de controle
	    */
	   pan_controle.add(pan_gene_pers,gbc1);
	   gbc1.gridx = 0;
	   gbc1.gridy = 3;
	   gbc1.gridheight = 1;
	   gbc1.gridwidth = 3;
	   /**
	    * On place le titre du menu deroulant
	    */
	   pan_controle.add(pan_titre_et,gbc1);
	   gbc1.gridx = 0;
	   gbc1.gridy = 4;
	   gbc1.gridheight = 3;
	   gbc1.gridwidth =3;
	   /**
	    * On place le menu deroulant 
	    */
		pan_controle.add(retour1,gbc1);
		/**
		* On construit notre separateur de Panel 
		*/		    
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan_controle, pan_affi);
		split.setResizeWeight(0.042);
		split.setOneTouchExpandable(false);
		split.setDividerLocation(180 + split.getInsets().left);
		/**
		* Remplissage du contentPane()
		*/
		this.getContentPane().add(split, BorderLayout.CENTER);
		/**
		* On rend la fenetre et les changements graphiques visibles pour l'utilisateur
		*/
		this.setVisible(true);
		}
	 	/**
		 * Le modèle de notre simulation.
		 * 
		 * @see Simulation#getModele()
		 */	
		public void setModele(Modele m) {
			this.m = m;
		}
		/**
		 * Getters modèle de notre simulation.
		 * 
		 * @see Simulation#getModele()
		 */
		public Modele getModele() {
			return this.m;
		}
		/**
		 * Le Panel affichage de notre simulation.
		 * 
		 * @see FenetrePrincipale#getPanAffi()
		 */
		public JPanel getPanAffi() {
			return this.pan_affi;
		}
		/**
		 * Les données de notre simulation.
		 * 
		 * @see FenetrePrincipale#getSimu()
		 */
		public void setSimu(List<List<List<List<Integer>>>> data) {
			this.data = data;
		}
		/**
		 * Les données de notre simulation.
		 * 
		 * @see FenetrePrincipale#getSimu()
		 */
		public List<List<List<List<Integer>>>> getSimu(){
			return this.data;
		}
		/**
		 * Le temps de notre simulation.
		 * 
		 * @see FenetrePrincipale#getTime()
		 */
		public void setTime(int time) {
			this.time = time ;
		}
		/**
		 * Le temps de notre simulation.
		 * 
		 * @see FenetrePrincipale#getTime()
		 */
		public int getTime () {
			return this.time;
		}
		/**
		 * Le differentiel temps de notre simulation.
		 * 
		 * @see FenetrePrincipale#getDTime()
		 */
		public void setDTime(int dtime) {
			this.dtime = dtime ;
		}
		/**
		 * Le differentiel temps de notre simulation.
		 * 
		 * @see FenetrePrincipale#getDTime()
		 */
		public int getDTime () {
			return this.dtime;
		}
		/**
		 * Le temps Max de notre simulation.
		 * 
		 * @see FenetrePrincipale#getTimeMax()
		 */
		public void setTimeMax(int timeMax) {
			this.timeMax = timeMax ;
		}
		/**
		 * Le temps Max de notre simulation.
		 * 
		 * @see FenetrePrincipale#getTimeMax()
		 */
		public int getTimeMax () {
			return this.timeMax;
		}
		/**
		 * Les parametres de notre simulation
		 * 
		 * @see FenetrePrincipale#getPara()
		 */
		public Parametre getPara () {
			return this.para;
		}
		/**
		 * L etage a observer
		 * 
		 * @see FenetrePrincipale#getStageToObserve()
		 */
		public void setStageToObserve(int stageToObserve) {
			this.stageToObserve = stageToObserve;
		}
		/**
		 * L etage a observer
		 * 
		 * @see FenetrePrincipale#getStageToObserve()
		 */
		public int getStageToObserve() {
			return this.stageToObserve;
		}
		/**
		 * L'etat de la simulation
		 * 
		 * @see FenetrePrincipale
		 */
		public void setSimulationReady (boolean x) {
			this.simulationReady = x;
		}
		/**
		 * Le main constructeur
		 */
		public static void main(String[] args) { 
			FenetrePrincipale gui = new FenetrePrincipale();	
		}	
}




