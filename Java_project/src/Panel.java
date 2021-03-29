package imports_prog;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Deque;

import javax.swing.JPanel;

public class Panel extends JPanel{
	Modele m;
	Simulation simu;
	
	public void paintComponent(Graphics g) {
		System.out.println("PLAY");
		m = new Modele(4, 2 , this);
		simu = new Simulation(m);
		System.out.println(simu);
		System.out.println(simu.simulation.get(0));
		int niveau_a_representer = 0;
		Etages show_etage;
		show_etage = RecupEtage(niveau_a_representer);
		
		//FOND
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//OBSTACLES
		g.setColor(Color.CYAN);
		Deque<Obstacles> obstacles = show_etage.getObstacles();
		for(Obstacles o : obstacles) {
			g.fillRect(o.getx(), o.gety(), o.getLargeur(), o.getHauteur());
		}
		//ESCALIERS
		g.setColor(Color.RED);
		Deque<Escaliers> escalier = show_etage.getEscaliers();
		for(Escaliers e : escalier) {
			g.fillRect(e.getX(), e.getY(), e.getLargeur(), e.getHauteur());
		}
		
		//INDIVIDUS
		
		g.setColor(Color.YELLOW);
		Deque<Individus> individus = show_etage.individus_in_etage;
		for(Individus i : individus) {
			g.fillOval((int)i.getX(), (int)i.getY(), (int)i.getTaille(), (int)i.getTaille());
		}
		
		//ISSUES
		g.setColor(Color.GREEN);
		Deque<Issues> issues = show_etage.issues;
		for(Issues s : issues){
			g.fillRect(s.x, s.y, s.largeur, s.hauteur);
		}
		
		System.out.println("STOP");
	}
	public Etages RecupEtage(int niveau) {
		Etages result = m.getEtages().getFirst();
		for(Etages e : m.getEtages()) {
			if(e.niveau == niveau) {
				result = e;
			} 
		}
		return result;
	}
}


