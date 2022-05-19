package br.com.oobj.easybill.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;


@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    @Length(max = 150)
    private String nome;

    @Column
    @NotBlank
    @Length(max = 500)
    private String urlImagem;

    @Column
    @Length(max = 1000)
    private String descricao;

    @Column
    @Positive
    private BigDecimal preco;

    @Column
    @Positive
    private BigDecimal precoPromocional;

    @Column
    @NotBlank
    @Length(max = 10)
    private String classeFiscal;

    public void setPrecoPromocional(BigDecimal precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setpreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setPrecopromocional(BigDecimal precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getimagemURL() {
        return urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public BigDecimal getPrecoPromocional() {
        return precoPromocional;
    }

}
