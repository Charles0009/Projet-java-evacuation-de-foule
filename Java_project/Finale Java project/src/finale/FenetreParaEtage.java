package finale;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * <b> FenetreParaEtage est la classe ou l'on donne les specifications de nos etages.</b>
 * <p>
 * Un Etage est caractérisée par les informations suivantes :
 * <ul>
 * </ul>
 * </p>
 * 
 * @author Charles
 *
 */				 
public class FenetreParaEtage implements ActionListener{
	/**
	 * L'etage a parametre
	 * 
	 * @see ChoixEtage#getEtage()
	 */
	ChoixEtage choix;
	/**
	 * L'indice de notre etage
	 */
	int i;
	/**
	 * Les parametres portes + obstacles des sliders 
	 */
	static final int esc_MIN = 1;
	static final int esc_MAX = 4;
	static final int esc_INIT = 1;  
	static final int obst_MIN = 0;
	static final int obst_MAX = 10;
	static final int obst_INIT = 0;     
	int nbEscaliers;					
	int nbObstacles; 
	/**
	 * Constructeur FenetreParaEtage
	 * <p>
	 * On construit nos parametre etages en fonction des resultats du action listener
	 * pour chaque indice d'etages
	 * </p>
	 * 
	 * @param choix   		le retour des parametres de l'etage
	 **@param i   		l'indice etage
	 * @see FenetreParaEtage#choix()
	 * @see FenetreParaEtage#i()
	 */
	public FenetreParaEtage(ChoixEtage choix, int i) {
		this.choix = choix;
		this.i = i;
	}
	/**
	 * Le getter de l'etage choisi
	 */
	public ChoixEtage getChoixEtage() {
		return this.choix;
	}
	/**
	 * Constructeur actionPerformed
	 * <p>
	 * On construit nos etages en incorporant les actions utilisateur
	 * </p>
	 
	 */
	public void actionPerformed(ActionEvent arg0) {
					        JFrame frame =new JFrame();
					        frame.setLocationRelativeTo(null);
					        frame.setSize(330,480);
					        frame.setTitle("Choix des parametres de l'etage: " + i);
					        frame.setResizable(false);
					        frame.setVisible(true);
					        JPanel pan_rdc_menu = new JPanel();
					        // creation des sliders parametres 
													    // Slideur portes 
														    // Create the label 
														    	JLabel sliderLabel_esc = new JLabel("Nombre d'escaliers: 3 ", JLabel.CENTER);
														    	sliderLabel_esc.setAlignmentX(Component.CENTER_ALIGNMENT);
															//Create the slider.
															    JSlider Slide_esc = new JSlider(JSlider.HORIZONTAL,
															                                          esc_MIN, esc_MAX, esc_INIT);
															    Slide_esc.setPaintTicks(true);
															    Slide_esc.setPaintLabels(true);
															    Slide_esc.setMinorTickSpacing(1);
															    Slide_esc.setMajorTickSpacing(2);
															    Slide_esc.addChangeListener(new ChangeListener(){
															      public void stateChanged(ChangeEvent events){
															        sliderLabel_esc.setText("Nombre d'escaliers: " + ((JSlider)events.getSource()).getValue());
															        nbEscaliers = ((JSlider)events.getSource()).getValue();
															        getChoixEtage().Fen.para.setNbEscaliersInStage(nbEscaliers, i );
															      }
															    });  
														 // Slideur Obstacles 
															 // Create the label 
														    	JLabel sliderLabel_Obstacles = new JLabel("Nombre d'obstacles: 0 ", JLabel.CENTER);
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
															        nbObstacles = ((JSlider)eventss.getSource()).getValue();
															        getChoixEtage().Fen.para.setNbObstaclesInStage(nbObstacles, i);
															        System.out.println(i);
															      }
															    });          
											// mise en place des sliders dans un pan respectif 	    
																// mise en place du nombre d'escaliers 	
																		// decla 6 
																			    JPanel pan_slider_esc = new JPanel();
																			    pan_slider_esc.setBackground(Color.WHITE);
																			    pan_slider_esc.setPreferredSize(new Dimension(200, 70));
																		// imple 6   
																			    pan_slider_esc.setLayout(new BorderLayout());
																			    pan_slider_esc.add(Slide_esc, BorderLayout.CENTER);
																			    
																		// decla 7   
																			    JPanel pan_titre_slider_esc = new JPanel();
																			    pan_titre_slider_esc.setBackground(Color.WHITE);
																			    pan_titre_slider_esc.setPreferredSize(new Dimension(60, 40));
																		// imple 7    
																			    pan_titre_slider_esc.setLayout(new BorderLayout());
																			    pan_titre_slider_esc.add(sliderLabel_esc, BorderLayout.CENTER);						

																		// decla panel general portes 
																				JPanel pan_gene_esc = new JPanel();  
																				pan_gene_esc.setLayout (new GridLayout(2,1));
																				pan_gene_esc.add(pan_titre_slider_esc);
																				pan_gene_esc.add(pan_slider_esc);
																				pan_gene_esc.setPreferredSize(new Dimension (180,180));
																// Mise en place du nombre d'obstacles 
																			// decla 11 
																				    JPanel pan_titre_slider_Obstacles = new JPanel();
																				    pan_titre_slider_Obstacles.setBackground(Color.WHITE);
																				    pan_titre_slider_Obstacles.setPreferredSize(new Dimension(180, 40));
																		    // imple 11
																				    pan_titre_slider_Obstacles.setLayout(new BorderLayout());
																				    pan_titre_slider_Obstacles.add(sliderLabel_Obstacles, BorderLayout.CENTER);
																					    
																			// decla 12		
																				    JPanel pan_slider_Obstacles = new JPanel();
																				    pan_slider_Obstacles.setBackground(Color.WHITE);
																				    pan_slider_Obstacles.setPreferredSize(new Dimension(180, 40));
																		    // imple 11
																				    pan_slider_Obstacles.setLayout(new BorderLayout());
																				    pan_slider_Obstacles.add(Slide_Obstacles, BorderLayout.CENTER);
																			// decla panel general obstacles 
																				    JPanel pan_gene_obst = new JPanel();  
																					pan_gene_obst.setLayout (new GridLayout(2,1));
																					pan_gene_obst.add(pan_titre_slider_Obstacles);
																					pan_gene_obst.add(pan_slider_Obstacles);
																					pan_gene_obst.setPreferredSize(new Dimension (180,180));
																				
					        JButton bouton_valid = new JButton("VALIDER");
					        JPanel pan_bouton_valid = new JPanel();
					        pan_bouton_valid.add(bouton_valid);
					        pan_bouton_valid.setBackground(Color.WHITE);
							pan_bouton_valid.setPreferredSize(new Dimension (40,40));
							 bouton_valid.addActionListener(new ActionListener(){
								    public void actionPerformed(ActionEvent event){
							        frame.dispose() ;
								      }
								    });
					        pan_rdc_menu.setLayout (new GridLayout(4,1));
					        pan_rdc_menu.add(pan_gene_esc);
					        pan_rdc_menu.add(pan_gene_obst);
					        pan_rdc_menu.add(pan_bouton_valid);
					        frame.getContentPane().add(pan_rdc_menu, BorderLayout.CENTER);       
					    }
	}  
				
				
			
			
			   
	

