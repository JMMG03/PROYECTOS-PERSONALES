package org.example.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Estudiantes", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private int id;

	@Column(name = "NOMBRE", length = 20, nullable = true)
	private String nombre;

	@Column(name = "NOTA", nullable = true)
	private Double nota;

	@Column(name = "CREATED_AT", nullable = true)
	private Date createdAt;

	public Estudiante() {
	}

	public Estudiante(String name, Double note, Date createdAt) {
		this.nombre = name;
		this.nota = note;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String name) {
		this.nombre = name;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double note) {
		this.nota = note;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Estudiante cuyo id es: " + id + ", se llama " + nombre + " y tiene una nota de " + nota + ", creada el " + createdAt + ".";
	}
}
