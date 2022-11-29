package Kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.GetLanguageByIdRequest;
import Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.GetLanguageByIdResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getById")
	public GetLanguageByIdResponse getById(GetLanguageByIdRequest getLanguage) throws Exception{
		return languageService.getById(getLanguage);
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest addLanguage) throws Exception{
		languageService.add(addLanguage);
	}
	
	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguage) throws Exception{
		languageService.update(updateLanguage);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest delLanguage) throws Exception{
		languageService.delete(delLanguage);
	}
}
