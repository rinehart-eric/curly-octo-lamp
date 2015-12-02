import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class ResultSetTableModel extends DefaultTableModel {
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
	public String getColumnName(int column) {
		try {
			return metadata.getColumnName(column);
		} catch (SQLException e) {
			return "";
		}
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		try {
			results.absolute(row - 1);
			return results.getObject(column);
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
