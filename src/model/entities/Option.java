package model.entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Option {

	Scanner sc = null;

	private static final String PATHTXT = "C:\\temp\\ws-eclipse\\wTI Inventory Collector\\src\\model\\util\\listTitle\\";

	private List<String> location;;
	private List<String> floors;
	private List<String> typeEquipment;
	private List<String> memoryRam;
	private List<String> hardDisk;
	private List<String> monitor;

	public Option() {
		startLocation();
		startFloors();
		startTypeEquipment();
		startMemoryRam();
		startHardDisk();
		startMonitor();
	}

	private void startLocation() {
		location = new ArrayList<>();

		String path = PATHTXT + "LOCATION.txt";

		read(path, location);
	}

	public List<String> getLocation() {
		return location;
	}

	public void addLocation(String location) {

		String path = PATHTXT + "LOCATION.txt";

		write(path, location);
	}

	private void startFloors() {
		floors = new ArrayList<>();

		String path = PATHTXT + "FLOORS.txt";

		read(path, floors);
	}

	public List<String> getFloors() {
		return floors;
	}

	public void addFloors(String floors) {

		String path = PATHTXT + "FLOORS.txt";

		write(path, floors);
	}

	private void startTypeEquipment() {
		typeEquipment = new ArrayList<>();

		String path = PATHTXT + "TYPE_EQUIPMENT.txt";

		read(path, typeEquipment);
	}

	public List<String> getTypeEquipment() {
		return typeEquipment;
	}

	public void addTypeEquipment(String typeEquipment) {

		String path = PATHTXT + "TYPE_EQUIPMENT.txt";

		write(path, typeEquipment);
	}

	private void startMemoryRam() {
		memoryRam = new ArrayList<>();

		String path = PATHTXT + "MEMORY_RAM.txt";

		read(path, memoryRam);
	}

	public List<String> getMemoryRam() {
		return memoryRam;
	}

	public void addMemoryRam(String memoryRam) {

		String path = PATHTXT + "MEMORY_RAM.txt";

		write(path, memoryRam);
	}

	private void startHardDisk() {
		hardDisk = new ArrayList<>();

		String path = PATHTXT + "HARD_DISK.txt";

		read(path, hardDisk);
	}

	public List<String> getHardDisk() {
		return hardDisk;
	}

	public void addHardDisk(String hardDisk) {

		String path = PATHTXT + "HARD_DISK.txt";

		write(path, hardDisk);
	}

	private void startMonitor() {
		monitor = new ArrayList<>();

		String path = PATHTXT + "MONITOR.txt";

		read(path, monitor);
	}

	public List<String> getMonitor() {
		return monitor;
	}

	public void addMonitor(String monitor) {

		String path = PATHTXT + "MONITOR.txt";

		write(path, monitor);
	}

	public void addCostType(String costType) {

		String path = PATHTXT + "COST_TYPE.txt";

		write(path, costType);
	}

	private void read(String path, List<String> list) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
			String line = br.readLine();
			while (line != null) {
				list.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void write(String path, String option) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			bw.write(option);
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
