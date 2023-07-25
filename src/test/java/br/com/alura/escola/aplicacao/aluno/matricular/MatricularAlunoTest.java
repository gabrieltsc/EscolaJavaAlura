package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.PublicadorDeEventos;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.infra.aluno.RepositoriosDeAlunosEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido(){
        // MOCK -> Mockito
        RepositoriosDeAlunosEmMemoria repositorio = new RepositoriosDeAlunosEmMemoria();
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        MatricularAluno useCase = new MatricularAluno(repositorio, publicador);

        MatricularAlunoDto dados = new MatricularAlunoDto(
                "Fulano",
                "123.456.789-00",
                "fulano@email.com");
        useCase.executa(dados);

        Aluno encontrado = repositorio.buscarPorCPF(
                new CPF("123.456.789-00"));

        assertEquals("Fulano", encontrado.getNome());
        assertEquals("123.456.789-00", encontrado.getCpfEscrito());
        assertEquals("fulano@email.com", encontrado.getEmail());
    }
}
