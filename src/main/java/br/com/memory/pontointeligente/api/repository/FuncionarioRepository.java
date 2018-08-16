package br.com.memory.pontointeligente.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.memory.pontointeligente.api.entities.Funcionario;

@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>
{
	
	/**
	 * Pesquisar um funcionario a partir do seu cpf
	 * 
	 * @param cpf
	 * @return Funcionario
	 */
	Funcionario findByCpf(String cpf);
	
	/**
	 * Pesquisar um funcionario a partir do seu email.
	 * 
	 * @param email
	 * @return
	 */
	Funcionario findByEmail(String email);
	
	/**
	 * Pesquisar um funcionario a partir do seu cpf ou do seu email.
	 * 
	 * @param cpf
	 * @param email
	 * @return
	 */
	Funcionario findByCpfOrEmail(String cpf, String email);
	

}
