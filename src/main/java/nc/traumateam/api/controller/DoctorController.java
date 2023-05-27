package nc.traumateam.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import nc.traumateam.api.converter.DoctorConverter;
import nc.traumateam.api.entities.dto.SaveDoctorDTO;
import nc.traumateam.api.entities.dto.ListDoctorDTO;
import nc.traumateam.api.entities.dto.UpdateDoctorDTO;
import nc.traumateam.api.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity save(@RequestBody @Valid SaveDoctorDTO dto, UriComponentsBuilder uriBuilder) {
        var doctor = repository.save(DoctorConverter.toEntity(dto));
        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(DoctorConverter.toDetailsDoctorDTO(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<ListDoctorDTO>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        Page<ListDoctorDTO> doctors = DoctorConverter.toListDto(repository.findAllByDeletedFalse(page));
        return ResponseEntity.ok(doctors);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateDoctorDTO dto){
        var doctor = repository.getReferenceById(dto.id());
        doctor = DoctorConverter.updateFields(doctor, dto);
        return ResponseEntity.ok(DoctorConverter.toDetailsDoctorDTO(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id) {
        var doctor = repository.getReferenceById(id);
        doctor.setDeleted(true);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable UUID id) {
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(DoctorConverter.toDetailsDoctorDTO(doctor));
    }

}
