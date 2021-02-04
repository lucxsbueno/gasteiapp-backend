package com.goldencode.gasteiapp.repositories;

import com.goldencode.gasteiapp.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Integer> { }
