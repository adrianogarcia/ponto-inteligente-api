package br.com.memory.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.memory.pontointeligente.api.entities.Lancamento;

public interface LancamentoService
{

	/**
	 * Retornar uma lista paginada de um determinado funcionário.
	 * 
	 * @param funcionarioId
	 * @param pageRequest
	 * @return Page<Lancamento>
	 */
	Page<Lancamento> buscarPorFuncionario(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * 	Retornar um lançamento por Id.
	 * 
	 * @param id
	 * @return Optional<Lancamento>
	 */
	Optional<Lancamento> buscarPorId(Long id);
	
	/**
	 * 
	 * @param lancamento
	 * @return Lancamento
	 */
	Lancamento persistir(Lancamento lancamento);
	
	/**
	 * Remover um lançamento da base de dados.
	 * @param id
	 */
	void remover(Long id);
	
}
