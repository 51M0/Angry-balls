package angryBalls.controleur;

import java.util.Observable;
import java.util.Observer;

import angryBalls.controleur.interfaces.ResponsableAnimation;

public class EcouteurAnimation extends Observable {
	
	protected ResponsableAnimation ra;

	public EcouteurAnimation(ResponsableAnimation ra, Observer observeur) {
		this.ra = ra;
		this.addObserver(observeur);
	}
	
}
