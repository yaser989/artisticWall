package org.openup.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.openup.entity.Artist;
import org.openup.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long>{

	
	@Query("select event from Event event where event.id = :id")
	List<Event> findEventById(@Param("id") Long id);
	
	List<Event> findByArtistOrShared(Artist artist, boolean shared);
	
	List<Event> findByArtist(Artist artist);
	
	List<Event> findBySharedAndArtistIsNotLike(boolean shared, Artist artist);

	@Query(value = "select event.*, categories.categories_id,"
			+ "artist.artiste_id,categories.type_categories,"
			+ "artist.artiste_name,artist.artiste_last_name,"
			+ "artist.artiste_email,artistDomain.artist_domain,"
			+ "address.common,address.street,address.zip_code,address.phone"
			+ " from Artist artist inner join Artist_Domain artistDomain on artist.artist_domain_id = artistDomain.artist_domain_id"
			+ " inner join Event event on artist.artiste_id = event.artiste_id"
			+ " inner join Categories categories on event.categories_id = categories.categories_id"
			+ " inner join Address address on event.event_id=address.event_id",nativeQuery=true)
      List<Event> AdminfindAll ();
	
}
