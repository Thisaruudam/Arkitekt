package lk.ijse.archi.rest.service.impl;

import lk.ijse.archi.rest.dto.FreeLancerDTO;
import lk.ijse.archi.rest.entity.FreeLancer;
import lk.ijse.archi.rest.repository.FreeLancerRepository;
import lk.ijse.archi.rest.service.FreeLancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class FreeLancerServiceImpl implements FreeLancerService {

    @Autowired
    private FreeLancerRepository freeLancerRepository;

    @Override
    public boolean saveFreelancer(FreeLancerDTO freeLancerDTO) {
        FreeLancer freeLancer = new FreeLancer(freeLancerDTO.getEmail(), freeLancerDTO.getName(), freeLancerDTO.getPhone(), freeLancerDTO.getAddress());
        freeLancerRepository.save(freeLancer);
        return true;
    }

    @Override
    public FreeLancerDTO getFreelancer(String email) {
        FreeLancer freeLancer=freeLancerRepository.findById(email).get();
        return new FreeLancerDTO(freeLancer.getEmail(),freeLancer.getName(),freeLancer.getPhone(),freeLancer.getAddress());
    }
}
