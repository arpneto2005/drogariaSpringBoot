package br.edu.angelo.drogaria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTestes {
	
	@Test
	public void criar() {
		Produto p = new Produto(
				Integer.valueOf("1"), 
				"Cerveja Duff", 
				Byte.valueOf("15"), 
				BigDecimal.valueOf(10.50),
				LocalDate.of(2021, 11, 23),
				null
				);
		System.out.println(p);
	}
}
