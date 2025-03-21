package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AgendaTest {
    private Agenda agenda;

    @BeforeEach
    void setUp(){
        agenda = new Agenda();
    }

    @Test
    void constroi(){
        List<Evento> listaVazia = new ArrayList<>();
        assertEquals(listaVazia, agenda.getEventos());
    }

    @Test
    void acionaVideo(){
        Evento evento = mock(Evento.class); //Evento falso (simulado)
        when(evento.valido()).thenReturn(true); //Para considerar o evento válido
        agenda.adiciona(evento);

        List<Evento> eventos = new ArrayList<>();
        eventos.add(evento);

        assertEquals(eventos, agenda.getEventos());
    }

    @Test
    void acionaInvalido(){
        Evento evento = mock(Evento.class); //Evento falso (simulado)
        when(evento.valido()).thenReturn(false); //Para considerar o evento válido

        IllegalArgumentException e = assertThrows (IllegalArgumentException.class, () -> {
                agenda.adiciona(evento);
        });
        assertEquals("Evento inválido!",e.getMessage());

    }

}
