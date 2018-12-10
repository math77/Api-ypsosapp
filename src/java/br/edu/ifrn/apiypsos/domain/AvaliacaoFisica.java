package br.edu.ifrn.apiypsos.domain;

public class AvaliacaoFisica {

    private Aluno aluno;
    private double altura;
    private double peso;
    private long dataAvaliacao;
    private int idAvaliacao;
    
    
    public AvaliacaoFisica(){}

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public long getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(long dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }
    
    

}
