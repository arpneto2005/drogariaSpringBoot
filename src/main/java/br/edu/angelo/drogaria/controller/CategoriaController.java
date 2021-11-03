package br.edu.angelo.drogaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.edu.angelo.drogaria.domain.Categoria;
import br.edu.angelo.drogaria.exception.RecursoNaoEncontradoException;
import br.edu.angelo.drogaria.repositorio.CategoriaRepositorio;
import br.edu.angelo.drogaria.services.CategoriaServico;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	/* Notação para injetar instâncias */
	@Autowired
	private CategoriaServico categoriaServico;
	private CategoriaRepositorio categoriaRepositorio;
	
	/* Notação para  */
	@GetMapping
	public List<Categoria> listar(){
		List<Categoria> categorias = categoriaServico.listar();
		//System.out.println("Categorias: " + categorias);
		return categorias;
	}
	
	/* Buscar por código */
	@GetMapping("/{codigo}")
	public Categoria buscarPorCodigo (@PathVariable Short codigo) {
		try {
			Categoria categoria = categoriaServico.buscarPorCodigo(codigo);
			return categoria;
		} catch(RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não Encontrada", excecao);
		}
	}
	
	@PostMapping
	public Categoria inserir(@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaRepositorio.save(categoria);
		return categoriaSalva;
	}
	
	@DeleteMapping("/{codigo}")
	public Categoria excluir(@PathVariable Short codigo) {
		Optional<Categoria> categoria = categoriaRepositorio.findById(codigo);
		categoriaRepositorio.delete(categoria.get());
		Categoria categoriaRetorno = categoria.get();
		return categoriaRetorno;
	}
	
	@PutMapping
	public Categoria editar(@RequestBody Categoria categoria) {
		/* É usado o mesmo método save do inserir, a diferença é o ID se existir ele salva, se não altera */ 
		Categoria categoriaEditada = categoriaRepositorio.save(categoria);
		return categoriaEditada; 
	}

}
