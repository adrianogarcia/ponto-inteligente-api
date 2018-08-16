package br.com.memory.pontointeligente.api.repository;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.memory.pontointeligente.api.entities.Lancamento;

@Transactional(readOnly = true)
@NamedQueries
({
	@NamedQuery(name  = "LancamentoRepository.findByFuncionarioId",
				query = "select lanc from Lancamento lanc where lanc.funcionario.id = :funcionarioId") 
})
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>
{
	
	/**
	 * 	Pesquisar um lista de lançamentos relacionados a um determinado funcionario.
	 * 
	 * @param funcionarioId
	 * @return List<Lancamento>
	 */
	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
	
	/**
	 * 
	 * @param funcionarioId
	 * @param pageable
	 * @return Page<Lancamento>
	 */
	Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
	

}
