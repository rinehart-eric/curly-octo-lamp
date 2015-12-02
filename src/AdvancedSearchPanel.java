import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AdvancedSearchPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextArea queryField;
	private JButton searchButton;
	private JLabel resultsLabel;
	
	public AdvancedSearchPanel() {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1, 0.4,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(3, 3, 3, 3), 0, 0);
		
		queryField = new JTextArea();
		add(queryField, gbc);
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(e -> executeSearch());
		gbc.gridy++;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.NONE;
		add(searchButton, gbc);
		
		resultsLabel = new JLabel("RESULTS GO HERE");
		gbc.gridy++;
		gbc.weighty = 0.6;
		gbc.fill = GridBagConstraints.BOTH;
		add(resultsLabel, gbc);
	}
	
	private void executeSearch() {
		resultsLabel.setText("Search results for \"" + queryField.getText() + "\"");
	}
}
