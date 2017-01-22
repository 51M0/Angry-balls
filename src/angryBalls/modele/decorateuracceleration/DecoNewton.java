package angryBalls.modele.decorateuracceleration;

import java.util.Vector;

import angryBalls.modele.Bille;
import angryBalls.modele.OutilsBille;

public class DecoNewton extends DecorationAbstraiteBilleAcceleration {

	public DecoNewton(Bille billeDecoree) {
		super(billeDecoree);
	}

	@Override
	protected void decorationDeGestionAcceleration(Vector<Bille> billes) {
		this.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this, billes)); // contribution de l'accélération due à l'attraction des autres		
	}
	
}