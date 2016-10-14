package sample;

import java.util.HashSet;
import java.util.Set;

public class User {
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	protected long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public Set getPhoneNumbers() {
		return phoneNumbers;
	}

	void setPhoneNumbers(Set phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	private long id;
	private String name;
	private String password;
	private Set phoneNumbers = new HashSet();
}
