//package htw.berlin.webtech.demo.api;
//
//import htw.berlin.webtech.demo.persistence.BestellungEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//public class Controller {
//
//	@Autowired
//	private BestellungRepository bestellungRepository;
//	@Autowired
//	private BestellungService bestellungService;
//	@Autowired
//	private BestellungServiceImp bestellungServiceImp;


//	@GetMapping("/homepage")
//	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//		model.addAttribute("name", name);
//		return "homepage";
//	}

//	@GetMapping("/bestellungs")
//	public List<BestellungEntity> allbestellung() {
//		return bestellungRepository.findAll();
//	}

//	@PostMapping("/bestellungs")
//	public BestellungEntity createBestellung(@RequestBody BestellungEntity bestellung) {
//		return bestellungServiceImp.save(bestellung);
//	}

//	@PostMapping("/bestellungs/{id}")
//	public RedirectView delete(@PathVariable int id) {
//		bestellungServiceImp.deleteById(id);
//		return new RedirectView("/listbestellungs");
//	}

//}
