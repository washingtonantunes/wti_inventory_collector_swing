package model.entities;

import java.util.Date;

public class Inventory {
	
	
	private Integer idInventory;
	private Date date;
	
	private WorkPosition workPosition;
	private Project project;
	private User user;
	private Equipment equipment;
	private Monitor monitor1;
	private Monitor monitor2;
	
	private String reason;
	
	public Inventory(Inventory inventory) {
		this.workPosition = inventory.getWorkPosition();
		this.project = inventory.getProject();
		this.user = inventory.getUser();
		this.equipment = inventory.getEquipment();
		this.monitor1 = inventory.getMonitor1();
		this.monitor2 = inventory.getMonitor2();
	}
	
	public Inventory() {
		this.workPosition = new WorkPosition();
		this.project = new Project();
		this.user = new User();
		this.equipment = new Equipment();
		this.monitor1 = new Monitor();
		this.monitor2 = new Monitor();
	}

	public Integer getIdInventory() {
		return idInventory;
	}

	public void setIdInventory(Integer idInventory) {
		this.idInventory = idInventory;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public WorkPosition getWorkPosition() {
		return workPosition;
	}

	public void setWorkPosition(WorkPosition workPosition_) {
		this.workPosition = workPosition_;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Monitor getMonitor1() {
		return monitor1;
	}

	public void setMonitor1(Monitor Monitor1) {
		this.monitor1 = Monitor1;
	}

	public Monitor getMonitor2() {
		return monitor2;
	}

	public void setMonitor2(Monitor Monitor2) {
		this.monitor2 = Monitor2;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}	
}
