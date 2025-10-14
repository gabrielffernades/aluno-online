package br.com.alunoonline.api.service;


import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void createStudent(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> findAllStudents() {
       return alunoRepository.findAll();
    }

    public Optional<Aluno> findStudentById(long id) {
        return alunoRepository.findById(id);
    }
}
