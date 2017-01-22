package angryBalls.modele.decorateurcollision;

import mesmaths.cinematique.Collisions;
import angryBalls.modele.Bille;

public class DecoRebond extends DecorationAbstraiteBilleCollision {

	public DecoRebond(Bille billeDecoree) {
		super(billeDecoree);
	}

	@Override
	protected void decorationDeCollisionContour(double abscisseCoinHautGauche,
			double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond( this.getPositionActuelle(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
	
}