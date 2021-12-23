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

import model.DAO.WorkPositionDAO;
import model.entities.WorkPosition;

public class AddWorkPosition extends JDialog {

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 130;
	private static final int HEIGHT = 25;

	private static final Dimension DIMENSIONMAINPANEL = new Dimension(350, 270);
	
	private Options options = new Options();

	private JPanel panelMainAddWorkPosition;

	private JButton buttonSave;
	private JButton buttonClean;

	private JLabel label_WorkPoint;
	private JLabel label_Location;
	private JLabel label_Floors;
	private JLabel label_NetPoint;

	private JTextField textField_WorkPoint;
	private JComboBox<String> comboBox_Location;
	private JComboBox<String> comboBox_Floors;
	private JTextField textField_NetPoint;

	public AddWorkPosition() {
		initComponents();
	}

	private void initComponents() {
		setModal(true);

		panelMainAddWorkPosition = new JPanel();
		panelMainAddWorkPosition.setLayout(null);

		buttonSave = new JButton("Salvar");
		buttonClean = new JButton("Limpar");

		buttonSave.setBounds(50, 190, WIDTH - 30, HEIGHT);
		buttonSave.addActionListener(new buttonSaveListener());
		panelMainAddWorkPosition.add(buttonSave);

		buttonClean.setBounds(180, 190, WIDTH - 30, HEIGHT);
		buttonClean.addActionListener(new buttonCleanListener());
		panelMainAddWorkPosition.add(buttonClean);

		addLabels();
		addTextFields();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Adicionar Posição de Trabalho");
		setPreferredSize(DIMENSIONMAINPANEL);
		setResizable(false);
		
		getRootPane().setDefaultButton(buttonSave);

		add(panelMainAddWorkPosition);

		pack();
		setLocationRelativeTo(null);
	}

	private void addLabels() {
		label_WorkPoint = new JLabel("Posição de Trabalho:");
		label_Location = new JLabel("Localização:");
		label_Floors = new JLabel("Andar:");
		label_NetPoint = new JLabel("Ponto de Rede:");

		label_WorkPoint.setBounds(20, 10, WIDTH, HEIGHT);
		panelMainAddWorkPosition.add(label_WorkPoint);

		label_Location.setBounds(20, 50, WIDTH, HEIGHT);
		panelMainAddWorkPosition.add(label_Location);

		label_Floors.setBounds(20, 90, WIDTH, HEIGHT);
		panelMainAddWorkPosition.add(label_Floors);

		label_NetPoint.setBounds(20, 130, WIDTH, HEIGHT);
		panelMainAddWorkPosition.add(label_NetPoint);
	}

	private void addTextFields() {
		textField_WorkPoint = new JTextField();
		comboBox_Location = new JComboBox<>(new Vector<>(options.getLocation()));
		comboBox_Floors = new JComboBox<>(new Vector<>(options.getFloors()));
		textField_NetPoint = new JTextField();

		textField_WorkPoint.setBounds(150, 10, WIDTH, HEIGHT);
		panelMainAddWorkPosition.add(textField_WorkPoint);

		comboBox_Location.setSelectedIndex(-1);
		comboBox_Location.setBounds(150, 50, WIDTH, HEIGHT);
		panelMainAddWorkPosition.add(comboBox_Location);

		comboBox_Floors.setSelectedIndex(-1);
		comboBox_Floors.setBounds(150, 90, WIDTH, HEIGHT);
		panelMainAddWorkPosition.add(comboBox_Floors);

		textField_NetPoint.setBounds(150, 130, WIDTH, HEIGHT);
		panelMainAddWorkPosition.add(textField_NetPoint);
	}

	private class buttonSaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (textField_WorkPoint.getText().trim().isEmpty() || comboBox_Location.getSelectedIndex() < 0
					|| comboBox_Floors.getSelectedIndex() < 0) {
				JOptionPane.showMessageDialog(null,
						"Campos: 'Posição de Trabalho', 'Localização' e 'Andar' são obrigatórios!");
			} else if (textField_WorkPoint.getText().length() < 6) {
				JOptionPane.showMessageDialog(null, "É necessário informar uma posição de trabalho válida.");
			} else {
				WorkPosition workPosition_ = new WorkPosition();

				workPosition_.setWorkPoint(textField_WorkPoint.getText().toUpperCase().trim());
				workPosition_.setLocation(comboBox_Location.getSelectedItem().toString());
				workPosition_.setFloors(comboBox_Floors.getSelectedItem().toString());
				workPosition_.setNetPoint(textField_NetPoint.getText().toUpperCase().trim());

				WorkPositionDAO workPositionDAO_ = new WorkPositionDAO();
				workPositionDAO_.addWorkPosition(workPosition_);

				dispose();
			}
		}
	}

	private class buttonCleanListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textField_WorkPoint.setText("");
			comboBox_Location.setSelectedIndex(-1);
			comboBox_Floors.setSelectedIndex(-1);
			textField_NetPoint.setText("");
		}
	}
}

