package model.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Equipment;

public class SearchData {

	private static final String GET_SERIAL_NUMBER = "wmic bios get serialnumber";
	private static final String GET_HOST_NAME = "hostname";
	private static final String GET_ADDRESS_MAC = "getmac";
	private static final String GET_BRAND = "wmic computersystem get manufacturer";
	private static final String GET_MODEL = "wmic computersystem get model";

	private Equipment equipment;

	public Equipment getEquipment() {
		return equipment;
	}

	public SearchData() {
		this.equipment = new Equipment();
		initComponents();
	}

	private void initComponents() {
		initSerialNumber();
		initHostName();
		initAddressMAC();
		initBrand();
		initModel();
	}

	private void initSerialNumber() {
		List<String> list = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(GET_SERIAL_NUMBER);
			Scanner sc = new Scanner(process.getInputStream());
			while (sc.hasNextLine()) {
				list.add(sc.nextLine().trim());
			}
			equipment.setSerialNumber(list.get(2));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void initHostName() {
		try {
			Process process = Runtime.getRuntime().exec(GET_HOST_NAME);
			Scanner sc = new Scanner(process.getInputStream());
			equipment.setHostName(sc.nextLine().trim());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void initAddressMAC() {
		List<String> list = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(GET_ADDRESS_MAC);
			Scanner sc = new Scanner(process.getInputStream());
			while (sc.hasNextLine()) {
				list.add(sc.nextLine().trim());
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

	private void initBrand() {
		List<String> list = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(GET_BRAND);
			Scanner sc = new Scanner(process.getInputStream());
			while (sc.hasNextLine()) {
				list.add(sc.nextLine().trim());
			}
			equipment.setBrandEquipment(list.get(2));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void initModel() {
		List<String> list = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(GET_MODEL);
			Scanner sc = new Scanner(process.getInputStream());
			while (sc.hasNextLine()) {
				list.add(sc.nextLine().trim());
			}
			equipment.setModelEquipment(list.get(2));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
