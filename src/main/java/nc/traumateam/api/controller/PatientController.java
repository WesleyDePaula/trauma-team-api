package nc.traumateam.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import nc.traumateam.api.model.converter.PatientConverter;
import nc.traumateam.api.model.entities.dto.ListPatientDTO;
import nc.traumateam.api.model.entities.dto.PatientDTO;
import nc.traumateam.api.model.entities.dto.UpdatePatientDTO;
import nc.traumateam.api.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid PatientDTO patientDto, UriComponentsBuilder uriBuilder){
        var patient = repository.save(PatientConverter.toEntity(patientDto));
        var uri = uriBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(PatientConverter.toDetailsPatientDTO(patient));

    }

    @GetMapping
    public ResponseEntity<Page<ListPatientDTO>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable page){
        Page<ListPatientDTO> patients = PatientConverter.toListDTO(repository.findAllByDeletedFalse(page));
        return ResponseEntity.ok(patients);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody UpdatePatientDTO dto) {
        var patient = repository.getReferenceById(dto.id());
        PatientConverter.updateFields(patient, dto);
        return ResponseEntity.ok(PatientConverter.toDetailsPatientDTO(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id) {
        var patient = repository.getReferenceById(id);
        patient.setDeleted(true);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity get(@PathVariable UUID id) {
        var patient = repository.getReferenceById(id);
        return ResponseEntity.ok(PatientConverter.toDetailsPatientDTO(patient));
    }

}
