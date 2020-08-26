package co.grandcircus.lab24.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Party {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name="id")
	private Long id;
	private String name;
	private LocalDate date;
	
	
	public Party(Long id, String name, LocalDate date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	
	public Party() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Party [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

	
}
