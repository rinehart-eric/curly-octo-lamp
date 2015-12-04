import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class MainWindow {
	private static final String WINDOW_TITLE = "Video Game Database";
	
	private JFrame window;
	private QueryCaller qc;
	
	public MainWindow() {
		window = new JFrame(WINDOW_TITLE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initialize();
	}
	
	private void initialize() {
		qc = new QueryCaller();
		createInterface();
	}
	
	private void createInterface() {
		JTabbedPane searchPane = new JTabbedPane();
		searchPane.add("Basic search", new BasicSearchPanel(qc));
		searchPane.add("Advanced search", new AdvancedSearchPanel(qc));
		
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
