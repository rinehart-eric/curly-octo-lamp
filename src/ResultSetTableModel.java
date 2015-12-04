import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private ResultSet results;
	private ResultSetMetaData metadata;
	
	private ResultSetTableModel(ResultSet results) {
		super();
		this.results = results;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	@Override
	public int getColumnCount() {
		try {
			return metadata.getColumnCount();
		} catch (SQLException e) {
			return 0;
		}
	}
	
	@Override
	public int getRowCount() {
		try {
			results.last();
			return results.getRow();
		} catch (SQLException e) {
			return 0;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		try {
			return metadata.getColumnName(column + 1);
		} catch (SQLException e) {
			return "";
		}
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		try {
			results.absolute(row + 1);
			return results.getObject(column + 1);
		} catch (SQLException e) {
			return null;
		}
	}
	
	public static ResultSetTableModel createTableModel(ResultSet results) throws SQLException {
		ResultSetMetaData rsmd = results.getMetaData();
		ResultSetTableModel rstm = new ResultSetTableModel(results);
		rstm.metadata = rsmd;

		return rstm;
	}
}
