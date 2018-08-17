package br.com.memory.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.memory.pontointeligente.api.entities.Lancamento;
import br.com.memory.pontointeligente.api.repository.LancamentoRepository;
import br.com.memory.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService
{
	private static final Logger log = LoggerFactory.getLogger(Lancamento.class);

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	/**
	 * {@link LancamentoService#buscarPorFuncionario(Long, PageRequest)}
	 */
	@Override
	public Page<Lancamento> buscarPorFuncionario(Long funcionarioId, PageRequest pageRequest)
	{
		log.info("Buscando os lançamentos para o funcionário ID {}", funcionarioId);		
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
		
	}

	/**
	 * {@link LancamentoService#buscarPorId(Long)}
	 */
	@Override
	public Optional<Lancamento> buscarPorId(Long id)
	{
		log.info("Buscando um lançamento pelo ID {}", id);
		return this.lancamentoRepository.findById(id);
//		the original code was that below.		
//		return Optional.ofNullable(this.lancamentoRepository.findOne(id));
		
	}

	/**
	 * {@link LancamentoService#persistir(Lancamento)}
	 */
	@Override
	public Lancamento persistir(Lancamento lancamento)
	{
		log.info("Persistindo o lançamento: {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	/**
	 * {@link LancamentoService#remover(Long)}
	 */
	@Override
	public void remover(Long id)
	{
		log.info("Removendo o lançamento ID {}, id");
		this.lancamentoRepository.deleteById(id);
//		the original code was that below.		
//		this.lancamentoRepository.delete(id);

	}

}
