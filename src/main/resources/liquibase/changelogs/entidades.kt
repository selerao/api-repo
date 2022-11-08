import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "empresa", nullable = false, length = 256)
    private String Empresa;

    @Column(name = "responsavel", nullable = false, length = 256)
    private String Responsavel;

    @Column(name = "gestor_de_trafego", nullable = false, length = 256)
    private String gestorTrafego;

    @Column(name = "vendedor", nullable = false, length = 256)
    private String Vendedor;

    @Column(name = "ativo", nullable = false, length = 256)
    private String Ativo;


}
@Entity
@Table(name = "facebook_data")
public class FacebookData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta_de_anuncios")
    private Long ContaAnuncio;

    @Column(name = "campanha", nullable = false, length = 256)
    private String Campanha;

    @Column(name = "gestor_de_trafego", nullable = false, length = 256)
    private String GestorTrafego;

    @Column(name = "conjunto_de_anuncios", nullable = false, length = 256)
    private String ConjuntoAnuncios;

    @Column(name = "criativo", nullable = false, length = 256)
    private String Empresa;

    @Column(name = "resultados", nullable = false, length = 256)
    private Long Resultados;

    @Column(name = "custo_por_resultados", nullable = false, length = 256)
    private Long CustoResultados;

    @Column(name = "valor_gasto", nullable = false, length = 256)
    private Long ValorGasto;

    @Column(name = "orcamento", nullable = false, length = 256)
    private Long Orcamento;

    @Column(name = "ctm", nullable = false, length = 256)
    private Long Ctm;

    @Column(name = "ctr", nullable = false, length = 256)
    private Long Ctr;

    @Column(name = "ctc", nullable = false, length = 256)
    private Long Ctc;

    @Column(name = "frequencia", nullable = false, length = 256)
    private Long Frequencia;

    @Column(name = "custo_medio_lead", nullable = false, length = 256)
    private Long CustoMedioLead7;

    @Column(name = "custo_medio_lead_7", nullable = false, length = 256)
    private Long CustoMedioLead30;

    @Column(name = "custo_medio_lead_30", nullable = false, length = 256)
    private Long CustoMedioLead60;

    @Column(name = "custo_medio_lead_60", nullable = false, length = 256)
    private Long CustoMedioLeadVitalicio;

}

@Entity
@Table(name = "contas")
public class Contas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id1;

    @Column(name = "email", nullable = false, length = 256)
    private String Email;

}