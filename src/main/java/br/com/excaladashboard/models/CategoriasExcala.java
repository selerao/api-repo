package br.com.excaladashboard.models;

import javax.persistence.*;

@Entity
@Table(name = "categorias_excala")
public class CategoriasExcala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "gestor_trafego_categoria", length = 150)
    private String gestorTrafegoCategoria;

    @Column(name = "vendedor_clt", length = 150)
    private String vendedorClt;

    @Column(name = "vendedor_pj", length = 150)
    private String vendedorPj;

    @Column(name = "indicador", length = 150)
    private String indicador;

    @Column(name = "franqueado", length = 150)
    private String franqueado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGestorTrafegoCategoria() {
        return gestorTrafegoCategoria;
    }

    public void setGestorTrafegoCategoria(String gestorTrafegoCategoria) {
        this.gestorTrafegoCategoria = gestorTrafegoCategoria;
    }

    public String getVendedorClt() {
        return vendedorClt;
    }

    public void setVendedorClt(String vendedorClt) {
        this.vendedorClt = vendedorClt;
    }

    public String getVendedorPj() {
        return vendedorPj;
    }

    public void setVendedorPj(String vendedorPj) {
        this.vendedorPj = vendedorPj;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public String getFranqueado() {
        return franqueado;
    }

    public void setFranqueado(String franqueado) {
        this.franqueado = franqueado;
    }

}