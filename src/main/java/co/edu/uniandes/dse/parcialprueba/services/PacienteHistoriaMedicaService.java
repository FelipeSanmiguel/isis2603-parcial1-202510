package co.edu.uniandes.dse.parcialprueba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.HistoriaClinicaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacienteHistoriaMedicaService {

    @Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private HistoriaClinicaRepository historiaClinicaRepositoryRepository;

    

}
