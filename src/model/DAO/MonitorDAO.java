package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.controller.Window;
import model.entities.Monitor;

public class MonitorDAO {

	private final java.sql.Date DATE = new java.sql.Date(new Date().getTime());

	private final String INSERT = "CALL wti_inventory.add_monitor_collector(?,?,?,?,?,?,?,?);";
	private final String LIST = "SELECT * FROM wti_inventory.monitors";

	public void addMonitor(Monitor monitor_) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConexao();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(INSERT);

			pstm.setString(1, monitor_.getSerialNumberMonitor());
			pstm.setString(2, monitor_.getModelMonitor());
			pstm.setString(3, monitor_.getPatrimonyNumberMonitor());
			pstm.setString(4, "STAND BY");
			pstm.setDate(5, DATE);
			pstm.setString(6, "Novo Monitor Adicionado");
			pstm.setString(7, "Entrada de Monitor");
			pstm.setString(8, Window.getCollaborator().getName());

			pstm.execute();
			JOptionPane.showMessageDialog(null, "Monitor cadastrado com sucesso");
			ConnectionFactory.fechaConexao(conn, pstm);

		} catch (Exception e) {
			if (e.getMessage().contains("Duplicate entry")) {
				JOptionPane.showMessageDialog(null, "Monitor já existe");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao inserir monitor no banco de dados: " + e.getMessage());
			}
		}
	}
	
	public List<Monitor> getMonitor() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Monitor> monitors_ = new ArrayList<Monitor>();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Monitor monitor_ = new Monitor();

				monitor_.setSerialNumberMonitor(rs.getString("serialNumberMonitor"));
				monitor_.setModelMonitor(rs.getString("modelMonitor"));
				monitor_.setPatrimonyNumberMonitor(rs.getString("patrimonyNumberMonitor"));
				monitor_.setStatusMonitor(rs.getString("statusMonitor"));
				monitor_.setDateEntry(rs.getDate("dateEntry"));
				monitors_.add(monitor_);
			}
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar monitores: " + e.getMessage());
		}
		return monitors_;
	}
}
