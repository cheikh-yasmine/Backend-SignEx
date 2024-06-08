package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.models.CategorieEntity;
import project.repository.CategorieRepository;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieServiceInter{
    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public CategorieEntity createCategorie(CategorieEntity categorie) {

        return categorieRepository.save(categorie);
    }

    @Override
    public List<CategorieEntity> getAllCategories(){

        return categorieRepository.findAll();
    }

    @Override
    public void deleteCategorie(Long id) {

        categorieRepository.deleteById(id);
    }

    @Override
    public CategorieEntity updateCategorie(Long CategorieId, CategorieEntity updatedCategorie) {
        CategorieEntity existingCategorie = categorieRepository.findById(CategorieId).orElseThrow(() -> new IllegalArgumentException("Ctegorie not found"));
        existingCategorie.setType(updatedCategorie.getType());
        return categorieRepository.save(existingCategorie);
    }

    @Override
    public CategorieEntity getCatgById(Long categorieId) {
        return categorieRepository.findById(categorieId).orElse(null);
    }
}
