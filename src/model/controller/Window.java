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

import model.DAO.EquipmentDAO;
import model.DAO.MonitorDAO;
import model.DAO.ProjectDAO;
import model.DAO.UserDAO;
import model.DAO.WorkPositionDAO;
import model.entities.Collaborator;
import model.entities.Equipment;
import model.entities.Monitor;
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
	private static Equipment equipment;
	private static List<WorkPosition> workPosition;
	private static List<User> users;
	private static Collaborator collaborator;
	
	private SearchData searcData;

	public Window(Collaborator collaborator_) {
		searcData = new SearchData();
		collaborator = collaborator_;
		initButtons();
		initLabels();
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		setTitle("wTI Inventory Collector");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPreferredSize(new Dimension(400, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

		buttonAddWorkPosition = new JButton("Adicionar Posição de Trabalho");
		buttonAddWorkPosition.setBounds(70, 370, 250, 45);
		buttonAddWorkPosition.addActionListener(new buttonAddWorkPositionListener());
		add(buttonAddWorkPosition);

		buttonAddInventory = new JButton("Adicionar Inventário");
		buttonAddInventory.setBounds(70, 430, 250, 45);
		buttonAddInventory.addActionListener(new buttonAddEquipmenListener());
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
	
	public static void updateMonitor() {
		MonitorDAO monitorDAO = new MonitorDAO();
		monitors = monitorDAO.getMonitor();
	}

	private void initEquipment() {
		EquipmentDAO equipmentDAO = new EquipmentDAO();
		equipment = equipmentDAO.getEquipment(searcData.getEquipment().getSerialNumber());
	}

	private void initWorkPosition() {
		WorkPositionDAO workPositionDAO = new WorkPositionDAO();
		workPosition = workPositionDAO.getWorkPosition();
	}
	
	public static void updateWorkPosition() {
		WorkPositionDAO workPositionDAO = new WorkPositionDAO();
		workPosition = workPositionDAO.getWorkPosition();
	}

	private void initUser() {
		UserDAO userDAO = new UserDAO();
		users = userDAO.getUser();
	}

	public static Collaborator getCollaborator() {
		return collaborator;
	}

	public static List<Project> getProject() {
		return projects;
	}

	public static List<Monitor> getMonitor() {
		return monitors;
	}

	public static Equipment getEquipment() {
		return equipment;
	}

	public static void setEquipment(Equipment equipment) {
		Window.equipment = equipment;
	}

	public static List<WorkPosition> getWorkPosition() {
		return workPosition;
	}

	public static List<User> getUser() {
		return users;
	}

	private class buttonAddEquipmentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AddEquipment addEquipment = new AddEquipment(searcData.getEquipment());
			addEquipment.setVisible(true);
		}
	}

	private class buttonAddMonitorListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AddMonitor addMonitor = new AddMonitor();
			addMonitor.setVisible(true);
		}
	}

	private class buttonAddWorkPositionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AddWorkPosition addWorkPosition = new AddWorkPosition();
			addWorkPosition.setVisible(true);
		}
	}

	private class buttonAddEquipmenListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			initProject();
			initMonitor();
			initEquipment();
			initWorkPosition();
			initUser();
			
			AddInventory addInventory = new AddInventory();
			addInventory.setVisible(true);
		}
	}
}
