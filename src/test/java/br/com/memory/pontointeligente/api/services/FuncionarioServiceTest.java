package br.com.memory.pontointeligente.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.memory.pontointeligente.api.entities.Funcionario;
import br.com.memory.pontointeligente.api.repository.FuncionarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceTest
{

	/**
	 * utilizando o moquito para criar uma instância falsa do objeto.
	 */
	@MockBean
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Before
	public void setUp()
	{
		BDDMockito.given(this.funcionarioRepository.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findById(Mockito.anyLong())).willReturn(Optional.ofNullable(new Funcionario()));
		BDDMockito.given(this.funcionarioRepository.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
	}
	
	
	@Test
	public void testPersistirFuncionario()
	{
		Funcionario funcionario = this.funcionarioRepository.save(new Funcionario());
		assertNotNull(funcionario);
	}

	@Test
	public void testBuscarFuncionarioPorId()
	{
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorId(1L);
		assertNotNull(funcionario.isPresent());
	}
	
	@Test
	public void testBuscarFuncionarioPorEmail()
	{
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorEmail("email@email.com");
		assertTrue(funcionario.isPresent());
	}

	@Test
	public void testBuscarFuncionarioPorCpf()
	{
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorCpf("24291173484");
		assertTrue(funcionario.isPresent());
	}
	
}














