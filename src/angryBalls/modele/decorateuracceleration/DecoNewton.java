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
		this.getAcc�l�ration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes)); // contribution de l'acc�l�ration due � l'attraction des autres		
	}
	
}