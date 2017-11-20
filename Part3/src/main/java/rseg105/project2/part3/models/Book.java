package rseg105.project2.part3.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@SqlResultSetMapping(name = "bookResult", entities = @EntityResult(entityClass = Book.class))
public class Book {

	private Long id;
	private String title;
	private String isbn;
	private double price;
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
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		return "Book: { ID:" + this.id + ", Title: " + this.title + ", Price: " + this.price + ", ISBN: "+this.isbn + "} ";
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "BOOK_ID"), inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public void addAuthor(Author Author) {
		getAuthors().add(Author);
	}

	public void removeAuthor(Author Author) {
		getAuthors().remove(Author);
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "CATEGORY_ID")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "isbn")
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

}
