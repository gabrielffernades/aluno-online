package br.com.alunoonline.api.service;


import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public void createProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public List<Professor> findAllProfessors() {
       return professorRepository.findAll();
    }

    public Optional<Professor> findProfessorById(long id) {
        return professorRepository.findById(id);
    }

    public void updateProfessor(long id, Professor professor) {
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if (professorOptional.isPresent()) {
            Professor professorExistente = professorOptional.get();
            professorExistente.setNome(professor.getNome());
            professorExistente.setEmail(professor.getEmail());
            professorExistente.setCpf(professor.getCpf());
            professorRepository.save(professorExistente);
        }
    }

    public void deleteProfessorById(long id) {
        professorRepository.deleteById(id);
    }
}

