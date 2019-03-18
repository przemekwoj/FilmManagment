package com.przemo.dao;

import java.util.List;

import com.przemo.entity.Aktor;

public interface ActorDao
{

	public Aktor getActorById(int actorId);
	
	public void saveActor(Aktor actor);
	
	public void updateActor(Aktor aktor);
	
	public List<Aktor> getAllActors();

}
