package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.entities.Option;


public class OptionDAO {

	private final String LIST = "SELECT * FROM wti_inventory.options";
	
	public List<Option> getOption() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Option> options_ = new ArrayList<>();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Option option_ = new Option();
				
				option_.setOption(rs.getString("option"));
				option_.setType(rs.getString("type"));
				option_.setStatusOption(rs.getString("statusOption"));
				options_.add(option_);
				
			}
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar opções: " + e.getMessage());
		}
		return options_;
	}
}
