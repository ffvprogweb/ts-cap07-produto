package com.fatec.produto.persistencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.produto.model.IProdutoRepository;
import com.fatec.produto.model.Produto;
@SpringBootTest
class Req01CadastrarProdutoDDTests {

	@Autowired
	IProdutoRepository repository;
	@ParameterizedTest
	@CsvSource({
		"Eletrobomba 110V para Maquina de Lavar e Lava Louças, maquina de lavar, 51.66, 12, Sucesso",
		
	})
	

	void leDados(String descricao, String categoria, String custo, String quant, String re) {
		try {
			Produto produto1 = new Produto(descricao, categoria,custo,quant);
			Produto p = repository.save(produto1);
			assertTrue(produto1.equals(p));
		}catch(Exception e){
			assertEquals(re,e.getMessage());
		}
	}

}
