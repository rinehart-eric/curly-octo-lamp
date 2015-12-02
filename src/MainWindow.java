import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class MainWindow {
	private static final String WINDOW_TITLE = "Video Game Database";
	
	private JFrame window;
	
	public MainWindow() {
		window = new JFrame(WINDOW_TITLE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createInterface();
	}
	
	private void createInterface() {
		JTabbedPane searchPane = new JTabbedPane();
		searchPane.add("Basic search", new BasicSearchPanel());
		searchPane.add("Advanced search", new AdvancedSearchPanel());
		
		window.add(searchPane, SwingConstants.CENTER);
	}
	
	public void show() {
		window.setSize(600, 400);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainWindow().show();
	}
}
