package model.entities;

import java.util.Date;

public class Monitor {

	private String serialNumberMonitor;
	private String modelMonitor;
	private String patrimonyNumberMonitor;
	private String statusMonitor;
	private Date dateEntry;

	public Monitor() {
	}

	public Monitor(String serialNumberMonitor) {
		this.serialNumberMonitor = serialNumberMonitor;
	}

	public String getModelMonitor() {
		return modelMonitor;
	}

	public void setModelMonitor(String modelMonitor) {
		this.modelMonitor = modelMonitor;
	}

	public String getSerialNumberMonitor() {
		return serialNumberMonitor;
	}

	public void setSerialNumberMonitor(String serialNumberMonitor) {
		this.serialNumberMonitor = serialNumberMonitor;
	}

	public String getPatrimonyNumberMonitor() {
		return patrimonyNumberMonitor;
	}

	public void setPatrimonyNumberMonitor(String patrimonyNumberMonitor) {
		this.patrimonyNumberMonitor = patrimonyNumberMonitor;
	}
	
	public String getStatusMonitor() {
		return statusMonitor;
	}

	public void setStatusMonitor(String statusMonitor) {
		this.statusMonitor = statusMonitor;
	}

	public Date getDateEntry() {
		return dateEntry;
	}

	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}
	
	@Override
	public String toString() {
		return serialNumberMonitor;
	}
}
