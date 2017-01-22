package angryBalls.modele.decorateuracceleration;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import angryBalls.modele.Bille;

public class DecoPesanteur extends DecorationAbstraiteBilleAcceleration {

	protected Vecteur pesanteur;

	public DecoPesanteur(Bille billeDecoree, Vecteur pesanteur) {
		super(billeDecoree);
		this.pesanteur = pesanteur;
	}

	@Override
	protected void decorationDeGestionAcceleration(Vector<Bille> billes) {
		this.getAccélération().ajoute(this.pesanteur); // contribution du champ de pesanteur (par exemple)
	}

}