package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.entities.User;

public class UserDAO {

	private final String LIST = "SELECT * FROM wti_inventory.users";

	public List<User> getUser() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<User> users_ = new ArrayList<User>();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				User user_ = new User();

				user_.setRegistration(rs.getString("registration"));
				user_.setNameUser(rs.getString("nameUser"));
				user_.setCPF(rs.getString("cpf"));
				user_.setPhone(rs.getString("phone"));
				user_.setProject(rs.getString("project"));
				user_.setEmail(rs.getString("email"));
				user_.setDepartment(rs.getString("department"));
				user_.setStatusUser(rs.getString("statusUser"));
				user_.setDateEntry(rs.getDate("dateEntry"));

				users_.add(user_);
			}
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar usuários: " + e.getMessage());
		}
		return users_;
	}
}
