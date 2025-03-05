package co.edu.uniandes.dse.parcialprueba.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.HistoriaClinicaRepository;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class HistoriaClinicaService {

    @Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private HistoriaClinicaRepository historiaClinicaRepository;

    @Transactional
	public HistoriaClinicaEntity createHistoriaClinica(Long pacienteId, HistoriaClinicaEntity historiaClinicaEntity) 
        throws EntityNotFoundException {
		
		Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(pacienteId);
		if (pacienteEntity.isEmpty())
			throw new EntityNotFoundException("Id paciente no valido");
        
        

        if (pacienteEntity.get().getAcudiente() == null){
            historiaClinicaEntity.setPaciente(pacienteEntity.get());
        }
        else{
            historiaClinicaEntity.setDiagnostico("HistoriaCompartida-".concat(historiaClinicaEntity.getDiagnostico()));
            historiaClinicaEntity.setPaciente(pacienteEntity.get());
        }

		return historiaClinicaRepository.save(historiaClinicaEntity);
	}

}
