package com.produtos.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@ApiOperation(value="Retorno de uma lista de produtos")
	@GetMapping(value = "/lista")
	public ResponseEntity<List<Produto>> listaProduto() {
		return ResponseEntity.ok().body(produtoService.listaProdutos());
	}

	@ApiOperation(value="Retorno de um produto por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> BuscarPorId(@PathVariable Long id) {
		Produto produto = produtoService.BuscarPorId(id);
		return ResponseEntity.ok().body(produto);
	}

	@ApiOperation(value="Adiciona um produto")
	@PostMapping(value = "/produto")	
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoService.salvarProduto(produto);
	}

	@ApiOperation(value="Deleta um produto")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Edita um produto")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> editar(@RequestBody Produto produto) {
		produtoService.salvarProduto(produto);
		return ResponseEntity.noContent().build();
	}
}
