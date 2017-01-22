package angryBalls.modele.decorateuracceleration;

import angryBalls.modele.Bille;
import angryBalls.modele.DecoratteurBille;

public abstract class DecorationAbstraiteBilleAcceleration extends DecoratteurBille {

	public DecorationAbstraiteBilleAcceleration(Bille billeDecoree) {
		super(billeDecoree);
	}

	@Override
	protected final void decorationDeCollisionContour(double abscisseCoinHautGauche,
			double ordonn�eCoinHautGauche, double largeur, double hauteur) {		
	}

}