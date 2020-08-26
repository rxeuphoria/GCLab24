package co.grandcircus.lab24;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.lab24.entity.Party;
import co.grandcircus.lab24.entity.PartyOption;

public interface PartyPlannerRepository extends JpaRepository<Party, Long> {

	
	
}
