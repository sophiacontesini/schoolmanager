package tech.ada.school.service;

import org.springframework.stereotype.Service;
import tech.ada.school.domain.dto.exeption.v1.AlunoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService implements IAlunoService {

    private final List<AlunoDto> alunos = new ArrayList<>();
    private int idCounter = 1;
    @Override
    public int criarAluno(String nome) {
        AlunoDto novoAluno = new AlunoDto();
        novoAluno.setId(idCounter++);
        novoAluno.setNome(nome);
        alunos.add(novoAluno);
        return novoAluno.getId();
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return alunos;
    }

    @Override
    public Optional<AlunoDto> buscarAlunoPorId(int id) {
        return alunos.stream()
                .filter(aluno -> aluno.getId() == id)
                .findFirst();
    }

    @Override
    public void atualizarAluno(int id, String novoNome) {
        Optional<AlunoDto> optionalAluno = buscarAlunoPorId(id);
        optionalAluno.ifPresent(aluno -> aluno.setNome(novoNome));
    }

    @Override
    public void deletarAluno(int id) {
        Optional<AlunoDto> optionalAluno = buscarAlunoPorId(id);
        optionalAluno.ifPresent(alunos::remove);
    }
}
