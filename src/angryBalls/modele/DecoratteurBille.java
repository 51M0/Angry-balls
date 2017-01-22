package angryBalls.modele;

import java.util.Observer;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public abstract class DecoratteurBille implements Bille {
	
	protected Bille billeDecoree;
	
	public DecoratteurBille(Bille billeDecoree) {
		this.billeDecoree = billeDecoree;
	}

	@Override
	public Vecteur getPositionActuelle() {
		return this.billeDecoree.getPositionActuelle();
	}
	
	@Override
	public Vecteur getPositionPrecedente() {
		return this.billeDecoree.getPositionPrecedente();
	}
	
	@Override
	public void setPositionPrecedente(Vecteur positionP) {
		this.billeDecoree.setPositionPrecedente(positionP);
	}

	@Override
	public double getRayon() {
		return this.billeDecoree.getRayon();
	}

	@Override
	public Vecteur getVitesse() {
		return this.billeDecoree.getVitesse();
	}

	@Override
	public Vecteur getAcc�l�ration() {
		return this.billeDecoree.getAcc�l�ration();
	}

	@Override
	public int getClef() {
		return this.billeDecoree.getClef();
	}

	@Override
	public String getCouleur() {
		return this.billeDecoree.getCouleur();
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeDecoree.gestionAcc�l�ration(billes);
		this.decorationDeGestionAcceleration(billes);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		this.billeDecoree.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
		this.decorationDeCollisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}
	
	protected abstract void decorationDeGestionAcceleration(Vector<Bille> billes);
	protected abstract void decorationDeCollisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur);

	@Override
	public double masse() {
		return this.billeDecoree.masse();
	}

	@Override
	public void d�placer(double deltaT) {
		this.billeDecoree.d�placer(deltaT);
	}
	
	@Override
	public String toString() {
		return this.billeDecoree.toString();
	}

	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return this.billeDecoree.gestionCollisionBilleBille(billes);
	}

	@Override
	public void addObserver(Observer observer) {
		this.billeDecoree.addObserver(observer);
	}

}
