package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Aluno aluno) {
        alunoService.createStudent(aluno);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findAllStudents() {
        return alunoService.findAllStudents();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> findStudentById(@PathVariable long id) {
        return alunoService.findStudentById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable long id) {
        alunoService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudentById(@PathVariable long id, @RequestBody Aluno updatedAluno) {
        alunoService.updateStudentById(id, updatedAluno);
    }

}
