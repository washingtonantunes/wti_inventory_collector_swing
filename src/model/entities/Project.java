package model.entities;

import java.util.Date;

public class Project {

	private String nameProject;
	private String locality;
	private String costCenter;
	private String department;
	private String statusProject;
	private Date dateEntry;

	public Project() {
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatusProject() {
		return statusProject;
	}

	public void setStatusProject(String statusProject) {
		this.statusProject = statusProject;
	}

	public Date getDateEntry() {
		return dateEntry;
	}

	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}

	@Override
	public String toString() {
		return nameProject;
	}
}
