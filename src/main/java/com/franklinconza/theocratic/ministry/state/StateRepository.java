package com.franklinconza.theocratic.ministry.state;

import com.franklinconza.theocratic.models.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<StateModel, Integer> {
}
