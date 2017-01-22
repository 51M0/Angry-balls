package angryBalls.modele.decorateurcollision;

import mesmaths.cinematique.Collisions;
import angryBalls.modele.Bille;

public class DecoRebond extends DecorationAbstraiteBilleCollision {

	public DecoRebond(Bille billeDecoree) {
		super(billeDecoree);
	}

	@Override
	protected void decorationDeCollisionContour(double abscisseCoinHautGauche,
			double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond( this.getPositionActuelle(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}
	
}