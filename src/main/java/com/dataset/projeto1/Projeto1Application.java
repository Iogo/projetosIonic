package com.dataset.projeto1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dataset.projeto1.domain.Categoria;
import com.dataset.projeto1.domain.Cidade;
import com.dataset.projeto1.domain.Estado;
import com.dataset.projeto1.domain.Produto;
import com.dataset.projeto1.repositories.CategoriaRepository;
import com.dataset.projeto1.repositories.CidadeRepository;
import com.dataset.projeto1.repositories.EstadoRepository;
import com.dataset.projeto1.repositories.ProdutoRepository;

@SpringBootApplication
public class Projeto1Application implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
		
	public static void main(String[] args) {
		SpringApplication.run(Projeto1Application.class, args);
	}
	
	
	@Override
	public void run(String... args)throws Exception{
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Deposito");
		
		Produto p1 = new Produto(null,"Computador",2000);
		Produto p2 = new Produto(null,"Impressora",800);
		Produto p3 = new Produto(null,"Mouse",80);
		
		Estado est1  = new Estado(null,"Minas Gerais");
		Estado est2  = new Estado(null,"Sao Paulo");
		
		Cidade c1    = new Cidade(null,"Uberlandia",est1);
		Cidade c2    = new Cidade(null,"Sao Paulo",est2);
		Cidade c3    = new Cidade(null,"Campinas",est2);
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
	}
}
