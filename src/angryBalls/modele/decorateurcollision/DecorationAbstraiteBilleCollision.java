package angryBalls.modele.decorateurcollision;

import java.util.Vector;

import angryBalls.modele.Bille;
import angryBalls.modele.DecoratteurBille;

public abstract class DecorationAbstraiteBilleCollision extends DecoratteurBille {

	
	public DecorationAbstraiteBilleCollision(Bille billeDecoree) {
		super(billeDecoree);
	}

	@Override
	protected final void decorationDeGestionAcceleration(Vector<Bille> billes) {
	}

}