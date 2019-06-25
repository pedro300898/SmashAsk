package com.example.smashask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class BancoDeDados extends SQLiteOpenHelper {
    private static  final String NOME_BD = "SmashBanco";
    private static final  int VERSAO =1;

    private SQLiteDatabase db;

    public BancoDeDados(Context context){
        super(context, NOME_BD, null, VERSAO);
        db = getWritableDatabase();
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists table_usuario (usuario_Id text primary key, usuario_nome text not null)");

        db.execSQL("create table if not exists table_Pergunta (pergunta_Id integer primary key autoincrement, pergunta_Texto text not null, resposta_A text not null, resposta_B text not null, resposta_C text not null," +
                " resposta_D text not null, resposta_Correta text not null, tempo_teste integer not null, timer integer not null)");

        db.execSQL("create table if not exists table_estatistica (estatisca_Id integer primary key autoincrement, email_usuario text not null, tempo_Gasto text not null, qtd_Acerto integer not null, tipo_Teste integer not null)") ;

        db.execSQL("create table if not exists table_Lista ( lista_Id integer primary key autoincrement, Id_Pergunta_1 integer not null, Id_Pergunta_2 integer not null, Id_Pergunta_3 integer not null, " +
                "Id_Pergunta_4 integer not null, Id_Pergunta_5 integer not null, Id_Pergunta_6 integer not null, Id_Pergunta_7 integer not null, Id_Pergunta_8 integer not null," +
                "Id_Pergunta_9 integer not null, Id_Pergunta_10 integer not null, Id_Pergunta_11 integer not null, Id_Pergunta_12 integer not null, Id_Pergunta_13 integer not null, " +
                "Id_Pergunta_14 integer not null, Id_Pergunta_15 integer not null, Id_Pergunta_16 integer not null, Id_Pergunta_17 integer not null, Id_Pergunta_18 integer not null," +
                "Id_Pergunta_19 integer not null, Id_Pergunta_20 integer not null, qtd_Perguntas integer not null)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table table_Pergunta");
        db.execSQL("drop table table_usuario");
        db.execSQL("drop table table_estatistica");
        db.execSQL("drop table table_Lista");
        onCreate(db);
    }

    public Pergunta buscaPergunta(String id){
        Pergunta pergunta = new Pergunta();

        String selection =  "pergunta_Id" + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor c = db.query("table_Pergunta",null,selection,selectionArgs,null,null,null,null);

        if (null != c) {
            c.moveToFirst();
            pergunta.setId(c.getInt(c.getColumnIndex("pergunta_Id")));
            pergunta.setPergunta(c.getString(c.getColumnIndex("pergunta_Texto")));
            pergunta.setRespostaA(c.getString(c.getColumnIndex("resposta_A")));
            pergunta.setRespostaB(c.getString(c.getColumnIndex("resposta_B")));
            pergunta.setRespostaC(c.getString(c.getColumnIndex("resposta_C")));
            pergunta.setRespostaD(c.getString(c.getColumnIndex("resposta_D")));
            pergunta.setRespostaCorreta(c.getString(c.getColumnIndex("resposta_Correta")));
            pergunta.setTempoTeste(c.getInt(c.getColumnIndex("tempo_teste")));
            pergunta.setTimer(c.getInt(c.getColumnIndex("timer")));
        }
        db.close();

        return pergunta;
    }
    public int buscaTamLista(int idLista){
        int tamLista =0;
        String selection =  "lista_Id" + " = ?";
        String[] selectionArgs = {String.valueOf(idLista)};

        Cursor c = db.query("table_Lista",null,selection,selectionArgs,null,null,null,null);

        if (null != c) {
            c.moveToFirst();
            tamLista = c.getInt(c.getColumnIndex("qtd_Perguntas"));
        }
        db.close();

        return tamLista;
    };

    public String buscaCorreta(int idLista){
        String respostaCorreta = new String();
        String selection =  "pergunta_Id" + " = ?";
        String[] selectionArgs = {String.valueOf(idLista)};

        Cursor c = db.query("table_Pergunta",null,selection,selectionArgs,null,null,null,null);

        if (null != c) {
            c.moveToFirst();
            respostaCorreta = c.getString(c.getColumnIndex("resposta_Correta"));
        }
        db.close();

        return respostaCorreta;
    };

    public Pergunta buscaPerguntaNaLista(int idLista, int numeroPergunta){
        Pergunta pergunta = new Pergunta();
        String idPergunta = new String();

        String columns = "Id_Pergunta_"+numeroPergunta;
        String selection =  "lista_Id" + " = ?";
        String[] selectionArgs = {String.valueOf(idLista)};

        Cursor c = db.query("table_Lista",null,selection,selectionArgs,null,null,null,null);

        if (null != c) {
            c.moveToFirst();
            idPergunta = c.getString(c.getColumnIndex(columns));
            pergunta = buscaPergunta(idPergunta);
        }
        db.close();

        return pergunta;
    }

    public void inserirPerguntaBD(Pergunta p){
        Log.d("BANCO", "Método inserir invocado");
        ContentValues valores = new ContentValues();
        valores.put("pergunta_Texto", p.getPergunta());
        valores.put("resposta_A", p.getRespostaA());
        valores.put("resposta_B", p.getRespostaB());
        valores.put("resposta_C", p.getRespostaC());
        valores.put("resposta_D", p.getRespostaD());
        valores.put("tempo_teste", 0);
        valores.put("timer", p.getTimer());

        db.insert("table_Pergunta","", valores);
        Log.d("BANCO", "Inserido com sucesso");

    }

}