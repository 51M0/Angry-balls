package angryBalls.controleur.cadre;

import angryBalls.controleur.interfaces.Animation;
import angryBalls.controleur.interfaces.ResponsableAnimation;

public class EcouteurBoutonLancer implements ResponsableAnimation {

	@Override
	public void action(Animation animation) {
		animation.lancerAnimation();
	}

}
