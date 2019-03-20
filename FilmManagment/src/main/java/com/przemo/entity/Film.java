package com.przemo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.przemo.entity.abst.User;

@Entity
@Table(name = "filmy")
public class Film 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "tytul")
	private String tytul;
	
	@Column(name = "iloscwyp")
	private int iloscwyp;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "datawyp")
	private Date datawyp;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "datazwot")
	private Date datazwot;
	
	@Column(name = "dostepnosc")
	private boolean dostepnosc;
	
	@Column(name = "zamowione")
	private boolean zamowione;
	


	public boolean isZamowione() {
		return zamowione;
	}


	public void setZamowione(boolean zamowione) {
		this.zamowione = zamowione;
	}

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
				CascadeType.DETACH, CascadeType.REFRESH})		
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
	name="aktorzy_filmy",
	joinColumns=@JoinColumn(name="id"),
	inverseJoinColumns=@JoinColumn(name="aktorzy_id")
	)
	private List<Aktor> aktorzyList;
		
	public Film()
	{
		setDostepnosc(true);
	}

	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Aktor> getAktorzyList() {
		return aktorzyList;
	}


	public void setAktorzyList(List<Aktor> aktorzyList) {
		this.aktorzyList = aktorzyList;
	}


	public boolean isDostepnosc() {
		return dostepnosc;
	}

	public void setDostepnosc(boolean dostepnosc) {
		this.dostepnosc = dostepnosc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public int getIloscwyp() {
		return iloscwyp;
	}

	public void setIloscwyp(int iloscwyp) {
		this.iloscwyp = iloscwyp;
	}

	public Date getDatawyp() {
		return datawyp;
	}

	public void setDatawyp(Date datawyp) {
		this.datawyp = datawyp;
	}

	public Date getDatazwot() {
		return datazwot;
	}

	public void setDatazwot(Date datazwot) {
		this.datazwot = datazwot;
	}
	
	public void add(Aktor aktor)
	{
		if(aktorzyList == null)
		{
			aktorzyList =  new ArrayList<Aktor>();
		}
		
		aktorzyList.add(aktor);
	}
	
	@Override
	public String toString() {
		return "Film [id=" + id + ", tytul=" + tytul + ", iloscwyp=" + iloscwyp + ", datawyp=" + datawyp + ", datazwot="
				+ datazwot + "]";
	}
	
	
	
	
}
