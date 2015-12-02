import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BasicSearchPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel viewLabel;
	private JComboBox<String> entitySelector;
	private JTextField searchText;
	private JButton searchButton;
	private JTable resultsTable;
	
	public BasicSearchPanel() {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(3, 3, 3, 3), 0, 0);
		
		viewLabel = new JLabel("Search: ");
		add(viewLabel, gbc);
		
		entitySelector = new JComboBox<>(new String[] {"Video Games", "Platforms", "Franchises"});
		gbc.gridx++;
		gbc.weightx = 0.5;
		add(entitySelector, gbc);
		
		searchText = new JTextField(20);
		gbc.gridx++;
		gbc.weightx = 1;
		add(searchText, gbc);
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(e -> executeSearch());
		gbc.gridx++;
		gbc.weightx = 0;
		add(searchButton, gbc);
		
		resultsTable = new JTable();
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 4;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(resultsTable, gbc);
	}
	
	private void executeSearch() {
		// set JTable's table model to table model for new ResultSet
	}
}
