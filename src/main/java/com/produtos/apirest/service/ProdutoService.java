package com.produtos.apirest.service;

import java.util.List;

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

	public Produto getProduto(Long id) {
		Produto produto = null;
		if (id == null || id == 0L)
			System.out.println("Id do usuário deve ser informado");
		produto = produtoRepository.getById(id);
		if (produto == null) {
			System.out.println("Usuário não encontrado.");
		}
		return produto;
	}
	
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
