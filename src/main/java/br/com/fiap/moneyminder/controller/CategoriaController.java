package br.com.fiap.moneyminder.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyminder.model.Categoria;
import br.com.fiap.moneyminder.repository.CategoriaRepository;



@Controller
@RestController
@RequestMapping("categoria")
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> index() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    // @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        log.info("cadastrando categoria: {}", categoria);
        categoriaRepository.save(categoria);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoria);
    }

    // @GetMapping("{id}")
    // public ResponseEntity<Categoria> get(@PathVariable Long id) {
    //     var categoria = categoriaRepository.getReferenceById(id);
    //     return ResponseEntity.ok(categoria);
    // }

    @DeleteMapping("{id}")
    public ResponseEntity<Object>destroy(@PathVariable Long id){
        var categoria = categoriaRepository.getReferenceById(id);
        categoriaRepository.delete(categoria);
        return ResponseEntity.noContent().build();
    }

    // @PutMapping("{id}")
    // public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Categoria categoria){

    //     log.info("Atualizando a categoria id{} para {}", id, categoria);

    //     var optionalCategoria = buscarCategoriaPorId(id);

    //     if(optionalCategoria.isEmpty())
    //         return ResponseEntity.notFound().build();
        
    //     var categoriaEncontrada = optionalCategoria.get();
    //     var categoriaAtualizada = new Categoria(id, categoria.nome(), categoria.icone());
    //     repository.remove(categoriaEncontrada);
    //     repository.add(categoriaAtualizada);

    //     return ResponseEntity.ok().body(categoriaAtualizada);

    // }

}
