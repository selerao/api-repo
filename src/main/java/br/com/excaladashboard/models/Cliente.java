package br.com.excaladashboard.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "empresa", length = 256)
    private String empresa;

    @Column(name = "telefone", length = 256)
    private String telefone;

    @Column(name = "email", length = 256)
    private String email;

    @Column(name = "cnpj", length = 256)
    private String cnpj;

    @Column(name = "cpf", length = 256)
    private String cpf;

    @Column(name = "pagamento_em_dia", length = 256)
    private String pagamentoDia;

    @Column(name = "contrato_assinado", length = 256)
    private String contratoAssinado;

    @Column(name = "preco_fixo_contrato", precision = 15, scale = 2)
    private Double precoFixoContrato;

    @Column(name = "taxa_variavel_contrato", precision = 15, scale = 2)
    private Double taxaVariavel;

    @Column(name = "inicio_contrato")
    @Temporal(TemporalType.DATE)
    private Date inicioContrato;

    @Column(name = "tempo_contrato_ativo")
    @Temporal(TemporalType.DATE)
    private Date contratoAtivo;

    @Column(name = "status_contrato", length = 256)
    private String statusContrato;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "cliente")
    private List<Conta> contas;

    @Column(name = "vendedor_responsavel", length = 256)
    private String vendedorResponsavel;

    @Column(name = "produtos_anunciados", length = 256)
    private String produtosAnunciados;

    @Column(name = "valor_total_mes", length = 256)
    private String valorTotalMes;

    @Column(name = "pagamento_feito", length = 256)
    private String pagamentoFeito;

    @Column(name = "subdivisao", length = 256)
    private String subdivisao;

    @Column(name = "valor_vendido", length = 256)
    private String valorVendido;

    @Column(name = "cotas_vendidas", length = 256)
    private String cotasVendidas;

    @Column(name = "clientes_compradores", length = 256)
    private String clientesCompradores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPagamentoDia() {
        return pagamentoDia;
    }

    public void setPagamentoDia(String pagamentoDia) {
        this.pagamentoDia = pagamentoDia;
    }

    public String getContratoAssinado() {
        return contratoAssinado;
    }

    public void setContratoAssinado(String contratoAssinado) {
        this.contratoAssinado = contratoAssinado;
    }

    public Double getPrecoFixoContrato() {
        return precoFixoContrato;
    }

    public void setPrecoFixoContrato(Double precoFixoContrato) {
        this.precoFixoContrato = precoFixoContrato;
    }

    public Double getTaxaVariavel() {
        return taxaVariavel;
    }

    public void setTaxaVariavel(Double taxaVariavel) {
        this.taxaVariavel = taxaVariavel;
    }

    public Date getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(Date inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public Date getContratoAtivo() {
        return contratoAtivo;
    }

    public void setContratoAtivo(Date contratoAtivo) {
        this.contratoAtivo = contratoAtivo;
    }

    public String getStatusContrato() {
        return statusContrato;
    }

    public void setStatusContrato(String statusContrato) {
        this.statusContrato = statusContrato;
    }

    public String getVendedorResponsavel() {
        return vendedorResponsavel;
    }

    public void setVendedorResponsavel(String vendedorResponsavel) {
        this.vendedorResponsavel = vendedorResponsavel;
    }

    public String getProdutosAnunciados() {
        return produtosAnunciados;
    }

    public void setProdutosAnunciados(String produtosAnunciados) {
        this.produtosAnunciados = produtosAnunciados;
    }

    public String getValorTotalMes() {
        return valorTotalMes;
    }

    public void setValorTotalMes(String valorTotalMes) {
        this.valorTotalMes = valorTotalMes;
    }

    public String getPagamentoFeito() {
        return pagamentoFeito;
    }

    public void setPagamentoFeito(String pagamentoFeito) {
        this.pagamentoFeito = pagamentoFeito;
    }

    public String getSubdivisao() {
        return subdivisao;
    }

    public void setSubdivisao(String subdivisao) {
        this.subdivisao = subdivisao;
    }

    public String getValorVendido() {
        return valorVendido;
    }

    public void setValorVendido(String valorVendido) {
        this.valorVendido = valorVendido;
    }

    public String getCotasVendidas() {
        return cotasVendidas;
    }

    public void setCotasVendidas(String cotasVendidas) {
        this.cotasVendidas = cotasVendidas;
    }

    public String getClientesCompradores() {
        return clientesCompradores;
    }

    public void setClientesCompradores(String clientesCompradores) {
        this.clientesCompradores = clientesCompradores;
    }



    }