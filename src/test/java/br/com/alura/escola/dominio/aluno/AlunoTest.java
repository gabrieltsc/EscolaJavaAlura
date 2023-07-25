package br.com.alura.escola.dominio.aluno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlunoTest {
    private Aluno aluno;

    @BeforeEach
    void beforeEach(){
        this.aluno = new Aluno(
                new CPF("123.456.789-00"),
                "Fulano da Silva",
                new Email("fulano@email.com"));
    }

    @Test
    void deveriaPermitirAdicionarTelefone(){
        this.aluno.adicionarTelefone("11", "912345678");
        assertEquals(1, this.aluno.getTelefones().size());
    }

    @Test
    void deveriaPermitirAdicionar2Telefones(){
        this.aluno.adicionarTelefone("11", "912345678");
        this.aluno.adicionarTelefone("11", "988888888");
        assertEquals(2, this.aluno.getTelefones().size());
    }

    @Test
    void naoDeveriaPermitirAdicionar3Telefones(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.aluno.adicionarTelefone("11", "912345678");
            this.aluno.adicionarTelefone("11", "988888888");
            this.aluno.adicionarTelefone("11", "977777777");
        });
    }
}
