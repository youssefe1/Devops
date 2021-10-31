package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Entreprise;

public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer>  {
	 @Query("SELECT name FROM Entreprise")
	    public List<String> entreprisename();
		@Query("SELECT count(*) FROM Entreprise")
	    public int countent();
	
}
