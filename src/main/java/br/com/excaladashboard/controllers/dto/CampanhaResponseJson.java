package br.com.excaladashboard.controllers.dto;

import br.com.excaladashboard.models.Conta;

import java.util.Date;

public class CampanhaResponseJson {

    private Long id;
    private String responsavel;
    private Date data;
    private String idExterno;
    private String nome;
    private String gestorTrafego;
    private Long resultados;
    private String custoPorResultado;
    private String valorGasto;
    private String orcamento;
    private Long clicks;
    private String cpm;
    private String ctr;
    private String cpc;
    private String frequencia;

    public Long getId() {
        return this.id;
    }

    public CampanhaResponseJson setId(Long id) {
        this.id = id;
        return this;
    }

    public String getResponsavel() {
        return this.responsavel;
    }

    public CampanhaResponseJson setResponsavel(String responsavel) {
        this.responsavel = responsavel;
        return this;
    }

    public Date getData() {
        return this.data;
    }

    public CampanhaResponseJson setData(Date data) {
        this.data = data;
        return this;
    }

    public String getIdExterno() {
        return this.idExterno;
    }

    public CampanhaResponseJson setIdExterno(String idExterno) {
        this.idExterno = idExterno;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public CampanhaResponseJson setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getGestorTrafego() {
        return this.gestorTrafego;
    }

    public CampanhaResponseJson setGestorTrafego(String gestorTrafego) {
        this.gestorTrafego = gestorTrafego;
        return this;
    }

    public Long getResultados() {
        return this.resultados;
    }

    public CampanhaResponseJson setResultados(Long resultados) {
        this.resultados = resultados;
        return this;
    }

    public String getCustoPorResultado() {
        return this.custoPorResultado;
    }

    public CampanhaResponseJson setCustoPorResultado(String custoPorResultado) {
        this.custoPorResultado = custoPorResultado;
        return this;
    }

    public String getValorGasto() {
        return this.valorGasto;
    }

    public CampanhaResponseJson setValorGasto(String valorGasto) {
        this.valorGasto = valorGasto;
        return this;
    }

    public String getOrcamento() {
        return this.orcamento;
    }

    public CampanhaResponseJson setOrcamento(String orcamento) {
        this.orcamento = orcamento;
        return this;
    }

    public Long getClicks() {
        return this.clicks;
    }

    public CampanhaResponseJson setClicks(Long clicks) {
        this.clicks = clicks;
        return this;
    }

    public String getCpm() {
        return this.cpm;
    }

    public CampanhaResponseJson setCpm(String cpm) {
        this.cpm = cpm;
        return this;
    }

    public String getCtr() {
        return this.ctr;
    }

    public CampanhaResponseJson setCtr(String ctr) {
        this.ctr = ctr;
        return this;
    }

    public String getCpc() {
        return this.cpc;
    }

    public CampanhaResponseJson setCpc(String cpc) {
        this.cpc = cpc;
        return this;
    }

    public String getFrequencia() {
        return this.frequencia;
    }

    public CampanhaResponseJson setFrequencia(String frequencia) {
        this.frequencia = frequencia;
        return this;
    }
}
