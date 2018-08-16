/**
 * 
 */
package br.com.memory.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.memory.pontointeligente.api.entities.Empresa;
import br.com.memory.pontointeligente.api.repository.EmpresaRepository;
import br.com.memory.pontointeligente.api.services.EmpresaService;

/**
 * @author adriano
 *
 */
@Service
public class EmpresaServiceImpl implements EmpresaService
{
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	/**
	 * {@link EmpresaService#busacarPorCnpj(String)}
	 */
	@Override
	public Optional<Empresa> busacarPorCnpj(String cnpj)
	{
		log.info("Buscando uma empresa paraq o CNPJ {}", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	/**
	 * {@link EmpresaService#pesistir(Empresa)}
	 */
	@Override
	public Empresa pesistir(Empresa empresa)
	{
		log.info("Persistindo empresa {}", empresa);
		return this.empresaRepository.save(empresa);
	}

}
