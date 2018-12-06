package br.edu.ifrn.apiypsos.dominio;

public class PlanoExercicio {

    private int repeticoes;
    private String nomeExercicio;
    private int series;
    private int carga;
    private String observacoes;
    private Plano idPlano;
    private Exercicio idExercicio;
    
    public PlanoExercicio(){
        
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Plano getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Plano idPlano) {
        this.idPlano = idPlano;
    }

    public Exercicio getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(Exercicio idExercicio) {
        this.idExercicio = idExercicio;
    }
    
    

}
