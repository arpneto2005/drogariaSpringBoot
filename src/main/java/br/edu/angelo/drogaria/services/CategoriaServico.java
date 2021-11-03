package br.edu.angelo.drogaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.angelo.drogaria.domain.Categoria;
import br.edu.angelo.drogaria.exception.RecursoNaoEncontradoException;
import br.edu.angelo.drogaria.repositorio.CategoriaRepositorio;

/* Notação Spring para classes de Serviços */
@Service
public class CategoriaServico {
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	public Categoria buscarPorCodigo(Short codigo) {
		Optional<Categoria> resultado = categoriaRepositorio.findById(codigo);
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		Categoria categoria = resultado.get();
		return categoria;
	}
	
	public List<Categoria> listar(){
		List<Categoria> resultado = categoriaRepositorio.findAll();
		return resultado;
	}
}
