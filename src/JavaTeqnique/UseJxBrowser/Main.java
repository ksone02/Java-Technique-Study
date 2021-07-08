package JavaTeqnique.UseJxBrowser;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;

public final class Main {
	public static void main(String[] args) {
		Engine engine = Engine.newInstance(EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("6P830J66YB74320L8YCSI4AWGNTTNH1C9SWLJVBKVN8S4OXV65C8JVL67LTC55VW87LH")
                .build());
		Browser browser = engine.newBrowser();
		System.setProperty("jxbrowser.license.key",
				"6P830J66YB74320L8YCSI4AWGNTTNH1C9SWLJVBKVN8S4OXV65C8JVL67LTC55VW87LH");

		SwingUtilities.invokeLater(() -> {
			BrowserView view = BrowserView.newInstance(browser);

			JFrame frame = new JFrame("Swing BrowserView");
			frame.add(view, BorderLayout.CENTER);
			frame.setSize(700, 500);
			frame.setVisible(true);

			browser.navigation().loadUrl("https://www.google.com");
		});
	}
}
