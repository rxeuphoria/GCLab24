package co.grandcircus.lab24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.lab24.entity.PartyOption;

@Controller
public class PartyPlannerController {
	
	@Autowired
	private PartyPlannerRepository dao;
	
	@Autowired
	private PartyOptionRepository optionDao;

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
	
	
	
	
	
	
}
