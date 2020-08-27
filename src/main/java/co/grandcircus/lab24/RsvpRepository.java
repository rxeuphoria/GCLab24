package co.grandcircus.lab24;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.lab24.entity.Rsvp;

public interface RsvpRepository extends JpaRepository<Rsvp, Long>{

	List<Rsvp> findAllById(Long id);

}
