package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.aluno.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontrado(CPF cpf) {
        super("Não foi possível encontrar o cpf: " + cpf.getNumero());
    }
}
