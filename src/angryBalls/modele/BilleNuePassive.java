package angryBalls.modele;

import java.util.Observable;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import angryBalls.modele.visitor.BilleDessin;
import angryBalls.modele.visitor.BilleDispatche;

public class BilleNuePassive extends Observable implements Bille,BilleDispatche {
	
	protected Vecteur positionActuelle; // centre de la bille
	protected double rayon; // rayon > 0
	protected Vecteur vitesse;
	protected Vecteur accélération;
	protected int clef; // identifiant unique de cette bille
	protected String couleur;
	protected static int prochaineClef = 0;
	protected static double ro = 1; // masse volumique

	/**
	 * @param centre
	 * @param rayon
	 * @param vitesse
	 * @param accélération
	 * @param couleur
	 */
	private BilleNuePassive(Vecteur centre, double rayon, Vecteur vitesse, Vecteur accélération, String couleur) {
		this.positionActuelle = centre;
		this.rayon = rayon;
		this.vitesse = vitesse;
		this.accélération = accélération;
		this.couleur = couleur;
		this.clef = BilleNuePassive.prochaineClef++;
	}

	/**
	 * @param position
	 * @param rayon
	 * @param vitesse
	 * @param couleur
	 */
	public BilleNuePassive(Vecteur position, double rayon, Vecteur vitesse, String couleur) {
		this(position, rayon, vitesse, new Vecteur(), couleur);
	}

	@Override
	public Vecteur getPositionActuelle() {
		return this.positionActuelle;
	}
	
	@Override
	public double getRayon() {
		return this.rayon;
	}

	@Override
	public Vecteur getVitesse() {
		return this.vitesse;
	}

	@Override
	public Vecteur getAccélération() {
		return this.accélération;
	}

	@Override
	public int getClef() {
		return this.clef;
	}

	@Override
	public String getCouleur() {
		return this.couleur;
	}

	@Override
	public double masse() {
		return BilleNuePassive.ro * Geop.volumeSphère(this.getRayon());
	}
	
	@Override
	public void déplacer(double deltaT) {
		Cinematique.mouvementUniformémentAccéléré(this.getPositionActuelle(), this.getVitesse(), this.getAccélération(), deltaT);
	}
	
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes){
		if (OutilsBille.gestionCollisionBilleBille(this, billes)) {
			this.setChanged();
			this.notifyObservers();
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "centre = " + this.getPositionActuelle() + " rayon = " + this.getRayon() + " vitesse = " + this.getVitesse() + " accélération = " + this.getAccélération() + " couleur = " + this.getCouleur() + "clef = "
				+ this.getClef();
	}
		
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {	
		this.getAccélération().set(Vecteur.VECTEURNUL);
	}

	@Override
	public void accepte(BilleDessin billeVisiteur) {
		billeVisiteur.dessiner(this);
	}

	@Override
	public Vecteur getPositionPrecedente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPositionPrecedente(Vecteur positionP) {
		// TODO Auto-generated method stub
		
	}
	
}