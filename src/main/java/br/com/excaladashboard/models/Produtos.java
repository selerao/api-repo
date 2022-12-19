package br.com.excaladashboard.models;

import javax.persistence.*;

@Entity
@Table(name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "produto", length = 150)
    private String produto;

    @Column(name = "categoria", length = 150)
    private String categoria;

    @Column(name = "subcategorias", length = 256)
    private String subCategorias;

    @Column(name = "adesao", length = 256)
    private String adesao;

    @Column(name = "tipo_venda", length = 256)
    private String tipoVenda;

    @Column(name = "administradores", length = 256)
    private String administradores;

    @Column(name = "tipos_anuncios", length = 256)
    private String tiposAnuncios;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(String subCategorias) {
        this.subCategorias = subCategorias;
    }

    public String getAdesao() {
        return adesao;
    }

    public void setAdesao(String adesao) {
        this.adesao = adesao;
    }

    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
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