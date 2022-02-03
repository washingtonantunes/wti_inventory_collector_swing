package model.entities;

public class InventoryUtil {
	
	//Inventory New
	private boolean workPositionNewBoolean;
	private boolean userNewBoolean;
	private boolean projectNewBoolean;
	private boolean equipmentNewBoolean;
	private boolean monitor1NewBoolean;
	private boolean monitor2NewBoolean;

	private String changesWorkPositionNew;
	private String changesUserNew;
	private String changesProjectNew;
	private String changesEquipmentNew;
	private String changesMonitor1New;
	private String changesMonitor2New;
	
	//Inventory Old
	private boolean workPositionOldBoolean;
	private boolean userOldBoolean;
	private boolean projectOldBoolean;
	private boolean equipmentOldBoolean;
	private boolean monitor1OldBoolean;
	private boolean monitor2OldBoolean;

	private String changesWorkPositionOld;
	private String changesUserOld;
	private String changesProjectOld;
	private String changesEquipmentOld;
	private String changesMonitor1Old;
	private String changesMonitor2Old;
	
	private Inventory inventoryNew = new Inventory();
	private Inventory inventoryOld = new Inventory();
	
	public InventoryUtil() {
	}
	
	public InventoryUtil(Inventory inventoryOld) {
		this.inventoryOld = inventoryOld;
	}

	public boolean isWorkPositionNewBoolean() {
		return workPositionNewBoolean;
	}

	public void setWorkPositionNewBoolean(boolean workPositionNewBoolean) {
		this.workPositionNewBoolean = workPositionNewBoolean;
	}

	public boolean isUserNewBoolean() {
		return userNewBoolean;
	}

	public void setUserNewBoolean(boolean userNewBoolean) {
		this.userNewBoolean = userNewBoolean;
	}

	public boolean isProjectNewBoolean() {
		return projectNewBoolean;
	}

	public void setProjectNewBoolean(boolean projectNewBoolean) {
		this.projectNewBoolean = projectNewBoolean;
	}

	public boolean isEquipmentNewBoolean() {
		return equipmentNewBoolean;
	}

	public void setEquipmentNewBoolean(boolean equipmentNewBoolean) {
		this.equipmentNewBoolean = equipmentNewBoolean;
	}

	public boolean isMonitor1NewBoolean() {
		return monitor1NewBoolean;
	}

	public void setMonitor1NewBoolean(boolean monitor1NewBoolean) {
		this.monitor1NewBoolean = monitor1NewBoolean;
	}

	public boolean isMonitor2NewBoolean() {
		return monitor2NewBoolean;
	}

	public void setMonitor2NewBoolean(boolean monitor2NewBoolean) {
		this.monitor2NewBoolean = monitor2NewBoolean;
	}

	public String getChangesWorkPositionNew() {
		return changesWorkPositionNew;
	}

	public void setChangesWorkPositionNew(String changesWorkPositionNew) {
		this.changesWorkPositionNew = changesWorkPositionNew;
	}

	public String getChangesUserNew() {
		return changesUserNew;
	}

	public void setChangesUserNew(String changesUserNew) {
		this.changesUserNew = changesUserNew;
	}

	public String getChangesProjectNew() {
		return changesProjectNew;
	}

	public void setChangesProjectNew(String changesProjectNew) {
		this.changesProjectNew = changesProjectNew;
	}

	public String getChangesEquipmentNew() {
		return changesEquipmentNew;
	}

	public void setChangesEquipmentNew(String changesEquipmentNew) {
		this.changesEquipmentNew = changesEquipmentNew;
	}

	public String getChangesMonitor1New() {
		return changesMonitor1New;
	}

	public void setChangesMonitor1New(String changesMonitor1New) {
		this.changesMonitor1New = changesMonitor1New;
	}

	public String getChangesMonitor2New() {
		return changesMonitor2New;
	}

	public void setChangesMonitor2New(String changesMonitor2New) {
		this.changesMonitor2New = changesMonitor2New;
	}

	public boolean isWorkPositionOldBoolean() {
		return workPositionOldBoolean;
	}

	public void setWorkPositionOldBoolean(boolean workPositionOldBoolean) {
		this.workPositionOldBoolean = workPositionOldBoolean;
	}

	public boolean isUserOldBoolean() {
		return userOldBoolean;
	}

	public void setUserOldBoolean(boolean userOldBoolean) {
		this.userOldBoolean = userOldBoolean;
	}

	public boolean isProjectOldBoolean() {
		return projectOldBoolean;
	}

	public void setProjectOldBoolean(boolean projectOldBoolean) {
		this.projectOldBoolean = projectOldBoolean;
	}

	public boolean isEquipmentOldBoolean() {
		return equipmentOldBoolean;
	}

	public void setEquipmentOldBoolean(boolean equipmentOldBoolean) {
		this.equipmentOldBoolean = equipmentOldBoolean;
	}

	public boolean isMonitor1OldBoolean() {
		return monitor1OldBoolean;
	}

	public void setMonitor1OldBoolean(boolean monitor1OldBoolean) {
		this.monitor1OldBoolean = monitor1OldBoolean;
	}

	public boolean isMonitor2OldBoolean() {
		return monitor2OldBoolean;
	}

	public void setMonitor2OldBoolean(boolean monitor2OldBoolean) {
		this.monitor2OldBoolean = monitor2OldBoolean;
	}

	public String getChangesWorkPositionOld() {
		return changesWorkPositionOld;
	}

	public void setChangesWorkPositionOld(String changesWorkPositionOld) {
		this.changesWorkPositionOld = changesWorkPositionOld;
	}

	public String getChangesUserOld() {
		return changesUserOld;
	}

	public void setChangesUserOld(String changesUserOld) {
		this.changesUserOld = changesUserOld;
	}

	public String getChangesProjectOld() {
		return changesProjectOld;
	}

	public void setChangesProjectOld(String changesProjectOld) {
		this.changesProjectOld = changesProjectOld;
	}

	public String getChangesEquipmentOld() {
		return changesEquipmentOld;
	}

	public void setChangesEquipmentOld(String changesEquipmentOld) {
		this.changesEquipmentOld = changesEquipmentOld;
	}

	public String getChangesMonitor1Old() {
		return changesMonitor1Old;
	}

	public void setChangesMonitor1Old(String changesMonitor1Old) {
		this.changesMonitor1Old = changesMonitor1Old;
	}

	public String getChangesMonitor2Old() {
		return changesMonitor2Old;
	}

	public void setChangesMonitor2Old(String changesMonitor2Old) {
		this.changesMonitor2Old = changesMonitor2Old;
	}

	public Inventory getInventoryNew() {
		return inventoryNew;
	}

	public void setInventoryNew(Inventory inventoryNew) {
		this.inventoryNew = inventoryNew;
	}

	public Inventory getInventoryOld() {
		return inventoryOld;
	}

	public void setInventoryOld(Inventory inventoryOld) {
		this.inventoryOld = inventoryOld;
	}
}
