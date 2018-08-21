package br.com.memory.pontointeligente.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.memory.pontointeligente.api.enums.PerfilEnum;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable
{

	/**
	 * serialVersion
	 */
	private static final long serialVersionUID = -7624822069618158837L;

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private BigDecimal valorHora;
	private Float qtdHorasTrabalhoDia;
	private Float qtdHorasAlmoco;
	private PerfilEnum perfil;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private Empresa empresa;
	private List<Lancamento> lancamento;

	public Funcionario()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public Long getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	@Column( name = "nome", nullable = false)
	public String getNome()
	{
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	@Column( name = "email", nullable = false)
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	@Column( name = "senha", nullable = false)
	public String getSenha()
	{
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	/**
	 * @return the cpf
	 */
	@Column( name = "cpf", nullable = false)
	public String getCpf()
	{
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	/**
	 * @return the valorHora
	 */
	@Column( name = "valor_hora", nullable = true)
	public BigDecimal getValorHora()
	{
		return valorHora;
	}

	
	@Transient
	public Optional<BigDecimal> getValorHoraOpt()
	{
		return Optional.ofNullable(valorHora);
	}
	
	/**
	 * @param valorHora the valorHora to set
	 */
	public void setValorHora(BigDecimal valorHora)
	{
		this.valorHora = valorHora;
	}

	/**
	 * @return the qtdHorasTrabalhoDia
	 */
	@Column( name = "qtd_horas_trabalho_dia", nullable = true)
	public Float getQtdHorasTrabalhoDia()
	{
		return qtdHorasTrabalhoDia;
	}
	
	@Transient
	public Optional<Float> getQtdHorasTrabalhoDiaOpt()
	{
		return Optional.ofNullable(qtdHorasTrabalhoDia);
	}
	

	/**
	 * @param qtdHorasTrabalhoDia the qtdHorasTrabalhoDia to set
	 */
	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia)
	{
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}

	/**
	 * @return the qtdHorasAlmoco
	 */
	public Float getQtdHorasAlmoco()
	{
		return qtdHorasAlmoco;
	}

	@Transient
	public Optional<Float> getQtdHorasAlmocoOpt()
	{
		return Optional.ofNullable(qtdHorasAlmoco);
	}

	
	/**
	 * @param qtdHorasAlmoco the qtdHorasAlmoco to set
	 */
	public void setQtdHorasAlmoco(Float qtdHorasAlmoco)
	{
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}

	/**
	 * @return the perfil
	 */
	@Enumerated(EnumType.STRING)
	@Column( name = "perfil", nullable = false)
	public PerfilEnum getPerfil()
	{
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(PerfilEnum perfil)
	{
		this.perfil = perfil;
	}

	/**
	 * @return the dataCricao
	 */
	@Column( name = "data_criacao", nullable = false)
	public Date getDataCricao()
	{
		return dataCriacao;
	}

	/**
	 * @param dataCricao the dataCricao to set
	 */
	public void setDataCricao(Date dataCricao)
	{
		this.dataCriacao = dataCricao;
	}

	/**
	 * @return the dataAtualizacao
	 */
	@Column( name = "data_atualizacao", nullable = false)
	public Date getDataAtualizacao()
	{
		return dataAtualizacao;
	}

	/**
	 * @param dataAtualizacao the dataAtualizacao to set
	 */
	public void setDataAtualizacao(Date dataAtualizacao)
	{
		this.dataAtualizacao = dataAtualizacao;
	}

	/**
	 * @return the empresa
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	public Empresa getEmpresa()
	{
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
	}

	/**
	 * @return the lancamento
	 */
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	public List<Lancamento> getLancamento()
	{
		return lancamento;
	}
	

	/**
	 * Método que atribui a data do objeto no ato de sua persistência.
	 */
	@PrePersist
	public void prePersist()
	{
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}

	/**
	 * Método que atribui a data atualização do objeto no ato de sua persistência.
	 */
	@PreUpdate
	public void preUpdate()
	{
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	
	
	/**
	 * @param lancamento the lancamento to set
	 */
	public void setLancamento(List<Lancamento> lancamento)
	{
		this.lancamento = lancamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHora=" + valorHora + ", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + ", qtdHorasAlmoco="
				+ qtdHorasAlmoco + ", perfil=" + perfil + ", dataCricao=" + dataCriacao + ", dataAtualizacao="
				+ dataAtualizacao + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lancamento == null) ? 0 : lancamento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((qtdHorasAlmoco == null) ? 0 : qtdHorasAlmoco.hashCode());
		result = prime * result + ((qtdHorasTrabalhoDia == null) ? 0 : qtdHorasTrabalhoDia.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((valorHora == null) ? 0 : valorHora.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cpf == null)
		{
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataAtualizacao == null)
		{
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (dataCriacao == null)
		{
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (email == null)
		{
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empresa == null)
		{
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lancamento == null)
		{
			if (other.lancamento != null)
				return false;
		} else if (!lancamento.equals(other.lancamento))
			return false;
		if (nome == null)
		{
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (perfil != other.perfil)
			return false;
		if (qtdHorasAlmoco == null)
		{
			if (other.qtdHorasAlmoco != null)
				return false;
		} else if (!qtdHorasAlmoco.equals(other.qtdHorasAlmoco))
			return false;
		if (qtdHorasTrabalhoDia == null)
		{
			if (other.qtdHorasTrabalhoDia != null)
				return false;
		} else if (!qtdHorasTrabalhoDia.equals(other.qtdHorasTrabalhoDia))
			return false;
		if (senha == null)
		{
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (valorHora == null)
		{
			if (other.valorHora != null)
				return false;
		} else if (!valorHora.equals(other.valorHora))
			return false;
		return true;
	}
	
}
