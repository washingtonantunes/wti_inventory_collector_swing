package application;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

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

    private static Map<String, Collaborator> collaborators;

	public Login() {
		initCollaborators();		
		initButtons();
		initLabels();
		initComponents();
	}

	private void initComponents() {
		setLayout(null);

		setTitle("wTI Inventory Collector");
		setPreferredSize(new Dimension(500, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		setLocationRelativeTo(null);
	}

	private void initButtons() {
		button_Entrar = new JButton("Entrar");
		button_Entrar.setBounds(90, 350, 130, 30);
		button_Entrar.addActionListener(new buttonLoginEquipmentListener());
		add(button_Entrar);

		button_Sair = new JButton("Sair");
		button_Sair.setBounds(270, 350, 130, 30);
		button_Sair.addActionListener(new buttonLogOffMonitorListener());
		add(button_Sair);
	}

	private void initLabels() {
		label_Icon = new JLabel((new ImageIcon(getClass().getResource("/model/icon/iconMain2.jpg"))));
		label_Icon.setBounds(90, 40, 300, 180);
		add(label_Icon);
		
		label_Login = new JLabel("Matrícula");
		label_Login.setBounds(60, 250, 130, 30);
		add(label_Login);
		
		label_Password  = new JLabel("Senha");
		label_Password.setBounds(300, 250, 130, 30);
		add(label_Password);
		
		textField_Login = new JTextField();
		textField_Login.setBounds(60, 280, 130, 30);
		add(textField_Login);
		
	    passwordField_Password = new JPasswordField();
	    passwordField_Password.setBounds(300, 280, 130, 30);
		add(passwordField_Password);
	}

	private void initCollaborators() {
		CollaboratorDAO collaboratorDAO = new CollaboratorDAO();
		collaborators = collaboratorDAO.getCollaborator();
	}

	private class buttonLoginEquipmentListener implements ActionListener {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			if (textField_Login.getText().trim().isEmpty() || passwordField_Password.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "É necessário informar matrícula e senha!");
			} else {
				final String registration = textField_Login.getText();
		        final String password = new String(passwordField_Password.getPassword());
		        final Collaborator collaborator = collaborators.get(registration);
		        if (collaborator == null) {
		        	JOptionPane.showMessageDialog(null, "Colaborador Não Cadastrado!");
		        } else {
		        	if((collaborator.getRegistration().equals(registration)) && (collaborator.getPassword().equals(password))) {
			        	new Window(collaborator).setVisible(true);
			        	dispose();
			        } else {
			            JOptionPane.showMessageDialog(null, "Senha Inválida!");
			        }
		        }
			}
		}
	}

	private class buttonLogOffMonitorListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Runtime.getRuntime().exit(0);
		}
	}	
}
