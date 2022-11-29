package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.GetLanguageByIdRequest;
import Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.GetLanguageByIdResponse;

public interface LanguageService {
	List<GetAllLanguagesResponse> getAll();
	GetLanguageByIdResponse getById(GetLanguageByIdRequest getLanguage) throws Exception;
	void add(CreateLanguageRequest createLanguage)  throws Exception;
	void delete(DeleteLanguageRequest deleteLanguage) throws Exception;
	void update(UpdateLanguageRequest updateLanguage) throws Exception;
}
