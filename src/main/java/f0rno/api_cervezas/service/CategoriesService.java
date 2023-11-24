package f0rno.api_cervezas.service;

import f0rno.api_cervezas.error.categorie.CategorieNotFoundExecption;
import f0rno.api_cervezas.model.Categories;
import f0rno.api_cervezas.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriesService {
    CategoriesRepository categoriesRepository;
    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }
    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }
    public ResponseEntity<Categories> getCategory(int id) throws CategorieNotFoundExecption {
        return categoriesRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElseThrow(() -> new CategorieNotFoundExecption(id));
    }
}