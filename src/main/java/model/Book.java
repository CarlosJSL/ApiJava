package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "book", schema = "public")
public class Book {

	@Id
	@SequenceGenerator(name = "book_seq", sequenceName = "publilc.book_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "book_seq", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String titulo;
	private String descrição;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

}
