package br.com.fiap.moneyminder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.moneyminder.model.Categoria;
import br.com.fiap.moneyminder.repository.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("categoria")
@Slf4j
public class CategoriaController {

    
    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> index() {
        return categoriaRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> get(@PathVariable Long id) {
    
    return categoriaRepository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Categoria create(@RequestBody Categoria categoria) {
        log.info("cadastrando categoria: {}", categoria);
        categoriaRepository.save(categoria);
        return categoria;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Object>destroy(@PathVariable Long id){
        log.info("Apagando por id: {}", id);

        verificarSeExisteCategoria(id);

        categoriaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria){

    verificarSeExisteCategoria(id);
    
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    

    }

    private void verificarSeExisteCategoria(Long id) {
        categoriaRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(NOT_FOUND, "Categoria não encontrada")
            );
    }

}



