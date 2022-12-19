package br.com.excaladashboard.models;

import javax.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_completo", length = 150)
    private String nomeCompleto;

    @Column(name = "email_corporativo", length = 150)
    private String emailCorporativo;

    @Column(name = "email_facebook", length = 150)
    private String emailFacebook;

    @Column(name = "categoria", length = 256)
    private String categoria;

    @Column(name = "cpf_funcionario")
    private String cpfFuncionario;

    @Column(name = "cnpj_funcionario")
    private String cnpjFuncionario;

    @Column(name = "pix_funcionario")
    private String pixFuncionario;

    @Column(name = "contrato_assinado")
    private String contratoAssinado;

    @Column(name = "responsavel_por_clientes_ativos")
    private String responsavelClientesAtivos;

    @Column(name = "salario")
    private String salario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    public String getEmailFacebook() {
        return emailFacebook;
    }

    public void setEmailFacebook(String emailFacebook) {
        this.emailFacebook = emailFacebook;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getCnpjFuncionario() {
        return cnpjFuncionario;
    }

    public void setCnpjFuncionario(String cnpjFuncionario) {
        this.cnpjFuncionario = cnpjFuncionario;
    }

    public String getPixFuncionario() {
        return pixFuncionario;
    }

    public void setPixFuncionario(String pixFuncionario) {
        this.pixFuncionario = pixFuncionario;
    }

    public String getContratoAssinado() {
        return contratoAssinado;
    }

    public void setContratoAssinado(String contratoAssinado) {
        this.contratoAssinado = contratoAssinado;
    }

    public String getResponsavelClientesAtivos() {
        return responsavelClientesAtivos;
    }

    public void setResponsavelClientesAtivos(String responsavelClientesAtivos) {
        this.responsavelClientesAtivos = responsavelClientesAtivos;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

}