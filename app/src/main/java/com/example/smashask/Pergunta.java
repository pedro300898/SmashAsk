package com.example.smashask;

public class Pergunta {
    private  String pergunta, respostaA, respostaB, respostaC, respostaD, respostaCorreta;

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int timer, tempoTeste, id;

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getRespostaA() {
        return respostaA;
    }

    public void setRespostaA(String respostaA) {
        this.respostaA = respostaA;
    }

    public String getRespostaB() {
        return respostaB;
    }

    public void setRespostaB(String respostaB) {
        this.respostaB = respostaB;
    }

    public String getRespostaC() {
        return respostaC;
    }

    public void setRespostaC(String respostaC) {
        this.respostaC = respostaC;
    }

    public String getRespostaD() {
        return respostaD;
    }

    public void setRespostaD(String respostaD) {
        this.respostaD = respostaD;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getTempoTeste() {
        return tempoTeste;
    }

    public void setTempoTeste(int tempoTeste) {
        this.tempoTeste = tempoTeste;
    }
}
