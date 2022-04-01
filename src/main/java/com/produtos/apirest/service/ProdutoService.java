package com.produtos.apirest.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	public Produto BuscarPorId(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException(id, "Objeto não encontrado"));
	}
	
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	/*public void delete (@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}*/

	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
	
}
