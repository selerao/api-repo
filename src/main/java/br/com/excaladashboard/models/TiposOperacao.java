package br.com.excaladashboard.models;

import javax.persistence.*;

@Entity
@Table(name = "tipos_operacao")
public class TiposOperacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "modelo_venda", length = 150)
    private String modeloVenda;

    @Column(name = "abrangencia_anuncios", length = 150)
    private String abrangenciaAnuncios;

    @Column(name = "qual_crm", length = 256)
    private String qualCrm;

    @Column(name = "ferramenta_integracao")
    private Long ferramentaIntegracao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModeloVenda() {
        return modeloVenda;
    }

    public void setModeloVenda(String modeloVenda) {
        this.modeloVenda = modeloVenda;
    }

    public String getAbrangenciaAnuncios() {
        return abrangenciaAnuncios;
    }

    public void setAbrangenciaAnuncios(String abrangenciaAnuncios) {
        this.abrangenciaAnuncios = abrangenciaAnuncios;
    }

    public String getQualCrm() {
        return qualCrm;
    }

    public void setQualCrm(String qualCrm) {
        this.qualCrm = qualCrm;
    }

    public Long getFerramentaIntegracao() {
        return ferramentaIntegracao;
    }

    public void setFerramentaIntegracao(Long ferramentaIntegracao) {
        this.ferramentaIntegracao = ferramentaIntegracao;
    }


}