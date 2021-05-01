package net.codejava.model;

import javax.persistence.Id;

public class Client {
	
	private String clientName;

	@Id
	private String email;
	
	private int clientid;

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	@Override
	public String toString() {
		return "Client [clientName=" + clientName + ", email=" + email + ", clientid=" + clientid + "]";
	}
}
