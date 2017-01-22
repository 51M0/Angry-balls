package angryBalls.modele;

import java.util.Observer;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public interface Bille {

	/**
	 * @return the position
	 */
	abstract Vecteur getPositionActuelle();
	abstract Vecteur getPositionPrecedente();
	
	/**
	 * 
	 * @param positionP: new position
	 */
	abstract void setPositionPrecedente(Vecteur positionP);

	/**
	 * @return the rayon
	 */
	abstract double getRayon();

	/**
	 * @return the vitesse
	 */
	abstract Vecteur getVitesse();

	/**
	 * @return the accélération
	 */
	abstract Vecteur getAccélération();

	/**
	 * @return the clef
	 */
	abstract int getClef();
	
	/**
	 * @return the couleur
	 */
	abstract String getCouleur();	
	

	abstract double masse();

	/**
	 * mise à jour de position et vitesse à t+deltaT à partir de position et vitesse à l'instant t
	 * 
	 * modifie le vecteur position et le vecteur vitesse
	 * 
	 * laisse le vecteur accélération intact
	 * 
	 * La bille subit par défaut un mouvement uniformément accéléré
	 * */
	abstract void déplacer(double deltaT);

	/**
	 * calcul (c-à-d mise à jour) éventuel du vecteur accélération. billes est la liste de toutes les billes en mouvement Cette méthode peut avoir besoin de
	 * "billes" si this subit l'attraction gravitationnelle des autres billes La nature du calcul du vecteur accélération de la bille est définie dans les
	 * classes dérivées A ce niveau le vecteur accélération est mis à zéro (c'est à dire pas d'accélération)
	 * */
	abstract void gestionAccélération(Vector<Bille> billes);

	/**
	 * gestion de l'éventuelle collision de cette bille avec les autres billes
	 * 
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par défaut est le choc parfaitement élastique (c-à-d rebond sans amortissement)
	 * 
	 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquées dans le choc sont modifiées si renvoie false,
	 *         il n'y a pas de collision et les billes sont laissées intactes
	 * */
	abstract boolean gestionCollisionBilleBille(Vector<Bille> billes);

	/**
	 * gestion de l'éventuelle collision de la bille (this) avec le contour rectangulaire de l'écran défini par (abscisseCoinHautGauche, ordonnéeCoinHautGauche,
	 * largeur, hauteur)
	 * 
	 * détecte si il y a collision et le cas échéant met à jour position et vitesse
	 * 
	 * La nature du comportement de la bille en réponse à cette collision est définie dans les classes dérivées
	 * */
	abstract void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur);

	abstract String toString();
	
	void addObserver(Observer observer);
	
}
