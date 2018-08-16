package br.com.memory.pontointeligente.api.services;

import java.util.Optional;

import br.com.memory.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService
{

	/**
	 * Persiste um funcionário na base de dados.
	 * 
	 * @param funcionario
	 * @return
	 */
	Funcionario persistir(Funcionario funcionario);
	

	/**
	 * 
	 * Buscar e retornar um funcionário dado um cpf.
	 * 
	 * @param cpf
	 * @return Funcionario
	 */
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * 
	 * Buscar e retornar um funcionário dado um email.
	 * 
	 * @param email
	 * @return Funcionario
	 */
	Optional<Funcionario> buscarPorEmail(String email);
	
	/**
	 * 
	 * Buscar e retornar um funcionário por Id.
	 * 
	 * @param id
	 * @return Funcionario
	 */
	Optional<Funcionario> buscarPorId(Long id);
	
	
}












