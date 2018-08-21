package br.com.memory.pontointeligente.api.services;

import java.util.Optional;

import br.com.memory.pontointeligente.api.entities.Empresa;

public interface EmpresaService
{
	
	
	/**
	 * Retorna uma empresa dado o CNPJ
	 * 
	 * @param empresa
	 * @retun Opcional<Empresa>
	 * 
	 */
	Optional<Empresa> busacarPorCnpj(String cnpj);
	
	/**
	 * Cadastrar uma nova empresa na base de dados.
	 * 
	 * @param empresa
	 * @return Empresa
	 */
	Empresa persistir(Empresa empresa);
	
	
	
	

}
