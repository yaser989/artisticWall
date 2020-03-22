package org.openup.controller;
import org.openup.entity.Artist;
import org.openup.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/v1/artist")
@CrossOrigin(origins="*")
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	

	
	@GetMapping("/")
	public ResponseEntity findAll() {
		
		return ResponseEntity.ok(artistService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findByID(@PathVariable (name = "id") Long id) {
		return ResponseEntity.ok(artistService.findById(id));
	}
	
	@PostMapping("/")
	public ResponseEntity createNewArtist(Artist artist) {
		return ResponseEntity.ok(artistService.createNewArtist(artist));
	}
	
	@PostMapping("/login")
    public ResponseEntity login(@RequestParam(name = "mail",required=false) String mail, @RequestParam(name = "password",required=false) String password) {
		
        if(StringUtils.isEmpty(mail) || StringUtils.isEmpty(password)) {
             return ResponseEntity.badRequest().body("Cannot login with empty user mail or password");
        }
        
        if (artistService.login(mail, password) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(artistService.login(mail, password));
    }

}
