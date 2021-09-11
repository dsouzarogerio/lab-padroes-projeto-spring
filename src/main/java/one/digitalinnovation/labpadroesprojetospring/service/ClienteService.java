package one.digitalinnovation.labpadroesprojetospring.service;

import one.digitalinnovation.labpadroesprojetospring.model.Cliente;

/**
 * Interface que define o padrão <b>Strategy<b/> no domínio de cliente.
 * Com isso podemos ter múltiplas implementações dessa mesma interface.
 * @author dsouzarogerio
 *
 */

public interface ClienteService {
	
	Iterable<Cliente> buscarTodos();
	
	Cliente buscarPorId(Long id);
	
	void inserir(Cliente cliente);
	
	void atualizar(Long id, Cliente cliente);
	
	void deletar(Long id);

}
