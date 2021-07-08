package JavaTeqnique.UseJxBrowser;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.navigation.Navigation;
import com.teamdev.jxbrowser.view.swing.BrowserView;


public final class Main extends JFrame {
	
	private Browser browser;
	private BrowserView view;
	private Navigation nav;
	
	private JTextField textField = new JTextField(30);
	private JButton button = new JButton("°Ë»ö");
	private JPanel panel = new JPanel();
	
	public class Event implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			setURL(textField.getText());
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
	public void setURL(String URL) {
		nav.loadUrl(URL);
	}
	
	public Main() {
		Engine engine = Engine.newInstance(EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("6P830J66YB74320L8YCSI4AWGNTTNH1C9SWLJVBKVN8S4OXV65C8JVL67LTC55VW87LH")
                .build());
		browser = engine.newBrowser();
		System.setProperty("jxbrowser.license.key",
				"6P830J66YB74320L8YCSI4AWGNTTNH1C9SWLJVBKVN8S4OXV65C8JVL67LTC55VW87LH");

		SwingUtilities.invokeLater(() -> {
			view = BrowserView.newInstance(browser);

			setLayout(new BorderLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("JxBrowser");
			
			setSize(1280, 720);
			setVisible(true);
			
			add(panel, BorderLayout.NORTH);
			add(view, BorderLayout.CENTER);

			browser.navigation().loadUrl("https://www.google.com");
			
			panel.add(textField);
			panel.add(button);
			button.addMouseListener(new Event());
		});
		
		
	}
	public static void main(String[] args) {
		Main main = new Main();
	}
}
