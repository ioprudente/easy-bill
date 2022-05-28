package br.com.oobj.easybill.controller;

import br.com.oobj.easybill.dto.DevolucaoProduto;
import br.com.oobj.easybill.dto.ProdutoRequest;
import br.com.oobj.easybill.model.Produto;
import br.com.oobj.easybill.repository.ProdutoRepository;
import br.com.oobj.easybill.validador.PrecoPromocionalValidador;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProdutoController {

    private ProdutoRepository produtoRepository;
    private PrecoPromocionalValidador precoPromocionalValidador;

    public ProdutoController(ProdutoRepository produtoRepository, PrecoPromocionalValidador precoPromocionalValidator) {
        this.produtoRepository = produtoRepository;
        this.precoPromocionalValidador = precoPromocionalValidador;
    }

    @GetMapping("/produtos/formulario")
    public String formulario(ProdutoRequest produtoRequest) {
        return "formulario.html";
    }

    @GetMapping("/produto")
    public ModelAndView listaProdutos() {
        ModelAndView modelAndView = new ModelAndView("/produto");
        modelAndView.addObject("produto", this.listagemDeProdutos());
        return modelAndView;
    }


    @GetMapping("/produtos")
    public List<DevolucaoProduto> listagemDeProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return DevolucaoProduto.converter(produtos);
    }


    @PostMapping("/produtos/novo")
    public String novo(@Valid ProdutoRequest produtoRequest, BindingResult result) {
        precoPromocionalValidador.valid(produtoRequest, result);
        if (result.hasErrors()) {
            return "/produtos/formulario.html";
        }
        Produto produto = produtoRequest.toProduto();
        produtoRepository.save(produto);

        return "redirect:/produtos/formulario";
    }
}