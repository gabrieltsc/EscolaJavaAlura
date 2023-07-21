package br.com.alura.escola.dominio.aluno;

public class Email {

    // Value Object
    private String endereco;

    public Email(String endereco) {
        if (endereco == null || // Teste de endereço inválido
                !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$")){
            throw new IllegalArgumentException("br.com.alura.escola.aluno.Email inválido.");
        }
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
