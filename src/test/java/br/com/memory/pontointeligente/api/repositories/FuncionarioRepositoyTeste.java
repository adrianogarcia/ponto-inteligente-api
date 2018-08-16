package br.com.memory.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.memory.pontointeligente.api.entities.Empresa;
import br.com.memory.pontointeligente.api.entities.Funcionario;
import br.com.memory.pontointeligente.api.enums.PerfilEnum;
import br.com.memory.pontointeligente.api.repository.EmpresaRepository;
import br.com.memory.pontointeligente.api.repository.FuncionarioRepository;
import br.com.memory.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoyTeste
{
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String CNPJ = "51463645000100";

	private static final String EMAIL = "email@email.com";
	private static final String CPF   = "24291173474";
	
	@Before
	public void setUp() throws Exception
	{
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		this.funcionarioRepository.save(obterDadosFuncionario(empresa));
	}

	
	@After
	public final void tearDown()
	{
		this.empresaRepository.deleteAll();
	}

	
	/**
	 * Testar a recuperação de um objeto Funcionario pelo seu 
	 * EMAIL.
	 */
	@Test
	public void testBuscarFuncionarioPorEmail()
	{
		Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);
		assertEquals(EMAIL, funcionario.getEmail());
	}
	
	/**
	 * Testar a recuperação de um objeto Funcionario pelo seu 
	 * CPF.
	 */
	@Test
	public void testBuscarFuncionarioPorCpf()
	{
		Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);
		assertEquals(CPF, funcionario.getCpf());
	}
	
	
	/**
	 * Testar a recuperação de um objeto Funcionario pelo seu 
	 * CPF ou EMAIL.
	 */
	@Test
	public void testBuscarFuncionarioPorEmailECpf()
	{
		Funcionario funcionario = funcionarioRepository.findByCpfOrEmail(CPF, EMAIL);
		assertNotNull(funcionario);
	}
	
	/**
	 * Testar a recuperação de um objeto Funcionario pelo seu 
	 * CPF ou EMAIL para e-mail inválido.
	 */
	@Test
	public void testBuscarFuncionarioPorCpfOuEmailParaEmailInvalido()
	{
		Funcionario funcionario = funcionarioRepository.findByCpfOrEmail(CPF, "email@invalido.com");
		assertNotNull(funcionario);
	}
	
	/**
	 * Testar a recuperação de um objeto Funcionario pelo seu 
	 * CPF ou EMAIL para e-mail inválido.
	 */
	@Test
	public void testBuscarFuncionarioPorEmaiECpflParaCpfInvalido()
	{
		Funcionario funcionario = funcionarioRepository.findByCpfOrEmail("12345678901", EMAIL);
		assertNotNull(funcionario);
	}
	
	/**
	 * Criar um objeto Empresa para o contexto deste teste
	 * de persistência.
	 * @return Empresa
	 */
	private Empresa obterDadosEmpresa()
	{
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj(CNPJ);
		return empresa;
	}

	
	/**
	 * Obter uma instãncia do objeto funcionário para o contexto 
	 * de teste de persistência.
	 * 
	 * @param empresa
	 * @return Funcionario
	 */
	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException
	{
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fulano de tal");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.gerarBCrypt("123456"));
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setEmpresa(empresa);
		return funcionario;
	}
	
}
