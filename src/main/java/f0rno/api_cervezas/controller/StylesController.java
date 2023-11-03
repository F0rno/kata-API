package f0rno.api_cervezas.controller;

import f0rno.api_cervezas.model.Styles;
import f0rno.api_cervezas.repository.StyleRepository;
import f0rno.api_cervezas.service.StylesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StylesController {
    StylesService stylesService;
    @Autowired
    public StylesController(StylesService stylesService) {
        this.stylesService = stylesService;
    }
    @GetMapping("/styles")
    public List<Styles> getAllStyles() {
        return stylesService.getAllStyles();
    }
    @GetMapping("/style/{id}")
    public Styles getStyle(@PathVariable int id) {
        return stylesService.getStyle(id);
    }
}
