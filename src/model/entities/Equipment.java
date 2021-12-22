package model.entities;

import java.util.Date;

public class Equipment {

	private String serialNumber;
	private String hostName;
	private String addressMAC;
	private String typeEquipment;
	private String patrimonyNumberEquipment;
	private String brandEquipment;
	private String modelEquipment;
	private String memoryRam;
	private String hardDisk;
	private String costType;
	private Double valueEquipment;
	private String statusEquipment;
	private Date dateEntry;

	public Equipment() {
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getAddressMAC() {
		return addressMAC;
	}

	public void setAddressMAC(String addressMAC) {
		this.addressMAC = addressMAC;
	}

	public String getTypeEquipment() {
		return typeEquipment;
	}

	public void setTypeEquipment(String typeEquipment) {
		this.typeEquipment = typeEquipment;
	}

	public String getPatrimonyNumberEquipment() {
		return patrimonyNumberEquipment;
	}

	public void setPatrimonyNumberEquipment(String patrimonyNumberEquipment) {
		this.patrimonyNumberEquipment = patrimonyNumberEquipment;
	}

	public String getBrandEquipment() {
		return brandEquipment;
	}

	public void setBrandEquipment(String brandEquipment) {
		this.brandEquipment = brandEquipment;
	}

	public String getModelEquipment() {
		return modelEquipment;
	}

	public void setModelEquipment(String modelEquipment) {
		this.modelEquipment = modelEquipment;
	}

	public String getMemoryRam() {
		return memoryRam;
	}

	public void setMemoryRam(String memoryRam) {
		this.memoryRam = memoryRam;
	}

	public String getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	public Double getValueEquipment() {
		return valueEquipment;
	}

	public void setValueEquipment(Double valueEquipment) {
		this.valueEquipment = valueEquipment;
	}

	public String getStatusEquipment() {
		return statusEquipment;
	}

	public void setStatusEquipment(String statusEquipment) {
		this.statusEquipment = statusEquipment;
	}

	public Date getDateEntry() {
		return dateEntry;
	}

	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}

	@Override
	public String toString() {
		return serialNumber;
	}

}
