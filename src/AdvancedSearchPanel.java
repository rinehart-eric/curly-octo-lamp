import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class AdvancedSearchPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextArea queryField;
	private JButton searchButton;
	private JTable resultsTable;
	
	public AdvancedSearchPanel() {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1, 0.2,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(3, 3, 3, 3), 0, 0);
		
		queryField = new JTextArea();
		JScrollPane queryPane = new JScrollPane(queryField);
		add(queryPane, gbc);
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(e -> executeSearch());
		gbc.gridy++;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.NONE;
		add(searchButton, gbc);
		
		resultsTable = new JTable();
		gbc.gridy++;
		gbc.weighty = 0.8;
		gbc.fill = GridBagConstraints.BOTH;
		add(resultsTable, gbc);
	}
	
	private void executeSearch() {
		// set JTable's table model to table model for new ResultSet
	}
}
