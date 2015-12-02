import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BasicSearchPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel viewLabel;
	private JComboBox<String> entitySelector;
	private JLabel resultsLabel;
	
	public BasicSearchPanel() {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(3, 3, 3, 3), 0, 0);
		
		viewLabel = new JLabel("View: ");
		add(viewLabel, gbc);
		
		entitySelector = new JComboBox<>(new String[] {"Video Games", "Platforms", "Franchises"});
		entitySelector.addActionListener(e -> executeSearch());
		gbc.gridx++;
		gbc.weightx = 1;
		add(entitySelector, gbc);
		
		resultsLabel = new JLabel("RESULTS GO HERE");
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(resultsLabel, gbc);
	}
	
	private void executeSearch() {
		resultsLabel.setText("Search results for \"" + entitySelector.getSelectedItem() + "\"");
	}
}
