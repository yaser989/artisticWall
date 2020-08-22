package org.openup;

import static org.junit.Assert.assertEquals;
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
	private String mail;
	private String password;

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
	
	@InjectMocks
	private EventService targetEvent;
	
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
		artist.setPassword(bCryptPasswordEncoder.encode("1234"));
         
       artistDto.setArtistDomain(domain.getDomain());
       artistDto.setArtistLastName(artist.getLastName());
       artistDto.setArtistMail(artist.getMail());
       artistDto.setArtistName(artist.getName());
       artistDto.setArtistPassword(artist.getPassword());
       artistDto.setArtistRole(role.getRoleName());
       artistDto.setId(artist.getId());
       Mockito.when(artistRepository.save(artist)).thenReturn(artist);
		}
	
	@Test
	public void login () {
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
       Mockito.when(artistRepository.findByMail("yaser@gmail.com")).thenReturn(artist);

	}
	
	@Test
	public void updatArtist() {
		ArtistDomain domain = ArtistDomain.builder().domain(artistDto.getArtistDomain()).build();
		domain.setDomain("music");
		Role role = new Role();
		role.setRoleName("ROLE_ADMIN");
		artist.setName("mari");
		artist.setLastName("mar");
		artist.setMail("mari@gmail.com");
		artist.setArtistDomain(domain);
		artist.setRole(role);
		artist.setPassword("mari1234");
  
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
		verify(eventRepository).findAll();
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
	
	@Test
	public void updateEvent() {
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
        event.setArtist(artist);
        
        adminDto.setArtistDomain(domain.getDomain());
        adminDto.setArtistLastName(artist.getLastName());
        adminDto.setArtistMail(artist.getMail());
        adminDto.setArtistName(artist.getName());
        adminDto.setArtistPassword(artist.getPassword());
        adminDto.setCategoriesDto(cat.getCategories());
        adminDto.setCommonDto(adres.getCommon());
        adminDto.setDescriptionDto(event.getDescription());
        adminDto.setPhoneDto(adres.getPhone());
        adminDto.setZipCodeDto(adres.getZipCode());
        adminDto.setRoleName(role.getRoleName());
        adminDto.setTypeEventDto(event.getTypeEvent());
		
        when(eventRepository.save(event)).thenReturn(event);
		assertEquals(adminDto, targetAdmin.updateEvent(id, adminDto));
        
	}
	
	@Test
	public void findByID() {
		targetAdmin.findByID(id);
		verify(eventRepository).findById(id);
	}
	
	//============================ Test ServiceEvent ============================//
	
	@Test
	public void findAllEvent() {
		targetEvent.findAll();
		verify(eventRepository).findAll();
	}
	
	@Test
	public void findAllArtistEventById() {
		targetEvent.findAllArtistEventById(id);
		 artist = artistRepository.getOne(id);
		verify(eventRepository).findBySharedAndArtistIsNotLike(true, artist);
		
	}
	
	@Test
	public void findEventById() {
		targetEvent.findEventById(id);
		verify(eventRepository).findById(id);
	}
	
	@Test
	public void findEventbyConcert() {
		targetEvent.findEventbyConcert();
		verify(eventRepository).findBySharedAndTypeEvent(true,"Concert");
	}
	
	@Test 
	public void findEventbyShow() {
		targetEvent.findEventbyShow();
		verify(eventRepository).findBySharedAndTypeEvent(true,"Show");
	}
	
	@Test 
	public void findEventbyAudition() {
		targetEvent.findEventbyAudition();
		verify(eventRepository).findBySharedAndTypeEvent(true,"Audition");
	}
	
	@Test
	public void createNewEvent() {
		
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
        
        eventDto.setCategoriesDto(cat.getCategories());
        eventDto.setCommonDto(adres.getCommon());
        eventDto.setDescriptionDto(event.getDescription());
        eventDto.setPhoneDto(adres.getPhone());
        eventDto.setZipCodeDto(adres.getZipCode());
        eventDto.setTypeEventDto(event.getTypeEvent());
        eventDto.setIdEvent(event.getId());
                
        Mockito.when(eventRepository.save(event)).thenReturn(event);

	}
	
	@Test
	public void eventUpdateEvent() {
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
        
        eventDto.setCategoriesDto(cat.getCategories());
        eventDto.setCommonDto(adres.getCommon());
        eventDto.setDescriptionDto(event.getDescription());
        eventDto.setPhoneDto(adres.getPhone());
        eventDto.setZipCodeDto(adres.getZipCode());
        eventDto.setTypeEventDto(event.getTypeEvent());
        eventDto.setIdEvent(event.getId());
                
        Mockito.when(eventRepository.save(event)).thenReturn(event);
	}
	
	
	@Test 
	public void EventDeleteEvent() {
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
	
	@Test
	public void shareEvent() {
		boolean isShared = true;
		event.setShared(!isShared);
		Mockito.when(eventRepository.getOne(1L)).thenReturn(event);
	}
	
	
}
