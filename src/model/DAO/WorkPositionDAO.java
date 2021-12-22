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
import model.entities.WorkPosition;

public class WorkPositionDAO {

	private final java.sql.Date DATE = new java.sql.Date(new Date().getTime());

	private final String INSERT = "CALL wti_inventory.add_work_position_collector(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String LIST = "SELECT * FROM wti_inventory.work_positions";

	public void addWorkPosition(WorkPosition workPosition_) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConexao();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(INSERT);

			pstm.setString(1, workPosition_.getWorkPoint());
			pstm.setString(2, workPosition_.getLocation());
			pstm.setString(3, workPosition_.getFloors());
			pstm.setString(4, workPosition_.getNetPoint());
			pstm.setString(5, "ATIVO");
			pstm.setDate(6, DATE);
			pstm.setString(7, "Nova Posição de Trabalho Adicionada");
			pstm.setString(8, "Entrada de Posição de Trabalho");
			pstm.setString(9, Window.getCollaborator().getName());

			pstm.execute();
			JOptionPane.showMessageDialog(null, "Posição de trabalho cadastrado com sucesso");
			ConnectionFactory.fechaConexao(conn, pstm);

		} catch (Exception e) {
			if (e.getMessage().contains("Duplicate entry")) {
				JOptionPane.showMessageDialog(null, "Posição de trabalho já existe");
			} else {
				JOptionPane.showMessageDialog(null,
						"Erro ao inserir posição de trabalho no banco de dados:  " + e.getMessage());
			}
		}
	}
	
	public List<WorkPosition> getWorkPosition() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<WorkPosition> workPositions_ = new ArrayList<WorkPosition>();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				WorkPosition workPosition_ = new WorkPosition();

				workPosition_.setLocation(rs.getString("location"));
				workPosition_.setFloors(rs.getString("floors"));
				workPosition_.setWorkPoint(rs.getString("workPoint"));
				workPosition_.setNetPoint(rs.getString("netPoint"));
				workPosition_.setStatusWorkPoint(rs.getString("statusWorkPosition"));
				workPosition_.setDateEntry(rs.getDate("dateEntry"));
				workPosition_.setReason(rs.getString("reason"));
				workPosition_.setIdChange(rs.getInt("idChange"));
				workPositions_.add(workPosition_);
			}
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar posição de trabalho: " + e.getMessage());
		}
		return workPositions_;
	}
}
