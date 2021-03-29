package finale;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
/**
 * <b> PanelRDC est la classe où l'on met en place notre information parametrage RDC</b>
 * <p>
 * La classe est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un JButton Parametrer</li>
 * <li>Un JButton Afficher</li>
 * <li>Un JPanel pour contenir nos Boutons</li>
 * </ul>
 * </p>
 * 
 * @author Charles
 *
 */
public class PanelRDC {
	/**
	 * Le Bouton 1 du parametrage
	 * 
	 * @see PanelRDC#bouton
	 */
	JButton bouton = new JButton("Parametrer RDC"); // Bouton accees aux parametres du RDC
	/**
	 * Le Bouton 2 de l'affichage
	 *  
	 * @see FenetreRDC#retour_porte_int()
	 */
	JButton bouton_2 = new JButton("Afficher RDC");
	/**
	 * Le JPanel contenant
	 *  
	 * @see PanelRDC#pan_gene_rdc
	 */
	JPanel pan_gene_rdc = new JPanel ();
	/**
	 * Le int du nombre d'issues 
	 */
	int nbIssues;	
	/**
	 * Le Choix de l'etage 
	 *  
	 * @see PanelRDC#choix
	 */
	ChoixEtage choix;
	/**
	 * Constructeur PanelRDC
	 * <p>
	 * On recupere notre panel et le renvoie vers son affichage sous-jacent dans ChoixEtage
	 * </p>
	 * 
	 * @param choix  		Le JPanel ou renvoyer notre Panel.
	 * 
	 * @see PanelAffi#Fen
	 */
	public PanelRDC(ChoixEtage choix) {
			this.choix = choix;
		}
	/**
	 * Constructeur GUI_RDC
	 * <p>
	 * On Construit notre Panel contenant les parametres RDC
	 * </p>
	 * 
	 * @param choix  		Le JPanel ou renvoyer notre Panel.
	 * 
	 * @see PanelAffi#Fen
	 */
	public void GUI_RDC () {
			
			PanelRDC me = this;
			pan_gene_rdc.setPreferredSize(new Dimension(340,80));
			pan_gene_rdc.setLayout(new GridLayout(1,2));
			pan_gene_rdc.add(bouton);
			pan_gene_rdc.add(bouton_2);
			
			 bouton.addActionListener(new ActionListener(){
				 public void actionPerformed(ActionEvent arg0) {
						FenetreRDC jpan_diag_RDC = new FenetreRDC(me);
						bouton.add(jpan_diag_RDC.getSliders());					
						}											 
										 });			 
			 bouton_2.addActionListener(new ActionListener() {				 
				 public void actionPerformed (ActionEvent arg0) {
					 choix.Fen.setStageToObserve(0);
				 }
			 });		
		}		
	/**
	 * Le JPanel contenant
	 *  
	 * @see PanelRDC#pan_gene_rdc
	 */
	public JPanel GUI_RDCs(){
	    return pan_gene_rdc;
		}

		   
}
