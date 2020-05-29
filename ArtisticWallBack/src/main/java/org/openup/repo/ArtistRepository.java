package org.openup.repo;



import java.util.List;
import java.util.Optional;

import org.openup.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{


	Artist findByMailAndPassword(String mail,String password);
	
	Artist findByMail(String mail);
	
	@Query("select art from Artist art where art.id = :id")
	List<Artist> findArtistById(@Param("id") Long id);
   
 
	Optional<Artist> findByName(String name);
      

	
	
}

