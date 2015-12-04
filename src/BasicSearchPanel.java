import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BasicSearchPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private enum Entity {
		GAME, PUBLISHER, DEVELOPER, PLATFORM, FRANCHISE;
	}
	
	private JComboBox<Entity> entitySelector;
	private JTextField searchText;
	private JButton searchButton;
	private JTable resultsTable;
	
	private QueryCaller qc;
	
	public BasicSearchPanel(QueryCaller qc) {
		super(new GridBagLayout());
		
		this.qc = qc;
		
		GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(3, 3, 3, 3), 0, 0);
		
		entitySelector = new JComboBox<>(Entity.values());
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
		add(new JScrollPane(resultsTable), gbc);
	}
	
	private void executeSearch() {
		ResultSet rs;
		String s = searchText.getText();
		try {
			switch((Entity) entitySelector.getSelectedItem()) {
			case DEVELOPER:
				rs = qc.queryDeveloper(s);
				break;
			case FRANCHISE:
				rs = qc.queryFranchise(s);
				break;
			case GAME:
				rs = qc.queryGame(s);
				break;
			case PLATFORM:
				rs = qc.queryPlatform(s);
				break;
			case PUBLISHER:
				rs = qc.queryPublisher(s);
				break;
			default:
				return;
			}

			resultsTable.setModel(ResultSetTableModel.createTableModel(rs));
		} catch (SQLException e) {
		}
	}
}
