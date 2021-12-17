package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import entities.Equipment;


public class EquipmentDAO {

	private final java.sql.Date DATE = new java.sql.Date(new Date().getTime());

	private final String INSERT = "CALL inventory.add_equipment(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public EquipmentDAO() {

	}

	public String addEquipment(Equipment equipment_) {
		if (equipment_ != null) {
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
				pstm.setString(10, "");
				pstm.setDouble(11, 0);
				pstm.setString(12, "STAND BY");
				pstm.setDate(13, DATE);
				pstm.setString(14, "Adcionado Automaticamente");
				pstm.setString(15, "Entrada de Equipamento");
				pstm.setString(16, "supindra");

				pstm.execute();
				JOptionPane.showMessageDialog(null, "Equipamento cadastrado com sucesso");
				ConnectionFactory.fechaConexao(conn, pstm);
				return "Equipamento cadastrado com sucesso";
			} catch (Exception e) {
				if (e.getMessage().contains("Duplicate entry")) {
					return "Equipamento j� cadastrado";
				} else {
					return "Erro ao inserir equipamento no banco de dados: " + e.getMessage();
				}
			}
		} else {
			return "O equipamento enviado por par�metro est� vazio";
		}
	}
}