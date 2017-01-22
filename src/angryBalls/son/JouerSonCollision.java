package angryBalls.son;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Observable;
import java.util.Observer;

public class JouerSonCollision implements Observer {

	private AudioClip audioClip;
	private static String CHEMIN = "BallCollision1.wav"; 
	
	public JouerSonCollision() {
		try {
			audioClip = Applet.newAudioClip(new File(CHEMIN).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}	

	public void jouer() {
		audioClip.play();
	}

	@Override
	public void update(Observable o, Object arg) {
		this.jouer();
	}
	
}