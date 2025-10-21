package br.com.alunoonline.api.service;


import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public void deleteStudentById(long id) {
        alunoRepository.deleteById(id);
    }

    public void updateStudentById(long id, Aluno updatedAluno) {
        Optional<Aluno> student = findStudentById(id);

        if (student.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado.");
        }

        Aluno editedAluno = student.get();

        editedAluno.setCompletName(updatedAluno.getCompletName());
        editedAluno.setEmail(updatedAluno.getEmail());
        editedAluno.setCpf(updatedAluno.getCpf());

        alunoRepository.save(editedAluno);
    }
}
