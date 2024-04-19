package tech.ada.school.service;

import org.springframework.stereotype.Service;
import tech.ada.school.domain.dto.exeption.v1.ProfessorDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService implements IProfessorService {

    private final List<ProfessorDto> professores = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public ProfessorDto criarProfessor(ProfessorDto pedido) {
        return null;
    }

    @Override
    public int criarProfessor(String nome) {
        ProfessorDto novoProfessor = new ProfessorDto();
        novoProfessor.setId(idCounter++);
        novoProfessor.setNome(nome);
        professores.add(novoProfessor);
        return novoProfessor.getId();
    }

    @Override
    public List<ProfessorDto> listarProfessores() {
        return professores;
    }

    @Override
    public ProfessorDto buscarProfessor(int id) {
        return null;
    }

    @Override
    public ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) {
        return null;
    }

    @Override
    public void removerProfessor(int id) {

    }

    @Override
    public ProfessorDto buscarPorCpf(String cpf) {
        return null;
    }

    @Override
    public Optional<ProfessorDto> buscarProfessorPorId(int id) {
        return professores.stream()
                .filter(professor -> professor.getId() == id)
                .findFirst();
    }

    @Override
    public void atualizarProfessor(int id, String novoNome) {
        Optional<ProfessorDto> optionalProfessor = buscarProfessorPorId(id);
        optionalProfessor.ifPresent(professor -> professor.setNome(novoNome));
    }

    @Override
    public void deletarProfessor(int id) {
        Optional<ProfessorDto> optionalProfessor = buscarProfessorPorId(id);
        optionalProfessor.ifPresent(professores::remove);
    }
}