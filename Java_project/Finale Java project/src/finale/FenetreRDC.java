
package finale;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * <b> FenetreRDC est la classe où l'on parametre notre RDC</b>
 * <p>
 * La classe est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un int de retour du nombre de portes au RDC</li>
 * <li>Un int de retour du nombre d'obstacles au RDC</li>
 * <li>Une JFrame ou le parametrage popup</li>
 * <li>Un JPanel Contenant les sliders</li>
 * </ul>
 * </p>
 * 
 * @author Charles
 *
 */
public class FenetreRDC  {
	/**
	 * Le retour du nombre de portes 
	 * 
	 * @see FenetreRDC#retour_porte_int()
	 */
	int retour_porte_int;
	/**
	 * Le retour du nombre d'obstacles
	 * 
	 * @see FenetreRDC#retour_obst_int()
	 */
	int retour_obst_int;
	/**
	 * Le Panel d'affichage des JFrame
	 * 
	 * @see FenetreRDC#getPanelRDC()
	 */
	JPanel panel = new JPanel();
	PanelRDC pan;
	/**
	 * Le constructeur FenetreRDC
	 * 
	 * @see FenetreRDC
	 */
	public FenetreRDC (PanelRDC pan) {
		this.pan = pan;
	}
	/**
	 * Le getters du Panel principal de la fenetre
	 */
	public PanelRDC getPanelRDC() {
		return this.pan;
	}
	
	/**
	 * Constructeur getSliders().
	 * <p>
	 * On construit notre Fenetre et on y incorpore nos Sliders
	 * </p>
	 * @see FenetreRDC#getSliders()
	 */
	public JFrame getSliders() {
		
		JFrame frame =new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setSize(330,480);
        frame.setTitle("Choix des parametres de l'etage");
        frame.setResizable(false);
        frame.setVisible(true);
		  // Slideur portes 
		// Create the label 
    	JLabel sliderLabel_portes = new JLabel("Nombre de sorties de secours: 1 ", JLabel.CENTER);
    	sliderLabel_portes.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Create the slider.
		    JSlider Slide_porte = new JSlider(JSlider.HORIZONTAL,
		                                          1, 4, 1);
		    Slide_porte.setPaintTicks(true);
		    Slide_porte.setPaintLabels(true);
		    Slide_porte.setMinorTickSpacing(1);
		    Slide_porte.setMajorTickSpacing(1);
	    Slide_porte.addChangeListener(new ChangeListener(){
		    public void stateChanged(ChangeEvent events){
		        sliderLabel_portes.setText("Nombre de sorties de secours: " + ((JSlider)events.getSource()).getValue());
		      }
		    }); 
	    
	    Slide_porte.addChangeListener(new ChangeListener(){
		    public void stateChanged(ChangeEvent events){
		        retour_porte_int =  ((JSlider)events.getSource()).getValue();
		        
		        getPanelRDC().choix.Fen.para.setNbOut(retour_porte_int);
		      }
		    });  
						// decla 6 
							    JPanel pan_slider_porte = new JPanel();
							    pan_slider_porte.setBackground(Color.WHITE);
							    pan_slider_porte.setPreferredSize(new Dimension(200, 70));
						// imple 6   
							    pan_slider_porte.setLayout(new BorderLayout());
							    pan_slider_porte.add(Slide_porte, BorderLayout.CENTER);
						// decla 7   
							    JPanel pan_titre_slider_porte = new JPanel();
							    pan_titre_slider_porte.setBackground(Color.WHITE);
							    pan_titre_slider_porte.setPreferredSize(new Dimension(60, 40));
						// imple 7    
							    pan_titre_slider_porte.setLayout(new BorderLayout());
							    pan_titre_slider_porte.add(sliderLabel_portes, BorderLayout.CENTER);
						// decla panel general portes 
								JPanel pan_gene_porte = new JPanel();  
								pan_gene_porte.setLayout (new GridLayout(2,1));
								pan_gene_porte.add(pan_titre_slider_porte);
								pan_gene_porte.add(pan_slider_porte);
								pan_gene_porte.setPreferredSize(new Dimension (300,180));
							// Create the label 
					    	JLabel sliderLabel_obst = new JLabel("Nombre d'obstacles: 1 ", JLabel.CENTER);
					    	sliderLabel_obst.setAlignmentX(Component.CENTER_ALIGNMENT);
							//Create the slider.
									JSlider Slide_Obstacles = new JSlider(JSlider.HORIZONTAL,
							                0, 10, 0);
							Slide_Obstacles.setPaintTicks(true);
							Slide_Obstacles.setPaintLabels(true);
							Slide_Obstacles.setMinorTickSpacing(1);
							Slide_Obstacles.setMajorTickSpacing(2);
							// decla 6 
							JPanel pan_slider_obst = new JPanel();
							pan_slider_obst.setBackground(Color.WHITE);
							pan_slider_obst.setPreferredSize(new Dimension(200, 70));
							//imple 6   
							pan_slider_obst.setLayout(new BorderLayout());
							pan_slider_obst.add(Slide_Obstacles, BorderLayout.CENTER);
							//decla 7   
							JPanel pan_titre_slider_obst = new JPanel();
							pan_titre_slider_obst.setBackground(Color.WHITE);
							pan_titre_slider_obst.setPreferredSize(new Dimension(60, 40));
							//imple 7    
							pan_titre_slider_obst.setLayout(new BorderLayout());
							pan_titre_slider_obst.add(sliderLabel_obst, BorderLayout.CENTER);
							//decla panel general portes 
							JPanel pan_gene_obst = new JPanel();  
							pan_gene_obst.setLayout (new GridLayout(2,1));
							pan_gene_obst.add(pan_titre_slider_obst);
							pan_gene_obst.add(pan_slider_obst);
							pan_gene_obst.setPreferredSize(new Dimension (300,180));
							Slide_Obstacles.addChangeListener(new ChangeListener(){
							    public void stateChanged(ChangeEvent events){
							        sliderLabel_obst.setText("Nombre d'obstacles: " + ((JSlider)events.getSource()).getValue());
							      }
							    }); 
							Slide_Obstacles.addChangeListener(new ChangeListener(){
							    public void stateChanged(ChangeEvent events){
							        retour_obst_int =  ((JSlider)events.getSource()).getValue();
							        getPanelRDC().choix.Fen.para.setNbObstaclesInStage(retour_obst_int, 0);
							      }
							    }); 
					        JButton bouton_valid = new JButton("VALIDER"); // le bouton pour fermer la fenetre une fois la saisie terminee
					        JPanel pan_bouton_valid = new JPanel();
					        pan_bouton_valid.add(bouton_valid);
					        pan_bouton_valid.setBackground(Color.WHITE);
							pan_bouton_valid.setPreferredSize(new Dimension (40,40));
							 bouton_valid.addActionListener(new ActionListener(){
								    public void actionPerformed(ActionEvent event){
							        frame.dispose() ;
								      }
								    });
							panel.setLayout(new GridLayout(3,1));
							panel.add(pan_gene_porte);
							panel.add(pan_gene_obst);
							panel.add(pan_bouton_valid);
							  frame.getContentPane().add(panel, BorderLayout.CENTER);
							  frame.setVisible(true);
							  return frame;
								  }
}


