package br.com.excaladashboard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "empresa", length = 256)
    private String empresa;

    @Column(name = "responsavel", length = 256)
    private String responsavel;

    @Column(name = "gestor_de_trafego", length = 256)
    private String gestorTrafego;

    @Column(name = "vendedor", length = 256)
    private String vendedor;

    @Column(name = "ativo", length = 256)
    private String ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getGestorTrafego() {
        return gestorTrafego;
    }

    public void setGestorTrafego(String gestorTrafego) {
        this.gestorTrafego = gestorTrafego;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}