package org.openup.repo;

import java.util.List;

import org.openup.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

	@Query(nativeQuery = true,value ="SELECT artiste_name,"
			+ "artiste_last_name,"
			+ "artiste_email"
			+ "FROM artist"
			+ "artist,artist_domain"
			+ "WHERE artist.artiste_id=artist,artist_domain.artist_domain_id AND artist.projectId = :param")
	public Artist findTransaksisByAccountIdOrderById(@Param("param") Long projectId);

	
}

