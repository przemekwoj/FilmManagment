package com.przemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aktorzy")
public class Aktor 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aktorzy_id")
    private int aktorzy_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
				 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
	name="aktorzy_filmy",
	joinColumns=@JoinColumn(name="aktorzy_id"),
	inverseJoinColumns=@JoinColumn(name="id")
	)
	private List<Film> filmsList;

	public int getAktorzy_id() {
		return aktorzy_id;
	}

	public void setAktorzy_id(int aktorzy_id) {
		this.aktorzy_id = aktorzy_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public List<Film> getFilmsList() {
		return filmsList;
	}

	public void setFilmsList(List<Film> filmsList) {
		this.filmsList = filmsList;
	}

	public void add(Film tempFilm)
	{
		if(filmsList == null)
		{
			filmsList =  new ArrayList<Film>();
		}
		
		filmsList.add(tempFilm);
	}
	
	@Override
	public String toString() {
		return "Aktor [aktorzy_id=" + aktorzy_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", filmsList=" + filmsList + "]";
	}
	
	
}
