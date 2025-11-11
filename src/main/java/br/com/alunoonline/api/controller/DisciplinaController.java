package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDiscipline(@RequestBody Disciplina disciplina) {
        disciplinaService.createDiscipline(disciplina);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Disciplina> findAllDisciplinas() {
        return disciplinaService.findAllDisciplinas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Disciplina> findDisciplinaById(@PathVariable long id) {
        return disciplinaService.findDisciplinaById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDisciplinaById(@PathVariable long id) {
        disciplinaService.deleteDisciplinaById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDisciplinaById(@PathVariable long id, @RequestBody Disciplina updatedDisciplina) {
        disciplinaService.updateDisciplinaById(id, updatedDisciplina);
    }
}
