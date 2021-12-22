package model.entities;

import java.util.Date;

public class WorkPosition {

	private String workPoint;
	private String location;
	private String floors;
	private String netPoint;
	private String statusWorkPoint;
	private Date dateEntry;
	private String reason;
	private Integer idChange;

	public WorkPosition() {
	}

	public String getWorkPoint() {
		return workPoint;
	}

	public void setWorkPoint(String workPoint) {
		this.workPoint = workPoint;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFloors() {
		return floors;
	}

	public void setFloors(String floors) {
		this.floors = floors;
	}

	public String getNetPoint() {
		return netPoint;
	}

	public void setNetPoint(String netPoint) {
		this.netPoint = netPoint;
	}

	public String getStatusWorkPoint() {
		return statusWorkPoint;
	}

	public void setStatusWorkPoint(String statusWorkPoint) {
		this.statusWorkPoint = statusWorkPoint;
	}

	public Date getDateEntry() {
		return dateEntry;
	}

	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getIdChange() {
		return idChange;
	}

	public void setIdChange(Integer idChange) {
		this.idChange = idChange;
	}

	@Override
	public String toString() {
		return workPoint;
	}
}
