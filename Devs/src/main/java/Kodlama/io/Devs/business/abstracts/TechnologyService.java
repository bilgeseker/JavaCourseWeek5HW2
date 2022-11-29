package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.GetTechnologyByIdRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import Kodlama.io.Devs.business.responses.GetTechnologyByIdResponse;

public interface TechnologyService {
	List<GetAllTechnologiesResponse> getAll();
	GetTechnologyByIdResponse getById(GetTechnologyByIdRequest getTech);
	void add(CreateTechnologyRequest tech) throws Exception;
	void delete(DeleteTechnologyRequest tech) throws Exception;
	void update(UpdateTechnologyRequest tech) throws Exception;
}
