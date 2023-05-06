package nc.traumateam.api.controller;

import jakarta.validation.Valid;
import nc.traumateam.api.converter.PatientConverter;
import nc.traumateam.api.entities.dto.ListPatientDTO;
import nc.traumateam.api.entities.dto.PatientDTO;
import nc.traumateam.api.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    public void save(@RequestBody @Valid PatientDTO patientDto){
        repository.save(PatientConverter.toEntity(patientDto));
    }

    @GetMapping
    public Page<ListPatientDTO> list(@PageableDefault(size = 10, sort = {"name"}) Pageable page){
        return PatientConverter.toListDTO(repository.findAll(page));
    }


}
