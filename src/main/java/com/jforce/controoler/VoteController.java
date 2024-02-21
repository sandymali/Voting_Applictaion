package com.jforce.controoler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jforce.model.Candidate;
import com.jforce.model.Voter;
import com.jforce.service.VoterService;

@Controller
public class VoteController {

	@Autowired
	private VoterService service;

	@RequestMapping("/")
	public String LandingPage() {
		return "index";
	}

	@RequestMapping("/login")
	public String LoginPage(@RequestParam String uname, @RequestParam String pass, Model model) {

		Voter v = service.getData(uname);
		if (v != null) {
			if (v.getPass().equals(pass)) {
				return "success";
			} else {
				return "index";
			}
		} else {
			return "index";
		}

	}

	@RequestMapping("/register")
	public String RegisterPage() {
		return "register";
	}

	@RequestMapping("/reg")
	public String Reg(@ModelAttribute Voter v) {
		service.saveData(v);
		return "index";
	}

	@RequestMapping("/AdminLoginPage")
	public String AdminPage() {
		return "AdminLoginPage";
	}

	@RequestMapping("/Admin")
	public String AdminLogin(@RequestParam String uname, @RequestParam String pass, Model model) {
		if (uname.equals("Admin") && pass.equals("Admin@123")) {
			List<Candidate> list = service.getAllCandidates();
			for (Candidate c : list) {
				System.out.println("Name: " + c.getName());
				System.out.println("Count: " + c.getCount());
			}
			model.addAttribute("candidate", list);
			return "AdminHome";
		} else {

			return "index";
		}
	}

	@RequestMapping("/vote")
	public String voteTo(@RequestParam String voteTo, @RequestParam String uname) {
//			System.out.println(voteTo);
//			System.out.println("uname");
		Voter v = service.getData(uname);
		if (v.getVoteTo() == null) {
			Candidate c = service.getCandidate(voteTo);
			c.setCount(c.getCount() + 1);
			c.setName(voteTo);
			service.saveCandidate(c);
			v.setVoteTo(voteTo);
			service.saveData(v);
			return "index";
		} else {
			return "fail";
		}

	}

	@RequestMapping("/logout")
	public String Logout() {
		return "index";
	}

}
