package model.util;

import java.awt.Desktop;
//import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.controller.Window;
import model.entities.Inventory;

public class CreatePDFFileDelivery {

	private static final DateFormat dfmt = new SimpleDateFormat("d 'de' MMMM 'de' yyyy");
	private static final Date hoje = Calendar.getInstance(Locale.getDefault()).getTime();

	private String filePath = null;

	private Inventory inventory;

	public CreatePDFFileDelivery(Inventory inventory_) {
		this.inventory = inventory_;
		createPDF();
	}

	private void createPDF() {

		Document document = new Document(PageSize.A4, 36f, 52f, 40f, 80f);

		Paragraph linha = new Paragraph(" ");

		getPath();

		try {
			PdfWriter.getInstance(document,
					new FileOutputStream(filePath.contains("pdf") ? filePath : filePath + ".pdf"));
			document.open();
			document.add(getHeader()); // cabeçalho
			document.add(linha);
			document.add(linha);
			document.add(getDate());
			document.add(linha);
			document.add(getUser());
			document.add(getEquipment());
			if (inventory.getMonitor1().getSerialNumberMonitor() != null) {
				document.add(getMonitor1());
			}

			if (inventory.getMonitor2().getSerialNumberMonitor() != null) {
				document.add(getMonitor2());
			}

			document.add(linha);
			document.add(linha);
			document.add(getThird());
			document.add(linha);
			document.add(linha);
			document.add(linha);
			document.add(getSignature());
			document.add(linha);
			document.add(linha);
			document.add(linha);
			document.add(getTechnical());

			Desktop.getDesktop().open(new File(filePath));
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} finally {
			document.close();
		}

	}

	private void getPath() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			filePath = selectedFile.getAbsolutePath().contains("pdf") ? selectedFile.getAbsolutePath()
					: selectedFile.getAbsolutePath() + ".pdf";
		}
	}

	private Paragraph getHeader() {
		Paragraph header = new Paragraph("TERMO DE ENTREGA");
		header.setAlignment(1);
		return header;
	}

	private Paragraph getDate() {
		Paragraph date = new Paragraph("São Paulo, " + dfmt.format(hoje) + ".");
		date.setAlignment(0);
		return date;
	}

	private Paragraph getUser() {
		Paragraph first = new Paragraph("Eu, " + inventory.getUser().getNameUser() + ", portador do CPF: "
				+ inventory.getUser().getCPF() + ", matrícula: " + inventory.getUser().getRegistration()
				+ ", alocada no projeto: " + inventory.getProject().getNameProject()
				+ ", recebi nesta data, da empresa INDRA, os equipamentos listados abaixo: \n");
		first.setAlignment(0);
		return first;
	}

	private Paragraph getEquipment() {
		Paragraph equipment = new Paragraph(inventory.getEquipment().getTypeEquipment() + ":\n" + "marca "
				+ inventory.getEquipment().getBrandEquipment() + ", modelo "
				+ inventory.getEquipment().getModelEquipment() + ", número de patrimônio: "
				+ inventory.getEquipment().getPatrimonyNumberEquipment() + ", número de série: "
				+ inventory.getEquipment().getSerialNumber() + ".");
		equipment.setAlignment(0);
		return equipment;
	}

	private Paragraph getMonitor1() {
		Paragraph monitor1 = new Paragraph("Monitor 1: \n" + "marca: " + inventory.getMonitor1().getModelMonitor()
				+ ", número de patrimônio: " + inventory.getMonitor1().getPatrimonyNumberMonitor()
				+ ", número de série: " + inventory.getMonitor1().getSerialNumberMonitor());
		monitor1.setAlignment(0);
		return monitor1;
	}

	private Paragraph getMonitor2() {
		Paragraph monitor2 = new Paragraph("Monitor 2: \n" + "marca: " + inventory.getMonitor2().getModelMonitor()
				+ ", número de patrimônio: " + inventory.getMonitor2().getPatrimonyNumberMonitor()
				+ ", número de série: " + inventory.getMonitor2().getSerialNumberMonitor());
		monitor2.setAlignment(0);
		return monitor2;
	}

	private Paragraph getThird() {
		Paragraph third = new Paragraph("Declaro estar ciente que:\n"
				+ "• O equipamento é de uso estritamente profissional e apenas devo utilizá-lo para executar as atividades solicitadas pela Empresa. \n"
				+ "• É proibida a instalação, de forma intencional ou não, de qualquer software, hardware, periférico ou qualquer outro componente no equipamento.  \n"
				+ "• Qualquer alteração no equipamento, tanto de Software, quanto de Hardware, somente poderá ser efetuada pelo departamento de Suporte Técnico da Indra ou com uma autorização por e-mail do Gestor. \n"
				+ "• As penalidades previstas na Lei nº 9.609/98 de proteção aos Programas de Computador recairão exclusivamente sobre o colaborador responsável pelo equipamento, sob pena, também, de ser demitido por justa causa. \n");

		third.setAlignment(0);
		return third;
	}

	private Paragraph getSignature() {
		Paragraph signature = new Paragraph("______________________________\n" + "              Assinatura           ");
		signature.setAlignment(1);
		return signature;
	}

	private Paragraph getTechnical() {
		Paragraph technical = new Paragraph("Técnico Responsável: " + Window.getCollaborator().getName());
		technical.setAlignment(0);
		return technical;
	}
}
