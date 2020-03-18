package org.openup.repo;

import java.util.List;

import org.openup.entity.Artist;
import org.openup.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long>{

	
	@Query("select event from Event event where event.id = :id")
	List<Event> findEventById(@Param("id") Long id);
	
	List<Event> findByArtistOrShared(Artist artist, boolean shared);
	
	List<Event> findByArtist(Artist artist);
	
	List<Event> findBySharedAndArtistIsNotLike(boolean shared, Artist artist);
	
}
