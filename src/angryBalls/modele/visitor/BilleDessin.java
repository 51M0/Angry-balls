package angryBalls.modele.visitor;

import angryBalls.modele.BilleNueActif;
import angryBalls.modele.BilleNuePassive;

public interface BilleDessin {

	void dessiner(BilleNuePassive bille);
	void dessiner(BilleNueActif bille);
	
}
