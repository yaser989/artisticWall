package org.openup.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name="artist")
public class Artist implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="artiste_id")
	private Long id;
	@Column(name="artiste_name")
	private String name;
	@Column(name="artiste_last_name")
	private String lastName;
	@Column(name="artiste_email")
	private String mail;
	@Column(name="artiste_password")
	private String password;
	@Lob
	private byte[] photo;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	  private Role role;
    @JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "artist_domain_id")
	  private ArtistDomain artistDomain;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "artist", fetch = FetchType.EAGER)
	List <Event> event;
}
