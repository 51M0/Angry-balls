package angryBalls.vues.outilsVues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.lang.reflect.Field;

/**
 * Quelques outils pratiques dans des applis GUI
 * */
public class Outils {

	/**
	 * 
	 * place frame et calcule sa taille en fonction des dimensions de l'écran.
	 * Soient L et H respectivement la largeur et la hauteur de l'écran
	 * 
	 * Alors place l'origine de frame en (Ox*L,Oy*H) et la largeur de frame sera
	 * L*largeur et la hauteur de frame sera H*hauteur
	 * 
	 * 
	 * */
	public static void place(Frame frame, double largeur, double hauteur) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		Dimension screenSize = toolkit.getScreenSize();

		frame.setSize((int) (screenSize.width * largeur), (int) (screenSize.height * hauteur));
		frame.setLocationRelativeTo(null);
	}
	
	
	public static Color getCouleur(String value) {
		if (value == null) {
			return Color.BLACK;
		}
		try {
			Field f = Color.class.getField(value);
			return (Color) f.get(null);
		} catch (Exception ce) {
			return Color.BLACK;
		}
	}

}
