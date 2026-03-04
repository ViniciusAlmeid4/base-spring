package com.example.school.services;

import com.example.school.models.AlunoModel;
import com.example.school.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoModel criarAluno(AlunoModel alunoModel) {
        return alunoRepository.save(alunoModel);
    }

    public List<AlunoModel> listarTodos() {
        return alunoRepository.findAll();
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    public Optional<AlunoModel> listarAluno(Long id) {
        return alunoRepository.findById(id);
    }

    public AlunoModel editarAluno(Long id, AlunoModel putAluno) {
        Optional<AlunoModel> aluno = alunoRepository.findById(id);

        if (aluno.isEmpty()) {
            return null;
        }

        AlunoModel alunoModel = aluno.get();
        alunoModel.setNome(putAluno.getNome());
        alunoModel.setEndereco(putAluno.getEndereco());
        alunoModel.setMatricula(putAluno.getMatricula());

        return alunoRepository.save(alunoModel);
    }
}
