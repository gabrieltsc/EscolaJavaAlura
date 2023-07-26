package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.List;

// Agregate Root
public class Aluno {

    // Entidade
    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();
    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    // A manipulação de telefones deve ser feita de dentro do Aluno (Agregate)
    public void adicionarTelefone(String ddd, String numero) {
        // Business Invariant
        if (telefones.size() == 2){
            throw new IllegalArgumentException("Número máximo de telefones atingido!");
        }
        this.telefones.add(new Telefone(ddd, numero));
    }

    public String getCpfEscrito() {
        return cpf.getNumero();
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
