package angryBalls.controleur.cadre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JButton;

import angryBalls.controleur.EcouteurAnimation;
import angryBalls.controleur.interfaces.ResponsableAnimation;


public class EcouteurAnimationBouton extends EcouteurAnimation implements ActionListener {
	
	public EcouteurAnimationBouton(ResponsableAnimation ra, Observer observeur, JButton bouton) {
		super(ra, observeur);
		bouton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setChanged();
		this.notifyObservers(ra);
	}
	
}
