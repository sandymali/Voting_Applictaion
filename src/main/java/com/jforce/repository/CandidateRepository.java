package com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jforce.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {

}
