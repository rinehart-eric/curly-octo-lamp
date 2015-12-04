import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BasicSearchPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> entitySelector;
	private JTextField searchText;
	private JButton searchButton;
	private JTable resultsTable;
	
	public BasicSearchPanel() {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(3, 3, 3, 3), 0, 0);
		
		entitySelector = new JComboBox<>(new String[] {"Video Games", "Platforms", "Franchises"});
		add(entitySelector, gbc);
		
		searchText = new JTextField();
		gbc.gridx++;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(searchText, gbc);
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(e -> executeSearch());
		gbc.gridx++;
		gbc.weightx = 0;
		gbc.fill = GridBagConstraints.NONE;
		add(searchButton, gbc);
		
		resultsTable = new JTable();
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 3;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(resultsTable, gbc);
	}
	
	private void executeSearch() {
		// set JTable's table model to table model for new ResultSet
	}
}
