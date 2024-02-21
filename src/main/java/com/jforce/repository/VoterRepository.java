package com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jforce.model.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, String> {

}
