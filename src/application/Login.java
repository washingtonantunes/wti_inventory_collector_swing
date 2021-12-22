package application;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.DAO.CollaboratorDAO;
import model.controller.Window;
import model.entities.Collaborator;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

    private JLabel label_Icon;
    private JLabel label_Login;
    private JLabel label_Password;
    
    private JButton button_Entrar;
    private JButton button_Sair;

    private JPasswordField passwordField_Password;
    private JTextField textField_Login;
    
    private static List<Collaborator> collaborators;

	public Login() {
		initCollaborators();
		initButtons();
		initLabels();
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		setTitle("wTI Inventory Collector");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setPreferredSize(new Dimension(500, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		setLocationRelativeTo(null);
	}

	private void initButtons() {
		button_Entrar = new JButton("Entrar");
		button_Entrar.setBounds(70, 250, 250, 45);
		button_Entrar.addActionListener(new buttonLoginEquipmentListener());
		add(button_Entrar);

		button_Sair = new JButton("Sair");
		button_Sair.setBounds(70, 310, 250, 45);
		button_Sair.addActionListener(new buttonLogOffMonitorListener());
		add(button_Sair);
	}

	private void initLabels() {
		label_Icon = new JLabel((new ImageIcon(getClass().getResource("/model/icon/iconMain.jpg"))));
		label_Icon.setBounds(43, 60, 300, 180);
		add(label_Icon);
		
		label_Login = new JLabel("Login");
		label_Login.setBounds(43, 60, 300, 180);
		add(label_Login);
		
		label_Password  = new JLabel("Sair");
		label_Password.setBounds(43, 60, 300, 180);
		add(label_Password);
		
		textField_Login = new JTextField();
		textField_Login.setBounds(43, 60, 300, 180);
		add(textField_Login);
		
	    passwordField_Password = new JPasswordField();
	    passwordField_Password.setBounds(43, 60, 300, 180);
		add(passwordField_Password);
	}

	private void initCollaborators() {
		CollaboratorDAO collaboratorDAO = new CollaboratorDAO();
		collaborators = collaboratorDAO.getCollaborator();
	}

	private class buttonLoginEquipmentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			final String registration = textField_Login.getText();
	        final String password = new String(passwordField_Password.getPassword());
	        final Collaborator collaborator = collaborators.stream().filter(c -> c.getRegistration().equals(registration)).findFirst().get();
	        
	        
	        
	        if((collaborator.getRegistration().equals(registration)) && (collaborator.getPassword().equals(password))) {
	        	new Window(collaborator).setVisible(true);
	        	dispose();
	        	
	        	
	        } else {
	            JOptionPane.showMessageDialog(null, "Acesso Negado!");
	        }
		}
	}

	private class buttonLogOffMonitorListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Runtime.getRuntime().exit(0);
		}
	}	
}
