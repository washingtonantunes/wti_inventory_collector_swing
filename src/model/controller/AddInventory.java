package model.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import model.DAO.InventoryDAO;
import model.entities.Equipment;
import model.entities.InventoryUtil;
import model.entities.Monitor;
import model.entities.Project;
import model.entities.User;
import model.entities.WorkPosition;
import model.util.CreatePDFFileNew;
import services.InventoryService;

public class AddInventory extends JDialog {

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 150;
	private static final int HEIGHT = 25;

	private static final int LINE_1 = 20;
	private static final int LINE_2 = 170;
	private static final int LINE_3 = 380;
	private static final int LINE_4 = 540;
	private static final int LINE_5 = 740;
	private static final int LINE_6 = 900;

	private static final Color COLOR_1 = new Color(25, 25, 112);

	private static final Dimension DIMENSIONMAINPANEL = new Dimension(1100, 550);

	private JPanel panelMainAddInventory;

	private JButton buttonSave;
	private JButton buttonClean;

	private JLabel label_WorkPosition;
	private JLabel label_Location;
	private JLabel label_Floors;
	private JLabel label_NetPoint;

	private JLabel label_Project;
	private JLabel label_CostCenter;
	private JLabel label_Locality;

	private JLabel label_SerialNumber;
	private JLabel label_HostName;
	private JLabel label_AddressMAC;
	private JLabel label_TypeEquipment;
	private JLabel label_PatrimonyNumberEquipment;
	private JLabel label_BrandEquipment;
	private JLabel label_ModelEquipment;
	private JLabel label_MemoryRam;
	private JLabel label_HardDisk;
	private JLabel label_CostType;
	private JLabel label_ValueEquipment;
	private JLabel label_StatusEquipment;

	private JLabel label_SerialNumberMonitor1;
	private JLabel label_ModelMonitor1;
	private JLabel label_PatrimonyNumberMonitor1;

	private JLabel label_SerialNumberMonitor2;
	private JLabel label_ModelMonitor2;
	private JLabel label_PatrimonyNumberMonitor2;

	private JLabel label_Registration;
	private JLabel label_NameUser;
	private JLabel label_CPF;
	private JLabel label_Phone;
	private JLabel label_Email;
	private JLabel label_Department;

	private JComboBox<WorkPosition> comboBox_WorkPosition;
	private JLabel label_show_Location;
	private JLabel label_show_Floors;
	private JLabel label_show_NetPoint;

	private JComboBox<Project> comboBox_Project;
	private JLabel label_show_CostCenter;
	private JLabel label_show_Locality;

	private JLabel label_show_SerialNumberEquipment;
	private JLabel label_show_HostName;
	private JLabel label_show_AddressMAC;
	private JLabel label_show_TypeEquipment;
	private JLabel label_show_PatrimonyNumberEquipment;
	private JLabel label_show_BrandEquipment;
	private JLabel label_show_ModelEquipment;
	private JLabel label_show_MemoryRam;
	private JLabel label_show_HardDisk;
	private JLabel label_show_CostType;
	private JLabel label_show_ValueEquipment;
	private JLabel label_show_StatusEquipment;

	private JComboBox<Monitor> comboBox_Monitor1;
	private JLabel label_show_modelMonitor1;
	private JLabel label_show_patrimonyNumberMonitor1;

	private JComboBox<Monitor> comboBox_Monitor2;
	private JLabel label_show_modelMonitor2;
	private JLabel label_show_patrimonyNumberMonitor2;

	private JComboBox<User> comboBox_User;
	private JLabel label_show_NameUser;
	private JLabel label_show_CPF;
	private JLabel label_show_Phone;
	private JLabel label_show_Email;
	private JLabel label_show_Department;

	private Equipment equipment;

	public AddInventory() {
		this.equipment = Window.getEquipment();
		initComponents();
	}

	private void initComponents() {
		setModal(true);

		panelMainAddInventory = new JPanel();
		panelMainAddInventory.setLayout(null);

		buttonSave = new JButton("Salvar");
		buttonSave.setBounds(400, 470, WIDTH - 50, HEIGHT);
		buttonSave.addActionListener(new buttonSaveListener());
		panelMainAddInventory.add(buttonSave);

		buttonClean = new JButton("Limpar");
		buttonClean.setBounds(580, 470, WIDTH - 50, HEIGHT);
		buttonClean.addActionListener(new buttonCleanListener());
		panelMainAddInventory.add(buttonClean);

		addWorkPosition();
		addProject();
		addUser();
		addEquipment();
		addMonitor1();
		addMonitor2();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Adicionar Inventory");
		setPreferredSize(DIMENSIONMAINPANEL);
		setResizable(false);

		getRootPane().setDefaultButton(buttonSave);

		add(panelMainAddInventory);

		pack();
		setLocationRelativeTo(null);
	}

	private void addWorkPosition() {
		label_WorkPosition = new JLabel("Posição de Trabalho:");
		label_Location = new JLabel("Localização");
		label_Floors = new JLabel("Andar:");
		label_NetPoint = new JLabel("Ponto de Rede:");

		label_WorkPosition.setBounds(LINE_1, 10, WIDTH, HEIGHT);
		label_WorkPosition.setForeground(COLOR_1);
		panelMainAddInventory.add(label_WorkPosition);

		label_Location.setBounds(LINE_1, 50, WIDTH, HEIGHT);
		label_Location.setForeground(COLOR_1);
		panelMainAddInventory.add(label_Location);

		label_Floors.setBounds(LINE_1, 90, WIDTH, HEIGHT);
		label_Floors.setForeground(COLOR_1);
		panelMainAddInventory.add(label_Floors);

		label_NetPoint.setBounds(LINE_1, 130, WIDTH, HEIGHT);
		label_NetPoint.setForeground(COLOR_1);
		panelMainAddInventory.add(label_NetPoint);

		comboBox_WorkPosition = new JComboBox<>(new Vector<>(
				Window.getWorkPosition().stream().filter(m -> m.getStatusWorkPoint().equals("ACTIVE")).collect(Collectors.toList())));
		label_show_Location = new JLabel();
		label_show_Floors = new JLabel();
		label_show_NetPoint = new JLabel();

		AutoCompleteDecorator.decorate(comboBox_WorkPosition);
		comboBox_WorkPosition.setSelectedIndex(-1);
		comboBox_WorkPosition.setBounds(LINE_2, 10, WIDTH, HEIGHT);
		comboBox_WorkPosition.addItemListener(new ItemChangeWorkPositionListener());
		panelMainAddInventory.add(comboBox_WorkPosition);

		label_show_Location.setBounds(LINE_2, 50, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_Location);

		label_show_Floors.setBounds(LINE_2, 90, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_Floors);

		label_show_NetPoint.setBounds(LINE_2, 130, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_NetPoint);
	}

	private void addProject() {
		label_Project = new JLabel("Projeto:");
		label_CostCenter = new JLabel("Centro de Custo:");
		label_Locality = new JLabel("Cidade:");

		label_Project.setBounds(LINE_1, 170, WIDTH, HEIGHT);
		label_Project.setForeground(COLOR_1);
		panelMainAddInventory.add(label_Project);

		label_CostCenter.setBounds(LINE_1, 210, WIDTH, HEIGHT);
		label_CostCenter.setForeground(COLOR_1);
		panelMainAddInventory.add(label_CostCenter);

		label_Locality.setBounds(LINE_1, 250, WIDTH, HEIGHT);
		label_Locality.setForeground(COLOR_1);
		panelMainAddInventory.add(label_Locality);

		comboBox_Project = new JComboBox<>(new Vector<>(Window.getProject().stream()
				.filter(p -> p.getStatusProject().equals("ACTIVE")).collect(Collectors.toList())));
		label_show_CostCenter = new JLabel();
		label_show_Locality = new JLabel();

		AutoCompleteDecorator.decorate(comboBox_Project);
		comboBox_Project.setSelectedIndex(-1);
		comboBox_Project.setBounds(LINE_2, 170, WIDTH, HEIGHT);
		comboBox_Project.addItemListener(new ItemChangeProjectListener());
		panelMainAddInventory.add(comboBox_Project);

		label_show_CostCenter.setBounds(LINE_2, 210, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_CostCenter);

		label_show_Locality.setBounds(LINE_2, 250, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_Locality);
	}

	private void addUser() {
		label_Registration = new JLabel("Matrícula:");
		label_NameUser = new JLabel("Nome:");
		label_CPF = new JLabel("CPF:");
		label_Phone = new JLabel("Telefone:");
		label_Email = new JLabel("Email:");
		label_Department = new JLabel("Departamento:");

		label_Registration.setBounds(LINE_1, 290, WIDTH, HEIGHT);
		label_Registration.setForeground(COLOR_1);
		panelMainAddInventory.add(label_Registration);

		label_NameUser.setBounds(LINE_1, 330, WIDTH, HEIGHT);
		label_NameUser.setForeground(COLOR_1);
		panelMainAddInventory.add(label_NameUser);

		label_CPF.setBounds(LINE_1, 370, WIDTH, HEIGHT);
		label_CPF.setForeground(COLOR_1);
		panelMainAddInventory.add(label_CPF);

		label_Phone.setBounds(LINE_1, 410, WIDTH, HEIGHT);
		label_Phone.setForeground(COLOR_1);
		panelMainAddInventory.add(label_Phone);

		label_Email.setBounds(LINE_3, 10, WIDTH, HEIGHT);
		label_Email.setForeground(COLOR_1);
		panelMainAddInventory.add(label_Email);

		label_Department.setBounds(LINE_3, 50, WIDTH, HEIGHT);
		label_Department.setForeground(COLOR_1);
		panelMainAddInventory.add(label_Department);

		comboBox_User = new JComboBox<>(new Vector<>(
				Window.getUser().stream().filter(u -> u.getStatusUser().equals("ACTIVE")).collect(Collectors.toList())));
		label_show_NameUser = new JLabel();
		label_show_CPF = new JLabel();
		label_show_Phone = new JLabel();
		label_show_Email = new JLabel();
		label_show_Department = new JLabel();

		AutoCompleteDecorator.decorate(comboBox_User);
		comboBox_User.setSelectedIndex(-1);
		comboBox_User.setBounds(170, 290, WIDTH, HEIGHT);
		comboBox_User.addItemListener(new ItemChangeUserListener());
		panelMainAddInventory.add(comboBox_User);

		label_show_NameUser.setBounds(LINE_2, 330, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_NameUser);

		label_show_CPF.setBounds(LINE_2, 370, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_CPF);

		label_show_Phone.setBounds(LINE_2, 410, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_Phone);

		label_show_Email.setBounds(LINE_4, 10, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_Email);

		label_show_Department.setBounds(LINE_4, 50, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_Department);
	}

	private void addEquipment() {
		label_SerialNumber = new JLabel("Nº de Série:");
		label_HostName = new JLabel("Nome do Computador:");
		label_AddressMAC = new JLabel("Endereço MAC:");
		label_TypeEquipment = new JLabel("Tipo de Equipamento:");
		label_PatrimonyNumberEquipment = new JLabel("Nº de Patrimônio:");
		label_BrandEquipment = new JLabel("Marca do Equipamento:");
		label_ModelEquipment = new JLabel("Modelo do Equipamento:");
		label_MemoryRam = new JLabel("Memória RAM:");
		label_HardDisk = new JLabel("Disco Rígido:");
		label_CostType = new JLabel("Tipo de Custo:");
		label_ValueEquipment = new JLabel("Valor do Equipamento:");
		label_StatusEquipment = new JLabel("Status do Equipamento:");

		label_SerialNumber.setBounds(LINE_3, 90, WIDTH, HEIGHT);
		label_SerialNumber.setForeground(COLOR_1);
		panelMainAddInventory.add(label_SerialNumber);

		label_HostName.setBounds(LINE_3, 130, WIDTH, HEIGHT);
		label_HostName.setForeground(COLOR_1);
		panelMainAddInventory.add(label_HostName);

		label_AddressMAC.setBounds(LINE_3, 170, WIDTH, HEIGHT);
		label_AddressMAC.setForeground(COLOR_1);
		panelMainAddInventory.add(label_AddressMAC);

		label_TypeEquipment.setBounds(LINE_3, 210, WIDTH, HEIGHT);
		label_TypeEquipment.setForeground(COLOR_1);
		panelMainAddInventory.add(label_TypeEquipment);

		label_PatrimonyNumberEquipment.setBounds(LINE_3, 250, WIDTH, HEIGHT);
		label_PatrimonyNumberEquipment.setForeground(COLOR_1);
		panelMainAddInventory.add(label_PatrimonyNumberEquipment);

		label_BrandEquipment.setBounds(LINE_3, 290, WIDTH, HEIGHT);
		label_BrandEquipment.setForeground(COLOR_1);
		panelMainAddInventory.add(label_BrandEquipment);

		label_ModelEquipment.setBounds(LINE_3, 330, WIDTH, HEIGHT);
		label_ModelEquipment.setForeground(COLOR_1);
		panelMainAddInventory.add(label_ModelEquipment);

		label_MemoryRam.setBounds(LINE_3, 370, WIDTH, HEIGHT);
		label_MemoryRam.setForeground(COLOR_1);
		panelMainAddInventory.add(label_MemoryRam);

		label_HardDisk.setBounds(LINE_3, 410, WIDTH, HEIGHT);
		label_HardDisk.setForeground(COLOR_1);
		panelMainAddInventory.add(label_HardDisk);

		label_CostType.setBounds(LINE_5, 10, WIDTH, HEIGHT);
		label_CostType.setForeground(COLOR_1);
		panelMainAddInventory.add(label_CostType);

		label_ValueEquipment.setBounds(LINE_5, 50, WIDTH, HEIGHT);
		label_ValueEquipment.setForeground(COLOR_1);
		panelMainAddInventory.add(label_ValueEquipment);

		label_StatusEquipment.setBounds(LINE_5, 90, WIDTH, HEIGHT);
		label_StatusEquipment.setForeground(COLOR_1);
		panelMainAddInventory.add(label_StatusEquipment);

		label_show_SerialNumberEquipment = new JLabel(equipment.getSerialNumber());
		label_show_HostName = new JLabel(equipment.getHostName());
		label_show_AddressMAC = new JLabel(equipment.getAddressMAC());
		label_show_TypeEquipment = new JLabel(equipment.getTypeEquipment());
		label_show_PatrimonyNumberEquipment = new JLabel(equipment.getPatrimonyNumberEquipment());
		label_show_BrandEquipment = new JLabel(equipment.getBrandEquipment());
		label_show_ModelEquipment = new JLabel(equipment.getModelEquipment());
		label_show_MemoryRam = new JLabel(equipment.getMemoryRam());
		label_show_HardDisk = new JLabel(equipment.getHardDisk());
		label_show_CostType = new JLabel(equipment.getCostType());
		label_show_ValueEquipment = new JLabel(
				equipment.getValueEquipment() == null ? null : equipment.getValueEquipment().toString());
		label_show_StatusEquipment = new JLabel(equipment.getStatusEquipment());

		label_show_SerialNumberEquipment.setBounds(LINE_4, 90, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_SerialNumberEquipment);

		label_show_HostName.setBounds(LINE_4, 130, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_HostName);

		label_show_AddressMAC.setBounds(LINE_4, 170, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_AddressMAC);

		label_show_TypeEquipment.setBounds(LINE_4, 210, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_TypeEquipment);

		label_show_PatrimonyNumberEquipment.setBounds(LINE_4, 250, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_PatrimonyNumberEquipment);

		label_show_BrandEquipment.setBounds(LINE_4, 290, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_BrandEquipment);

		label_show_ModelEquipment.setBounds(LINE_4, 330, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_ModelEquipment);

		label_show_MemoryRam.setBounds(LINE_4, 370, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_MemoryRam);

		label_show_HardDisk.setBounds(LINE_4, 410, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_HardDisk);

		label_show_CostType.setBounds(LINE_6, 10, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_CostType);

		label_show_ValueEquipment.setBounds(LINE_6, 50, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_ValueEquipment);

		label_show_StatusEquipment.setBounds(LINE_6, 90, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_StatusEquipment);
	}

	private void addMonitor1() {
		label_SerialNumberMonitor1 = new JLabel("Nº Série - Monitor 1:");
		label_ModelMonitor1 = new JLabel("Modelo - Monitor 1:");
		label_PatrimonyNumberMonitor1 = new JLabel("Nº Patrimônio - Monitor 1:");

		label_SerialNumberMonitor1.setBounds(LINE_5, 130, WIDTH, HEIGHT);
		label_SerialNumberMonitor1.setForeground(COLOR_1);
		panelMainAddInventory.add(label_SerialNumberMonitor1);

		label_ModelMonitor1.setBounds(LINE_5, 170, WIDTH, HEIGHT);
		label_ModelMonitor1.setForeground(COLOR_1);
		panelMainAddInventory.add(label_ModelMonitor1);

		label_PatrimonyNumberMonitor1.setBounds(LINE_5, 210, WIDTH, HEIGHT);
		label_PatrimonyNumberMonitor1.setForeground(COLOR_1);
		panelMainAddInventory.add(label_PatrimonyNumberMonitor1);

		comboBox_Monitor1 = new JComboBox<>(new Vector<>(Window.getMonitor().stream()
				.filter(m -> m.getStatusMonitor().equals("STAND BY")).collect(Collectors.toList())));
		label_show_modelMonitor1 = new JLabel();
		label_show_patrimonyNumberMonitor1 = new JLabel();

		AutoCompleteDecorator.decorate(comboBox_Monitor1);
		comboBox_Monitor1.setSelectedIndex(-1);
		comboBox_Monitor1.setBounds(LINE_6, 130, WIDTH, HEIGHT);
		comboBox_Monitor1.addItemListener(new ItemChangeMonitor1Listener());
		panelMainAddInventory.add(comboBox_Monitor1);

		label_show_modelMonitor1.setBounds(LINE_6, 170, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_modelMonitor1);

		label_show_patrimonyNumberMonitor1.setBounds(LINE_6, 210, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_patrimonyNumberMonitor1);
	}

	private void addMonitor2() {
		label_SerialNumberMonitor2 = new JLabel("Nº de Série - Monitor 2:");
		label_ModelMonitor2 = new JLabel("Modelo - Monitor 2:");
		label_PatrimonyNumberMonitor2 = new JLabel("Nº Patrimônio - Monitor 2:");

		label_SerialNumberMonitor2.setBounds(LINE_5, 250, WIDTH, HEIGHT);
		label_SerialNumberMonitor2.setForeground(COLOR_1);
		panelMainAddInventory.add(label_SerialNumberMonitor2);

		label_ModelMonitor2.setBounds(LINE_5, 290, WIDTH, HEIGHT);
		label_ModelMonitor2.setForeground(COLOR_1);
		panelMainAddInventory.add(label_ModelMonitor2);

		label_PatrimonyNumberMonitor2.setBounds(LINE_5, 330, WIDTH, HEIGHT);
		label_PatrimonyNumberMonitor2.setForeground(COLOR_1);
		panelMainAddInventory.add(label_PatrimonyNumberMonitor2);

		comboBox_Monitor2 = new JComboBox<>(new Vector<>(Window.getMonitor().stream()
				.filter(m -> m.getStatusMonitor().equals("STAND BY")).collect(Collectors.toList())));
		label_show_modelMonitor2 = new JLabel();
		label_show_patrimonyNumberMonitor2 = new JLabel();

		AutoCompleteDecorator.decorate(comboBox_Monitor2);
		comboBox_Monitor2.setSelectedIndex(-1);
		comboBox_Monitor2.setBounds(LINE_6, 250, WIDTH, HEIGHT);
		comboBox_Monitor2.addItemListener(new ItemChangeMonitor2Listener());
		panelMainAddInventory.add(comboBox_Monitor2);

		label_show_modelMonitor2.setBounds(LINE_6, 290, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_modelMonitor2);

		label_show_patrimonyNumberMonitor2.setBounds(LINE_6, 330, WIDTH, HEIGHT);
		panelMainAddInventory.add(label_show_patrimonyNumberMonitor2);
	}

	private class buttonSaveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (comboBox_Project.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "É necessário selecionar um Projeto!");
			} else if (comboBox_WorkPosition.getSelectedIndex() < 0 && comboBox_User.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(null, "É necessário selecionar um usuário ou uma posição de trabalho!");
			} else if (comboBox_WorkPosition.getSelectedItem().toString().equals("HOME-OFFICE")
					&& comboBox_User.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(null, "É necessário selecionar um usuário!");
			} else if (label_show_TypeEquipment.getText().equals("DESKTOP")
					&& comboBox_Monitor1.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(null, "É necessário selecionar um monitor!");
			} else if (comboBox_Monitor1.getSelectedIndex() > -1 && comboBox_Monitor2.getSelectedIndex() > -1) {
				if (comboBox_Monitor1.getSelectedItem() == comboBox_Monitor2
						.getSelectedItem()) {
					JOptionPane.showMessageDialog(null, "Os dois monitores selecionados são iguais!");
				} 
			} else {
				InventoryUtil inventoryUtil = new InventoryUtil();
				
				// WorkPosition
				inventoryUtil.getInventoryNew().setWorkPosition((WorkPosition) comboBox_WorkPosition.getSelectedItem());
				
				// Project
				inventoryUtil.getInventoryNew().setProject((Project) comboBox_Project.getSelectedItem());
				
				// User
				inventoryUtil.getInventoryNew().setUser((User) comboBox_User.getSelectedItem());

//				// Equipment
				inventoryUtil.getInventoryNew().getEquipment().setSerialNumber(label_show_SerialNumberEquipment.getText());
				inventoryUtil.getInventoryNew().getEquipment().setHostName(label_show_HostName.getText());
				inventoryUtil.getInventoryNew().getEquipment().setAddressMAC(label_show_AddressMAC.getText());
				inventoryUtil.getInventoryNew().getEquipment().setTypeEquipment(label_show_TypeEquipment.getText());
				inventoryUtil.getInventoryNew().getEquipment()
						.setPatrimonyNumberEquipment(label_show_PatrimonyNumberEquipment.getText());
				inventoryUtil.getInventoryNew().getEquipment().setBrandEquipment(label_show_BrandEquipment.getText());
				inventoryUtil.getInventoryNew().getEquipment().setModelEquipment(label_show_ModelEquipment.getText());
				inventoryUtil.getInventoryNew().getEquipment().setMemoryRam(label_show_MemoryRam.getText());
				inventoryUtil.getInventoryNew().getEquipment().setHardDisk(label_show_HardDisk.getText());
				inventoryUtil.getInventoryNew().getEquipment().setCostType(label_show_CostType.getText());
				inventoryUtil.getInventoryNew().getEquipment()
						.setValueEquipment(Double.parseDouble(label_show_ValueEquipment.getText()));
				inventoryUtil.getInventoryNew().getEquipment().setStatusEquipment(label_show_StatusEquipment.getText());

				// Monitor1
				inventoryUtil.getInventoryNew().setMonitor1((Monitor) comboBox_Monitor1.getSelectedItem());

				// Monitor2
				inventoryUtil.getInventoryNew().setMonitor2((Monitor) comboBox_Monitor2.getSelectedItem());
				
				inventoryUtil = InventoryService.getInventoryUtilNew(inventoryUtil);

				InventoryDAO inventoryDAO_ = new InventoryDAO();
				boolean test = inventoryDAO_.addInventory(inventoryUtil);
				
				if (test) {
					if (inventoryUtil.isUserNewBoolean()) {
						if (JOptionPane.showConfirmDialog(null,
								"Deseja gerar o termo de entrega?") == JOptionPane.YES_OPTION) {
							new CreatePDFFileNew(inventoryUtil.getInventoryNew());
						}
					}
					dispose();
				} 
				else {
					dispose();
				}
			}
		}
	}

	private class buttonCleanListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			comboBox_WorkPosition.setSelectedIndex(-1);
			label_show_Location.setText("");
			label_show_Floors.setText("");
			label_show_NetPoint.setText("");

			comboBox_Project.setSelectedIndex(-1);
			label_show_CostCenter.setText("");
			label_show_Locality.setText("");

			comboBox_Monitor1.setSelectedIndex(-1);
			label_show_modelMonitor1.setText("");
			label_show_patrimonyNumberMonitor1.setText("");

			comboBox_Monitor2.setSelectedIndex(-1);
			label_show_modelMonitor2.setText("");
			label_show_patrimonyNumberMonitor2.setText("");

			comboBox_User.setSelectedIndex(-1);
			label_show_NameUser.setText("");
			label_show_CPF.setText("");
			label_show_Phone.setText("");
			label_show_Email.setText("");
			label_show_Department.setText("");
		}
	}

	private class ItemChangeWorkPositionListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				Object item = event.getItem();

				label_show_Location.setText(((WorkPosition) item).getLocation());
				label_show_Floors.setText(((WorkPosition) item).getFloors());
				label_show_NetPoint.setText(((WorkPosition) item).getNetPoint());
			}
		}
	}

	private class ItemChangeProjectListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				Object item = event.getItem();

				label_show_CostCenter.setText(((Project) item).getCostCenter());
				label_show_Locality.setText(((Project) item).getLocality());
				label_show_Department.setText(((Project) item).getDepartment());
			}
		}
	}

	private class ItemChangeUserListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				Object item = event.getItem();

				label_show_NameUser.setText(((User) item).getNameUser());
				label_show_CPF.setText(((User) item).getCPF());
				label_show_Phone.setText(((User) item).getPhone());
				label_show_Email.setText(((User) item).getEmail());
				label_show_Department.setText(((User) item).getDepartment());
			}
		}
	}

	private class ItemChangeMonitor1Listener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				Object item = event.getItem();

				label_show_modelMonitor1.setText(((Monitor) item).getModelMonitor());
				label_show_patrimonyNumberMonitor1.setText(((Monitor) item).getPatrimonyNumberMonitor());
			}
		}
	}

	private class ItemChangeMonitor2Listener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				Object item = event.getItem();

				label_show_modelMonitor2.setText(((Monitor) item).getModelMonitor());
				label_show_patrimonyNumberMonitor2.setText(((Monitor) item).getPatrimonyNumberMonitor());
			}
		}
	}
}