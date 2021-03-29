package finale;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * <b> ChoixEtage est la classe où l'on demande a l'utilisateur son nombre d'etage.</b>
 * <p>
 * Un Choix d'etage est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un menu deroulant.</li>
 * <li>Un JPanel composant.</li>\
 * </ul>
 * </p>
 * 
 * @author Charles
 *
 */
public class ChoixEtage {
	/**
	 * Le menu deroulant 
	 */
    public JComboBox floorList;
    /**
	 * Le Panel des boutons 
	 */
    public JPanel buttons;
    /**
	 * Le Panel du choix 
	 */
    public JPanel choix_boutons;
    /**
	 * Le Panel generale
	 */
    JPanel finale = new JPanel();
    JPanel gene2 = new JPanel();
    /**
	 * un index pour chaque etage
	 */
    int index = 1;
    /**
	 * Le retour fenetre principale
	 * 
	 * @see FenetrePrincipale()
	 */
    FenetrePrincipale Fen;
    /**
	 * un getter d'etage
	 */
    ChoixEtage me = this;
    /**
	 * Constructeur ChoixEtage.
	 * <p>
	 * On choisi le nomnre d'etage ainsi que leur parametrage 
	 * et leur affichage
	 * </p>
	 * 
	 * @param Fen  		La fenetre ou retourner le Jpanel
	 * 
	 * @see ChoixEtage#ChoixEtage()
	 */
    public ChoixEtage(FenetrePrincipale Fen) {
    	this.Fen = Fen;
        gene2.setLayout(new GridLayout(1,2));
        String[] floorStrings = {"Nombre d'etages", "1 Etage", "2 Etages", "3 Etages", "4 Etages", "5 Etages", "6 Etages"};
        floorList = new JComboBox(floorStrings);
        JButton go = new JButton("Go");
        ActionListener listenerA = new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	int i = 0;
            	ArrayList<JButton> liste_bouton_para = new ArrayList<>();
            	ArrayList<JButton> liste_bouton_affi = new ArrayList<>();
                int count = floorList.getSelectedIndex();
                getFen().getPara().nbEtages = count+1;
                buttons.removeAll(); 
                	for ( me.index =1; me.index < count+1; IncrementIndex()) {
	                	i++;
	                	JButton bouton_et = new JButton("Parametrer etage " + String.valueOf(me.index));
	                	JButton bouton_et2 = new JButton("Afficher etage " + String.valueOf(me.index));
	                	JPanel boutons_para = new JPanel();
	                	JPanel boutons_affi = new JPanel();
	                	liste_bouton_para.add(bouton_et);
	                	liste_bouton_affi.add(bouton_et2);
	                	boutons_affi.add(liste_bouton_affi.get(me.index-1));
		                liste_bouton_affi.get(me.index-1).addActionListener(new ShowEtage(me,i));
		            	liste_bouton_para.get(me.index-1).addActionListener(new FenetreParaEtage(me, i));
		            	boutons_para.add(liste_bouton_para.get(me.index-1));
		                buttons.add(boutons_para);
		               	buttons.add(boutons_affi);
                    }
                buttons.revalidate();
            }          
        };
        go.addActionListener(listenerA);    
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        top.add(floorList);
        top.add(go);
 	    // Le bouton du RDC 
 	    PanelRDC pan_bouton_RDC = new PanelRDC(this);
 	    pan_bouton_RDC.GUI_RDC();
        buttons = new JPanel();
        buttons.setLayout(new GridLayout (index-1 ,2));
        buttons.setPreferredSize(new Dimension(340, 400));
        JPanel gene = new JPanel();
        gene.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints(); //L'objet servant à positionner les composants  
     // On positionne le bouton rdc
	    gbc1.gridx = 0;
	    gbc1.gridy = 1;
	    gbc1.gridheight = 1;
	    gbc1.gridwidth = 1; 
	    gene.add(pan_bouton_RDC.GUI_RDCs(), gbc1);
	   
      //On positionne la case de départ du composant top
	    gbc1.gridx = 0;
	    gbc1.gridy = 0;
	    //La taille en hauteur et en largeur
	    gbc1.gridheight = 1;
	    gbc1.gridwidth = 1;
	    gene.add(top, gbc1);
	    
	 // On positionne les boutons a display 
	    gbc1.gridx = 0;
	    gbc1.gridy = 2;
	    gbc1.gridheight = 15;
	    gbc1.gridwidth = 1; 
	    gbc1.fill = GridBagConstraints.VERTICAL;
	    gene.add(buttons,gbc1);
	    gene.setPreferredSize(new Dimension(340,400)); 
        finale.add(gene);
        finale.setPreferredSize(new Dimension(340,400));
    }
    /**
	 * Le retour d'indice
	 * 
	 * @see FenetrePrincipale()
	 */
    public void IncrementIndex () {
    	this.index = this.index+1 ;	
    }
    /**
	 * Le retour fenetre principale
	 * 
	 * @see FenetrePrincipale()
	 */     
    public FenetrePrincipale getFen() {
    	return this.Fen;
    }
    /**
	 * Le retour vers fenetre principale du JPanel avec le menu deroulant
	 * 
	 * @see ChoixEtages
	 */
    public JPanel get_Jpan_instructions_etages() {
    	return finale;
    }
}
