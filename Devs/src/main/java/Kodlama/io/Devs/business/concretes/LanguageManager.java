package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.GetLanguageByIdRequest;
import Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.GetLanguageByIdResponse;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<ProgrammingLanguage> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languageResponse = new ArrayList<GetAllLanguagesResponse>();
		for(ProgrammingLanguage language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languageResponse.add(responseItem);
		}
		return languageResponse;
	}

	@Override
	public GetLanguageByIdResponse getById(GetLanguageByIdRequest getLanguage) throws Exception {
		List<ProgrammingLanguage> languages = languageRepository.findAll();
		GetLanguageByIdResponse responseItem = new GetLanguageByIdResponse();
		for(ProgrammingLanguage language : languages)
		{
			if(getLanguage.getId() == language.getId())
			{
				responseItem.setName(language.getName());
				break;
			}
		}
		return responseItem;
	}

	@Override
	public void add(CreateLanguageRequest createLanguage) throws Exception {
		ProgrammingLanguage language = new ProgrammingLanguage();
		List<ProgrammingLanguage> languages = languageRepository.findAll();
		for(ProgrammingLanguage langName : languages) {
			if(langName.getName().equalsIgnoreCase(createLanguage.getName())) {
				throw new Exception ("The language is already exist");
			}
			else if(createLanguage.getName().isEmpty()) {
				throw new Exception ("Language name can not be empty");
			}
		}
		language.setName(createLanguage.getName());
		this.languageRepository.save(language);
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguage) throws Exception {
		List<ProgrammingLanguage> languages = languageRepository.findAll();
		for(ProgrammingLanguage language : languages) {
			if(language.getId() == deleteLanguage.getId())
			{
				languageRepository.delete(language);
				break;
			}
		}
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguage) throws Exception {
		List<ProgrammingLanguage> languages = languageRepository.findAll();
		for(ProgrammingLanguage language : languages) {
			if(language.getId() == updateLanguage.getId()) {
				language.setName(updateLanguage.getNewName());
				break;
			}
		}
	}

	
}
