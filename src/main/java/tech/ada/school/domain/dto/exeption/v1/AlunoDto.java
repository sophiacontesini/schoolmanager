package tech.ada.school.domain.dto.exeption.v1;

import jdk.jshell.Snippet;

public class AlunoDto {

    private int id;
    private String nome;

    public static Snippet builder() {
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
