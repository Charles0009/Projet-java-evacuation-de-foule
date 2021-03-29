package finale;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * <b> BoutonsControle est une classe ou l'on cree les boutons Play, Pause, Stop et de vitesse 
 * de notre affichage.</b>
 * <p>
 * Un BoutonControle est caracterise par:
 * <ul>
 * <li>Un Bouton Play.</li>
 * <li>Un Bouton Pause</li>
 * <li>Un Bouton Stop.</li>
 * <li>Un Bouton speed.</li>
 * <li>Un Panel des Boutons</li>
 * </ul>
 * </p>
 * 
 * @author Charles
 *
 */

public class BoutonsControle {
	/**
	 * La fenetre principale ou renvoyer de l'information 
	 * 
	 * @see FentrePrincipale
	 */
	FenetrePrincipale Fen;
	/**
	 * Les Boutons
	 */
	JButton bouton_1 = new JButton("PLAY"); // Bouton demarage simulation 
	JButton bouton_2 = new JButton("STOP"); // Bouton arret simulation 
	JButton bouton_3 = new JButton("Pause"); // Bouton pause simulation 
	JButton bouton_4 = new JButton("SPEED x2");
	/**
	 * Le panel principal des boutons
	 * 
	 * @see FentrePrincipale
	 */
	JPanel pan_gene_bouton = new JPanel(); 
	/**
	 * Constructeur BoutonsControle.
	 * <p>
	 * On construit notre  Panel de boutons avec leurs actions associees 
	 * </p>
	 * 
	 * @param Fen   		La fentre ou renvoyer le Panel.
	 * 
	 * @see 
	 */
	public void BoutonsControle(FenetrePrincipale Fen) {
			this.Fen = Fen;
			bouton_1.setBackground(Color.GREEN);
			bouton_2.setBackground(Color.RED);
			bouton_1.setOpaque(true);
			bouton_2.setOpaque(true);
			// Mise en place d'un pan pour les boutons
		    JPanel bouton_play = new JPanel();
		    bouton_1.addActionListener(new ActionListener() {
		    	 public void actionPerformed(ActionEvent arg0) {
		    		 Fen.setDTime(1); 
		    	 }
		    });
		    bouton_play.setPreferredSize(new Dimension(60, 40));	
		    bouton_play.add(bouton_1);
		    JPanel bouton_stop = new JPanel();
		    bouton_2.addActionListener(new ActionListener() {
		    	 public void actionPerformed(ActionEvent arg0) {
		    		 Fen.setDTime(0); 
		    		 Fen.setTime(0);
		    	 }
		    });
		    bouton_stop.setPreferredSize(new Dimension(60, 40));
		    bouton_stop.add(bouton_2);
		    JPanel bouton_pause = new JPanel();
		    bouton_3.addActionListener(new ActionListener() {
		    	 public void actionPerformed(ActionEvent arg0) {
		    		 Fen.setDTime(0);
		    	 }
		    });
		    bouton_pause.setPreferredSize(new Dimension(60, 40));
		    bouton_pause.add(bouton_3);
		    JPanel bouton_acce = new JPanel();
		    bouton_4.addActionListener(new ActionListener() {
		    	 public void actionPerformed(ActionEvent arg0) {
		    		 Fen.dtime = Fen.dtime*2;
		    		 if (Fen.dtime > 16) {
		    			 Fen.dtime = 1;
		    		 }
		    	 }
		    });
		    bouton_acce.setPreferredSize(new Dimension(60, 40));
		    bouton_acce.add(bouton_4);
		    // Mise en Commun du panel Bouton 
		    // decla panel general bouton
			pan_gene_bouton.setLayout (new GridLayout(2,2));
			pan_gene_bouton.add(bouton_play);
			pan_gene_bouton.add(bouton_pause);
			pan_gene_bouton.add(bouton_stop);
			pan_gene_bouton.add(bouton_acce);
			pan_gene_bouton.setPreferredSize(new Dimension (220,80));	
		}
 
	/**
	 * Le setter du panel des boutons
	 * 
	 * @see BoutonsControle()
	 */
	public JPanel RetourBoutons(){
     return pan_gene_bouton;
	}
}
