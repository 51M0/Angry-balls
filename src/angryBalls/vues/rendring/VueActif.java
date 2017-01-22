package angryBalls.vues.rendring;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import angryBalls.modele.Bille;
import angryBalls.vues.Billard;
import angryBalls.vues.outilsVues.Outils;

public class VueActif extends Billard {

	
	public VueActif(Vector<Bille> billes) {
		super(billes);
		this.setIgnoreRepaint(true);
		createBufferStrategy(1);
	}

	@Override
	public void paint() {
		BufferStrategy strategy = this.getBufferStrategy();
		Graphics g = strategy.getDrawGraphics();

		for (int i = 0; i < this.billes.size(); ++i) {
			if (i == 0)
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			if (billes.get(i).getPositionPrecedente() != null)
				this.dessine(g, billes.get(i), billes.get(i)
						.getPositionPrecedente(), Color.WHITE, Color.WHITE);
			this.dessine(g, billes.get(i), billes.get(i).getPositionActuelle(),
					Outils.getCouleur(billes.get(i).getCouleur()), Color.CYAN);

			this.billes.get(i).setPositionPrecedente(
					new Vecteur(this.billes.get(i).getPositionActuelle().x,
							this.billes.get(i).getPositionActuelle().y));
		}

		strategy.show();
	}
	
}
