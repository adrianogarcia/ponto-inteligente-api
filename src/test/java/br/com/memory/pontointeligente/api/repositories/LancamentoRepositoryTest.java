package br.com.memory.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.memory.pontointeligente.api.entities.Empresa;
import br.com.memory.pontointeligente.api.entities.Funcionario;
import br.com.memory.pontointeligente.api.entities.Lancamento;
import br.com.memory.pontointeligente.api.enums.TipoEnum;
import br.com.memory.pontointeligente.api.repository.EmpresaRepository;
import br.com.memory.pontointeligente.api.repository.FuncionarioRepository;
import br.com.memory.pontointeligente.api.repository.LancamentoRepository;
import br.com.memory.pontointeligente.api.security.PerfilEnum;
import br.com.memory.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest
{
	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;
	
	private Long funcionarioId;
	

	/**
	 * Método que configura o contexto antes da execução dos testes desta classe.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());

		Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
		this.funcionarioId = funcionario.getId();
		
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
		
	}

	/**
	 * Método que executa após a execução dos testes desta classe. 
	 */
	@After
	public final void tearDown()
	{
		this.empresaRepository.deleteAll();
	}


	/**
	 * Testa a recuperação dos lançamentos relacionados a um determinado funcionario.
	 */
	@Test
	public void testBuscaLancamentosPorFuncionarioID()
	{
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId);
		assertEquals(2, lancamentos.size());
	}

	/**
	 * Recuperar um lista de lançamentos de um determinado funcionario
	 * de forma paginada.
	 */
	@Test
	public void testBuscaLancamentosPorFuncionarioIdPagindo()
	{
		PageRequest page = new PageRequest(0, 10);
		Page<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId, page);
		assertEquals(2, lancamentos.getTotalElements());
	}

	
	
	
	
	/**
	 * Criar um objeto Lancamento para o contexto deste teste
	 * de persistência.
	 * 
	 * @param funcionario
	 * @return Lancamento
	 */
	private Lancamento obterDadosLancamentos(Funcionario funcionario)
	{
		Lancamento lancamento = new Lancamento();
		lancamento.setData(new Date());
		lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
		lancamento.setFuncionario(funcionario);
		return lancamento;
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
		empresa.setCnpj("51463645000100");
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
		funcionario.setCpf("email@email.com");
		funcionario.setEmail("24291173474");
		funcionario.setEmpresa(empresa);
		return funcionario;
	}
	
}
