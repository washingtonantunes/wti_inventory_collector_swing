package model.controller;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.DAO.EquipmentDAO;
import model.DAO.MonitorDAO;
import model.DAO.OptionDAO;
import model.DAO.ProjectDAO;
import model.DAO.UserDAO;
import model.DAO.WorkPositionDAO;
import model.entities.Collaborator;
import model.entities.Equipment;
import model.entities.Monitor;
import model.entities.Option;
import model.entities.Project;
import model.entities.User;
import model.entities.WorkPosition;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel label_text;
	private JLabel label_icon;

	private JButton buttonAddEquipment;
	private JButton buttonAddMonitor;
	private JButton buttonAddWorkPosition;
	private JButton buttonAddInventory;
	
	private static List<Project> projects;
	private static List<Monitor> monitors;
	private static List<WorkPosition> workPosition;
	private static List<User> users;
	private static List<Option> options;
	
	private static Equipment equipment;
	private static Collaborator collaborator;
	private SearchData searcData;

	public Window(Collaborator collaborator_) {
		searcData = new SearchData();
		collaborator = collaborator_;
		initComponents();
	}
	
	private void initComponents() {
		setLayout(null);

		setTitle("wTI Inventory Collector");
		setPreferredSize(new Dimension(400, 600));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initButtons();
		initLabels();
		
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initButtons() {
		buttonAddEquipment = new JButton("Adicionar Equipamento");
		buttonAddEquipment.setBounds(70, 250, 250, 45);
		buttonAddEquipment.addActionListener(new buttonAddEquipmentListener());
		add(buttonAddEquipment);

		buttonAddMonitor = new JButton("Adicionar Monitor");
		buttonAddMonitor.setBounds(70, 310, 250, 45);
		buttonAddMonitor.addActionListener(new buttonAddMonitorListener());
		add(buttonAddMonitor);

		buttonAddWorkPosition = new JButton("Adicionar Posi��o de Trabalho");
		buttonAddWorkPosition.setBounds(70, 370, 250, 45);
		buttonAddWorkPosition.addActionListener(new buttonAddWorkPositionListener());
		add(buttonAddWorkPosition);

		buttonAddInventory = new JButton("Adicionar Invent�rio");
		buttonAddInventory.setBounds(70, 430, 250, 45);
		buttonAddInventory.addActionListener(new buttonAddInventoryListener());
		add(buttonAddInventory);
	}
	
	private void initLabels() {
		label_text = new JLabel("Bem-Vindo ao wTI Inventory Collector");
		label_text.setForeground(Color.BLUE);
		label_text.setBounds(90, 20, 250, 50);
		add(label_text);

		label_icon = new JLabel((new ImageIcon(getClass().getResource("/model/icon/iconMain1.jpg"))));
		label_icon.setBounds(43, 60, 300, 180);
		add(label_icon);
	}
	
	private void initProject() {
		ProjectDAO projectDAO = new ProjectDAO();
		projects = projectDAO.getProject();
	}

	private void initMonitor() {
		MonitorDAO monitorDAO = new MonitorDAO();
		monitors = monitorDAO.getMonitor();
	}
	
	private void initWorkPosition() {
		WorkPositionDAO workPositionDAO = new WorkPositionDAO();
		workPosition = workPositionDAO.getWorkPosition();
	}
	
	private void initEquipment() {
		EquipmentDAO equipmentDAO = new EquipmentDAO();
		equipment = equipmentDAO.getEquipment(searcData.getEquipment().getSerialNumber());
	}
	
	private void initUser() {
		UserDAO userDAO = new UserDAO();
		users = userDAO.getUser();
	}
	
	private void initOption() {
		OptionDAO optionDAO = new OptionDAO();
		options = optionDAO.getOption();
	}
	
	public static List<Project> getProject() {
		return projects;
	}

	public static List<Monitor> getMonitor() {
		return monitors;
	}
	
	public static List<WorkPosition> getWorkPosition() {
		return workPosition;
	}
	
	public static List<User> getUser() {
		return users;
	}
	
	public static List<Option> getOption() {
		return options;
	}
	
	public static Equipment getEquipment() {
		return equipment;
	}

	public static void setEquipment(Equipment equipment_) {
		equipment = equipment_;
	}
	
	public static Collaborator getCollaborator() {
		return collaborator;
	}
	
	private class buttonAddEquipmentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			initOption();
			AddEquipment addEquipment = new AddEquipment(searcData.getEquipment());
			addEquipment.setVisible(true);
		}
	}

	private class buttonAddMonitorListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			initOption();
			AddMonitor addMonitor = new AddMonitor();
			addMonitor.setVisible(true);
		}
	}

	private class buttonAddWorkPositionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			initOption();
			AddWorkPosition addWorkPosition = new AddWorkPosition();
			addWorkPosition.setVisible(true);
		}
	}

	private class buttonAddInventoryListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			initProject();
			initMonitor();
			initEquipment();
			initWorkPosition();
			initUser();
			
			if (equipment.getSerialNumber() == null) {
				JOptionPane.showMessageDialog(null, "Equipamento n�o adicionado");
			} else {
				AddInventory addInventory = new AddInventory();
				addInventory.setVisible(true);
			}
		}
	}
}