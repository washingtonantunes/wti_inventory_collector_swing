package model.entities;

public class Collaborator {

	private String name;
	private String registration;
	private String password;
	private String privilege;
	private String office;
	
	public Collaborator() {
	}
	
	public Collaborator(String name, String registration, String password, String privilege, String office) {
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

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
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
