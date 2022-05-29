package br.com.oobj.easybill.dto;

import br.com.oobj.easybill.model.Produto;
import br.com.oobj.easybill.repository.ProdutoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ProdutoRequest {

    @NotBlank
    @Size(max = 150)
    private String nome;

    @NotBlank
    @Size(max = 500)
    private String urlImagem;

    @Size(max = 1000)
    private String descricao;

    @NotNull
    @Min(1)
    private BigDecimal preco;

    @Min(1)
    private BigDecimal precoPromocional;

    @NotBlank
    @Length(min = 10, max = 10)
    @Pattern(regexp = "^[0-9]{4}[.][0-9]{2}[.][0-9]{2}+$")
    private String classeFiscal;

    public ProdutoRequest(Produto produto) {
        if (produto != null) {


            this.nome = produto.getNome();
            this.preco = produto.getPreco();
            this.descricao = produto.getDescricao();
            this.urlImagem = produto.getUrlImagem();
            this.precoPromocional = produto.getPrecoPromocional();
            this.classeFiscal = produto.getClasseFiscal();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPrecoPromocional() {
        return precoPromocional;
    }

    public void setPrecoPromocional(BigDecimal precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    public String getClasseFiscal() {
        return classeFiscal;
    }

    public void setClasseFiscal(String classeFiscal) {
        this.classeFiscal = classeFiscal;
    }

    public Produto toProduto() {
        Produto produto = new Produto();

        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setUrlImagem(urlImagem);
        produto.setPreco(preco);
        produto.setPrecopromocional(precoPromocional);
        produto.setClasseFiscal(classeFiscal);

        return produto;
    }

    public Produto update(Long id, ProdutoRepository produtoRepository) {
        Produto produto = produtoRepository.getById(id);

        produto.setNome(this.nome);
        produto.setDescricao(this.descricao);
        produto.setUrlImagem(this.urlImagem);
        produto.setPreco(this.preco);
        produto.setPrecopromocional(this.precoPromocional);
        produto.setClasseFiscal(this.classeFiscal);
        return produto;
    }
}