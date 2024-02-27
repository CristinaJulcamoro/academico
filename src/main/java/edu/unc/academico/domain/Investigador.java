package edu.unc.academico.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Investigador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInvestigador;
	@Column(unique = true)
	private String email;
	private String nombres;
	private String apePat;
	private String apeMat;
	@Temporal(TemporalType.DATE) //Dato tipo fecha
	private Date fechaNac;
	@ManyToOne //Relacion de muchos a uno
	@JsonBackReference
	private Departamento departamento;
}
