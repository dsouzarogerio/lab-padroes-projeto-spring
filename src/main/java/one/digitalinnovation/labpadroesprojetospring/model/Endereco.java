package one.digitalinnovation.labpadroesprojetospring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Atributos gerados automaticamente através do site 
 * jsonschema2pojo.org, usando o JSON de retorno da API do ViaCEP.
 * 
 * obs.: alguns atributos gerados foram excluídos e customizados
 * 
 * @see <a href="https://www.jsonschema2pojo.org/">jsonschema2pojo.org</a>
 * @see <a href="https://viacep.com.br/">ViaCEP</a>
 * 
 * @author dsouzarogerio
 *
 */
@Entity
public class Endereco {
	
	@Id
	private String cep;
	
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
}