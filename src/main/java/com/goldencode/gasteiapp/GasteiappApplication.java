package com.goldencode.gasteiapp;

import com.goldencode.gasteiapp.domain.Category;
import com.goldencode.gasteiapp.domain.Entry;
import com.goldencode.gasteiapp.domain.Option;
import com.goldencode.gasteiapp.domain.User;
import com.goldencode.gasteiapp.repositories.CategoryRepository;
import com.goldencode.gasteiapp.repositories.EntryRepository;
import com.goldencode.gasteiapp.repositories.OptionRepository;
import com.goldencode.gasteiapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class GasteiappApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private OptionRepository optionRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EntryRepository entryRepository;

	public static void main(String[] args) {
		SpringApplication.run(GasteiappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User(null, "Lucas Bueno", "lucxsbueno@gmail.com", "1234");

		Category cat1 = new Category(null, "Mercado");
		Category cat2 = new Category(null, "Farmácia");
		Category cat3 = new Category(null, "Padaria");

		Entry entry1 = new Entry(null, user, cat1, Option.SPENT, 124.40, "20/11/2021", false);
		Entry entry2 = new Entry(null, user, cat3, Option.SPENT, 35.72, "20/11/2021", false);
		Entry entry3 = new Entry(null, user, cat2, Option.SPENT, 16.0, "21/11/2021", false);
		Entry entry4 = new Entry(null, user, Option.GAIN, 60.5, "21/11/2021", true);
		Entry entry5 = new Entry(null, user, Option.GAIN, 45.7, "21/11/2021", true);
		Entry entry6 = new Entry(null, user, Option.GAIN, 247.05, "21/11/2021", true);

		user.getEntry().addAll(Arrays.asList(entry1, entry2, entry3, entry4, entry5, entry6));

		cat1.setEntry(entry1);
		cat3.setEntry(entry2);
		cat2.setEntry(entry3);

		userRepository.saveAll(Arrays.asList(user));

		entryRepository.saveAll(Arrays.asList(entry1, entry2, entry3, entry4, entry5, entry6));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

	}

}
