package com.muvit.MUVIT.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.muvit.MUVIT.api.dto.request.RolRequest;
import com.muvit.MUVIT.api.dto.response.RolResponse;
import com.muvit.MUVIT.domain.entities.Rol;
import com.muvit.MUVIT.domain.repositories.RolRepository;
import com.muvit.MUVIT.infrastructure.abstract_services.interfaces.IRolService;
import com.muvit.MUVIT.util.enums.RolEnum;
import com.muvit.MUVIT.util.exceptions.IdNotFoundException;

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
        // TODO Auto-generated method stub

    }

    @Override
    public Page<RolResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RolResponse update(Long id, RolRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    private Rol find(Long id){
        return this.rolRepository.findById(id).orElseThrow(()-> new IdNotFoundException("Rol"));
    } 
    @Override
    public RolResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    private Rol requestToEntity(RolRequest request, Rol rol) {
        rol.setNameUser(request.getNameUser());
        rol.setPassword(request.getPassword());
        String enume = request.getRol();
        rol.setRol_enum(RolEnum.valueOf(enume));
        return rol;
    }

    private RolResponse entityToResponse(Rol entity) {
        RolResponse response = new RolResponse();
        response.setId_rol(entity.getId_rol());
        response.setNameUser(entity.getNameUser());
        response.setPassword(entity.getPassword());
        response.setRol(entity.getRol_enum());
        return response;
    }
}
