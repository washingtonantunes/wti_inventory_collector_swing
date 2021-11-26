package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Equipment;

public class SearchData {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private static final String GET_SERIAL_NUMBER = "wmic bios get serialnumber";
	private static final String GET_HOST_NAME = "hostname";
	private static final String GET_ADDRESS_MAC = "getmac";
	private static final String GET_MEMORY_RAM = "wmic memorychip get capacity";
	private static final String GET_BRAND = "wmic computersystem get manufacturer";
	private static final String GET_MODEL = "wmic computersystem get model";
	private static final String GET_HARD_DISK = "wmic logicaldisk get size";

	private Equipment equipment;

	public SearchData() {
		this.equipment = new Equipment();
		initComponents();
	}

	private void initComponents() {
		addtSerialNumber();
		addHostName();
		addAddressMAC();
		addBrand();
		addModel();
		addMemoryRam();
		addHardDisk();
		addType();
		print();
		write();

	}

	private void addtSerialNumber() {
		List<String> list = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(GET_SERIAL_NUMBER);
			Scanner sc = new Scanner(process.getInputStream());
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
			}
			equipment.setSerialNumber(list.get(2));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void addHostName() {
		try {
			Process process = Runtime.getRuntime().exec(GET_HOST_NAME);
			Scanner sc = new Scanner(process.getInputStream());
			equipment.setHostName(sc.nextLine());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void addAddressMAC() {
		List<String> list = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(GET_ADDRESS_MAC);
			Scanner sc = new Scanner(process.getInputStream());
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
			}
			for (String s : list) {
				if (s.contains("Device")) {
					equipment.setAddressMAC(s.substring(0, 17));
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void addMemoryRam() {
		List<String> list = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(GET_MEMORY_RAM);
			Scanner sc = new Scanner(process.getInputStream());
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		if (list.get(2).substring(0, 1).equalsIgnoreCase("4")) {
			equipment.setMemoryRam("4 GB");
		} else if (list.get(2).substring(0, 1).equalsIgnoreCase("8")) {
			equipment.setMemoryRam("8 GB");
		} else if (list.get(2).substring(0, 2).equalsIgnoreCase("16")) {
			equipment.setMemoryRam("16 GB");
		}
	}
	
	private void addHardDisk() {
		List<String> list = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(GET_HARD_DISK);
			Scanner sc = new Scanner(process.getInputStream());
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
			}
			if (list.get(2).contains("255")) {
				equipment.setHardDisk("250 GB");
			}
			if (list.get(2).contains("455")) {
				equipment.setHardDisk("500 GB");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void addBrand() {
		List<String> list = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(GET_BRAND);
			Scanner sc = new Scanner(process.getInputStream());
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
			}
			if (list.get(2).contains("HP")) {
				equipment.setBrandEquipment("HP");
			}
			if (list.get(2).contains("Dell")) {
				equipment.setBrandEquipment("Dell");
			}
			if (list.get(2).contains("LENOVO")) {
				equipment.setBrandEquipment("LENOVO");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void addModel() {
		List<String> list = new ArrayList<String>();
		String aux = null;
		try {
			Process process = Runtime.getRuntime().exec(GET_MODEL);
			Scanner sc = new Scanner(process.getInputStream());
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
			}
			if (list.get(2).contains(equipment.getBrandEquipment())) {
				int i = list.get(2).indexOf(equipment.getBrandEquipment()) + equipment.getBrandEquipment().length() + 1;
				aux = list.get(2).substring(i);
				if (aux.contains("Not")) {
					int j = aux.indexOf("Not");
					equipment.setModelEquipment(aux.substring(0, j));
				} else if (aux.contains("Des")) {
					int j = aux.indexOf("Des");
					equipment.setModelEquipment(aux.substring(i, j));
				} else {
					equipment.setModelEquipment(aux);
				}
			} else {
				equipment.setModelEquipment(list.get(2));
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void addType() {
		List<String> list = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(GET_MODEL);
			Scanner sc = new Scanner(process.getInputStream());
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
			}

			if (list.get(2).contains("Note")) {
				equipment.setTypeEquipment("NOTEBOOK");
			}
			if (list.get(2).contains("Desk")) {
				equipment.setBrandEquipment("DESKTOP");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void print() {
		System.out.println(equipment.getSerialNumber());
		System.out.println(equipment.getHostName());
		System.out.println(equipment.getAddressMAC());
		System.out.println(equipment.getBrandEquipment());
		System.out.println(equipment.getModelEquipment());
		System.out.println(equipment.getMemoryRam());
		System.out.println(equipment.getHardDisk());
		System.out.println(equipment.getTypeEquipment());

	}
	
	private void write() {
		
		String path = "C:\\InfoEquipamento.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("Nº Série: " + equipment.getSerialNumber());
			bw.newLine();
			bw.write("Nome do Equipamento: " + equipment.getHostName());
			bw.newLine();
			bw.write("Endereço MAC: " + equipment.getAddressMAC());
			bw.newLine();
			bw.write("Marca do Equipamento: " + equipment.getBrandEquipment());
			bw.newLine();
			bw.write("Modelo do Equipamento: " + equipment.getModelEquipment());
			bw.newLine();
			bw.write("Memória RAM: " + equipment.getMemoryRam());
			bw.newLine();
			bw.write("Disco Rígido: " + equipment.getHardDisk());
			bw.newLine();
			bw.write("Tipo de Equipamento: " + equipment.getTypeEquipment());
			bw.newLine();
			bw.write("Data: " + sdf.format(new Date()));
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
