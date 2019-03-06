package com.przemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.przemo.entity.abst.User;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User 
{

}
