package com.dataset.projeto1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dataset.projeto1.domain.Categoria;
import com.dataset.projeto1.repositories.CategoriaRepository;

@SpringBootApplication
public class Projeto1Application implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Projeto1Application.class, args);
	}
	
	
	@Override
	public void run(String... args)throws Exception{
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Deposito");
		
		categoriaRepository.save(Arrays.asList(cat1,cat2));
	}
}
