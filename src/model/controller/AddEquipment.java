package model.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.DAO.EquipmentDAO;
import model.entities.Equipment;
import model.entities.Option;
import model.util.Utilitary;

public class AddEquipment extends JDialog {

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 150;
	private static final int HEIGHT = 25;

	private static final Dimension DIMENSIONMAINPANEL = new Dimension(370, 470);

	private JPanel panelMainAddEquipment;

	private JButton buttonSave;
	private JButton buttonClean;

	private JLabel label_SerialNumber;
	private JLabel label_HostName;
	private JLabel label_AddressMAC;
	private JLabel label_TypeEquipment;
	private JLabel label_PatrimonyNumberEquipment;
	private JLabel label_BrandEquipment;
	private JLabel label_ModelEquipment;
	private JLabel label_MemoryRam;
	private JLabel label_HardDisk;

	private JLabel label_show_SerialNumber;
	private JLabel label_show_HostName;
	private JLabel label_show_AddressMAC;
	private JComboBox<String> comboBox_TypeEquipment;
	private JTextField textField_PatrimonyNumberEquipment;
	private JLabel label_show_BrandEquipment;
	private JLabel label_show_ModelEquipment;
	private JComboBox<String> comboBox_MemoryRam;
	private JComboBox<String> comboBox_HardDisk;
	
	private Equipment equipment;

	public AddEquipment(Equipment equipment_) {
		this.equipment = equipment_;
		initComponents();
	}

	private void initComponents() {
		setModal(true);

		panelMainAddEquipment = new JPanel();
		panelMainAddEquipment.setLayout(null);

		buttonSave = new JButton("Salvar");
		buttonSave.setBounds(50, 390, WIDTH - 30, HEIGHT);
		buttonSave.addActionListener(new buttonSaveListener());
		panelMainAddEquipment.add(buttonSave);

		buttonClean = new JButton("Limpar");
		buttonClean.setBounds(180, 390, WIDTH - 30, HEIGHT);
		buttonClean.addActionListener(new buttonCleanListener());
		panelMainAddEquipment.add(buttonClean);

		addLabels();
		addTextFields();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Adicionar Equipamento");
		setPreferredSize(DIMENSIONMAINPANEL);
		setResizable(false);
		
		getRootPane().setDefaultButton(buttonSave);

		add(panelMainAddEquipment);

		pack();
		setLocationRelativeTo(null);
	}

	private void addLabels() {
		label_SerialNumber = new JLabel("Número de Série:");
		label_HostName = new JLabel("Nome do Equipamento:");
		label_AddressMAC = new JLabel("Endereço MAC:");
		label_TypeEquipment = new JLabel("Tipo de Equipamento:");
		label_PatrimonyNumberEquipment = new JLabel("Número do Patrimônio:");
		label_BrandEquipment = new JLabel("Marca:");
		label_ModelEquipment = new JLabel("Modelo:");
		label_MemoryRam = new JLabel("Memória:");
		label_HardDisk = new JLabel("Disco Rígido");

		label_SerialNumber.setBounds(20, 10, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_SerialNumber);

		label_HostName.setBounds(20, 50, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_HostName);

		label_AddressMAC.setBounds(20, 90, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_AddressMAC);

		label_TypeEquipment.setBounds(20, 130, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_TypeEquipment);

		label_PatrimonyNumberEquipment.setBounds(20, 170, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_PatrimonyNumberEquipment);

		label_BrandEquipment.setBounds(20, 210, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_BrandEquipment);

		label_ModelEquipment.setBounds(20, 250, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_ModelEquipment);

		label_MemoryRam.setBounds(20, 290, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_MemoryRam);

		label_HardDisk.setBounds(20, 330, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_HardDisk);
	}

	private void addTextFields() {
		label_show_SerialNumber = new JLabel(equipment.getSerialNumber());
		label_show_HostName = new JLabel(equipment.getHostName());
		label_show_AddressMAC = new JLabel(equipment.getAddressMAC());
		comboBox_TypeEquipment = new JComboBox<>(new Vector<>(Window.getOption().stream()
				.filter(o -> o.getType().equals("TIPO DE EQUIPAMENTO") && o.getStatusOption().equals("ATIVO"))
				.map(Option::getOption).collect(Collectors.toList())));
		textField_PatrimonyNumberEquipment = new JTextField();
		label_show_BrandEquipment = new JLabel(equipment.getBrandEquipment());
		label_show_ModelEquipment = new JLabel(equipment.getModelEquipment());
		comboBox_MemoryRam = new JComboBox<>(new Vector<>(Window.getOption().stream()
				.filter(o -> o.getType().equals("MEMÓRIA RAM") && o.getStatusOption().equals("ATIVO"))
				.map(Option::getOption).collect(Collectors.toList())));
		comboBox_HardDisk = new JComboBox<>(new Vector<>(Window.getOption().stream()
				.filter(o -> o.getType().equals("DISCO RIGIDO") && o.getStatusOption().equals("ATIVO"))
				.map(Option::getOption).collect(Collectors.toList())));

		label_show_SerialNumber.setBounds(170, 10, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_show_SerialNumber);

		label_show_HostName.setBounds(170, 50, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_show_HostName);

		label_show_AddressMAC.setBounds(170, 90, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_show_AddressMAC);

		comboBox_TypeEquipment.setSelectedIndex(-1);
		comboBox_TypeEquipment.setBounds(170, 130, WIDTH, HEIGHT);
		panelMainAddEquipment.add(comboBox_TypeEquipment);

		textField_PatrimonyNumberEquipment.setBounds(170, 170, WIDTH, HEIGHT);
		panelMainAddEquipment.add(textField_PatrimonyNumberEquipment);

		label_show_BrandEquipment.setBounds(170, 210, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_show_BrandEquipment);

		label_show_ModelEquipment.setBounds(170, 250, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_show_ModelEquipment);

		comboBox_MemoryRam.setSelectedIndex(-1);
		comboBox_MemoryRam.setBounds(170, 290, WIDTH, HEIGHT);
		panelMainAddEquipment.add(comboBox_MemoryRam);

		comboBox_HardDisk.setSelectedIndex(-1);
		comboBox_HardDisk.setBounds(170, 330, WIDTH, HEIGHT);
		panelMainAddEquipment.add(comboBox_HardDisk);
	}

	private class buttonSaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (comboBox_MemoryRam.getSelectedIndex() < 0 || comboBox_HardDisk.getSelectedIndex() < 0
					|| comboBox_TypeEquipment.getSelectedIndex() < 0
					|| textField_PatrimonyNumberEquipment.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Campos: 'Número de Patrimônio', 'Memória Ram', 'Hard Disk' e 'Tipo de Equipamento'  são obrigatórios!");
			} else if (Utilitary.ToCheckHostName(label_show_HostName.getText().toUpperCase().trim()) == false
					|| label_show_HostName.getText().length() < 7) {
				JOptionPane.showMessageDialog(null,
						"É necessário informar o nome do equipamento no formato: 'SPODSK' ou 'SPONTB'!");
			} else if (textField_PatrimonyNumberEquipment.getText().length() < 4) {
				JOptionPane.showMessageDialog(null, "É necessário informar um número de patrimônio válido.");
			} else {
				Equipment equipment_ = new Equipment();

				equipment_.setSerialNumber(label_show_SerialNumber.getText().toUpperCase().trim());
				equipment_.setHostName(label_show_HostName.getText().toUpperCase().trim());
				equipment_.setAddressMAC(label_show_AddressMAC.getText().toUpperCase().trim());
				equipment_.setTypeEquipment(comboBox_TypeEquipment.getSelectedItem().toString().toUpperCase().trim());
				equipment_
						.setPatrimonyNumberEquipment(textField_PatrimonyNumberEquipment.getText().toUpperCase().trim());
				equipment_.setBrandEquipment(label_show_BrandEquipment.getText().toUpperCase().trim());
				equipment_.setModelEquipment(label_show_ModelEquipment.getText().toUpperCase().trim());
				equipment_.setMemoryRam(comboBox_MemoryRam.getSelectedItem().toString());
				equipment_.setHardDisk(comboBox_HardDisk.getSelectedItem().toString());

				EquipmentDAO equipmentDAO_ = new EquipmentDAO();
				equipmentDAO_.addEquipment(equipment_);

				Window.setEquipment(equipment_);
				dispose();
			}
		}
	}

	private class buttonCleanListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			comboBox_TypeEquipment.setSelectedIndex(-1);
			textField_PatrimonyNumberEquipment.setText("");
			comboBox_MemoryRam.setSelectedIndex(-1);
			comboBox_HardDisk.setSelectedIndex(-1);
		}
	}
}

