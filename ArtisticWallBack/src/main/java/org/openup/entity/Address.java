package org.openup.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name="address")
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="address_id")
	private Long id;
	
	@Column(name="street")
	private String street;
	
	@Column(name="ZIP_code")
	private String zipCode;
	
	@Column(name="common")
	private String common;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date ;
	
	
	 @JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
	private Event event;
	
}
