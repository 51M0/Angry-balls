package angryBalls.test;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import angryBalls.controleur.AnimationBilles;
import angryBalls.modele.Bille;
import angryBalls.modele.BilleNueActif;
import angryBalls.modele.decorateuracceleration.DecoFrottement;
import angryBalls.modele.decorateuracceleration.DecoNewton;
import angryBalls.modele.decorateuracceleration.DecoPesanteur;
import angryBalls.modele.decorateurcollision.DecoArret;
import angryBalls.modele.decorateurcollision.DecoRebond;
import angryBalls.modele.decorateurcollision.DecoTraverse;
import angryBalls.son.JouerSonCollision;
import angryBalls.vues.CadreAngryBalls;
import angryBalls.vues.rendring.VueActif;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement diff�rent
 * 
 * Id�al pour mettre en place le DP decorator
 * */
public class TestAngryBalls { 
	
	public static void main(String[] args) {
		//------------------- cr�ation de la liste (pour l'instant vide) des billes -----------------------
		
		Vector<Bille> billes = new Vector<Bille>();
		
		//---------------- cr�ation de la vue responsable du dessin des billes -------------------------
		
		CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
		                                        "KEROUAD + LMOUTASSIME.",
		                                        billes, new VueActif(billes));
		
		cadre.montrer(); // on rend visible la vue
		
		//------------- remplissage de la liste avec 5 billes -------------------------------
		
		
		
		double xMax, yMax;
		double vMax = 0.1;
		xMax = cadre.largeurBillard();      // abscisse maximal
		yMax = cadre.hauteurBillard();      // ordonn�e maximale
		
		double rayon = 0.06*Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le m�me rayon, mais ce n'est pas obligatoire
		
		Vecteur p0, p1, p2, p3, p4,  v0, v1, v2, v3, v4;    // les positions des centres des billes et les vecteurs vitesse au d�marrage. 
		                                                    // Elles vont �tre choisies al�atoirement
		
		//------------------- cr�ation des vecteurs position des billes ---------------------------------
		
		p0 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
		p1 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
		p2 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
		p3 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
		p4 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
		
		//------------------- cr�ation des vecteurs vitesse des billes ---------------------------------
		
		v0 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
		v1 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, 0);
		v2 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
		v3 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
		v4 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
		
		//--------------- ici commence la partie � changer ---------------------------------
				
		//billes.add(new      BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0,0.001), Color.yellow));
		billes.add(
				new DecoRebond(
						new DecoFrottement(
				new DecoPesanteur(
				
				new BilleNueActif(p1, rayon, v1, "yellow")
				, new Vecteur(0, 0.001)))));
		
		//billes.add(new         BilleMvtRURebond(p0, rayon, v0, Color.red));
		billes.add(
				new DecoRebond(
				new BilleNueActif(p0, rayon, v0, "red")
				));
		
		//billes.add(new              BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
		billes.add(
				new DecoRebond(
				new DecoFrottement(
				new DecoNewton(
				new BilleNueActif(p2, rayon, v2, "green")
				))));
		
		//billes.add(new              BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));
		billes.add(
				new DecoTraverse(
				new BilleNueActif(p3, rayon, v3, "cyan")
				));
		
		//billes.add(new BilleMvtNewtonArret(p4, rayon, v4,  Color.black));
		billes.add(
				new DecoNewton(
				new DecoArret(
				new BilleNueActif(p4, rayon, v4, "black")
				)));
		
		//----------------------- Ajout du son lors de collisions ----------------------------------------------------------------
		
		for(Bille bille: billes)
			bille.addObserver(new JouerSonCollision());
		
		//---------------------- ici finit la partie � changer -------------------------------------------------------------------
				
		System.out.println("billes = " + billes);
		
		//-------------------- cr�ation de l'objet responsable de l'animation (c'est un thread s�par�) ---------------------------
		
		new AnimationBilles(billes, cadre);
	
	}
}
