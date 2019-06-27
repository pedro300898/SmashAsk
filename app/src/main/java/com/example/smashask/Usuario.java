package com.example.smashask;

public class Usuario {
    private String usuario_Id , usuario_nome, tempo_Acumulado;
    private float smash_Ratio;
    private int qtd_Acerto, qtd_Respondidas;

    public String getUsuario_Id() {
        return usuario_Id;
    }

    public String getTempo_Acumulado() {
        return tempo_Acumulado;
    }

    public void setTempo_Acumulado(String tempo_Acumulado) {
        this.tempo_Acumulado = tempo_Acumulado;
    }

    public float getSmash_Ratio() {
        return smash_Ratio;
    }

    public void setSmash_Ratio(float smash_Ratio) {
        this.smash_Ratio = smash_Ratio;
    }

    public int getQtd_Acerto() {
        return qtd_Acerto;
    }

    public void setQtd_Acerto(int qtd_Acerto) {
        this.qtd_Acerto = qtd_Acerto;
    }

    public int getQtd_Respondidas() {
        return qtd_Respondidas;
    }

    public void setQtd_Respondidas(int qtd_Respondidas) {
        this.qtd_Respondidas = qtd_Respondidas;
    }

    public void setUsuario_Id(String usuario_Id) {
        this.usuario_Id = usuario_Id;
    }

    public String getUsuario_nome() {
        return usuario_nome;
    }

    public void setUsuario_nome(String usuario_nome) {
        this.usuario_nome = usuario_nome;
    }
}
