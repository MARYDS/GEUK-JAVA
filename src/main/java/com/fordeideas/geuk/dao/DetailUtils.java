package com.fordeideas.geuk.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fordeideas.geuk.datamodel.Detail;

@Service
public class DetailUtils {
	
    @Autowired
    private SessionFactory sessionFactory;
    
	/** Return detail results for one constituency  */
	public ArrayList<Detail> getDetailList(String electionYear, String selectedConstituency) {
	
		// run query and return results
		ArrayList<Detail> detailList = new ArrayList<Detail>();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String qry = "FROM com.fordeideas.geuk.datamodel.Detail where year = :year and constituency.constituencyName = :selectedConstituency order by votes desc";
			@SuppressWarnings("unchecked")
			Query<Detail> query = session.createQuery(qry);
			query.setParameter("year", electionYear);
			query.setParameter("selectedConstituency", selectedConstituency);;	
			detailList = (ArrayList<Detail>) query.list();		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return detailList;
	}
    
	/** Return detail results for one constituency for the previous election  */
	public ArrayList<Detail> getDetailListPreviousElection(String electionYear, String selectedConstituency) {

		ArrayList<Detail> detailList = new ArrayList<Detail>();
		ArrayList<String> electionYears = new ArrayList<String>();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String qry = "select distinct year FROM com.fordeideas.geuk.datamodel.Detail where year < :year and constituency.constituencyName = :selectedConstituency order by year desc";
			@SuppressWarnings("unchecked")
			Query<String> query = session.createQuery(qry);
			query.setParameter("year", electionYear);
			query.setParameter("selectedConstituency", selectedConstituency);;	
			electionYears = (ArrayList<String>) query.list();	
			if (electionYears.size() > 0) {
				detailList = getDetailList(electionYears.get(0), selectedConstituency);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return detailList;
	}
	
}
