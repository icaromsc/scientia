package com.example.projetoscientia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

	private static final String NOME_BASE="projeto_tcc";
	private static final int VERSAO_BASE=1;
	
	
	public DbHelper(Context context) {
		super(context, NOME_BASE, null, VERSAO_BASE);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//criação das tabelas no sqlite
		String CreateTabelaPergunta="CREATE TABLE pergunta(" 
				+"idPergunta INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+"idCategoria INTEGER NOT NULL,"
				+"enunciado varchar(120) NOT NULL,"
				+"resposta varchar(30) NOT NULL,"
				+"alternativa2 varchar(30) NOT NULL,"
				+"alternativa3 varchar(30) NOT NULL,"
				+"alternativa4 varchar(30) NOT NULL"
				+")";
		
		String CreateTabelaCategoria="CREATE TABLE categoria(" 
				+"idCategoria INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+"nome varchar(50) NOT NULL"
				+")";
		
		String CreateTabelaJogador="CREATE TABLE jogador(" 
				+"idUser INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+"idAmigo INTEGER NOT NULL,"
				+"nome varchar(100) NOT NULL,"
				+"email varchar(50) NOT NULL,"
				+"senha varchar(30) NOT NULL,"
				+"score INTEGER NOT NULL"
				+")";
		String CreateTabelaAmigos="CREATE TABLE amigos(" 
				+"idUser INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+"nome varchar(50) NOT NULL,"
				+"score INTEGER NOT NULL"
				+")";
		
		db.execSQL(CreateTabelaPergunta);
		db.execSQL(CreateTabelaCategoria);
		db.execSQL(CreateTabelaJogador);
		db.execSQL(CreateTabelaAmigos);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String DropTabelaPergunta = "DROP TABLE pergunta";
		String DropTabelaCategoria = "DROP TABLE categoria";
		String DropTabelaJogador = "DROP TABLE jogador";
		String DropTabelaAmigos = "DROP TABLE amigos";
		db.execSQL(DropTabelaPergunta);
		db.execSQL(DropTabelaCategoria);
		db.execSQL(DropTabelaJogador);
		db.execSQL(DropTabelaAmigos);
		
		onCreate(db);
	}
	
	
	

}
