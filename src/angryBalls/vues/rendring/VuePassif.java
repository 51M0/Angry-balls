package angryBalls.vues.rendring;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import angryBalls.modele.Bille;
import angryBalls.vues.Billard;
import angryBalls.vues.outilsVues.Outils;

public class VuePassif extends Billard {

	private static final long serialVersionUID = -5953322272125229991L;

	public VuePassif(Vector<Bille> billes) {
		super(billes);
	}

	@Override
	public void paint() {
		this.repaint();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		int i;
		
		for (i = 0; i < this.billes.size(); ++i)
			this.dessine(g, billes.get(i), billes.get(i).getPositionActuelle(),
					Outils.getCouleur(billes.get(i).getCouleur()), Color.CYAN);
	}
	
}
