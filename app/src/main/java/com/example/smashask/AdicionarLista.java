package com.example.smashask;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import static android.widget.TextView.BufferType.NORMAL;

public class AdicionarLista extends AppCompatActivity implements View.OnClickListener {

    private BancoDeDados bd;
    private LinearLayout lay;
    private SharedPreferences shared;
    private Button btnCriar;
    private EditText tamanho;
    private ArrayList<Pergunta> perguntas = new ArrayList<>();
    private  ArrayList<CheckBox> arrayCheck = new ArrayList<CheckBox>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_lista);

        shared = getSharedPreferences("dados", 0);
        bd = new BancoDeDados((getApplicationContext()));

        tamanho = (EditText) findViewById(R.id.editTamlista);
        btnCriar = (Button) findViewById(R.id.buttonCriarLista);
        btnCriar.setOnClickListener(this);
        lay = (LinearLayout) findViewById(R.id.linearPerguntas);

        perguntas = bd.buscaTodasPerguntasCriadas();
        for (int i = 0; i < perguntas.size(); i++) {
            LinearLayout layAux = new LinearLayout((getApplicationContext()));
            CheckBox check = new CheckBox(this);
            check.setId(i);
            arrayCheck.add(check);
            EditText aux = new EditText(this);
            aux.setText(perguntas.get(i).getPergunta(), NORMAL);
            layAux.addView(check);
            layAux.addView(aux);
            lay.addView(layAux);
        }
    }

    public void onClick(View v) {
        Lista lista = new Lista();

        if(v == btnCriar){
            int contador = 1;
            int nPerguntas = 0;
            for (int i = 0; i < perguntas.size(); i++){

                if(arrayCheck.get(i).isChecked() && contador < 21){
                    switch(contador){
                        case 1:
                        lista.setId_Pergunta_1(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 2:
                        lista.setId_Pergunta_2(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 3:
                        lista.setId_Pergunta_3(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 4:
                        lista.setId_Pergunta_4(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 5:
                        lista.setId_Pergunta_5(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 6:
                        lista.setId_Pergunta_6(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 7:
                        lista.setId_Pergunta_7(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 8:
                        lista.setId_Pergunta_8(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 9:
                        lista.setId_Pergunta_9(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 10:
                        lista.setId_Pergunta_10(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 11:
                        lista.setId_Pergunta_11(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 12:
                        lista.setId_Pergunta_12(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 13:
                        lista.setId_Pergunta_13(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 14:
                        lista.setId_Pergunta_14(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 15:
                        lista.setId_Pergunta_15(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 16:
                        lista.setId_Pergunta_16(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 17:
                        lista.setId_Pergunta_17(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 18:
                        lista.setId_Pergunta_18(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 19:
                        lista.setId_Pergunta_19(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                        case 20:
                        lista.setId_Pergunta_20(perguntas.get(i).getId());
                        nPerguntas++;
                        break;
                    }
                    contador++;
                }
            }
            lista.setQtd_Perguntas(nPerguntas);
            bd.inserirLista(lista);
        }
    }
}
