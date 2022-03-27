package com.produtos.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.service.ProdutoService;

@RestController
@RequestMapping(value = "produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/lista")
	public ResponseEntity<List<Produto>> listaProduto() {
		return ResponseEntity.ok().body(produtoService.listaProdutos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> BuscarPorId(@PathVariable Long id) {
		Produto produto = produtoService.BuscarPorId(id);
		return ResponseEntity.ok().body(produto);
	}

	@PostMapping(value = "/produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoService.salvarProduto(produto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> editar(@RequestBody Produto produto) {
		produtoService.salvarProduto(produto);
		return ResponseEntity.noContent().build();
	}
}
