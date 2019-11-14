package com.Tenis.jogo_de_tenis;

public enum Jogador {
    PRIMEIRO(0), 
    SEGUNDO(1);

    private int pontuandoJogador;

     Jogador(int jogador) {
         this.pontuandoJogador = jogador;
     }

     public int getJogador() { 
         return pontuandoJogador;
     }
}