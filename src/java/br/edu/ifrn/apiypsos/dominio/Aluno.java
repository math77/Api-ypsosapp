package br.edu.ifrn.apiypsos.dominio;

import java.util.Date;

public class Aluno {

    private String loginAluno;
    private String nomeAluno;
    private String senha;
    private String cpf;
    private String sexo;
    private Date dataNascimento;
    private Date dataIngresso;
    private boolean ativo;

    public Aluno() {

    }

    public String getLoginAluno() {
        return loginAluno;
    }

    public void setLoginAluno(String loginAluno) {
        this.loginAluno = loginAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    

}
