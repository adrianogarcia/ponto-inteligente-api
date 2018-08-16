package br.com.memory.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.memory.pontointeligente.api.entities.Funcionario;
import br.com.memory.pontointeligente.api.repository.FuncionarioRepository;
import br.com.memory.pontointeligente.api.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService
{

	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	/**
	 * {@link FuncionarioService#persistir(Funcionario)}
	 */
	@Override
	public Funcionario persistir(Funcionario funcionario)
	{
		log.info("Persistindo funcionario: {}", funcionario);
		return this.funcionarioRepository.save(funcionario);
	}

	/**
	 * {@link FuncionarioService#buscarPorCpf(String)}
	 */
	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf)
	{
		log.info("Buscando funcionario pelo CPF: {} ", cpf);
		return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
	}

	/**
	 * {@link FuncionarioService#buscarPorEmail(String)}
	 */
	@Override
	public Optional<Funcionario> buscarPorEmail(String email)
	{
		log.info("Buscando funcionário pelo e-mail: {}", email);		
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
	}

	/**
	 * {@link FuncionarioService#buscarPorId(Long)}
	 */
	@Override
	public Optional<Funcionario> buscarPorId(Long id)
	{
		log.info("Buscando funcionário pelo Id: {}", id);
		return this.funcionarioRepository.findById(id);
//		return Optional.ofNullable(this.funcionarioRepository.findOne(id));
		
	}

}
