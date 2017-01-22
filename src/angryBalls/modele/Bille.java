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
	 * @return the acc�l�ration
	 */
	abstract Vecteur getAcc�l�ration();

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
	 * mise � jour de position et vitesse � t+deltaT � partir de position et vitesse � l'instant t
	 * 
	 * modifie le vecteur position et le vecteur vitesse
	 * 
	 * laisse le vecteur acc�l�ration intact
	 * 
	 * La bille subit par d�faut un mouvement uniform�ment acc�l�r�
	 * */
	abstract void d�placer(double deltaT);

	/**
	 * calcul (c-�-d mise � jour) �ventuel du vecteur acc�l�ration. billes est la liste de toutes les billes en mouvement Cette m�thode peut avoir besoin de
	 * "billes" si this subit l'attraction gravitationnelle des autres billes La nature du calcul du vecteur acc�l�ration de la bille est d�finie dans les
	 * classes d�riv�es A ce niveau le vecteur acc�l�ration est mis � z�ro (c'est � dire pas d'acc�l�ration)
	 * */
	abstract void gestionAcc�l�ration(Vector<Bille> billes);

	/**
	 * gestion de l'�ventuelle collision de cette bille avec les autres billes
	 * 
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par d�faut est le choc parfaitement �lastique (c-�-d rebond sans amortissement)
	 * 
	 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliqu�es dans le choc sont modifi�es si renvoie false,
	 *         il n'y a pas de collision et les billes sont laiss�es intactes
	 * */
	abstract boolean gestionCollisionBilleBille(Vector<Bille> billes);

	/**
	 * gestion de l'�ventuelle collision de la bille (this) avec le contour rectangulaire de l'�cran d�fini par (abscisseCoinHautGauche, ordonn�eCoinHautGauche,
	 * largeur, hauteur)
	 * 
	 * d�tecte si il y a collision et le cas �ch�ant met � jour position et vitesse
	 * 
	 * La nature du comportement de la bille en r�ponse � cette collision est d�finie dans les classes d�riv�es
	 * */
	abstract void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur);

	abstract String toString();
	
	void addObserver(Observer observer);
	
}
