
package com.jforce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jforce.model.Candidate;
import com.jforce.model.Voter;
import com.jforce.repository.CandidateRepository;
import com.jforce.repository.VoterRepository;

@Service
public class VoterService {

	@Autowired
	private VoterRepository repo;
	@Autowired
	private CandidateRepository crepo;

	public Voter getData(String uname) {
		Optional<Voter> opt = repo.findById(uname);
		return opt.get();

	}

	public void saveData(Voter v) {
		repo.save(v);
	}

	public void saveCandidate(Candidate c) {
		crepo.save(c);

	}

	public Candidate getCandidate(String voteTo) {
		Optional<Candidate> opt = crepo.findById(voteTo);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return new Candidate();
		}
	}

	public List<Candidate> getAllCandidates() {

		return crepo.findAll();
	}

}
