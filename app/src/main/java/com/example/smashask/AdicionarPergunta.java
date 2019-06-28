package com.example.smashask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AdicionarPergunta extends AppCompatActivity implements View.OnClickListener {
    private EditText pergunta, questaoA, questaoB, questaoC, questaoD, temporizador;
    private RadioButton radio1, radio2, radio3, radio4;
    private RadioGroup grupo;
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


        grupo = (RadioGroup) findViewById(R.id.grupoRadio);
        radio1 =(RadioButton) findViewById(R.id.radioButtonA);
        radio2 =(RadioButton) findViewById(R.id.radioButtonB);
        radio3 =(RadioButton) findViewById(R.id.radioButtonC);
        radio4 =(RadioButton) findViewById(R.id.radioButtonD);
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId== R.id.radioButtonA){
                    respostaCorreta = "A)";
                }
                if (checkedId== R.id.radioButtonB){
                    respostaCorreta = "B)";
                }
                if (checkedId== R.id.radioButtonC){
                    respostaCorreta = "C)";
                }
                if (checkedId== R.id.radioButtonD){
                    respostaCorreta = "D)";
                }
            }
        });

        salvarPergunta = (Button) findViewById(R.id.buttonSalvarP);
        salvarPergunta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == salvarPergunta) {
            cadastarBD();
            this.finish();
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
