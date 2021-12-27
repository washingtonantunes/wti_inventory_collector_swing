package model.entities;

public class InventoryTest extends Inventory{

	private boolean workPositionBoolean;
	private boolean equipmentBoolean;
	private boolean userBoolean;
	private boolean monitor1Boolean;
	private boolean monitor2Boolean;
	
	private String changesEquipment;
	private String changesMonitor1;
	private String changesMonitor2;
	private String changesWorkPosition;
	
	public InventoryTest() {
	}

	public boolean isWorkPositionBoolean() {
		return workPositionBoolean;
	}

	public void setWorkPositionBoolean(boolean workPositionBoolean) {
		this.workPositionBoolean = workPositionBoolean;
	}

	public boolean isEquipmentBoolean() {
		return equipmentBoolean;
	}

	public void setEquipmentBoolean(boolean equipmentBoolean) {
		this.equipmentBoolean = equipmentBoolean;
	}

	public boolean isUserBoolean() {
		return userBoolean;
	}

	public void setUserBoolean(boolean userBoolean) {
		this.userBoolean = userBoolean;
	}

	public boolean isMonitor1Boolean() {
		return monitor1Boolean;
	}

	public void setMonitor1Boolean(boolean monitor1Boolean) {
		this.monitor1Boolean = monitor1Boolean;
	}

	public boolean isMonitor2Boolean() {
		return monitor2Boolean;
	}

	public void setMonitor2Boolean(boolean monitor2Boolean) {
		this.monitor2Boolean = monitor2Boolean;
	}

	public String getChangesEquipment() {
		return changesEquipment;
	}

	public void setChangesEquipment(String changesEquipment) {
		this.changesEquipment = changesEquipment;
	}

	public String getChangesMonitor1() {
		return changesMonitor1;
	}

	public void setChangesMonitor1(String changesMonitor1) {
		this.changesMonitor1 = changesMonitor1;
	}

	public String getChangesMonitor2() {
		return changesMonitor2;
	}

	public void setChangesMonitor2(String changesMonitor2) {
		this.changesMonitor2 = changesMonitor2;
	}

	public String getChangesWorkPosition() {
		return changesWorkPosition;
	}

	public void setChangesWorkPosition(String changesWorkPosition) {
		this.changesWorkPosition = changesWorkPosition;
	}
}
