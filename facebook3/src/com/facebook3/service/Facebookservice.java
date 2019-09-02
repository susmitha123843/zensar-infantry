package com.facebook3.service;

import com.facebook3.dao.FacebookDAO;
import com.facebook3.dao.FacebookDAOInterface;
import com.facebook3.entity.FacebookEmployee;

public class Facebookservice implements FacebookserviceInterface  {

	public static FacebookserviceInterface createObject() {
		// TODO Auto-generated method stub
		return new Facebookservice();
	}

	@Override
	public int createProfile(FacebookEmployee fe) {
		// TODO Auto-generated method stub
		FacebookDAOInterface fd=FacebookDAO.createObject();
		return fd.createObject(fe);
	}

}
