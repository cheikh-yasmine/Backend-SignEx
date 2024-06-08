package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.models.CategorieEntity;
import project.service.CategorieServiceInter;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "", allowedHeaders = "")
public class CategorieController {
    @Autowired
    CategorieServiceInter categorieServiceInter;

    @PostMapping("/add")
    public CategorieEntity createCategorie(@RequestBody CategorieEntity categorie){

        return categorieServiceInter.createCategorie(categorie);
    }
    @GetMapping("/getAll")
    public List<CategorieEntity> getAllCategories()
    {
        return categorieServiceInter.getAllCategories();

    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCategorie(@PathVariable Long id)
    {

        categorieServiceInter.deleteCategorie(id);
    }

    @PutMapping(value = "/update/{id}")
    public CategorieEntity updateCategorie(@PathVariable Long id , @RequestBody CategorieEntity categorie)
    {
        return categorieServiceInter.updateCategorie(id,categorie);

    }

    @GetMapping(value = "/getById/{categorieid}")
    public CategorieEntity getCatgById(@PathVariable Long categorieId)
    {
        return categorieServiceInter.getCatgById(categorieId);

    }
}
