package rseg105.project2.part2.models;


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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@NamedQueries({
		@NamedQuery(name = "Book.findAll", query = "select distinct b from Book b left join fetch b.authors a left join fetch b.category"),
		@NamedQuery(name = "Book.findById", query = "select distinct b from Book b left join fetch b.authors a left join fetch b.category where b.id = :id") })
@SqlResultSetMapping(name = "bookResult", entities = @EntityResult(entityClass = Book.class))
public class Book {

	private int id;
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
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "Book: { ID:" + this.id + ", Title: " + this.title + "} ";
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

	@ManyToOne(cascade = CascadeType.MERGE )
	@JoinColumn(name = "CATEGORY_ID")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
