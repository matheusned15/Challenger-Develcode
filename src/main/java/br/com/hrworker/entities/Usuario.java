package br.com.hrworker.entities;

import javax.persistence.Entity;

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
public class Usuario extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String nome;

	@NotNull
	private String dataNascimento;

	private String image;

}
