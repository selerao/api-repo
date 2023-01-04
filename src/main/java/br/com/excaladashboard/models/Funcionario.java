package br.com.excaladashboard.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_completo", length = 256)
    private String nomeCompleto;

    @Column(name = "email_corporativo", length = 256)
    private String emailCorporativo;

    @Column(name = "email_facebook", length = 256)
    private String emailFacebook;

    @ManyToMany(cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "funcionario_cargo",
            joinColumns = { @JoinColumn(name = "funcionario_id") },
            inverseJoinColumns = { @JoinColumn(name = "cargo_id") })
    private List<Cargo> cargos;

    @Column(name = "cpf")
    private String cpf;


    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "pix")
    private String pix;


    @Column(name = "contrato_assinado")
    private boolean contratoAssinado;

    @Column(name = "responsavel_por_clientes_ativos")
    private String responsavelClientesAtivos;


    @Column(name = "salario", precision = 15, scale = 2)
    private Double salario;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }
    public List<Cargo> getCargos() {
        return cargos;
    }

    public boolean isContratoAssinado() {
        return contratoAssinado;
    }

    public void setContratoAssinado(boolean contratoAssinado) {
        this.contratoAssinado = contratoAssinado;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }


    public String getResponsavelClientesAtivos() {
        return responsavelClientesAtivos;
    }

    public void setResponsavelClientesAtivos(String responsavelClientesAtivos) {
        this.responsavelClientesAtivos = responsavelClientesAtivos;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }


}