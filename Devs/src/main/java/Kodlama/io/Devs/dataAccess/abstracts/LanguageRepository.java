package Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;


public interface LanguageRepository extends JpaRepository<ProgrammingLanguage, Integer>{
	
}
