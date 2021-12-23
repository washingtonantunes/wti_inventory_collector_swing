package model.controller;

import java.util.List;
import java.util.stream.Collectors;

import model.entities.Option;

public class Options {

	private List<String> location;;
	private List<String> floors;
	private List<String> typeEquipment;
	private List<String> memoryRam;
	private List<String> hardDisk;
	private List<String> monitor;

	public Options() {
		startLocation();
		startFloors();
		startTypeEquipment();
		startMemoryRam();
		startHardDisk();
		startMonitor();
	}

	private void startLocation() {
		location = Window.getOption().stream().filter(o -> o.getType().equals("LOCATION")).map(Option::getOption).collect(Collectors.toList());
	}

	public List<String> getLocation() {
		return location;
	}

	private void startFloors() {
		floors = Window.getOption().stream().filter(o -> o.getType().equals("FLOORS")).map(Option::getOption).collect(Collectors.toList());
	}

	public List<String> getFloors() {
		return floors;
	}

	private void startTypeEquipment() {
		typeEquipment = Window.getOption().stream().filter(o -> o.getType().equals("TYPE_EQUIPMENT")).map(Option::getOption).collect(Collectors.toList());
	}

	public List<String> getTypeEquipment() {
		return typeEquipment;
	}

	private void startMemoryRam() {
		memoryRam = Window.getOption().stream().filter(o -> o.getType().equals("MEMORY_RAM")).map(Option::getOption).collect(Collectors.toList());
	}

	public List<String> getMemoryRam() {
		return memoryRam;
	}

	private void startHardDisk() {
		hardDisk = Window.getOption().stream().filter(o -> o.getType().equals("HARD_DISK")).map(Option::getOption).collect(Collectors.toList());
	}

	public List<String> getHardDisk() {
		return hardDisk;
	}

	private void startMonitor() {
		monitor = Window.getOption().stream().filter(o -> o.getType().equals("MONITOR")).map(Option::getOption).collect(Collectors.toList());
	}

	public List<String> getMonitor() {
		return monitor;
	}
}
