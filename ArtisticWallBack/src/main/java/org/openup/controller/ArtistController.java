package org.openup.controller;
import org.openup.DTO.ArtistDto;
import org.openup.repo.ArtistRepository;
import org.openup.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/v1/artist")
@CrossOrigin(origins="*")
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private ArtistRepository artistRepository;
	
	@GetMapping("/")
	public ResponseEntity findAll() {
		
		return ResponseEntity.ok(artistService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findByID(@PathVariable (name = "id") Long id) {
		return ResponseEntity.ok(artistService.findById(id));
	}
	
	@PostMapping("/")
	public ResponseEntity createNewArtist(@RequestBody ArtistDto artist) {
		System.out.println("Controller"+artist);
		return ResponseEntity.ok(artistService.createNewArtist(artist));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity updateEvent(@PathVariable(name="id") Long id, @RequestBody ArtistDto artist) {
		artistService.updatArtist(id, artist);
		return ResponseEntity.ok("updet done with success");
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
	 @GetMapping("/logoutSuccessful")
	    public ResponseEntity log() {
	        return ResponseEntity.ok().body("logout success");
	    }
}
