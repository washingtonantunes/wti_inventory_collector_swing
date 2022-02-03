package services;

import model.entities.InventoryUtil;

public class InventoryService {

	public static InventoryUtil getInventoryUtilNew(InventoryUtil inventoryUtil) {		
		if (inventoryUtil.getInventoryNew().getWorkPosition() != null && !inventoryUtil.getInventoryNew().getWorkPosition().getWorkPoint().equals("HOME-OFFICE")) {
			inventoryUtil.setWorkPositionNewBoolean(true);
		}
		if (inventoryUtil.getInventoryNew().getUser() != null) {
			inventoryUtil.setUserNewBoolean(true);
		}
		if (inventoryUtil.getInventoryNew().getProject() != null) {
			inventoryUtil.setProjectNewBoolean(true);
		}
		if (inventoryUtil.getInventoryNew().getEquipment() != null) {
			inventoryUtil.setEquipmentNewBoolean(true);
		}
		
		// Monitor1
		if (inventoryUtil.getInventoryNew().getMonitor1() != null) {
			inventoryUtil.setMonitor1NewBoolean(true);
		}
		if (inventoryUtil.getInventoryNew().getMonitor2() != null) {
			inventoryUtil.setMonitor2NewBoolean(true);
		}
		inventoryUtil = getChangesInventoryNew(inventoryUtil);
		
		return inventoryUtil;
	}
	
	private static InventoryUtil getChangesInventoryNew(InventoryUtil inventoryUtil) {

		// Equipment
		if (inventoryUtil.getInventoryNew().getWorkPosition() != null
				&& !inventoryUtil.getInventoryNew().getWorkPosition().getWorkPoint().equals("HOME-OFFICE")) {
			inventoryUtil.setChangesEquipmentNew("Equipamento alocado na posição: "
					+ inventoryUtil.getInventoryNew().getWorkPosition().getWorkPoint());
		} else if (inventoryUtil.getInventoryNew().getUser() != null) {
			inventoryUtil.setChangesEquipmentNew(
					"Equipamento entregue ao usuário: " + inventoryUtil.getInventoryNew().getUser().getNameUser());
		}

		// Monitor1
		if (inventoryUtil.getInventoryNew().getWorkPosition() != null
				&& !inventoryUtil.getInventoryNew().getWorkPosition().getWorkPoint().equals("HOME-OFFICE")) {
			inventoryUtil.setChangesMonitor1New(
					"Monitor alocado na posição: " + inventoryUtil.getInventoryNew().getWorkPosition().getWorkPoint());

		} else if (inventoryUtil.getInventoryNew().getUser() != null) {
			inventoryUtil.setChangesMonitor1New(
					"Monitor entregue ao usuário: " + inventoryUtil.getInventoryNew().getUser().getNameUser());
		}

		// Monitor2
		if (inventoryUtil.getInventoryNew().getWorkPosition() != null
				&& !inventoryUtil.getInventoryNew().getWorkPosition().getWorkPoint().equals("HOME-OFFICE")) {

			inventoryUtil.setChangesMonitor2New(
					"Monitor alocado na posição: " + inventoryUtil.getInventoryNew().getWorkPosition().getWorkPoint());
		} else if (inventoryUtil.getInventoryNew().getUser() != null) {
			inventoryUtil.setChangesMonitor2New(
					"Monitor entregue ao usuário: " + inventoryUtil.getInventoryNew().getUser().getNameUser());
		}

		// WorkPosition
		if (inventoryUtil.getInventoryNew().getWorkPosition() != null) {
			if (!inventoryUtil.getInventoryNew().getWorkPosition().getWorkPoint().equals("HOME-OFFICE")) {
				inventoryUtil.setChangesWorkPositionNew("Posição ocupada pelo equipamento: "
						+ inventoryUtil.getInventoryNew().getEquipment().getSerialNumber());
			}
		}

		return inventoryUtil;
	}
}
