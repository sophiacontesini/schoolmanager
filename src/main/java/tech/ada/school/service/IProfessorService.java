package tech.ada.school.service;

import tech.ada.school.domain.dto.exeption.v1.ProfessorDto;

import java.util.List;
import java.util.Optional;

public interface IProfessorService {

    ProfessorDto criarProfessor(ProfessorDto pedido);

    int criarProfessor(String nome);

    List<ProfessorDto> listarProfessores();

    ProfessorDto buscarProfessor(int id) ;

    ProfessorDto atualizarProfessor(int id, ProfessorDto pedido);

    void removerProfessor(int id);

    ProfessorDto buscarPorCpf(String cpf);

    Optional<ProfessorDto> buscarProfessorPorId(int id);

    void atualizarProfessor(int id, String novoNome);

    void deletarProfessor(int id);
}