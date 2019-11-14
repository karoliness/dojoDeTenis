package com.Tenis.jogo_de_tenis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TenisTest {

    private Jogo iniciandoJogo() {
        var jogo = new Jogo();
        return jogo;
    }

    @Test
    public void a_partida_deve_ser_iniciar_zerada(){
        var placarEsperado = Arrays.asList(0,0);

        var jogo = iniciandoJogo();
        var placarEncontrado = jogo.placar;

        assertEquals(placarEsperado, placarEncontrado);
    }

    @Test
    public void o_primeiro_recebe_15_pontos_porque_ganhou_uma_partida(){
        var placarEsperado = Arrays.asList(15,0);
        var jogo = iniciandoJogo();

        jogo.pontuar(Jogador.PRIMEIRO);

        var placarEncontrado = jogo.placar;

        assertEquals(placarEsperado, placarEncontrado);
    }

    @Test
    public void o_segundo_recebe_15_pontos_porque_ganhou_uma_partida(){
        var placarEsperado = Arrays.asList(0,15);
        var jogo = iniciandoJogo();
       
        jogo.pontuar(Jogador.SEGUNDO);

        var placarEncontrado = jogo.placar;

        assertEquals(placarEsperado, placarEncontrado);
    }

    @Test
    public void o_primeiro_recebe_30_pontos_porque_ganhou_duas_partidas(){
        var placarEsperado = Arrays.asList(30,0);
        var jogo = iniciandoJogo();

        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);

        var placarEncontrado = jogo.placar;

        assertEquals(placarEsperado, placarEncontrado);
    }

    @Test
    public void o_segundo_recebe_30_pontos_porque_ganhou_duas_partidas(){
        var placarEsperado = Arrays.asList(0,30);
        var jogo = iniciandoJogo();

        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);

        var placarEncontrado = jogo.placar;

        assertEquals(placarEsperado, placarEncontrado);
    }

    @Test
    public void o_primeiro_recebe_40_pontos_porque_ganhou_tres_partidas(){
        var placarEsperado = Arrays.asList(40,0);
        var jogo = iniciandoJogo();

        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);

        var placarEncontrado = jogo.placar;

        assertEquals(placarEsperado, placarEncontrado);
    }

    @Test
    public void o_segundo_recebe_40_pontos_porque_ganhou_tres_partidas(){
        var placarEsperado = Arrays.asList(0,40);
        var jogo = iniciandoJogo();
        
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);

        var placarEncontrado = jogo.placar;

        assertEquals(placarEsperado, placarEncontrado);
    }

    @Test
    public void se_o_primeiro_jogador_tiver_40_pontos_e_ganha_novamente_ele_vence_a_partida(){
        var jogo = iniciandoJogo();
        
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.PRIMEIRO);

        var placarEncontrado = jogo.vencedor;

        assertTrue(placarEncontrado);
    }

    @Test
    public void se_os_dois_jogadores_estao_com_40_pontos_entao_eh_deuce(){
        var jogo = iniciandoJogo();
        var placarEsperado = Arrays.asList(40,40);
        var placarEncontrado = jogo.placar;
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);

        var ehDeuce = jogo.deuce;

        assertEquals(placarEsperado, placarEncontrado);
        assertTrue(ehDeuce);
    }

    @Test
    public void se_estiverem_em_deuce_e_o_primeiro_pontuar_se_torna_advantage(){
        var jogo = iniciandoJogo();
        
        var placarEsperado = Arrays.asList(1,0);

        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.PRIMEIRO);

        var advantage = jogo.advantage;
        var placarEncontrado = jogo.placar;

        assertEquals(placarEsperado, placarEncontrado);
        assertTrue(advantage);
    }

    @Test
    public void se_estiverem_em_deuce_e_o_segundo_pontuar_se_torna_advantage(){
        var jogo = iniciandoJogo();
        
        var placarEsperado = Arrays.asList(0,1);

        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);

        var advantage = jogo.advantage;
        var placarEncontrado = jogo.placar;

        assertEquals(placarEsperado, placarEncontrado);
        assertTrue(advantage);
    }

    @Test
    public void se_o_primeiro_jogador_fizer_2_pontos_sera_o_vencedor(){
        var jogo = iniciandoJogo();

        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);

        var placarEncontrado = jogo.vencedor;

        assertTrue(placarEncontrado);
    }

    @Test
    public void se_o_segundo_jogador_fizer_2_pontos_sera_o_vencedor(){
        var jogo = iniciandoJogo();

        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.PRIMEIRO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);
        jogo.pontuar(Jogador.SEGUNDO);

        var placarEncontrado = jogo.vencedor;

        assertTrue(placarEncontrado);
    }
}