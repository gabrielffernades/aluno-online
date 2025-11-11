package br.com.alunoonline.api.service;


import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public void createDiscipline(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> findAllDisciplinas() {
       return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> findDisciplinaById(long id) {
        return disciplinaRepository.findById(id);
    }

    public void deleteDisciplinaById(long id) {
        disciplinaRepository.deleteById(id);
    }

    public void updateDisciplinaById(long id, Disciplina updatedDisciplina) {
        Optional<Disciplina> disciplina = findDisciplinaById(id);

        if (disciplina.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada.");
        }

        Disciplina editedDisciplina = disciplina.get();

        editedDisciplina.setName(updatedDisciplina.getName());
        editedDisciplina.setProfessor(updatedDisciplina.getProfessor());

        disciplinaRepository.save(editedDisciplina);
    }
}
