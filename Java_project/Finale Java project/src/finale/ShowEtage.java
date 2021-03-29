package finale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * <b> ShowEtage est la classe où l'on Choisi l'etage a afficher/parametrer</b>
 * <p>
 * La classe est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un int pour l'indice de l'etage</li>
 * </ul>
 * </p>
 * 
 * @author Charles
 *
 */
public class ShowEtage implements ActionListener {
	/**
	 * La fenetre principale de retour de notre information
	 * 
	 * @see ShowEtage#choix
	 */
	ChoixEtage choix;
	/**
	 * Le int de l'etage 
	 * 
	 * @see ShowEtage#i
	 */
	int i;
	/**
	 * Constructeur ShowEtage
	 * <p>
	 * On applique un etage a un indice correspondant 
	 * </p>
	 * 
	 * @param choix   		L'etage en question.
	 * @param i   		L'indice Etage.
	 * 
	 * 
	 * @see ShowEtage#choix
	 * @see ShowEtage#i
	 */
	public ShowEtage(ChoixEtage choix, int i) {
		this.choix = choix;
		this.i = i;
	}
	/**
	 * Le getter de retour de notre information
	 * 
	 * @see ShowEtage#choix
	 */
	public ChoixEtage getChoixEtage() {
		return this.choix;
	}
	/**
	 * Le actionPerformed de la classe 
	 */
	public void actionPerformed(ActionEvent arg0) {		
		choix.getFen().stageToObserve = i;
	}
}
