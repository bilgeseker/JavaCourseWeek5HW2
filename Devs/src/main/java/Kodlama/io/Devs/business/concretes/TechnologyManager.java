package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.GetTechnologyByIdRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import Kodlama.io.Devs.business.responses.GetTechnologyByIdResponse;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
	private TechnologyRepository techRepository;

	@Autowired
	public TechnologyManager(TechnologyRepository techRepository) {
		super();
		this.techRepository = techRepository;
	}
	
	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> techs = techRepository.findAll();
		List<GetAllTechnologiesResponse> techResponse = new ArrayList<GetAllTechnologiesResponse>();
		for(Technology tech : techs)
		{
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setId(tech.getId());
			responseItem.setName(tech.getName());
			techResponse.add(responseItem);
		}
		return techResponse;
	}

	@Override
	public GetTechnologyByIdResponse getById(GetTechnologyByIdRequest getTech) {
		List<Technology> techs = techRepository.findAll();
		GetTechnologyByIdResponse responseItem = new GetTechnologyByIdResponse();
		for(Technology tech : techs) {
			if(tech.getId() == getTech.getId())
			{
				responseItem.setName(tech.getName());
				break;
			}
		}
		return responseItem;
	}

	@Override
	public void add(CreateTechnologyRequest tech) throws Exception {
		List<Technology> techs = techRepository.findAll();
		Technology newTech = new Technology();
		for(Technology t : techs) {
			if(t.getName() == tech.getName()) {
				throw new Exception ("Technology already exists");
			}
			else if(t.getName().isEmpty()) {
				throw new Exception("Name can not be blank");
			}
		}
		newTech.setName(tech.getName());
		this.techRepository.save(newTech);
	}

	@Override
	public void delete(DeleteTechnologyRequest tech) throws Exception {
		List<Technology> techs = techRepository.findAll();
		for(Technology t : techs) {
			if(t.getId() == tech.getId()) {
				techRepository.delete(t);
				break;
			}
		}
	}

	@Override
	public void update(UpdateTechnologyRequest tech) throws Exception {
		List<Technology> techs = techRepository.findAll();
		for(Technology t : techs) {
			if(t.getId() == tech.getId()) {
				t.setName(tech.getNewName());
				break;
			}
		}
	}

}
