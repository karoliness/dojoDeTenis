package com.Tenis.jogo_de_tenis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jogo {

    public List<Integer> placar = new ArrayList<>();
    public Boolean vencedor = false;
    public Boolean deuce = false;
    public boolean advantage = false;
    
    public Jogo() {
        zerandoPlacar();
    }
    
    public void zerandoPlacar(){
        placar = Arrays.asList(0,0);
    }

    public void pontuar(Jogador jogador){
       
        if(deuce){
            placar.set(jogador.getJogador(), placar.get(jogador.getJogador()) + 1);
            if(verificandoSeEhAdvantage()){
                advantage = true;
            }
            else if (verificandoSeEhVencedorEmAdvantage()){
                vencedor = true;
            }else{
                zerandoPlacar();
            }
        }else{
            pontuaNoJogo(jogador);
            verificandoSeEstaEmpatado();
        }
    }

    private boolean verificandoSeEhVencedorEmAdvantage() {
        return placar.equals(Arrays.asList(2,0)) || placar.equals(Arrays.asList(0,2));
    }

    private boolean verificandoSeEhAdvantage() {
        return placar.equals(Arrays.asList(1,0)) || placar.equals(Arrays.asList(0,1));
    }

    private void verificandoSeEstaEmpatado() {
        if(placar.equals(Arrays.asList(40,40))){
            deuce = true;
            zerandoPlacar();
        }
    }

    private void pontuaNoJogo(Jogador jogador) {
        if(placar.get(jogador.getJogador()) < 30){
            placar.set(jogador.getJogador(), placar.get(jogador.getJogador()) + 15);
        }else {
            placar.set(jogador.getJogador(), placar.get(jogador.getJogador()) + 10);
            var jogador1 = placar.get(0);
            var jogador2 = placar.get(1);
            if( jogador1 == 50 || jogador2 == 50){
                vencedor = true;
            }
        }
    }
}