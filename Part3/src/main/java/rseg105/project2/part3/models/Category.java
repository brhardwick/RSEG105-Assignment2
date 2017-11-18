package rseg105.project2.part3.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // means Contact is a mapped entity class
@Table(name = "category")
@NamedQueries({ @NamedQuery(name = "Category.getById", query = "select c from Category c where c.id = :id") })
public class Category {

	private int id;

	private String name;
	private Set<Book> books = new HashSet<Book>();

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString()
	{
		return "Category: { ID:"+this.id + ", Name: " + this.name + "} "; 
	}

	 @OneToMany(mappedBy = "category", cascade=CascadeType.ALL, 
		        orphanRemoval=true)
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
