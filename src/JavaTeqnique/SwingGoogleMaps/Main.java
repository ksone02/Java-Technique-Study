package JavaTeqnique.SwingGoogleMaps;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame{
	
	private GoogleAPI googleAPI = new GoogleAPI();
	private String location = "¼­¿ï";
	private JLabel googleMap;

	public Main() {
		googleAPI.downloadMap(location);
		googleMap = new JLabel(googleAPI.getMap(location));
		googleAPI.fileDelete(location);
		add(googleMap);
		
		setTitle("Google Maps");
		setVisible(true);
		pack();
	}

}
