package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {

	public Entreprise ajouterEntreprise(Entreprise entreprise);

	Entreprise getEntrepriseById(long id);

	void deleteEntreprise(long id);

	Entreprise updateEntreprise(Entreprise entreprise);
	
	public List<Entreprise> retrieveAllEntreprise();
}
