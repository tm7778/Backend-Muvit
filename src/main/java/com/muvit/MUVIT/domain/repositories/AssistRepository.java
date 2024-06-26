package com.muvit.MUVIT.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muvit.MUVIT.domain.entities.Assistant;

@Repository
public interface AssistRepository extends JpaRepository
<Assistant, String>{

}
