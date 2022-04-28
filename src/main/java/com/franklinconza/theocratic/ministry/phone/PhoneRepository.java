package com.franklinconza.theocratic.ministry.phone;

import com.franklinconza.theocratic.models.PhoneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneModel, Integer> {
}
