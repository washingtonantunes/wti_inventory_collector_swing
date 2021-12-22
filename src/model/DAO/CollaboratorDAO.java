package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.entities.Collaborator;


public class CollaboratorDAO {

	private final String LIST = "SELECT * FROM wti_inventory.collaborators";

	public Map<String, Collaborator> getCollaborator() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Collaborator> collaborators_ = new HashMap<>();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Collaborator collaborator_ = new Collaborator();

				collaborator_.setName(rs.getString("name"));
				collaborator_.setRegistration(rs.getString("registration"));
				collaborator_.setPassword(rs.getString("password"));
				collaborator_.setPrivilege(rs.getString("privilege"));
				collaborator_.setOffice(rs.getString("office"));
				collaborators_.put(collaborator_.getRegistration(), collaborator_);
			}
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar colaboradores: " + e.getMessage());
		}
		return collaborators_;
	}
}
