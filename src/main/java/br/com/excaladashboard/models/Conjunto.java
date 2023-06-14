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
@Table(name = "conjuntos")
public class Conjunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campanha_id", nullable = false)
    @JsonBackReference
    private Campanha campanha;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conjunto")
    @JsonManagedReference
    private List<Anuncio> anuncios = new ArrayList<>();

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "id_externo", length = 150)
    private String idExterno;

    @Column(name = "nome", length = 256)
    private String nome;

    @Column(name = "resultados")
    private Long resultados;

    @Column(name = "valor_gasto", precision = 15, scale = 2)
    private Double valorGasto;

    @Column(name = "custo_por_resultado", precision = 15, scale = 2)
    private Double custoPorResultado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
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

    public Long getResultados() {
        return resultados;
    }

    public void setResultados(Long resultados) {
        this.resultados = resultados;
    }

    public Double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(Double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public Double getCustoPorResultado() {
        return custoPorResultado;
    }

    public void setCustoPorResultado(Double custoPorResultado) {
        this.custoPorResultado = custoPorResultado;
    }
}
