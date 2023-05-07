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
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void save(@RequestBody @Valid SaveDoctorDTO dto) {
        repository.save(DoctorConverter.toEntity(dto));
    }

    @GetMapping
    public Page<ListDoctorDTO> list(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        return DoctorConverter.toListDto(repository.findAllByDeletedFalse(page));
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateDoctorDTO dto){
        var doctor = repository.getReferenceById(dto.id());
        DoctorConverter.updateFields(doctor, dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable UUID id) {
        var doctor = repository.getReferenceById(id);
        doctor.setDeleted(true);
    }

}
