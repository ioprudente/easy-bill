package br.com.oobj.easybill.validador;

import br.com.oobj.easybill.dto.ProdutoRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import static java.util.Objects.isNull;

@Component
public class PrecoPromocionalValidador {

    public void valid(@NotNull ProdutoRequest requisition, BindingResult result) {
        if (isNull(requisition.getPrecoPromocional())) {
            return;
        }
        if (isNull(requisition.getPrecoPromocional())) {
            return;
        }
        Integer compare = requisition.getPrecoPromocional().compareTo(requisition.getPrecoPromocional());
        if (compare.equals(1)) {
            return;
        }
        result.rejectValue("PrecoPromocional", "", "O  preço promocional é maior que o preço!");
    }
}
