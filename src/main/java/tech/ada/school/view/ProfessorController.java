package tech.ada.school.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.school.domain.dto.exeption.v1.ProfessorDto;
import tech.ada.school.service.IProfessorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final IProfessorService servico;

    @Autowired
    public ProfessorController(IProfessorService servico) {
        this.servico = servico;
    }

    @GetMapping("/{id}")
    public ProfessorDto buscarProfessor(@PathVariable("id") int id) {
        Optional<ProfessorDto> optionalProfessor = servico.buscarProfessorPorId(id);
        return optionalProfessor.orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    @GetMapping
    public List<ProfessorDto> lerProfessores() {
        return servico.listarProfessores();
    }

    @PostMapping
    public int criarProfessor(@RequestBody ProfessorDto pedido) {
        return servico.criarProfessor(pedido.getNome());
    }

    @PutMapping("/{id}")
    public void atualizarProfessor(@PathVariable("id") int id, @RequestBody ProfessorDto pedido) {
        servico.atualizarProfessor(id, pedido.getNome());
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable("id") int id) {
        servico.deletarProfessor(id);
    }

}
