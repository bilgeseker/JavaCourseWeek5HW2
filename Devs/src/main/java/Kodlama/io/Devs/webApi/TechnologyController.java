package Kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.GetTechnologyByIdRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import Kodlama.io.Devs.business.responses.GetTechnologyByIdResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
private TechnologyService techService;
	
	@Autowired
	public TechnologyController(TechnologyService techService) {
		super();
		this.techService = techService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll(){
		return techService.getAll();
	}
	
	@GetMapping("/getById")
	public GetTechnologyByIdResponse getById(GetTechnologyByIdRequest getTech) throws Exception{
		return techService.getById(getTech);
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest addTech) throws Exception{
		techService.add(addTech);
	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyRequest updateTech) throws Exception{
		techService.update(updateTech);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest delTech) throws Exception{
		techService.delete(delTech);
	}
}
