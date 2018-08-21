package br.com.memory.pontointeligente.api.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T>
{
	/**
	 * Definição do objeto genérico que representará uma instância.
	 */
	private T data;
	
	/**
	 * Definição de uma lista que conterá os possíveis erros.
	 */
	private List<String> errors;
	
	public Response()
	{
	}

	/**
	 * @return the data
	 */
	public T getData()
	{
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data)
	{
		this.data = data;
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors()
	{
		if (this.errors == null)
		{
			this.errors = new ArrayList<String>();
		}
		
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<String> errors)
	{
		this.errors = errors;
	}
	
	
	
	

}
