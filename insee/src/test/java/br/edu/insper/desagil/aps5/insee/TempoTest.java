package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TempoTest {
    private Tempo tempo;

    @BeforeEach
    void setUp(){
        tempo = new Tempo();
    }

    @Test
    void constroi(){
        assertEquals(0, tempo.getMinuto());
        assertEquals(0, tempo.getHora());
    }

    @Test
    void naoAtualizaMenor(){
        tempo.atualiza(-1,-1);
        assertEquals(0, tempo.getMinuto());
        assertEquals(0, tempo.getHora());

    }

    @Test
    void atualizaMaior(){
        tempo.atualiza(24,60);
        assertEquals(59, tempo.getMinuto());
        assertEquals(23, tempo.getHora());
    }

    @Test
    void atualiza(){
        tempo.atualiza(15,30);
        assertEquals(30, tempo.getMinuto());
        assertEquals(15, tempo.getHora());
    }

    @Test
    void comoZero(){
        assertEquals(0, tempo.comoInteiro());
    }

    @Test
    void comoAgora(){
        tempo.atualiza(15, 30);
        assertEquals(930, tempo.comoInteiro());

    }

}
