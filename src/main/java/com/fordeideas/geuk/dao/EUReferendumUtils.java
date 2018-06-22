package com.fordeideas.geuk.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fordeideas.geuk.datamodel.Detail;
import com.fordeideas.geuk.datamodel.EUReferendum;

@Service
public class EUReferendumUtils {
	
    @Autowired
    private SessionFactory sessionFactory;
    
	/** Return EU referendum results for one constituency  */
	public ArrayList<EUReferendum> getEURefList(String selectedConstituency) {
	
		// run query and return results
		ArrayList<EUReferendum> euRefList = new ArrayList<EUReferendum>();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String qry = "FROM com.fordeideas.geuk.datamodel.EUReferendum where ";
			qry += "areaCode in (select areaId from com.fordeideas.geuk.datamodel.WardConLocAuth ";
			qry += "where constituencyName = :selectedConstituency)";
			Query<EUReferendum> query = session.createQuery(qry);
			query.setParameter("selectedConstituency", selectedConstituency);;	
			euRefList = (ArrayList<EUReferendum>) query.list();		 
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return euRefList;
	}

}
