package model.entities;

import java.util.Date;

public class Option {

	private Integer idOption;
	private String option;
	private String type;
	private String statusOption;
	private Date dateEntry;
	
	public Option() {
	}
	
	public Integer getIdOption() {
		return idOption;
	}

	public void setIdOption(Integer idOption) {
		this.idOption = idOption;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatusOption() {
		return statusOption;
	}

	public void setStatusOption(String statusOption) {
		this.statusOption = statusOption;
	}

	public Date getDateEntry() {
		return dateEntry;
	}

	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}

	@Override
	public String toString() {
		return option;
	}
}
