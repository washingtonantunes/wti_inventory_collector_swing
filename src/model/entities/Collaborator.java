package model.entities;

public class Collaborator {

	private String name;
	private Integer registration;
	private String password;
	private Integer privilege;
	private String office;
	
	public Collaborator() {
	}
	
	public Collaborator(String name, Integer registration, String password, Integer privilege, String office) {
		this.name = name;
		this.registration = registration;
		this.password = password;
		this.privilege = privilege;
		this.office = office;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRegistration() {
		return registration;
	}

	public void setRegistration(Integer registration) {
		this.registration = registration;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Integer privilege) {
		this.privilege = privilege;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
