package com.franklinconza.theocratic.ministry.call;

import com.franklinconza.theocratic.models.CallModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CallRepository extends JpaRepository<CallModel, UUID> {
}
