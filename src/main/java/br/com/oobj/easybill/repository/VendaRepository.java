package br.com.oobj.easybill.repository;

import br.com.oobj.easybill.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}