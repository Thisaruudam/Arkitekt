package lk.ijse.archi.rest.service;

import lk.ijse.archi.rest.dto.ClientDTO;

public interface ClientService {

    public boolean saveClient(ClientDTO clientDTO);

    public ClientDTO getClient(String email);

}
