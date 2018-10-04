package lk.ijse.archi.rest.service;

import lk.ijse.archi.rest.dto.FreeLancerDTO;

public interface FreeLancerService {

    public boolean saveFreelancer(FreeLancerDTO freeLancerDTO);

    public FreeLancerDTO getFreelancer(String email);

}
