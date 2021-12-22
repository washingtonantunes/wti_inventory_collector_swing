package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.controller.Window;
import model.entities.Equipment;


public class EquipmentDAO {

	private final java.sql.Date DATE = new java.sql.Date(new Date().getTime());

	private final String INSERT = "CALL inventory.add_equipment_collector(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String LIST = "SELECT * FROM inventory.equipments WHERE serialNumber=?";

	public EquipmentDAO() {

	}

	public void addEquipment(Equipment equipment_) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConexao();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(INSERT);
			
			pstm.setString(1, equipment_.getSerialNumber());
			pstm.setString(2, equipment_.getHostName());
			pstm.setString(3, equipment_.getAddressMAC());
			pstm.setString(4, equipment_.getTypeEquipment());
			pstm.setString(5, equipment_.getPatrimonyNumberEquipment());
			pstm.setString(6, equipment_.getBrandEquipment());
			pstm.setString(7, equipment_.getModelEquipment());
			pstm.setString(8, equipment_.getMemoryRam());
			pstm.setString(9, equipment_.getHardDisk());
			pstm.setString(10, "STAND BY");
			pstm.setDate(11, DATE);
			pstm.setString(12, "Novo Equipamento Adicionado");
			pstm.setString(13, "Entrada de Equipamento");
			pstm.setString(14, Window.collaborator);

			pstm.execute();
			JOptionPane.showMessageDialog(null, "Equipamento cadastrado com sucesso");
			ConnectionFactory.fechaConexao(conn, pstm);
		} catch (Exception e) {
			if (e.getMessage().contains("Duplicate entry")) {
				JOptionPane.showMessageDialog(null, "Equipamento já cadastrado");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao inserir equipamento no banco de dados: " + e.getMessage());
			}
		}
	}
	
	public Equipment getEquipment(String serialNumberEquipment) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Equipment equipment_ = new Equipment();
		try {
			conn = ConnectionFactory.getConexao();
			pstm = conn.prepareStatement(LIST);
			pstm.setString(1, serialNumberEquipment);
			rs = pstm.executeQuery();
			while (rs.next()) {
				
				equipment_.setSerialNumber(rs.getString("serialNumber"));
				equipment_.setHostName(rs.getString("hostname"));
				equipment_.setAddressMAC(rs.getString("addressMAC"));
				equipment_.setTypeEquipment(rs.getString("typeEquipment"));
				equipment_.setPatrimonyNumberEquipment(rs.getString("patrimonyNumberEquipment"));
				equipment_.setBrandEquipment(rs.getString("brandEquipment"));
				equipment_.setModelEquipment(rs.getString("modelEquipment"));
				equipment_.setMemoryRam(rs.getString("memoryRam"));
				equipment_.setHardDisk(rs.getString("hardDisk"));
				equipment_.setCostType(rs.getString("costType"));
				equipment_.setValueEquipment(rs.getDouble("valueEquipment"));
				equipment_.setStatusEquipment(rs.getString("statusEquipment"));
				equipment_.setDateEntry(rs.getDate("dateEntry"));
			}
			ConnectionFactory.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar equipamentos: " + e.getMessage());
		}
		return equipment_;
	}
}
