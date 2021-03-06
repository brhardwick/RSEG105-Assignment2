package rseg105.project2.part1.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // means Contact is a mapped entity class
@Table(name = "author")
public class Author {

	private String firstname;
	private String lastname;
	private String description;
	private int id;

	public String toString()
	{
		return "Author: { ID:" + this.id + ", First Name: " + this.firstname + ", Last Name: "+ this.lastname + "} "; 
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "LAST_NAME")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = IDENTITY) 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
