package angryBalls.vues;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import angryBalls.modele.Bille;

/**
 * responsable du dessin des billes
 * 
 * ICI : IL N'Y A RIEN A CHANGER
 * 
 * 
 * */

public abstract class Billard extends Canvas{

	protected Vector<Bille> billes;

	public Billard(Vector<Bille> billes) {
		this.billes = billes;
	}
	
	protected void dessine(Graphics g, Bille bille, Vecteur position,
			Color couleurBille, Color couleurContour) {
		int width, height;
		int xMin, yMin;

		xMin = (int) Math.round(position.x - bille.getRayon());
		yMin = (int) Math.round(position.y - bille.getRayon());

		width = height = 2 * (int) Math.round(bille.getRayon());

		g.setColor(couleurBille);
		g.fillOval(xMin, yMin, width, height);
		g.setColor(couleurContour);
		g.drawOval(xMin, yMin, width, height);
	}
	
	public abstract void paint();
	
}
