package finale;

import java.awt.Color;
import java.awt.Graphics;

import java.util.List;


import java.util.ArrayList;
import java.util.Deque;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * <b> PanelAffi est la classe où l'on affiche notre simulation reliee a un JPanel</b>
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
public class PanelAffi extends JPanel {
	/**
	 * La fenetre principale de retour de notre information
	 * 
	 * @see PanelAffi#getFenetre()
	 */
	FenetrePrincipale Fen;
	/**
	 * Constructeur PanelAffi().
	 * <p>
	 * On construit notre Panel d'affichage en recuperant les composants des autres classes 
	 * et en les materialisants sous forme geometriques.
	 * </p>
	 * 
	 * @param FenetrePrincipale  		La fenetre principale ou renvoyer notre Panel.
	 * 
	 * @see PanelAffi#Fen
	 */
	public PanelAffi(FenetrePrincipale Fen) {
		/**
		 * La fenetre principale de retour de notre information
		 * 
		 * @see PanelAffi#Fen
		 */
		this.Fen = Fen;
		setBackground(Color.BLACK);
		new Thread(new Runnable() {	
			@Override
			public void run() {
				while(true) {
					repaint();
					try {
						Thread.sleep(1000/60l);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

@Override
	/**
	 * La modelisation pure de nos composants
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int time = Fen.time;
		int niveau = Fen.getStageToObserve();
		ArrayList <Etages> listeEtages = new ArrayList();
			for (Etages e : Fen.m.etages) {	
			listeEtages.add(e);
			}	
		Etages e = listeEtages.get(niveau);
		List<List<List<List<Integer>>>> data = new ArrayList();
		if (Fen.simulationReady) {
			data = Fen.data;
			System.out.println(data.get(0).size());
		}
		//ImageIcon stair = new ImageIcon("image/stairs.jpg");
		//ImageIcon out = new ImageIcon("image/out.jpg");

		// Dessin des obstacles 		
		g.setColor(Color.CYAN);
		Deque <Obstacles> obstacles = e.obstacles;
		for (Obstacles o : obstacles) {
			g.fillRect(o.getx(), o.gety(), o.getLargeur(), o.getHauteur());
		}
		
		// Dessin des escaliers
		g.setColor(Color.RED);
		Deque <Escaliers> escaliers = e.escaliers;
		for (Escaliers u : escaliers) {
			g.fillRect(u.x, u.y, u.largeur, u.hauteur);
		}
		
		// Dessin des individus 
		if (Fen.simulationReady) {
			g.setColor(Color.YELLOW);
			int nbIndividus = data.get(niveau).get(time).size();
			for (int i = 0 ; i < nbIndividus ; i++) {
				g.fillOval(data.get(niveau).get(time).get(i).get(0), data.get(niveau).get(time).get(i).get(1), 8, 8);
			}
		}
		
		// Dessin des issues 
		g.setColor(Color.GRAY);
		Deque <Issues> issues = e.issues;
		for (Issues l : issues) {
			g.fillRect(l.x, l.y, l.largeur, l.hauteur);
		}
		
		if (Fen.simulationReady) {
			Fen.setTime(time+Fen.dtime);
			if (Fen.time > data.get(0).size()-1) {
				Fen.setTime(0);
			}
		}
		}
	
	
}
