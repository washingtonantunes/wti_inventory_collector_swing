package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.entities.Collaborator;


public class CollaboratorDAO {

	private final String LIST = "SELECT * FROM wti_inventory.collaborators";

	public List<Collaborator> getCollaborator() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Collaborator> collaborators_ = new ArrayList<Collaborator>();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Collaborator collaborator_ = new Collaborator();

				collaborator_.setName(rs.getString("name"));
				collaborator_.setRegistration(rs.getInt("registration"));
				collaborator_.setPassword(rs.getString("password"));
				collaborator_.setPrivilege(rs.getInt("privilege"));
				collaborator_.setOffice(rs.getString("office"));
				collaborators_.add(collaborator_);
			}
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar colaboradores: " + e.getMessage());
		}
		return collaborators_;
	}
}
