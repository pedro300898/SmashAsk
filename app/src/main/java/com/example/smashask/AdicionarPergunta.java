package com.example.smashask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AdicionarPergunta extends AppCompatActivity implements View.OnClickListener {
    private EditText pergunta, questaoA, questaoB, questaoC, questaoD, temporizador;
    private RadioButton a, b, c, d;
    private Button salvarPergunta;
    private BancoDeDados bd;
    private String respostaCorreta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_pergunta);

        pergunta =(EditText) findViewById(R.id.editPergunta);
        questaoA =(EditText) findViewById(R.id.editRespostaA);
        questaoB =(EditText) findViewById(R.id.editRespostaB);
        questaoC =(EditText) findViewById(R.id.editRespostaC);
        questaoD =(EditText) findViewById(R.id.editRespostaD);
        temporizador =(EditText) findViewById(R.id.editTimer);

        a = (RadioButton) findViewById(R.id.radioButtonA);
        b = (RadioButton) findViewById(R.id.radioButtonB);
        c = (RadioButton) findViewById(R.id.radioButtonC);
        d = (RadioButton) findViewById(R.id.radioButtonD);

        salvarPergunta = (Button) findViewById(R.id.buttonSalvarP);
        salvarPergunta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == salvarPergunta) {
            cadastarBD();
        }
    }


    public void cadastarBD(){
        bd = new BancoDeDados((getApplicationContext()));
        Pergunta p = new Pergunta();
        p.setPergunta(pergunta.getText().toString());
        p.setRespostaA(questaoA.getText().toString());
        p.setRespostaB(questaoB.getText().toString());
        p.setRespostaC(questaoC.getText().toString());
        p.setRespostaD(questaoD.getText().toString());
        p.setTimer(Integer.parseInt(temporizador.getText().toString()));
        p.setRespostaCorreta(respostaCorreta);
        bd.inserirPerguntaBD(p);
    }

}
