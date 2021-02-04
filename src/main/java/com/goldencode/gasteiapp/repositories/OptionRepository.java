package com.goldencode.gasteiapp.repositories;

import com.goldencode.gasteiapp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Category, Integer> { }
