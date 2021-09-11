package one.digitalinnovation.labpadroesprojetospring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.labpadroesprojetospring.model.Cliente;
import one.digitalinnovation.labpadroesprojetospring.model.Endereco;
import one.digitalinnovation.labpadroesprojetospring.repository.ClienteRepository;
import one.digitalinnovation.labpadroesprojetospring.repository.EnderecoRepository;
import one.digitalinnovation.labpadroesprojetospring.service.ClienteService;
import one.digitalinnovation.labpadroesprojetospring.service.ViaCepService;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, que pode ser injetada pelo Spring
 * atavés do injetor de dependências {@link Autowired}.
 * Sendo essa classe uma {@link Service}, ela será tratada como um <b>Singleton</b>
 * @author dsouzarogerio
 *
 */


@Service
public class ClienteServiceImpl implements ClienteService {
	
	//Singleton: Injetar os componentres do Spring com @Autowired
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;
	
	//Strategy: Implementar os métodos definidos na interface (ClienteService)
	//Facade: Abstrair integrações com subsistemas, provendo uma interface simples
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		//buscar todos os clientes
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		//buscar cliente por Id
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}
	
	@Override
	public void atualizar(Long id, Cliente cliente) {
		//buscar cliente por Id, caso exista:
		Optional<Cliente> clienteID = clienteRepository.findById(id);
		if(clienteID.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		//deletar cliente por id
		clienteRepository.deleteById(id);
	}
	
	private void salvarClienteComCep(Cliente cliente) {
		//Verificar se o endereco do cliente já existe com o CEP
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			//Caso não exista, integrar com o ViaCEP e persistir o retorno.
				Endereco novoEndereco = viaCepService.consultarCep(cep);
				enderecoRepository.save(novoEndereco);
				return novoEndereco;
		});
		cliente.setEndereco(endereco);
		//Inserir o cliente, vinculando o endereco (novo ou existente)
		clienteRepository.save(cliente);
	}
}