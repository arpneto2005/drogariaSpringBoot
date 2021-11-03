package br.edu.angelo.drogaria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Notrações para criação de métodos pelo lombok construtores, gets e sets*/
@Data
@NoArgsConstructor
@AllArgsConstructor
/* Notaçõa para dizer que a classe é uma entidade do banco */
@Entity
public class Produto {
	/* Notação para informar a chave primária, e demais propriedades de tabela */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Column(length = 50, nullable = false, unique = true)
	private String nomeProduto;
	@Column(nullable = false)
	private Byte quantidade;
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal preco;
	@Column
	private LocalDate dataValidade;
	/* Criando relações entre tabelas */
	/* Notação para relacionamento 1 para muitos */
	@ManyToOne
	@JoinColumn(nullable = false)
	private Categoria categoria;
}
