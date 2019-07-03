package com.example.smashask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CriarUsuario extends AppCompatActivity implements View.OnClickListener  {
    private EditText campo, campo2;
    private Button salvar;
    private BancoDeDados bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_usuario);
        bd = new BancoDeDados((getApplicationContext()));

        campo = (EditText) findViewById(R.id.editText2);
        campo2 = (EditText) findViewById(R.id.editText3);

        salvar = (Button) findViewById(R.id.btnSalvarUsuario);
        salvar.setOnClickListener(this);
    }


    public void onClick(View v) {
        if(v == salvar){
            //pegar os dados da seçao que esta logada
            Usuario user = new Usuario();
            user.setUsuario_Id(campo2.getText().toString());
            user.setUsuario_nome(campo.getText().toString());
            user.setSmash_Ratio(1);
            user.setQtd_Acerto(0);
            user.setQtd_Respondidas(0);
            user.setTempo_Acumulado("0");
            bd.insereUsuario(user);

            Intent i = new Intent(this, CodigoPerguntas.class);
            startActivity(i);
            this.finish();
        }
    }
}
