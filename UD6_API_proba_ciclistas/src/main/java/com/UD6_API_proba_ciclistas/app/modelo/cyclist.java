package com.UD6_API_proba_ciclistas.app.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class cyclist implements Serializable{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	@Column(name="first_name")

	private String firstName;


	@Column(name="last_name")

	private String lastName;


	@Column(name="birth_date")

	@DateTimeFormat (pattern = "yyyy-MM-dd")

	private LocalDate birthDate;


	private String nationality;
}
