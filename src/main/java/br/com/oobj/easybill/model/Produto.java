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
    private static String nome;

    @Column
    @NotBlank
    @Length(max = 500)
    private static String urlImagem;

    @Column
    @Length(max = 1000)
    private static String descricao;

    @Column
    @Positive
    private static BigDecimal preco;

    @Column
    @Positive
    private BigDecimal precoPromocional;

    @Column
    @NotBlank
    @Length(max = 10)
    private static String classeFiscal;


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setPrecopromocional(BigDecimal precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    public void setClasseFiscal (String classeFiscal) { this.classeFiscal = classeFiscal;}

    public Long getId() {
        return id;
    }

    public static String getNome() {
        return nome;
    }

    public static String getUrlImagem() {
        return urlImagem;
    }

    public static String getDescricao() {
        return descricao;
    }

    public static BigDecimal getPreco() {
        return preco;
    }

    public BigDecimal getPrecoPromocional() {
        return precoPromocional;
    }

    public static String getClasseFiscal() {
        return classeFiscal;
    }
}
