package br.com.inottec.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.inottec.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
