package tech.ada.school.service;

import tech.ada.school.domain.dto.exeption.v1.AlunoDto;

import java.util.List;
import java.util.Optional;

public interface IAlunoService {
    int criarAluno(String nome);

    List<AlunoDto> listarAlunos();

    Optional<AlunoDto> buscarAlunoPorId(int id);

    void atualizarAluno(int id, String novoNome);

    void deletarAluno(int id);

}


