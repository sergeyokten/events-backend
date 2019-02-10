package oktenweb.eventsbackend.repository;

import oktenweb.eventsbackend.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepo extends JpaRepository<Event, Integer> {
}
