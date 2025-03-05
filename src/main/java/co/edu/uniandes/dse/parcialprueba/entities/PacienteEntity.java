package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;

@Data
@Entity
public class PacienteEntity {
    private String nombre;
    
    private String correo;
    
    private String telefono;

    @PodamExclude
	@OneToMany(mappedBy = "paciente")
    private List<HistoriaClinicaEntity> historiasClinicas = new ArrayList<>();
    

    private PacienteEntity acudiente;
}
