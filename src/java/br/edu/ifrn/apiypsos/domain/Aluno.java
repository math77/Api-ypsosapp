package br.edu.ifrn.apiypsos.domain;

import br.edu.ifrn.apiypsos.data.AlunoDAO;
import java.util.Date;
import java.util.List;

public class Aluno {
    
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String sexo;
    private Date dataNascimento;
    private Date dataIngresso;
    private boolean ativo;

    public Aluno() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public boolean login(){
        return AlunoDAO.login(this);
    }
    
    public boolean create(){
        return AlunoDAO.createAluno(this);
    }
    
    public static boolean saveToken(String token, String email){
        return AlunoDAO.saveToken(token, email);
    }
    
    public static List<Aluno> getAlunos(){
        return AlunoDAO.listarAlunos();
    }
}
