package br.edu.ifrn.apiypsos.domain;

public class ProfessorAluno {

    private Professor loginProfessor;
    private Aluno loginAluno;

    public ProfessorAluno() {
    }

    public Professor getLoginProfessor() {
        return loginProfessor;
    }

    public void setLoginProfessor(Professor loginProfessor) {
        this.loginProfessor = loginProfessor;
    }

    public Aluno getLoginAluno() {
        return loginAluno;
    }

    public void setLoginAluno(Aluno loginAluno) {
        this.loginAluno = loginAluno;
    }

}
