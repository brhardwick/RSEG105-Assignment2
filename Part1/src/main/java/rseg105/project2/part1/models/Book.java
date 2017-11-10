package rseg105.project2.part1.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Version;

import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity 
@Table(name = "book")
@NamedQueries({ @NamedQuery(name = "Book.getAll", query = "from Book") })
public class Book {

	private int id;
	private int category_id;
	private String title;
	private Set<Author> authors = new HashSet<Author>();
	private Category category;

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "Book: { ID:"+this.id + ", Title: " + this.title + "} "; 
	}

	@Column(name = "category_id")
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	  @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	    @JoinTable(name = "author_book",
	        joinColumns = @JoinColumn(name = "BOOK_ID"),
	        inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
	public Set<Author> getAuthors() {
		return authors;
	}
	  
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	 @ManyToOne
	 @JoinColumn(name = "CATEGORY_ID")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	}
