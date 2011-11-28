package com.varun.yfs.server.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "campScreeningDetail")
public class CampScreeningDetail implements Serializable
{
	private static final long serialVersionUID = 7504451639139702860L;

	@Id
	@GeneratedValue
	@Column(name = "campScreeningDetailId")
	private long id;

	@Column(nullable = false)
	private String deleted;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name = "countryId", nullable = true, updatable = true, insertable = true)
	private Country country;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name = "stateId", nullable = true, updatable = true, insertable = true)
	private State state;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name = "cityId", nullable = true, updatable = true, insertable = true)
	private City city;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name = "townId", nullable = true, updatable = true, insertable = true)
	private Town town;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name = "villageId", nullable = true, updatable = true, insertable = true)
	private Village village;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name = "chapterNameId", nullable = true, updatable = true, insertable = true)
	private ChapterName chapterName;

	@Column(nullable = true)
	private String address;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name = "localityId", nullable = true, updatable = true, insertable = true)
	private Locality locality;

	@Column(nullable = true)
	private String screeningDate;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name = "processTypeId", nullable = true, updatable = true, insertable = true)
	private ProcessType processType;

	@Column(nullable = true)
	private String contactInformation;

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name = "typeOfLocationId", nullable = true, updatable = true, insertable = true)
	private TypeOfLocation typeOfLocation;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Volunteer> lstVolunteers;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Doctor> lstDoctors;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="CampScrDet_PatDet", joinColumns = { @JoinColumn(name = "campId") }, inverseJoinColumns = { @JoinColumn(name = "patId") })
	private List<CampPatientDetail> lstPatientDetails;

	public CampScreeningDetail()
	{
		setDeleted("N");
	}

	public CampScreeningDetail(String name)
	{
		setDeleted("N");
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getDeleted()
	{
		return deleted;
	}

	public final  void setDeleted(String deleted)
	{
		this.deleted = deleted;
	}

	public Country getCountry()
	{
		return country;
	}

	public void setCountry(Country country)
	{
		this.country = country;
	}

	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}

	public City getCity()
	{
		return city;
	}

	public void setCity(City city)
	{
		this.city = city;
	}

	public Town getTown()
	{
		return town;
	}

	public void setTown(Town town)
	{
		this.town = town;
	}

	public Village getVillage()
	{
		return village;
	}

	public void setVillage(Village village)
	{
		this.village = village;
	}

	public ChapterName getChapterName()
	{
		return chapterName;
	}

	public void setChapterName(ChapterName chapterName)
	{
		this.chapterName = chapterName;
	}

	public Locality getLocality()
	{
		return locality;
	}

	public void setLocality(Locality locality)
	{
		this.locality = locality;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getScreeningDate()
	{
		return screeningDate;
	}

	public void setScreeningDate(String screeningDate)
	{
		this.screeningDate = screeningDate;
	}

	public ProcessType getProcessType()
	{
		return processType;
	}

	public void setProcessType(ProcessType processType)
	{
		this.processType = processType;
	}

	public TypeOfLocation getTypeOfLocation()
	{
		return typeOfLocation;
	}

	public void setTypeOfLocation(TypeOfLocation typeOfLocation)
	{
		this.typeOfLocation = typeOfLocation;
	}

	public List<Volunteer> getVolunteers()
	{
		return lstVolunteers;
	}

	public void setVolunteers(List<Volunteer> volunteers)
	{
		this.lstVolunteers = volunteers;
	}

	public List<Doctor> getDoctors()
	{
		return lstDoctors;
	}

	public void setDoctors(List<Doctor> doctors)
	{
		this.lstDoctors = doctors;
	}

	public String getContactInformation()
	{
		return contactInformation;
	}

	public void setContactInformation(String contactInformation)
	{
		this.contactInformation = contactInformation;
	}

	public void setPatientDetails(List<CampPatientDetail> setPatientDetails)
	{
		this.lstPatientDetails = setPatientDetails;
	}

	public List<CampPatientDetail> getPatientDetails()
	{
		return lstPatientDetails;
	}

}
