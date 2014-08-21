package com.example.projetoscientia;

import java.util.List;

public class Jogador {
	private int idUser;
	private String nome;
	private String email;
	private String senha;
	private int score;
	private List<Jogador>amigos;
	
	public  static int  verPontuacao(int score){
		return score;
	}
	
	
}
