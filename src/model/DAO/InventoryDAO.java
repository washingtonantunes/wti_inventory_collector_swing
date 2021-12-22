package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.controller.Window;
import model.entities.Inventory;


public class InventoryDAO {

	private final java.sql.Date DATE = new java.sql.Date(new Date().getTime());

	private final String INSERT = "CALL wti_inventory.add_inventory_collector(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String LIST = "CALL wti_inventory.list_inventory_collector(?)";

	public int addInventory(Inventory inventory_, Boolean workPosition, String changesWorkPosition,
			String changesEquipment, String changesMonitor1, String changesMonitor2) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConexao();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(INSERT);

			pstm.setString(1, inventory_.getWorkPosition().getWorkPoint()); // workPositionAdd
			pstm.setBoolean(2, workPosition); // workPositionTeste
			pstm.setString(3, inventory_.getProject().getNameProject()); // project
			pstm.setString(4, inventory_.getUser().getRegistration()); // user
			pstm.setString(5, inventory_.getEquipment().getSerialNumber()); // equipment
			pstm.setString(6, inventory_.getMonitor1().getSerialNumberMonitor()); // monitor1
			pstm.setString(7, inventory_.getMonitor2().getSerialNumberMonitor()); // monitor2
			pstm.setDate(8, DATE); // data
			pstm.setString(9, changesWorkPosition); // changes WorkPosition
			pstm.setString(10, changesEquipment); // changes equipment
			pstm.setString(11, changesMonitor1); // changes monitor1
			pstm.setString(12, changesMonitor2); // changes monitor2
			pstm.setString(13, "Saída de Inventário"); // typeChange
			pstm.setString(14, Window.getCollaborator().getName()); // author

			pstm.execute();
			JOptionPane.showMessageDialog(null, "Inventário adicionado com sucesso");
			ConnectionFactory.fechaConexao(conn, pstm);
			return 1;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao remover inventário no banco de dados: " + e.getMessage());
			return -1;
		}
	}

	public Inventory getInventory(String serialNumberEquipment) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Inventory inventory_ = new Inventory();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(LIST);
			
			pstm.setString(1, serialNumberEquipment);
			rs = pstm.executeQuery();
			while (rs.next()) {
				
				inventory_.getWorkPosition().setWorkPoint(rs.getString("workPoint"));
				inventory_.getWorkPosition().setLocation(rs.getString("location"));
				inventory_.getWorkPosition().setFloors(rs.getString("floors"));
				inventory_.getWorkPosition().setNetPoint(rs.getString("netPoint"));

				inventory_.getProject().setNameProject(rs.getString("nameProject"));
				inventory_.getProject().setCostCenter(rs.getString("costCenter"));
				inventory_.getProject().setLocality(rs.getString("locality"));

				inventory_.getUser().setRegistration(rs.getString("registration"));
				inventory_.getUser().setNameUser(rs.getString("nameUser"));
				inventory_.getUser().setCPF(rs.getString("cpf"));
				inventory_.getUser().setPhone(rs.getString("phone"));
				inventory_.getUser().setEmail(rs.getString("email"));
				inventory_.getUser().setDepartment(rs.getString("department"));

				inventory_.getEquipment().setSerialNumber(rs.getString("serialNumber"));
				inventory_.getEquipment().setHostName(rs.getString("hostName"));
				inventory_.getEquipment().setAddressMAC(rs.getString("AddressMAC"));
				inventory_.getEquipment().setTypeEquipment(rs.getString("typeEquipment"));
				inventory_.getEquipment().setPatrimonyNumberEquipment(rs.getString("patrimonyNumberEquipment"));
				inventory_.getEquipment().setBrandEquipment(rs.getString("brandEquipment"));
				inventory_.getEquipment().setModelEquipment(rs.getString("modelEquipment"));
				inventory_.getEquipment().setMemoryRam(rs.getString("memoryRam"));
				inventory_.getEquipment().setHardDisk(rs.getString("hardDisk"));
				inventory_.getEquipment().setCostType(rs.getString("costType"));
				inventory_.getEquipment().setTypeEquipment(rs.getString("typeEquipment"));
				inventory_.getEquipment().setValueEquipment(rs.getDouble("valueEquipment"));
				inventory_.getEquipment().setStatusEquipment(rs.getString("statusEquipment"));

				inventory_.getMonitor1().setSerialNumberMonitor(rs.getString("serialNumberMonitor1"));
				inventory_.getMonitor1().setModelMonitor(rs.getString("modelMonitor1"));
				inventory_.getMonitor1().setPatrimonyNumberMonitor(rs.getString("patrimonyNumberMonitor1"));

				inventory_.getMonitor2().setSerialNumberMonitor(rs.getString("serialNumberMonitor2"));
				inventory_.getMonitor2().setModelMonitor(rs.getString("modelMonitor2"));
				inventory_.getMonitor2().setPatrimonyNumberMonitor(rs.getString("patrimonyNumberMonitor2"));

			}
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar inventário: " + e.getMessage());
		}
		return inventory_;
	}
}
