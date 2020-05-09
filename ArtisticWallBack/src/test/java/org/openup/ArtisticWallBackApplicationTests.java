package org.openup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.openup.DTO.AdminDto;
import org.openup.DTO.ArtistDto;
import org.openup.DTO.EventDto;
import org.openup.controller.ArtistController;
import org.openup.controller.EventController;
import org.openup.entity.Address;
import org.openup.entity.Artist;
import org.openup.entity.ArtistDomain;
import org.openup.entity.Categories;
import org.openup.entity.Event;
import org.openup.entity.Role;
import org.openup.repo.ArtistRepository;
import org.openup.repo.EventRepository;
import org.openup.service.AdminServise;
import org.openup.service.ArtistService;
import org.openup.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ArtisticWallBackApplicationTests {

	private static Event event = new Event();
	private static Artist artist = new Artist();
	private static ArtistDto artistDto = new ArtistDto();
	private static EventDto eventDto = new EventDto();
	private static AdminDto adminDto = new AdminDto();
	private Long id = 1L;
	private Long idEvent;
	private String mail;
	private String password;
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private AdminServise adminService;
	
	@Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Mock
	private ArtistRepository artistRepository;
    @Captor
    private ArgumentCaptor<Artist> artistCAptor;
    @Captor
    private ArgumentCaptor<ArtistDto> artistDtoCAptor;
    
    @Mock
    private EventRepository eventRepository;
    @Captor
    private ArgumentCaptor<Event> eventCAptor;
    @Captor
    private ArgumentCaptor<EventDto> evenDtotCAptor;
    @Captor
    private ArgumentCaptor<AdminDto> adminDtotCAptor;
	
    @Rule
	public ExpectedException expectedException = ExpectedException.none();

	@InjectMocks
	private ArtistService targetArtist;
	
	@InjectMocks
	private AdminServise targetAdmin;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
//	======================== Test ServiceArtist ===================//
	
	@Test
 public	void findAllArtist() {
		
		// when
		targetArtist.findAll();
		// then
		verify(artistRepository).findAll();
	}

	@Test
	public void findById() {
		targetArtist.findById(id);
		verify(artistRepository).findById(id);
	}
	
	@Test
	public void createNewArtist() {
	
		ArtistDomain domain = ArtistDomain.builder().domain(artistDto.getArtistDomain()).build();
		domain.setDomain("dancer");
		Role role = new Role();
		role.setRoleName("ROLE_USER");
		artist.setName("yaser");
		artist.setLastName("test");
		artist.setMail("yaser@gmail.com");
		artist.setArtistDomain(domain);
		artist.setRole(role);
		artist.setPassword("1234");
         
       artistDto.setArtistDomain(domain.getDomain());
       artistDto.setArtistLastName(artist.getLastName());
       artistDto.setArtistMail(artist.getMail());
       artistDto.setArtistName(artist.getName());
       artistDto.setArtistPassword(artist.getPassword());
       artistDto.setArtistRole(role.getRoleName());
		when(artistRepository.save(artist)).thenReturn(artist);
		assertEquals(artist, targetArtist.createNewArtist(artistDto));
	}
	
	@Test
	public void login () {
		targetArtist.login( mail, password);
		verify(artistRepository).findByMail(mail);
	}
	
	@Test
	public void updatArtist() {
		ArtistDomain domain = ArtistDomain.builder().domain(artistDto.getArtistDomain()).build();
		domain.setDomain("music");
		Role role = new Role();
		role.setRoleName("ROLE_ADMIN");
		artist.setName("mari");
		artist.setLastName("test2");
		artist.setMail("mari@gmail.com");
		artist.setArtistDomain(domain);
		artist.setRole(role);
		artist.setPassword("1234555");
  
       artistDto.setArtistDomain(domain.getDomain());
       artistDto.setArtistLastName(artist.getLastName());
       artistDto.setArtistMail(artist.getMail());
       artistDto.setArtistName(artist.getName());
       artistDto.setArtistPassword(artist.getPassword());
       artistDto.setArtistRole(role.getRoleName());
        
		when(artistRepository.save(artist)).thenReturn(artist);
		assertEquals(artistDto, targetArtist.updatArtist(id, artistDto));
     
	}
	
	
	//====================== Test AdminService =======================//
	
	@Test
	public void findAll() {
		targetAdmin.finAll();
		verify(eventRepository).eventfindAll();
	}
	
	@Test
	public void deleteEvent() {
		Address adres = new Address();
		adres.setCommon("paris");
		adres.setPhone("121212");
		adres.setStreet("5 rue");
		adres.setZipCode("55555");
		Categories cat = new Categories();
		cat.setCategories("dance");
	
		event.setTypeEvent("audition");
		event.setCategories(cat);
		event.setAddress(adres);
        event.setDescription("test");
        event.setId(2L);

        Mockito.when(eventRepository.getOne(2L)).thenReturn(event).thenReturn(null);

	}
	
	
	
}
