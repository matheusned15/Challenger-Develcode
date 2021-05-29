package br.com.hrworker.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Usuario extends BaseEntity{
	
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String codigo;
	
	@NotNull
	private String nome;
	
//	@NotNull
//	private String dataDeNascimento;
	
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String dataNascimento;
	
	private String image;
	
}
