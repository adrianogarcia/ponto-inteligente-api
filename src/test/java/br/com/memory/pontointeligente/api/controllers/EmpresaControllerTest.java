//package br.com.memory.pontointeligente.api.controllers;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Optional;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.BDDMockito;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import br.com.memory.pontointeligente.api.entities.Empresa;
//import br.com.memory.pontointeligente.api.services.EmpresaService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
//public class EmpresaControllerTest
//{
//
//	@Autowired
//	private MockMvc mvc;
//	
//	@MockBean
//	private EmpresaService empresaService;
//	
//	private static final String BUSCAR_EMPRESA_CNPJ_URL = "/api/empresas/cnpj/";
//	private static final Long ID = Long.valueOf(1);
//	private static final String CNPJ = "51463654000100";
//	private static final String RAZAO_SOCIAL = "Empresa XYZ";
//
//	/**
//	 * Realizar teste da tentativa de buscar uma empresa dado um cnpj inválido.
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	@WithMockUser
//	public void testBuscarEmpresaCnpjInvalido() throws Exception
//	{
//		BDDMockito.given(this.empresaService.busacarPorCnpj(Mockito.anyString())).willReturn(Optional.empty());
//		
//		mvc.perform(MockMvcRequestBuilders.get(BUSCAR_EMPRESA_CNPJ_URL + CNPJ).accept(MediaType.APPLICATION_JSON))
//			.andExpect(status().isBadRequest())
//			.andExpect(jsonPath("$.errors").value("Empresa não encontrada para o CNPJ: " + CNPJ));
//	}
//
//	/**
//	 * Realizar teste da tentativa de buscar uma empresa dado um cnpj válido.
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	@WithMockUser
//	public void testBuscarEmpresaComCnpjValido() throws Exception
//	{
//		BDDMockito.given(this.empresaService.busacarPorCnpj(Mockito.anyString()))
//			.willReturn(Optional.of(this.obterDadosEmpresa()));
//		
//		mvc.perform(MockMvcRequestBuilders.get(BUSCAR_EMPRESA_CNPJ_URL + CNPJ)
//			.accept(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
//			.andExpect(jsonPath("$.data.id").value(ID))
//			.andExpect(jsonPath("$.data.razaoSocial", equalTo(RAZAO_SOCIAL)))
//			.andExpect(jsonPath("$.data.cnpj", equalTo(CNPJ)))
//			.andExpect(jsonPath("$.errors").isEmpty());
//	}
//
//
//	/**
//	 *  Criar um instância de Empresa para sua utilização em teste de unidade.
//	 * @return
//	 */
//	private Empresa obterDadosEmpresa()
//	{
//		Empresa empresa = new Empresa();
//		empresa.setId(ID);
//		empresa.setRazaoSocial(RAZAO_SOCIAL);
//		empresa.setCnpj(CNPJ);
//		return empresa;
//	}
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
