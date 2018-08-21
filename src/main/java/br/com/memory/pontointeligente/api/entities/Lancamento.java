package br.com.memory.pontointeligente.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.memory.pontointeligente.api.enums.TipoEnum;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable
{

	/**
	 * serialVersion padrão.
	 */
	private static final long serialVersionUID = 5787277401415322726L;
	
	private Long id;
	private Date data;
	private String descricao;
	private String localizacao;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private TipoEnum tipo;
	private Funcionario funcionario;
	
	
	public Lancamento()
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
	 * @return the data
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable = false)
	public Date getData()
	{
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(Date data)
	{
		this.data = data;
	}


	/**
	 * @return the descricao
	 */
	@Column(name = "descricao", nullable = true)
	public String getDescricao()
	{
		return descricao;
	}


	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}


	/**
	 * @return the localizacao
	 */
	@Column(name = "localizacao", nullable = true)
	public String getLocalizacao()
	{
		return localizacao;
	}


	/**
	 * @param localizacao the localizacao to set
	 */
	public void setLocalizacao(String localizacao)
	{
		this.localizacao = localizacao;
	}


	/**
	 * @return the dataCricacao
	 */
	@Column(name = "dataCriacao", nullable = false)
	public Date getDataCriacao()
	{
		return dataCriacao;
	}


	/**
	 * @param dataCricacao the dataCricacao to set
	 */
	public void setDataCriacao(Date dataCriacao)
	{
		this.dataCriacao = dataCriacao;
	}


	/**
	 * @return the dataAtualizacao
	 */
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
	 * @return the tipo
	 */
	@Enumerated(EnumType.STRING)
	public TipoEnum getTipo()
	{
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoEnum tipo)
	{
		this.tipo = tipo;
	}

	/**
	 * @return the funcionario
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
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

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Lancamento other = (Lancamento) obj;
		if (data == null)
		{
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
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
		if (descricao == null)
		{
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (funcionario == null)
		{
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localizacao == null)
		{
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Lancamento [id=" + id + ", data=" + data + ", descricao=" + descricao + ", localizacao=" + localizacao
				+ ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + ", tipo=" + tipo
				+ ", funcionario=" + funcionario + "]";
	}

}
