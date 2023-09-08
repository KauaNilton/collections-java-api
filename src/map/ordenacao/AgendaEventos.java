package map.ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventosMap.put(data, new Evento(nome, atracao));
    }
    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap(eventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento() {
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap(eventosMap);
        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O proximo evento: " +proximoEvento + " acontecerá na data: " + proximaData);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.SEPTEMBER, 15), "evento 01", "atração 01");
        agendaEventos.adicionarEvento(LocalDate.of(2023,  9, 9), "evento 02", "atração 02");
        agendaEventos.adicionarEvento(LocalDate.of(2000,  1, 15), "evento 03", "atração 03");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();

    }
}

