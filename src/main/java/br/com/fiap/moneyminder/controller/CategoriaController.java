package br.com.fiap.moneyminder.controller;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fiap.moneyminder.model.Categoria;



@Controller
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());
    List<Categoria> repository = new ArrayList<>();

    @ResponseBody
    public List<Categoria> index() {
        return repository;
    }

    @PostMapping
    // @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        log.info("cadastrando categoria: {}", categoria);
        repository.add(categoria);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoria);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);

        // for (Categoria categoria : repository ){
        // if (categoria.id().equals(id)){
        // return ResponseEntity
        // .status(HttpStatus.OK)
        // .body(categoria);
        // }
        // }

        var optionalCategoria = repository
                .stream()
                .filter(c -> c.id().equals(id))
                .findFirst();

        if (optionalCategoria.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalCategoria.get());
    }

}
