package project.service;

import org.springframework.stereotype.Service;
import project.models.CategorieEntity;

import java.util.List;


public interface CategorieServiceInter {
    CategorieEntity createCategorie(CategorieEntity categorie);

    List<CategorieEntity> getAllCategories();

    void deleteCategorie(Long id);

    CategorieEntity updateCategorie(Long id, CategorieEntity categorie);


    CategorieEntity getCatgById(Long categorieid);
}
