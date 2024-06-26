package com.muvit.MUVIT.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.muvit.MUVIT.api.dto.request.RolRequest;
import com.muvit.MUVIT.api.dto.response.RolResponse;
import com.muvit.MUVIT.domain.entities.Rol;
import com.muvit.MUVIT.domain.repositories.RolRepository;
import com.muvit.MUVIT.infrastructure.abstract_services.interfaces.IRolService;
import com.muvit.MUVIT.util.enums.RolEnum;
import com.muvit.MUVIT.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RolService implements IRolService {

    @Autowired
    private final RolRepository rolRepository;

    @Override
    public RolResponse create(RolRequest request) {
        Rol rol = this.requestToEntity(request, new Rol());
        return this.entityToResponse(this.rolRepository.save(rol));
    }

    @Override
    public void delete(Long id) {
        Rol rol = this.find(id);
        this.rolRepository.delete(rol);
    }

    @Override
    public Page<RolResponse> getAll(int page, int size) {
        if(page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.rolRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public RolResponse update(Long id, RolRequest request) {
        Rol rol = this.find(id);
        Rol rolUpdate = this.requestToEntity(request, rol);
        return this.entityToResponse(this.rolRepository.save(rolUpdate));
    }

    private Rol find(Long id) {
        return this.rolRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay registros con el ID sumnistrado"));
    }

    @Override
    public RolResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    private Rol requestToEntity(RolRequest request, Rol rol) {
        rol.setNameUser(request.getNameUser());
        rol.setPassword(request.getPassword());

        String enume = request.getRolEnum();
        rol.setRolEnum(RolEnum.valueOf(enume));
        rol.setUserPhoto(request.getUserPhoto());
        return rol;
    }

    private RolResponse entityToResponse(Rol entity) {
        RolResponse response = new RolResponse();
        response.setId_rol(entity.getId_rol());
        response.setNameUser(entity.getNameUser());
        response.setPassword(entity.getPassword());
        response.setRolEnum(entity.getRolEnum());
        response.setUserPhoto(entity.getUserPhoto());
        return response;
    }

    @Override
    public RolResponse findByRol(String rol) {
        // TODO Auto-generated method stub
        throw new BadRequestException("Unimplemented method 'findByRol'");
    }
}
