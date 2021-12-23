package model.entities;

public class Option {

	private String option;
	private String type;
	
	public Option() {
	}
	
	public Option(String option, String type) {
		this.option = option;
		this.type = type;
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
}
