
package imports_prog;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.io.File;
import java.util.Deque;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;




public class Affichage extends JFrame {
	
// Creation du JPanel principal 
	public JPanel pan = new JPanel();

// declaration variables de l'affichage 
		
		
	//mise en place du slider personne 
		static final int pers_MIN = 0;
		static final int pers_MAX = 5000;
		static final int pers_INIT = 30;    //nombre initial de personnes 
	
	// mise en place du slider des portes 
		static final int porte_MIN = 1;
		static final int porte_MAX = 10;
		static final int porte_INIT = 3;     
		
	// mise en place du slider des obstacles
		static final int obst_MIN = 0;
		static final int obst_MAX = 10;
		static final int obst_INIT = 3;     
		
	// mise en place du slider des salles 
		static final int salles_MIN = 1;
		static final int salles_MAX = 5;
		static final int salles_INIT = 1;     
		
		
	
	public Affichage(){
	    
// mise en place de la fenetre 	    
	    // titre de l'interface 
	    this.setTitle("simulation de l'evacuation");
	    // definit la taille de la fenetre 
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    // position centree 
	    this.setLocationRelativeTo(null);
	    // arreter la cellule en fermeture 
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // authorise la manipulation de la fenetre 
	    this.setResizable(true);
	    
	   
// division de la fentre en partie parametres et affichage 	
	  //On déclare notre objet JSplitPane
	    JSplitPane split;
	  
	    
	    
// Conteneur des parametres	  
	    
	    
	    
	  //On crée Le conteneur parametre de controle de la simulation 
	    JPanel pan_controle = new JPanel();
	    pan_controle.setBackground(Color.WHITE);
	    
	    
	  // On cree les differents elements a utiliser 
	    
	    	// titre/logo 
	 
	 		JLabel titre_general = new JLabel("Rentrez vos instructions ", JLabel.CENTER);
	 	    titre_general.setAlignmentX(Component.CENTER_ALIGNMENT);
	 	    
	 	    
	 	    
	 	    // boutons de controle 
				 		
	 	    
			JButton bouton_1 = new JButton("Play"); // Bouton demarage simulation 
			JButton bouton_2 = new JButton("STOP"); // Bouton arret simulation 
			JButton bouton_3 = new JButton("Pause"); // Bouton pause simulation 
			
			bouton_1.setBackground(Color.GREEN);
			bouton_2.setBackground(Color.RED);
			bouton_1.setOpaque(true);
			bouton_2.setOpaque(true);
			bouton_1.setIcon(new ImageIcon("C:\\Users\\Antoine.Rainaud\\Desktop\\Projet java\\medhi.png"));
			
	    
			    
		    // Slideur personnes 
		    
			    //Create the label.
			    JLabel sliderLabel = new JLabel("Nombre de personnes: 30 ", JLabel.CENTER);
			    sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
			    //Create the slider.
			    JSlider Slide = new JSlider(JSlider.HORIZONTAL,
			                                          pers_MIN, pers_MAX, pers_INIT);
			    Slide.setPaintTicks(true);
			    Slide.setPaintLabels(true);
			    Slide.setMinorTickSpacing(500);
			    Slide.setMajorTickSpacing(1000);
			    Slide.addChangeListener(new ChangeListener(){
			      public void stateChanged(ChangeEvent event){
			        sliderLabel.setText("Nombre de personnes : " + ((JSlider)event.getSource()).getValue());
			      }
			    });      
		  
		    // Slideur portes 
			    
			    // Create the label 
			    	JLabel sliderLabel_portes = new JLabel("Nombre de sorties de secours: 3 ", JLabel.CENTER);
			    	sliderLabel_portes.setAlignmentX(Component.CENTER_ALIGNMENT);
			    
				//Create the slider.
				    JSlider Slide_porte = new JSlider(JSlider.HORIZONTAL,
				                                          porte_MIN, porte_MAX, porte_INIT);
				    Slide_porte.setPaintTicks(true);
				    Slide_porte.setPaintLabels(true);
				    Slide_porte.setMinorTickSpacing(1);
				    Slide_porte.setMajorTickSpacing(2);
				    Slide_porte.addChangeListener(new ChangeListener(){
				      public void stateChanged(ChangeEvent events){
				        sliderLabel_portes.setText("Nombre de sorties de secours: " + ((JSlider)events.getSource()).getValue());
				      }
				    });      
			  
			 // Slideur Obstacles 
			    
				 // Create the label 
			    	JLabel sliderLabel_Obstacles = new JLabel("Nombre d'obstacles: 2 ", JLabel.CENTER);
			    	sliderLabel_Obstacles.setAlignmentX(Component.CENTER_ALIGNMENT);
			    
				//Create the slider.
				    JSlider Slide_Obstacles = new JSlider(JSlider.HORIZONTAL,
				                                          obst_MIN, obst_MAX, obst_INIT);
				    Slide_Obstacles.setPaintTicks(true);
				    Slide_Obstacles.setPaintLabels(true);
				    Slide_Obstacles.setMinorTickSpacing(1);
				    Slide_Obstacles.setMajorTickSpacing(2);
				    Slide_Obstacles.addChangeListener(new ChangeListener(){
				      public void stateChanged(ChangeEvent eventss){
				        sliderLabel_Obstacles.setText("Nombre d'obstacles: " + ((JSlider)eventss.getSource()).getValue());
				      }
				    });      
				    
				    
			// Slideur nb de salles 
				    
				 // Create the label 
			    	JLabel sliderLabel_salles = new JLabel("Nombre de salles: 1 ", JLabel.CENTER);
			    	sliderLabel_salles.setAlignmentX(Component.CENTER_ALIGNMENT);
			    
				//Create the slider.
				    JSlider Slider_salles = new JSlider(JSlider.HORIZONTAL,
				                                          salles_MIN, salles_MAX, salles_INIT);
				    Slider_salles.setPaintTicks(true);
				    Slider_salles.setPaintLabels(true);
				    Slider_salles.setMinorTickSpacing(1);
				    Slider_salles.setMajorTickSpacing(2);
				    Slider_salles.addChangeListener(new ChangeListener(){
				      public void stateChanged(ChangeEvent eventsss){
				        sliderLabel_salles.setText("Nombre de salles: " + ((JSlider)eventsss.getSource()).getValue());
				      }
				    });      
				    
				    
				    
			    
	  //On définit le layout à utiliser sur le controle pane
	    pan_controle.setLayout(new GridBagLayout());
	  
			  // Mise en place des cellules de commande (boutons et sliders) 
			    
	    		// decla1
					    JPanel bouton_play = new JPanel();
					    bouton_play.setBackground(Color.WHITE);
					    bouton_play.setPreferredSize(new Dimension(200, 200));		
			    // implementaion 1
					    bouton_play.add(bouton_1);
			    
				// decla2
					    JPanel bouton_stop = new JPanel();
					    bouton_stop.setBackground(Color.WHITE);
					    bouton_stop.setPreferredSize(new Dimension(70, 40));
			    // implementation 2
					    bouton_stop.add(bouton_2);
					    	    
				// decla 3
					    JPanel bouton_pause = new JPanel();
					    bouton_pause.setBackground(Color.WHITE);
					    bouton_pause.setPreferredSize(new Dimension(70, 40));
				// imple3
					    bouton_pause.add(bouton_3);
					    
				
				// decla 4
					    JPanel pan_slider_pers = new JPanel();
					    pan_slider_pers.setBackground(Color.WHITE);
					    pan_slider_pers.setPreferredSize(new Dimension(60, 70));
				// imple4
					    pan_slider_pers.setLayout(new BorderLayout());
					    pan_slider_pers.add(Slide, BorderLayout.WEST);
					    
				// decla 5    
					    JPanel pan_titre_slider_pers = new JPanel();
					    pan_titre_slider_pers.setBackground(Color.WHITE);
					    pan_titre_slider_pers.setPreferredSize(new Dimension(60, 40));
				// imple 5 
					    pan_titre_slider_pers.setLayout(new BorderLayout());
					    pan_titre_slider_pers.add(sliderLabel, BorderLayout.WEST);
					    				    
					    
				// decla 6 
					    JPanel pan_slider_porte = new JPanel();
					    pan_slider_porte.setBackground(Color.WHITE);
					    pan_slider_porte.setPreferredSize(new Dimension(200, 70));
				// imple 6   
					    pan_slider_porte.setLayout(new BorderLayout());
					    pan_slider_porte.add(Slide_porte, BorderLayout.WEST);
					    
				// decla 7   
					    JPanel pan_titre_slider_porte = new JPanel();
					    pan_titre_slider_porte.setBackground(Color.WHITE);
					    pan_titre_slider_porte.setPreferredSize(new Dimension(60, 40));
				// imple 7    
					    pan_titre_slider_porte.setLayout(new BorderLayout());
					    pan_titre_slider_porte.add(sliderLabel_portes, BorderLayout.WEST);
					    
				// decla 8 
					    JPanel pan_titre_logo = new JPanel();
					    pan_titre_logo.setBackground(Color.WHITE);
					    pan_titre_logo.setPreferredSize(new Dimension(180, 40));
				// imple 8 
					    pan_titre_logo.add(titre_general);
				
				// decla 9 
					    JPanel pan_titre_slider_salles = new JPanel();
					    pan_titre_slider_salles.setBackground(Color.WHITE);
					    pan_titre_slider_salles.setPreferredSize(new Dimension(180, 40));
			    // imple 9
					    pan_titre_slider_salles.setLayout(new BorderLayout());
					    pan_titre_slider_salles.add(sliderLabel_salles, BorderLayout.WEST);
					
				// decla 10
					    JPanel pan_slider_salles = new JPanel();
					    pan_slider_salles.setBackground(Color.WHITE);
					    pan_slider_salles.setPreferredSize(new Dimension(180, 40));
			    // imple 10
					    pan_slider_salles.setLayout(new BorderLayout());
					    pan_slider_salles.add(Slider_salles, BorderLayout.WEST);
					    
					  
				// decla 11 
					    JPanel pan_titre_slider_Obstacles = new JPanel();
					    pan_titre_slider_Obstacles.setBackground(Color.WHITE);
					    pan_titre_slider_Obstacles.setPreferredSize(new Dimension(180, 40));
			    // imple 11
					    pan_titre_slider_Obstacles.setLayout(new BorderLayout());
					    pan_titre_slider_Obstacles.add(sliderLabel_Obstacles, BorderLayout.WEST);
					    
				// decla 12
					    JPanel pan_slider_Obstacles = new JPanel();
					    pan_slider_Obstacles.setBackground(Color.WHITE);
					    pan_slider_Obstacles.setPreferredSize(new Dimension(180, 40));
			    // imple 11
					    pan_slider_Obstacles.setLayout(new BorderLayout());
					    pan_slider_Obstacles.add(Slide_Obstacles, BorderLayout.WEST);
					    
					    
					    
				
					    
			   // Placement des cellules dans le pan parametre
			    GridBagConstraints gbc = new GridBagConstraints(); //L'objet servant à positionner les composants
	  
			  //On positionne la case de départ du composant
			    gbc.gridx = 0;
			    gbc.gridy = 1;
			    //La taille en hauteur et en largeur
			    gbc.gridheight = 1;
			    gbc.gridwidth = 1;
			    // le bouton play
			    pan_controle.add(bouton_play, gbc);
			    
			    
			    
			 // le bouton pause 
			    gbc.gridx = 1;
			    gbc.gridy = 1;
			    gbc.gridwidth =1;
			    gbc.gridheight = 1;
			    pan_controle.add(bouton_pause, gbc);
			    
			   // le bouton stop 
			 
			    gbc.gridx = 2;
			    gbc.gridy = 1;
			    gbc.gridwidth =1;
			    gbc.gridheight = 1;
			    pan_controle.add(bouton_stop, gbc);
			   
			   // un logo/instructions 
			    gbc.gridx = 0;
			    gbc.gridy = 0;
			    gbc.gridwidth = 3;
			    gbc.gridheight = 1;
			    //indique que la cellule se réplique de façon verticale
			    gbc.fill = GridBagConstraints.HORIZONTAL;
			    pan_controle.add(pan_titre_logo, gbc);
			    
			    
			   // le slider du nombre de personnes 
			    gbc.gridx = 0 ;
			    gbc.gridy = 2; 
			    gbc.gridwidth = 6;
			    gbc.gridheight = 1;
			    pan_controle.add(pan_titre_slider_pers, gbc);
			    
			    gbc.gridx = 0 ;
			    gbc.gridy = 3; 
			    gbc.gridwidth = 6;
			    gbc.gridheight = 1;
			    pan_controle.add(pan_slider_pers, gbc);
			    
			 // le slider du nombre de portes
			    gbc.gridx = 0 ;
			    gbc.gridy = 4; 
			    gbc.gridwidth = 6;
			    gbc.gridheight = 1;
			    pan_controle.add(pan_titre_slider_porte, gbc);
			    
			    gbc.gridx = 0 ;
			    gbc.gridy = 5; 
			    gbc.gridwidth = 6;
			    gbc.gridheight = 1;
			    pan_controle.add(pan_slider_porte, gbc);
			    
			 // le slider du nombre de salles
			    gbc.gridx = 0 ;
			    gbc.gridy = 6; 
			    gbc.gridwidth = 6;
			    gbc.gridheight = 1;
			    pan_controle.add(pan_titre_slider_salles, gbc);
			    
			    gbc.gridx = 0 ;
			    gbc.gridy = 7; 
			    gbc.gridwidth = 6;
			    gbc.gridheight = 1;
			    pan_controle.add(pan_slider_salles, gbc);
			    
	    
			 // le slider du nombre d'obstacles
			    gbc.gridx = 0 ;
			    gbc.gridy = 8; 
			    gbc.gridwidth = 6;
			    gbc.gridheight = 1;
			    pan_controle.add(pan_titre_slider_Obstacles, gbc);
			    
			    gbc.gridx = 0 ;
			    gbc.gridy = 9; 
			    gbc.gridwidth = 6;
			    gbc.gridheight = 1;
			    pan_controle.add(pan_slider_Obstacles, gbc);
			    
	    
	    
	    

    
 // conteneur affichage simulation   
 
    Panel pan_affi = new Panel();
    pan_affi.setBackground(Color.BLACK);
    
    
    //On construit enfin notre séparateur
    split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan_controle, pan_affi);
    split.setOneTouchExpandable(true);
    
    //On le passe ensuite au content pane de notre objet 
    //placé au centre pour qu'il utilise tout l'espace disponible
    this.getContentPane().add(split, BorderLayout.CENTER);
    
    // rend la fenetre et les changements graphiques visibles pour l'utilisateur
    this.setVisible(true);
    
    
    
    

	}
    
    

    
    
    

    

	
	
	public static void main(String[] args) { 
		Affichage gui = new Affichage();
		
	}

	
}


