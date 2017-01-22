package angryBalls.modele.decorateuracceleration;

import java.util.Vector;

import mesmaths.mecanique.MecaniquePoint;
import angryBalls.modele.Bille;

public class DecoFrottement extends DecorationAbstraiteBilleAcceleration {

	public DecoFrottement(Bille billeDecoree) {
		super(billeDecoree);
	}

	@Override
	protected void decorationDeGestionAcceleration(Vector<Bille> billes) {
		this.getAccélération().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution de l'accélération due au frottement																										// dans l'air
	}
	
}