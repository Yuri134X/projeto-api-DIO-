package me.dio.projeto_api.controller;

import com.exemplo.lanchonete.model.Lanche;
import com.exemplo.lanchonete.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lanches")
public class LancheController {

    @Autowired
    private LancheRepository lancheRepository;

    @GetMapping
    public List<Lanche> listar() {
        return lancheRepository.findAll();
    }

    @PostMapping
    public Lanche criar(@RequestBody Lanche lanche) {
        return lancheRepository.save(lanche);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lanche> buscarPorId(@PathVariable Long id) {
        return lancheRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lanche> atualizar(@PathVariable Long id, @RequestBody Lanche lanche) {
        if (!lancheRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        lanche.setId(id);
        return ResponseEntity.ok(lancheRepository.save(lanche));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!lancheRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        lancheRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}