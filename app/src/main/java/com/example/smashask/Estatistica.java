package com.example.smashask;

public class Estatistica {
    private int estatisca_Id , qtd_Acerto, tipo_Teste;
    private String email_usuario, tempo_Gasto;

    public int getEstatisca_Id() {
        return estatisca_Id;
    }

    public void setEstatisca_Id(int estatisca_Id) {
        this.estatisca_Id = estatisca_Id;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getTempo_Gasto() {
        return tempo_Gasto;
    }

    public void setTempo_Gasto(String tempo_Gasto) {
        this.tempo_Gasto = tempo_Gasto;
    }

    public int getQtd_Acerto() {
        return qtd_Acerto;
    }

    public void setQtd_Acerto(int qtd_Acerto) {
        this.qtd_Acerto = qtd_Acerto;
    }

    public int getTipo_Teste() {
        return tipo_Teste;
    }

    public void setTipo_Teste(int tipo_Teste) {
        this.tipo_Teste = tipo_Teste;
    }

}
