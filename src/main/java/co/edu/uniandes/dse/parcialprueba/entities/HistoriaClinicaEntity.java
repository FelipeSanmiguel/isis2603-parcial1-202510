package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.uniandes.dse.parcialprueba.podam.DateStrategy;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;

import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;


@Data
@Entity
public class HistoriaClinicaEntity {
    private String diagnostico;
    
    private String tratamiento;
    
    private String fechaDeCreación;


    @PodamExclude
	@ManyToOne
	private PacienteEntity paciente;
}
