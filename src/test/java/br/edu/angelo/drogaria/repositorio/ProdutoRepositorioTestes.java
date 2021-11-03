package br.edu.angelo.drogaria.repositorio;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.angelo.drogaria.domain.Produto;

@SpringBootTest
public class ProdutoRepositorioTestes {
	/* Notação para gerenciamento de objetos */
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Test
	public void inserir() {
		Produto p1 = new Produto(
			null, 
			"Sorvete Pardal 2l", 
			Byte.valueOf("20"), 
			BigDecimal.valueOf(15.00),
			LocalDate.of(2024, 10, 01),
			null
		);
		Produto p2 = new Produto(
			null, 
			"Fraudas Hubbies 72un", 
			Byte.valueOf("30"), 
			BigDecimal.valueOf(80.00),
			LocalDate.of(2021, 11, 23),
			null
		);
		produtoRepositorio.save(p1);
		produtoRepositorio.save(p2);
	}

}
