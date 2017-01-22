package angryBalls.modele.decorateurcollision;

import mesmaths.cinematique.Collisions;
import angryBalls.modele.Bille;

public class DecoArret extends DecorationAbstraiteBilleCollision {

	public DecoArret(Bille billeDecoree) {
		super(billeDecoree);
	}

	@Override
	protected void decorationDeCollisionContour(double abscisseCoinHautGauche,
			double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecArretHorizontal(this.getPositionActuelle(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.getPositionActuelle(), this.getRayon(), this.getVitesse(), ordonnéeCoinHautGauche, hauteur);
	}

}