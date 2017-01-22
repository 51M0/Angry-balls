package angryBalls.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import angryBalls.controleur.cadre.EcouteurAnimationBouton;
import angryBalls.controleur.cadre.EcouteurBoutonArreter;
import angryBalls.controleur.cadre.EcouteurBoutonLancer;
import angryBalls.controleur.interfaces.Animation;
import angryBalls.modele.Bille;
import angryBalls.vues.outilsVues.Outils;

/**
 * Vue dessinant les billes et contenant les 3 boutons de contrôle (arrêt du
 * programme, lancer les billes, arréter les billes)
 * 
 * ICI : IL N'Y A RIEN A CHANGER
 * 
 * 
 * */

@SuppressWarnings("serial")
public class CadreAngryBalls extends JFrame implements VueBillard {

	JTextField présentation;
	Billard billard;
	public JButton lancerBilles, arreterBilles;
	JPanel haut, centre, bas;

	public CadreAngryBalls(String titre, String message, Vector<Bille> billes, Billard billard) {
		super(titre);

		Outils.place(this, 0.8, 0.6);

		this.haut = new JPanel();
		this.haut.setBackground(Color.LIGHT_GRAY);
		this.add(this.haut, BorderLayout.NORTH);

		this.centre = new JPanel();
		this.add(this.centre, BorderLayout.CENTER);

		this.bas = new JPanel();
		this.bas.setBackground(Color.LIGHT_GRAY);
		this.add(this.bas, BorderLayout.SOUTH);

		this.présentation = new JTextField(message, 100);
		this.présentation.setEditable(false);
		this.présentation.setHorizontalAlignment(JTextField.CENTER);
		this.haut.add(this.présentation);

		this.billard = billard;
		this.add(this.billard);

		this.lancerBilles = new JButton("lancer les billes");
		this.bas.add(this.lancerBilles);
		this.arreterBilles = new JButton("arrêter les billes");
		this.bas.add(this.arreterBilles);

		this.getContentPane().setBackground(Color.WHITE);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public double largeurBillard() {
		return this.billard.getWidth();

	}

	public double hauteurBillard() {
		return this.billard.getHeight();
	}

	@Override
	public void miseAJour() {
		this.billard.paint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exodecorateur.vues.VueBillard#montrer()
	 */
	@Override
	public void montrer() {
		this.setVisible(true);
	}

	@Override
	public void ajoutCapaciteLancementAnimation(Animation animation) {
		new EcouteurAnimationBouton(new EcouteurBoutonLancer(), animation, lancerBilles);
	}

	@Override
	public void ajoutCapaciteArretAnimation(Animation animation) {
		new EcouteurAnimationBouton(new EcouteurBoutonArreter(), animation, arreterBilles);		
	}
	
}