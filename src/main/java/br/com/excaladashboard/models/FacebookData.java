package br.com.excaladashboard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facebook_data")
public class FacebookData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_id", precision = 15, scale = 2)
    private Long id;

    @Column(name = "campanha", precision = 15, scale = 2)
    private String campanha;

    @Column(name = "gestor_de_trafego", precision = 15, scale = 2)
    private String gestorTrafego;

    @Column(name = "conjunto_de_anuncios", precision = 15, scale = 2)
    private String conjuntoAnuncios;

    @Column(name = "criativo", precision = 15, scale = 2)
    private String empresa;

    @Column(name = "resultados", precision = 15, scale = 2)
    private Double resultados;

    @Column(name = "custo_por_resultados", precision = 15, scale = 2)
    private Double custoresultados;

    @Column(name = "valor_gasto", precision = 15, scale = 2)
    private Double valorGasto;

    @Column(name = "orcamento", precision = 15, scale = 2)
    private Double orcamento;

    @Column(name = "ctm", precision = 15, scale = 2)
    private Double ctm;

    @Column(name = "ctr", precision = 15, scale = 2)
    private Double ctr;

    @Column(name = "ctc",precision = 15, scale = 2)
    private Double ctc;

    @Column(name = "frequencia", precision = 15, scale = 2)
    private Double frequencia;

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

    public String getCampanha() {
        return campanha;
    }

    public void setCampanha(String campanha) {
        this.campanha = campanha;
    }

    public String getGestorTrafego() {
        return gestorTrafego;
    }

    public void setGestorTrafego(String gestorTrafego) {
        this.gestorTrafego = gestorTrafego;
    }

    public String getConjuntoAnuncios() {
        return conjuntoAnuncios;
    }

    public void setConjuntoAnuncios(String conjuntoAnuncios) {
        this.conjuntoAnuncios = conjuntoAnuncios;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    public Double getCtm() {
        return ctm;
    }

    public void setCtm(Double ctm) {
        this.ctm = ctm;
    }

    public Double getCtr() {
        return ctr;
    }

    public void setCtr(Double ctr) {
        this.ctr = ctr;
    }

    public Double getCtc() {
        return ctc;
    }

    public void setCtc(Double ctc) {
        this.ctc = ctc;
    }

    public Double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Double frequencia) {
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

