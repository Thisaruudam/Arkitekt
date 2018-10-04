package lk.ijse.archi.rest.service.impl;

import lk.ijse.archi.rest.dto.ClientDTO;
import lk.ijse.archi.rest.entity.Client;
import lk.ijse.archi.rest.repository.ClientRepository;
import lk.ijse.archi.rest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveClient(ClientDTO clientDTO) {
        Client client=new Client(clientDTO.getEmail(),clientDTO.getName(),clientDTO.getPhone(),clientDTO.getAddress());
        clientRepository.save(client);
        return true;
    }

    @Override
    public ClientDTO getClient(String email) {
        Client client=clientRepository.getClient(email);
        return new ClientDTO(client.getEmail(),client.getName(),client.getPhone(),client.getAddress());
    }
}
