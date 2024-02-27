package edu.unc.academico.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Generar ID automático
	private Long idDpto;
	@Column(unique = true) // Evitar valores repetidos
	private String nombreDpto;
	@OneToMany(mappedBy = "departamento") //Relación uno a muchos
	@JsonManagedReference
	private List<Investigador> investigadores = new ArrayList<>();

}
