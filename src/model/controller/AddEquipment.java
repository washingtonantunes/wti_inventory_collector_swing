package model.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import model.DAO.EquipmentDAO;
import model.entities.Equipment;
import model.entities.Option;

public class AddEquipment extends JDialog {

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 150;
	private static final int HEIGHT = 25;

	private static final Dimension DIMENSIONMAINPANEL = new Dimension(370, 470);

	private Option option = new Option();

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

		add(panelMainAddEquipment);

		pack();
		setLocationRelativeTo(null);
	}

	private void addLabels() {
		label_SerialNumber = new JLabel("N�mero de S�rie:");
		label_HostName = new JLabel("Nome do Equipamento:");
		label_AddressMAC = new JLabel("Endere�o MAC:");
		label_TypeEquipment = new JLabel("Tipo de Equipamento:");
		label_PatrimonyNumberEquipment = new JLabel("N�mero do Patrim�nio:");
		label_BrandEquipment = new JLabel("Marca:");
		label_ModelEquipment = new JLabel("Modelo:");
		label_MemoryRam = new JLabel("Mem�ria:");
		label_HardDisk = new JLabel("Disco R�gido");

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
		comboBox_TypeEquipment = new JComboBox<>(new Vector<>(option.getTypeEquipment()));
		comboBox_TypeEquipment.getModel().setSelectedItem(equipment.getTypeEquipment());
		textField_PatrimonyNumberEquipment = new JTextField();
		label_show_BrandEquipment = new JLabel(equipment.getBrandEquipment());
		label_show_ModelEquipment = new JLabel(equipment.getModelEquipment());
		comboBox_MemoryRam = new JComboBox<>(new Vector<>(option.getMemoryRam()));
		comboBox_MemoryRam.getModel().setSelectedItem(equipment.getMemoryRam());
		comboBox_HardDisk = new JComboBox<>(new Vector<>(option.getHardDisk()));
		comboBox_HardDisk.getModel().setSelectedItem(equipment.getHardDisk());

		label_show_SerialNumber.setBounds(170, 10, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_show_SerialNumber);

		label_show_HostName.setBounds(170, 50, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_show_HostName);

		label_show_AddressMAC.setBounds(170, 90, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_show_AddressMAC);

		AutoCompleteDecorator.decorate(comboBox_TypeEquipment);
		comboBox_TypeEquipment.setSelectedIndex(-1);
		comboBox_TypeEquipment.setBounds(170, 130, WIDTH, HEIGHT);
		panelMainAddEquipment.add(comboBox_TypeEquipment);

		textField_PatrimonyNumberEquipment.setBounds(170, 170, WIDTH, HEIGHT);
		panelMainAddEquipment.add(textField_PatrimonyNumberEquipment);

		label_show_BrandEquipment.setBounds(170, 210, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_show_BrandEquipment);

		label_show_ModelEquipment.setBounds(170, 250, WIDTH, HEIGHT);
		panelMainAddEquipment.add(label_show_ModelEquipment);

		AutoCompleteDecorator.decorate(comboBox_MemoryRam);
		comboBox_MemoryRam.setSelectedIndex(-1);
		comboBox_MemoryRam.setBounds(170, 290, WIDTH, HEIGHT);
		panelMainAddEquipment.add(comboBox_MemoryRam);

		AutoCompleteDecorator.decorate(comboBox_HardDisk);
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
						"Campos: 'N�mero de Patrim�nio', 'Mem�ria Ram', 'Hard Disk' e 'Tipo de Equipamento'  s�o obrigat�rios!");
			} else if (textField_PatrimonyNumberEquipment.getText().length() < 4) {
				JOptionPane.showMessageDialog(null, "� necess�rio informar um n�mero de patrim�nio v�lido.");
			} else {
				Equipment equipment_ = new Equipment();

				equipment_.setSerialNumber(label_show_SerialNumber.getText());
				equipment_.setHostName(label_show_HostName.getText());
				equipment_.setAddressMAC(label_show_AddressMAC.getText());
				equipment_.setTypeEquipment(comboBox_TypeEquipment.getSelectedItem().toString());
				equipment_
						.setPatrimonyNumberEquipment(textField_PatrimonyNumberEquipment.getText().toUpperCase().trim());
				equipment_.setBrandEquipment(label_show_BrandEquipment.getText());
				equipment_.setModelEquipment(label_show_ModelEquipment.getText());
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
