package br.com.excaladashboard.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 150)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    @JsonBackReference
    private Categoria categoria;

    @Column(name = "descricao", length = 256)
    private String descricao;

    @Column(name = "adesao", length = 256)
    private boolean adesao;

    @Column(name = "tipo_venda", length = 256)
    @Enumerated(STRING)
    private TipoVenda tipoVenda;

    @Column(name = "administradores", length = 256) // duvida
    private String administradores;

    @Column(name = "tipos_anuncios", length = 256) // duvida
    private String tiposAnuncios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAdesao() {
        return adesao;
    }

    public void setAdesao(boolean adesao) {
        this.adesao = adesao;
    }

    public TipoVenda getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(TipoVenda tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public String getAdministradores() {
        return administradores;
    }

    public void setAdministradores(String administradores) {
        this.administradores = administradores;
    }

    public String getTiposAnuncios() {
        return tiposAnuncios;
    }

    public void setTiposAnuncios(String tiposAnuncios) {
        this.tiposAnuncios = tiposAnuncios;
    }
}