package tech.ada.school.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.school.domain.dto.exeption.v1.AlunoDto;
import tech.ada.school.service.IAlunoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final IAlunoService servico;

    @Autowired
    public AlunoController(IAlunoService servico) {
        this.servico = servico;
    }

    @GetMapping("/{id}")
    public AlunoDto buscarAluno(@PathVariable("id") int id) {
        Optional<AlunoDto> optionalAluno = servico.buscarAlunoPorId(id);
        return optionalAluno.orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    @GetMapping
    public List<AlunoDto> lerAluno() {
        return servico.listarAlunos();
    }

    @PostMapping
    public int criarAluno(@RequestBody AlunoDto pedido) {
        return servico.criarAluno(pedido.getNome());
    }

    @PutMapping("/{id}")
    public void atualizarAluno(@PathVariable("id") int id, @RequestBody AlunoDto pedido) {
        servico.atualizarAluno(id, pedido.getNome());
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable("id") int id) {
        servico.deletarAluno(id);
    }
}
