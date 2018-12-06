package br.edu.ifrn.apiypsos.dominio;

import java.util.Date;

public class Plano {

    private int idPlano;
    private String nomePlano;
    private Aluno loginAluno;
    private Professor loginProfessor;
    private Date dataInicio;
    private Date dataFim;

    public Plano() {

    }

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public Aluno getLoginAluno() {
        return loginAluno;
    }

    public void setLoginAluno(Aluno loginAluno) {
        this.loginAluno = loginAluno;
    }

    public Professor getLoginProfessor() {
        return loginProfessor;
    }

    public void setLoginProfessor(Professor loginProfessor) {
        this.loginProfessor = loginProfessor;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
    

}
