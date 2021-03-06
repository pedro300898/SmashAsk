package com.example.smashask;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LayoutPergunta extends AppCompatActivity implements View.OnClickListener {

    private Pergunta pergunta;
    private BancoDeDados bd;
    private SharedPreferences shared;
    private String s1, correta;
    private int idLista, numeroDaPergunta, tamanhoLista;
    private TextView t1, textNP, textP, textA, textB, textC, textD, textRatio;
    private Button btnA, btnB, btnC, btnD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_pergunta);

        shared = getSharedPreferences("dados", 0);
        bd = new BancoDeDados((getApplicationContext()));
        pergunta = new Pergunta();

        t1 = (TextView) findViewById(R.id.textViewTimer);
        s1 = shared.getString("Modo", null);
        if(s1.equals(R.string.smashS) ){
            t1.setVisibility(View.INVISIBLE);
        }else{
            // roda timer
        }
        idLista = shared.getInt("IdLista",1);
        numeroDaPergunta = shared.getInt("NP", 1);
        tamanhoLista = bd.buscaTamLista(idLista);
        pergunta = bd.buscaPerguntaNaLista(idLista, numeroDaPergunta);

        textNP =(TextView) findViewById(R.id.textViewNumeroPergunta);
        textNP.setText("Pergunta"+numeroDaPergunta+"/"+tamanhoLista);
        textP =(TextView) findViewById(R.id.textViewPergunta);
        textP.setText(pergunta.getPergunta());
        textA =(TextView) findViewById(R.id.textViewRespostaA);
        textA.setText(pergunta.getRespostaA());
        textB =(TextView) findViewById(R.id.textViewRespostaB);
        textB.setText(pergunta.getRespostaB());
        textC =(TextView) findViewById(R.id.textViewRespostaC);
        textC.setText(pergunta.getRespostaC());
        textD =(TextView) findViewById(R.id.textViewRespostaD);
        textD.setText(pergunta.getRespostaD());


        btnA = (Button) findViewById(R.id.buttonA);
        btnA.setOnClickListener(this);
        btnB = (Button) findViewById(R.id.buttonB);
        btnB.setOnClickListener(this);
        btnC = (Button) findViewById(R.id.buttonC);
        btnC.setOnClickListener(this);
        btnD = (Button) findViewById(R.id.buttonD);
        btnD.setOnClickListener(this);

        correta = pergunta.getRespostaCorreta();

    }

    @Override
    public void onClick(View v) {
        Log.d("pergunta", "entrou no correta");
        shared = getSharedPreferences(getString(R.string.pref_Key), 0);
        Usuario u;
        SharedPreferences.Editor edit = shared.edit();
        bd = new BancoDeDados((getApplicationContext()));
        u = bd.buscaUsuario();
        if(v == btnA){
            if(btnA.getText().equals(correta)){
                u.setQtd_Respondidas((u.getQtd_Respondidas()+1));
                u.setQtd_Acerto((u.getQtd_Acerto()+1));
                u.setSmash_Ratio((u.getQtd_Acerto()/u.getQtd_Respondidas()));
                bd.upadateUsuario(u);

                //camputa que esta correta na lista
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta+1));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);
                    this.finish();
                }else{
                    //termina a lista
                    this.finish();
                }
            }else{
                u.setQtd_Respondidas((u.getQtd_Respondidas()+1));
                u.setSmash_Ratio((u.getQtd_Acerto()/u.getQtd_Respondidas()));
                bd.upadateUsuario(u);
                //camputa que esta errado
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta+1));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);
                    this.finish();
                }else{
                    //termina a lista
                    this.finish();
                }
            }
        }
        if(v == btnB){
            if(btnB.getText().equals(correta)){
                u.setQtd_Respondidas((u.getQtd_Respondidas()+1));
                u.setQtd_Acerto((u.getQtd_Acerto()+1));
                u.setSmash_Ratio((u.getQtd_Acerto()/u.getQtd_Respondidas()));
                bd.upadateUsuario(u);
                //camputa que esta correta
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta+1));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);
                    this.finish();
                }else{
                    //termina a lista
                    this.finish();
                }
            }else{
                u.setQtd_Respondidas((u.getQtd_Respondidas()+1));
                u.setQtd_Acerto((u.getQtd_Acerto()+1));
                u.setSmash_Ratio((u.getQtd_Acerto()/u.getQtd_Respondidas()));
                bd.upadateUsuario(u);
                //camputa que esta errado
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta+1));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);
                    this.finish();
                }else{
                    //termina a lista
                    this.finish();
                }
            }
        }
        if(v == btnC){
            if(btnC.getText().equals(correta)){
                u.setQtd_Respondidas((u.getQtd_Respondidas()+1));
                u.setQtd_Acerto((u.getQtd_Acerto()+1));
                u.setSmash_Ratio((u.getQtd_Acerto()/u.getQtd_Respondidas()));
                bd.upadateUsuario(u);
                //camputa que esta correta
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta+1));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);
                    this.finish();
                }else{
                    //termina a lista
                    bd.upadateUsuario(u);
                    this.finish();
                }
            }else{
                u.setQtd_Respondidas((u.getQtd_Respondidas()+1));
                u.setSmash_Ratio((u.getQtd_Acerto()/u.getQtd_Respondidas()));
                bd.upadateUsuario(u);
                //camputa que esta errado
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta+1));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);
                    this.finish();
                }else{
                    //termina a lista
                    this.finish();
                }
            }
        }
        if(v == btnD){
            if(btnD.getText().equals(correta)){
                u.setQtd_Respondidas((u.getQtd_Respondidas()+1));
                u.setQtd_Acerto((u.getQtd_Acerto()+1));
                u.setSmash_Ratio((u.getQtd_Acerto()/u.getQtd_Respondidas()));
                bd.upadateUsuario(u);
                //camputa que esta correta
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta+1));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);
                    this.finish();
                }else{
                    //termina a lista
                    this.finish();
                }
            }else{
                u.setQtd_Respondidas((u.getQtd_Respondidas()+1));
                u.setSmash_Ratio((u.getQtd_Acerto()/u.getQtd_Respondidas()));
                bd.upadateUsuario(u);
                //camputa que esta errado
                if(tamanhoLista != numeroDaPergunta){
                    edit.putInt("NP", (numeroDaPergunta+1));
                    edit.commit();
                    Intent i = new Intent(this, LayoutPergunta.class);
                    startActivity(i);
                    this.finish();
                }else{
                    //termina a lista
                    this.finish();
                }
            }
        }
    }
}