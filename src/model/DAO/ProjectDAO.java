package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.entities.Project;

public class ProjectDAO {

	private final String LIST = "SELECT * FROM wti_inventory.projects";

	public List<Project> getProject() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Project> projects_ = new ArrayList<Project>();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Project project_ = new Project();

				project_.setNameProject(rs.getString("nameProject"));
				project_.setLocality(rs.getString("locality"));
				project_.setCostCenter(rs.getString("costCenter"));
				project_.setStatusProject(rs.getString("statusProject"));
				project_.setDateEntry(rs.getDate("dateEntry"));
				projects_.add(project_);
			}
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar projetos: " + e.getMessage());
		}
		return projects_;
	}
}
