package com.produtos.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.service.ProdutoService;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/produtos")
	public ResponseEntity<List<Produto>> listaProduto() {
		return ResponseEntity.ok().body(produtoService.listaProdutos());
	}

	@GetMapping(value = "/produto/{id}")
	public Produto BuscarPorId(@PathVariable Long id) {
		return produtoService.getProduto(id);
	}
	
	@PostMapping("/produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoService.salvarProduto(produto);
	}
}
