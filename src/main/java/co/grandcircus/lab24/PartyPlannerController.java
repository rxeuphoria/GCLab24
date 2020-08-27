package co.grandcircus.lab24;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.lab24.entity.Party;
import co.grandcircus.lab24.entity.PartyOption;
import co.grandcircus.lab24.entity.Rsvp;

@Controller
public class PartyPlannerController {
	
	@Autowired
	private PartyPlannerRepository dao;
	
	@Autowired
	private PartyOptionRepository optionDao;
	
	@Autowired 
	private RsvpRepository rsvpDao;

	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("parties", dao.findAll());
		return "homepage";
	}
	
	@RequestMapping("/delete")
	public String deleteEntry(@RequestParam("id") Long id, Model model) {
		dao.deleteById(id);
		return "redirect:/";
	}
	
	@RequestMapping("/vote")
	public String showVotes(Model model) {
		model.addAttribute("party_options", optionDao.findAll());
		return "vote";
	}
	
	//TODO need to modify "/review" to not show items with 0 votes.
	@RequestMapping("/review")
	public String showReview(Model model) {
		model.addAttribute("party_options", optionDao.findAll(Sort.by(Direction.DESC, "votes")));
		return "review";
	}
	
	@RequestMapping("/addVote")
	public String addVote(@RequestParam("id") Long id) {
		PartyOption pizza = optionDao.findById(id).orElse(null);
		pizza.setVotes(pizza.getVotes()+1);
		optionDao.save(pizza);
		return "redirect:/vote";
	}
	
	@PostMapping("/addPizza")
	public String addPizza(PartyOption pizza) {
		optionDao.save(pizza);
		return "redirect:/vote";
	}
	
	@PostMapping("/addRsvp")
	public String addRsvp(Rsvp person) {
		rsvpDao.save(person);
		return "redirect:/";
	}
	
	@RequestMapping("/details")
	public String showDetails(@RequestParam("id") Long id, Party party, Model model) {
		Party party1 = dao.findById(id).orElse(null);
		//TODO need to fix the list problem
		
	
		model.addAttribute("party", party1);
		System.out.println(party1);
		
		return "details";
	}
	
	
	
	
	
	
	
}
