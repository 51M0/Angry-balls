package angryBalls.modele;

import java.util.Observable;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public class BilleRectiligne extends Observable implements Bille {
	
	protected Vecteur positionActuelle, positionPrecedente; // centre de la bille
	protected double rayon; // rayon > 0
	protected Vecteur vitesse;
	protected Vecteur acc�l�ration;
	protected int clef; // identifiant unique de cette bille
	protected String couleur;
	protected static int prochaineClef = 0;
	protected static double ro = 1; // masse volumique

	/**
	 * @param centre
	 * @param rayon
	 * @param vitesse
	 * @param acc�l�ration
	 * @param couleur
	 */
	private BilleRectiligne(Vecteur centre, double rayon, Vecteur vitesse, Vecteur acc�l�ration, String couleur) {
		this.positionActuelle = centre;
		this.positionPrecedente = null;
		this.rayon = rayon;
		this.vitesse = vitesse;
		this.acc�l�ration = acc�l�ration;
		this.couleur = couleur;
		this.clef = BilleRectiligne.prochaineClef++;
	}

	/**
	 * @param position
	 * @param rayon
	 * @param vitesse
	 * @param couleur
	 */
	public BilleRectiligne(Vecteur position, double rayon, Vecteur vitesse, String couleur) {
		this(position, rayon, vitesse, new Vecteur(), couleur);
	}

	@Override
	public Vecteur getPositionActuelle() {
		return this.positionActuelle;
	}
	
	@Override
	public Vecteur getPositionPrecedente() {
		return this.positionPrecedente;
	}
	
	@Override
	public void setPositionPrecedente(Vecteur positionP) {
		this.positionPrecedente = positionP;
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
	public Vecteur getAcc�l�ration() {
		return this.acc�l�ration;
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
		return BilleRectiligne.ro * Geop.volumeSph�re(this.getRayon());
	}
	
	@Override
	public void d�placer(double deltaT) {
		Cinematique.mouvementUniform�mentAcc�l�r�(this.getPositionActuelle(), this.getVitesse(), this.getAcc�l�ration(), deltaT);
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
		return "centre = " + this.getPositionActuelle() + " rayon = " + this.getRayon() + " vitesse = " + this.getVitesse() + " acc�l�ration = " + this.getAcc�l�ration() + " couleur = " + this.getCouleur() + "clef = "
				+ this.getClef();
	}
		
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {	
		this.getAcc�l�ration().set(Vecteur.VECTEURNUL);
	}
	
}
