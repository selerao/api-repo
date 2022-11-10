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
    @Column(name = "conta_id")
    private Long id2;

    @Column(name = "campanha", length = 256)
    private String campanha;

    @Column(name = "gestor_de_trafego", length = 256)
    private String gestorTrafego;

    @Column(name = "conjunto_de_anuncios", length = 256)
    private String conjuntoAnuncios;

    @Column(name = "criativo")
    private String empresa;

    @Column(name = "resultados")
    private Long resultados;

    @Column(name = "custo_por_resultados")
    private Long custoresultados;

    @Column(name = "valor_gasto")
    private Long valorGasto;

    @Column(name = "orcamento")
    private Long orcamento;

    @Column(name = "ctm")
    private Long ctm;

    @Column(name = "ctr")
    private Long ctr;

    @Column(name = "ctc",)
    private Long ctc;

    @Column(name = "frequencia")
    private Long frequencia;

    @Column(name = "custo_medio_lead")
    private Long customediolead7;

    @Column(name = "custo_medio_lead_7")
    private Long customediolead30;

    @Column(name = "custo_medio_lead_30" )
    private Long customediolead60;

    @Column(name = "custo_medio_lead_60")
    private Long customedioleadvitalicio;

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
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

    public Long getResultados() {
        return resultados;
    }

    public void setResultados(Long resultados) {
        this.resultados = resultados;
    }

    public Long getCustoresultados() {
        return custoresultados;
    }

    public void setCustoresultados(Long custoresultados) {
        this.custoresultados = custoresultados;
    }

    public Long getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(Long valorGasto) {
        this.valorGasto = valorGasto;
    }

    public Long getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Long orcamento) {
        this.orcamento = orcamento;
    }

    public Long getCtm() {
        return ctm;
    }

    public void setCtm(Long ctm) {
        this.ctm = ctm;
    }

    public Long getCtr() {
        return ctr;
    }

    public void setCtr(Long ctr) {
        this.ctr = ctr;
    }

    public Long getCtc() {
        return ctc;
    }

    public void setCtc(Long ctc) {
        this.ctc = ctc;
    }

    public Long getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Long frequencia) {
        this.frequencia = frequencia;
    }

    public Long getCustomediolead7() {
        return customediolead7;
    }

    public void setCustomediolead7(Long customediolead7) {
        this.customediolead7 = customediolead7;
    }

    public Long getCustomediolead30() {
        return customediolead30;
    }

    public void setCustomediolead30(Long customediolead30) {
        this.customediolead30 = customediolead30;
    }

    public Long getCustomediolead60() {
        return customediolead60;
    }

    public void setCustomediolead60(Long customediolead60) {
        this.customediolead60 = customediolead60;
    }

    public Long getCustomedioleadvitalicio() {
        return customedioleadvitalicio;
    }

    public void setCustomedioleadvitalicio(Long customedioleadvitalicio) {
        this.customedioleadvitalicio = customedioleadvitalicio;
    }

}

