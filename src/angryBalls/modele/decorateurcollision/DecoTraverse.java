package angryBalls.modele.decorateurcollision;

import mesmaths.cinematique.Collisions;
import angryBalls.modele.Bille;

public class DecoTraverse extends DecorationAbstraiteBilleCollision {

	public DecoTraverse(Bille billeDecoree) {
		super(billeDecoree);
	}

	@Override
	protected void decorationDeCollisionContour(double abscisseCoinHautGauche,
			double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourPasseMuraille( this.getPositionActuelle(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);		
	}

}