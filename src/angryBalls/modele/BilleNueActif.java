 package angryBalls.modele;

import mesmaths.geometrie.base.Vecteur;
import angryBalls.modele.visitor.BilleDessin;
import angryBalls.modele.visitor.BilleDispatche;

public class BilleNueActif extends BilleNuePassive implements BilleDispatche {

	private Vecteur positionPrecedente;
	
	public BilleNueActif(Vecteur position, double rayon, Vecteur vitesse,
			String couleur) {
		super(position, rayon, vitesse, couleur);
		this.positionPrecedente = null;
	}
	
	public Vecteur getPositionPrecedente() {
		return this.positionPrecedente;
	}
	
	public void setPositionPrecedente(Vecteur positionP) {
		this.positionPrecedente = positionP;
	}
	
	@Override
	public String toString() {
		return "Bille en Active Rendering: " + super.toString();
	}
	
	@Override
	public void accepte(BilleDessin billeVisiteur) {
		billeVisiteur.dessiner(this);
	}

}
