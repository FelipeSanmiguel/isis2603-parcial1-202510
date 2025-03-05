package co.edu.uniandes.dse.parcialprueba.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacienteService {
    

    private PacienteRepository pacienteRepository;

    @Transactional
	public PacienteEntity createPaciente(PacienteEntity pacienteEntity) throws IllegalOperationException {
		
		if (pacienteEntity.getTelefono().length() != 11)
			throw new IllegalOperationException("Telefono is not valid");
        
        if(!pacienteEntity.getTelefono().substring(0,3).equals("311")){
             if(!pacienteEntity.getTelefono().substring(0,3).equals("601"))
                throw new IllegalOperationException("Telefono is not valid");
        }

		return pacienteRepository.save(pacienteEntity);
	}

    @Transactional
	public PacienteEntity asociarAcudiente(Long pacienteId, Long acudienteId) throws IllegalOperationException {
		
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(pacienteId);
		if (pacienteEntity.isEmpty())
			throw new EntityNotFoundException("Id paciente no valido");
        
        if (pacienteEntity.get().getAcudiente() == null)
            throw new EntityNotFoundException("Paciente tiene acudiente");

        Optional<PacienteEntity> acudienteEntity = pacienteRepository.findById(acudienteId);
        if (acudienteEntity.isEmpty())
			throw new EntityNotFoundException("Id acudiente no valido");
        
        if (!(acudienteEntity.get().getAcudiente() == null))
			throw new EntityNotFoundException("Acudiente no valido");
        
        if (acudienteEntity.get().getHistoriasClinicas().size() < 1)
			throw new EntityNotFoundException("Acudiente no tiene historias");
        
        
        pacienteEntity.get().setAcudiente(acudienteEntity);
        

        return pacienteRepository.save(pacienteEntity);
	}


}
