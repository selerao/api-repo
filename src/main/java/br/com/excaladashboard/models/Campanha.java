package br.com.excaladashboard.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "campanhas")
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="conta_id", nullable=false)
    private Conta conta;

    @Column(name = "nome", length = 256)
    private String nome;

    @Column(name = "gestor_de_trafego", length = 256)
    private String gestorTrafego;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facebook")
    private List<Anuncio> anuncios;

    @Column(name = "resultados", precision = 15, scale = 2)
    private Double resultados;

    @Column(name = "custo_por_resultados", precision = 15, scale = 2)
    private Double custoresultados;

    @Column(name = "valor_gasto", precision = 15, scale = 2)
    private Double valorGasto;

    @Column(name = "orcamento", precision = 15, scale = 2)
    private Double orcamento;

    @Column(name = "cpm", precision = 15, scale = 2)
    private Double cpm;

    @Column(name = "ctr", precision = 15, scale = 2)
    private Double ctr;

    @Column(name = "cpc",precision = 15, scale = 2)
    private Double cpc;

    @Column(name = "frequencia")
    private Long frequencia;

    @Column(name = "custo_medio_lead", precision = 15, scale = 2)
    private Double customediolead7;

    @Column(name = "custo_medio_lead_7", precision = 15, scale = 2)
    private Double customediolead30;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGestorTrafego() {
        return gestorTrafego;
    }


    public Double getResultados() {
        return resultados;
    }

    public void setResultados(Double resultados) {
        this.resultados = resultados;
    }

    public Double getCustoresultados() {
        return custoresultados;
    }

    public void setCustoresultados(Double custoresultados) {
        this.custoresultados = custoresultados;
    }

    public Double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(Double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public Double getCpm() {
        return cpm;
    }

    public void setCpm(Double cpm) {
        this.cpm = cpm;
    }

    public Double getCtr() {
        return ctr;
    }

    public void setCtr(Double ctr) {
        this.ctr = ctr;
    }

    public Double getCpc() {
        return cpc;
    }

    public void setCpc(Double cpc) {
        this.cpc = cpc;
    }

    public Long getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Long frequencia) {
        this.frequencia = frequencia;
    }

    public Double getCustomediolead7() {
        return customediolead7;
    }

    public void setCustomediolead7(Double customediolead7) {
        this.customediolead7 = customediolead7;
    }

    public Double getCustomediolead30() {
        return customediolead30;
    }

    public void setCustomediolead30(Double customediolead30) {
        this.customediolead30 = customediolead30;
    }

    public Double getCustomediolead60() {
        return customediolead60;
    }

    public void setCustomediolead60(Double customediolead60) {
        this.customediolead60 = customediolead60;
    }

    public Double getCustomedioleadvitalicio() {
        return customedioleadvitalicio;
    }

    public void setCustomedioleadvitalicio(Double customedioleadvitalicio) {
        this.customedioleadvitalicio = customedioleadvitalicio;
    }

    @Column(name = "custo_medio_lead_30", precision = 15, scale = 2)
    private Double customediolead60;

    @Column(name = "custo_medio_lead_60", precision = 15, scale = 2)
    private Double customedioleadvitalicio;




}

