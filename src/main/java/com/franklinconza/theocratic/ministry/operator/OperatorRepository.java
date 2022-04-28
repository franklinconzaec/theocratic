package com.franklinconza.theocratic.ministry.operator;

import com.franklinconza.theocratic.models.OperatorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<OperatorModel, Integer> {
}
