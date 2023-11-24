package f0rno.api_cervezas.controller;

import f0rno.api_cervezas.error.categorie.CategorieNotFoundExecption;
import f0rno.api_cervezas.model.Categories;
import f0rno.api_cervezas.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {
    CategoriesService categoriesService;
    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }
    @GetMapping("/categories")
    public List<Categories> getAllCategories() {
        return categoriesService.getAllCategories();
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<Categories> getCategory(@PathVariable int id) throws CategorieNotFoundExecption {
        return categoriesService.getCategory(id);
    }
}
