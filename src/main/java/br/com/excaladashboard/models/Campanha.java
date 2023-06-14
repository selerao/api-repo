package br.com.excaladashboard.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "campanhas")
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    @JsonBackReference
    private Conta conta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campanha")
    @JsonManagedReference
    private List<Conjunto> conjuntos = new ArrayList<>();

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "id_externo", length = 150)
    private String idExterno;

    @Column(name = "nome", length = 256)
    private String nome;

    @Column(name = "gestor_de_trafego", length = 256)
    private String gestorTrafego;

    @Column(name = "resultados")
    private Long resultados;

    @Column(name = "custo_por_resultado", precision = 15, scale = 2)
    private Double custoPorResultado;

    @Column(name = "valor_gasto", precision = 15, scale = 2)
    private Double valorGasto;

    @Column(name = "orcamento", precision = 15, scale = 2)
    private Double orcamento;

    @Column(name = "cliques")
    private Long clicks;

    @Column(name = "cpm", precision = 15, scale = 2)
    private Double cpm;

    @Column(name = "ctr", precision = 15, scale = 2)
    private Double ctr;

    @Column(name = "cpc", precision = 15, scale = 2)
    private Double cpc;

    @Column(name = "frequencia", precision = 5, scale = 4)
    private Double frequencia;

    @Column(name = "custo_medio_lead", precision = 15, scale = 2)
    private Double custoMedioLead;

    @Column(name = "custo_medio_lead_7", precision = 15, scale = 2)
    private Double custoMedioLead7;

    @Column(name = "custo_medio_lead_30", precision = 15, scale = 2)
    private Double custoMedioLead30;

    @Column(name = "custo_medio_lead_90", precision = 15, scale = 2)
    private Double custoMedioLead90;

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

    public List<Conjunto> getConjuntos() {
        return conjuntos;
    }

    public void setConjuntos(List<Conjunto> conjuntos) {
        this.conjuntos = conjuntos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
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

    public void setGestorTrafego(String gestorTrafego) {
        this.gestorTrafego = gestorTrafego;
    }

    public Long getResultados() {
        return resultados;
    }

    public void setResultados(Long resultados) {
        this.resultados = resultados;
    }

    public Double getCustoPorResultado() {
        return custoPorResultado;
    }

    public void setCustoPorResultado(Double custoPorResultado) {
        this.custoPorResultado = custoPorResultado;
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

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
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

    public Double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Double frequencia) {
        this.frequencia = frequencia;
    }

    public Double getCustoMedioLead() {
        return custoMedioLead;
    }

    public void setCustoMedioLead(Double custoMedioLead) {
        this.custoMedioLead = custoMedioLead;
    }

    public Double getCustoMedioLead7() {
        return custoMedioLead7;
    }

    public void setCustoMedioLead7(Double custoMedioLead7) {
        this.custoMedioLead7 = custoMedioLead7;
    }

    public Double getCustoMedioLead30() {
        return custoMedioLead30;
    }

    public void setCustoMedioLead30(Double custoMedioLead30) {
        this.custoMedioLead30 = custoMedioLead30;
    }

    public Double getCustoMedioLead90() {
        return custoMedioLead90;
    }

    public void setCustoMedioLead90(Double custoMedioLead90) {
        this.custoMedioLead90 = custoMedioLead90;
    }
}

