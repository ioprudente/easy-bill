package br.com.oobj.easybill.repository;

import br.com.oobj.easybill.model.ItemVenda;
import br.com.oobj.easybill.projection.VendaPorProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
    List<ItemVenda> findAllByVenda_Id(Long id);

    @Query(value = "SELECT P.NOME AS \"NOMEPRODUTO\", SUM(QUANTIDADE) AS \"QUANTIDADE\" FROM ITENS_VENDA I JOIN PRODUTOS P ON P.ID=I.PRODUTO_ID GROUP BY (PRODUTO_ID)", nativeQuery = true)
    List<VendaPorProduto> relatorioVendaPorProduto();
}