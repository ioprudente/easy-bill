package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.DevolucaoProduto;
import br.com.oobj.easybill.model.Produto;
import br.com.oobj.easybill.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoAPIController {

    private ProdutoRepository produtoRepository;

    public ProdutoAPIController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/api/produtos")
    public List<DevolucaoProduto> produtos(){
        List<Produto> produtos = produtoRepository.findAll();
        return DevolucaoProduto.converter(produtos);
    }
}