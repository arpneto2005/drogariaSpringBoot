package br.edu.angelo.drogaria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.angelo.drogaria.domain.Produto;

/* Informar a classe que vai ser heradada e o tipo da chave primária */
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

}
