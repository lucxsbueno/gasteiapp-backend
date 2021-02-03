package com.goldencode.gasteiapp;

import com.goldencode.gasteiapp.domain.Category;
import com.goldencode.gasteiapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class GasteiappApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(GasteiappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Mercado");
		Category cat2 = new Category(null, "Farmácia");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));

	}

}
