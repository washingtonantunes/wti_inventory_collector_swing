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

import model.DAO.MonitorDAO;
import model.entities.Monitor;
import model.entities.Option;

public class AddMonitor extends JDialog {

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 130;
	private static final int HEIGHT = 25;

	private static final Dimension DIMENSIONMAINPANEL = new Dimension(370, 230);
	
	private Option option = new Option();

	private JPanel panelMainAddMonitor;

	private JButton buttonSave;
	private JButton buttonClean;

	private JLabel label_SerialNumberMonitor;
	private JLabel label_ModelMonitor;
	private JLabel label_PatrimonyNumber;
	
	private JTextField textField_SerialNumberMonitor;
	private JComboBox<String> comboBox_ModelMonitor;
	private JTextField textField_PatrimonyNumber;
	
	public AddMonitor() {
		initComponents();
	}

	private void initComponents() {
		setModal(true);

		panelMainAddMonitor = new JPanel();
		panelMainAddMonitor.setLayout(null);

		buttonSave = new JButton("Salvar");
		buttonClean = new JButton("Limpar");
		
		buttonSave.setBounds(50, 150, WIDTH - 30, HEIGHT);
		buttonSave.addActionListener(new buttonSaveListener());
		panelMainAddMonitor.add(buttonSave);

		buttonClean.setBounds(180, 150, WIDTH - 30, HEIGHT);
		buttonClean.addActionListener(new buttonCleanListener());
		panelMainAddMonitor.add(buttonClean);

		addLabels();
		addTextFields();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Adicionar Monitor");
		setPreferredSize(DIMENSIONMAINPANEL);
		setResizable(false);

		add(panelMainAddMonitor);

		pack();
		setLocationRelativeTo(null);
	}

	private void addLabels() {
		label_SerialNumberMonitor = new JLabel("Numero de Série:");
		label_ModelMonitor = new JLabel("Modelo:");
		label_PatrimonyNumber = new JLabel("Numero de Patrimônio:");
				
		label_SerialNumberMonitor.setBounds(20, 10, WIDTH, HEIGHT);
		panelMainAddMonitor.add(label_SerialNumberMonitor);

		label_ModelMonitor.setBounds(20, 50, WIDTH, HEIGHT);
		panelMainAddMonitor.add(label_ModelMonitor);

		label_PatrimonyNumber.setBounds(20, 90, WIDTH, HEIGHT);
		panelMainAddMonitor.add(label_PatrimonyNumber);
	}

	private void addTextFields() {
		textField_SerialNumberMonitor = new JTextField();
		comboBox_ModelMonitor = new JComboBox<>(new Vector<>(option.getMonitor()));
		textField_PatrimonyNumber = new JTextField();
				
		textField_SerialNumberMonitor.setBounds(170, 10, 150, HEIGHT);
		panelMainAddMonitor.add(textField_SerialNumberMonitor);

		AutoCompleteDecorator.decorate(comboBox_ModelMonitor);
		comboBox_ModelMonitor.setSelectedIndex(-1);
		comboBox_ModelMonitor.setBounds(170, 50, 150, HEIGHT);
		panelMainAddMonitor.add(comboBox_ModelMonitor);

		textField_PatrimonyNumber.setBounds(170, 90, 150, HEIGHT);
		panelMainAddMonitor.add(textField_PatrimonyNumber);
	}

	private class buttonSaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (comboBox_ModelMonitor.getSelectedItem() == null
					|| textField_SerialNumberMonitor.getText().trim().isEmpty()
					|| textField_PatrimonyNumber.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null,	"Campos: 'Modelo', 'Numero de Série' e 'Numero de Patrimônio' são obrigatórios!");
			} else if (textField_SerialNumberMonitor.getText().length() < 6) {
				JOptionPane.showMessageDialog(null, "É necessário informar um número de série válido!");
			} else if (textField_PatrimonyNumber.getText().length() < 4) {
				JOptionPane.showMessageDialog(null, "É necessário informar um número de patrimônio válido!");
			} else {
				Monitor monitor_ = new Monitor();

				monitor_.setSerialNumberMonitor(textField_SerialNumberMonitor.getText().toUpperCase().trim());
				monitor_.setModelMonitor(comboBox_ModelMonitor.getSelectedItem().toString());
				monitor_.setPatrimonyNumberMonitor(textField_PatrimonyNumber.getText().toUpperCase().trim());
				
				MonitorDAO monitorDAO_ = new MonitorDAO();
				monitorDAO_.addMonitor(monitor_);

				dispose();
			}
		}
	}

	private class buttonCleanListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textField_SerialNumberMonitor.setText("");
			comboBox_ModelMonitor.setSelectedIndex(-1);
			textField_PatrimonyNumber.setText("");
		}
	}
}

