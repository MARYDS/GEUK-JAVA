package com.fordeideas.geuk.dao;

import com.fordeideas.geuk.datamodel.*;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryUtils{
	
    @Autowired
    private SessionFactory sessionFactory;

	/** Return a filtered/sorted list of constituency results from the election results by constituency table   */
	public ArrayList<Summary> getSummaryList(String year, String searchTerm, String[][] selectedParties, String[][] selectedRegions, String[][] sortOrder) {
	
		// parties in where clause for parties
		ArrayList<String> parties = new ArrayList<String>();
		for (int i=0; i<selectedParties.length; i++) {
			if (selectedParties[i][1].equals("checked")) {
				parties.add(selectedParties[i][0]);
			}
		}
		
		// regions in where clause for regions
		ArrayList<String> regions = new ArrayList<String>();
		for (int i=0; i<selectedRegions.length; i++) {
			if (selectedRegions[i][1].equals("checked")) {
				regions.add(selectedRegions[i][0]);
			}
		}	
		
		// order by clause
		StringBuilder sortClause = new StringBuilder();
		for (int i=0; i<sortOrder.length; i++) {
			switch (sortOrder[i][0]) {
            case "Region":  
            	sortClause.append("constituency.regionName ");
                break;
            case "Constituency": 
            	sortClause.append("constituency.constituencyName ");
                break;
            case "Party": 
            	sortClause.append("party.name ");
                break;    
            case "MP": 
            	sortClause.append("surname ");
            	sortClause.append(sortOrder[i][1]);
            	sortClause.append(", ");
            	sortClause.append("firstName ");            	
                break;			
            case "Margin":  
            	sortClause.append("majorityPercent ");
                break;	
            case "Prev_Party":  
            	sortClause.append("prevParty.name ");
                break;
            case "2nd_Party":  
            	sortClause.append("runnerUpParty.name ");
                break;             
			}
            sortClause.append(sortOrder[i][1]); 
            if (sortOrder.length > i+1) {
            	sortClause.append(", ");
            }			
		}		

		// run query and return results
		ArrayList<Summary> summaryList = new ArrayList<Summary>();
		Session session = null;
		try {
			if (parties.size() > 0 && regions.size() > 0) {
				session = sessionFactory.openSession();
				String qry = "FROM com.fordeideas.geuk.datamodel.Summary where year = :year ";		
				qry += "and party.name in :parties ";				
				qry += "and constituency.regionName in :regions ";
				
				if (searchTerm != "") {
					qry += "and (upper(fullName) like :searchTerm "
						  + "or upper(constituency.constituencyName) like :searchTerm "
					      + "or upper(constituency.regionName) like :searchTerm "
						  + "or upper(party.name) like :searchTerm) ";
				}
				qry += "order by " + sortClause.toString();

				@SuppressWarnings("unchecked")
				Query<Summary> query = session.createQuery(qry);
				query.setParameter("year", year);
				query.setParameter("parties", parties);
				query.setParameter("regions", regions);
				if (searchTerm != "") {
					query.setParameter("searchTerm", "%" + searchTerm.toUpperCase() +"%");					
				}
				summaryList = (ArrayList<Summary>) query.list();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return summaryList;
	}

	/** Return a Summary results object for one year / constituency */
	public Summary getConstituencyResults(String electionYear, String selectedConstituency) {

		Summary constitResult = null;

		Session session = null;
		try {
			session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			Query<Summary> query = session.createQuery("FROM com.fordeideas.geuk.datamodel.Summary where year = :electionYear and constituency.constituencyName = :selectedConstituency");
			query.setParameter("electionYear", electionYear);
			query.setParameter("selectedConstituency", selectedConstituency);
			ArrayList<Summary> constitResults = (ArrayList<Summary>) query.list();	
			if (constitResults.size() > 0) {
				constitResult = constitResults.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return constitResult;
		
		
	}
	

	/** Return a list of election years from the election results by constituency table   */	
	public ArrayList<String> getElectionYearsList() {

		ArrayList<String> yearsList = new ArrayList<String>();

		Session session = null;
		try {
			session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			Query<String> query = session.createQuery("select distinct year FROM com.fordeideas.geuk.datamodel.Summary order by year desc");
			yearsList = (ArrayList<String>) query.list();		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return yearsList;
	}
	
	/** Return a list of regions from the election results by constituency table   */	
	public ArrayList<String> getRegionList() {

		ArrayList<String> regionList = new ArrayList<String>();

		Session session = null;
		try {
			session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			Query<String> query = session.createQuery("select distinct constituency.regionName FROM com.fordeideas.geuk.datamodel.Summary order by constituency.regionName");
			regionList = (ArrayList<String>) query.list();		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return regionList;
	}
	
	/** Return a list of parties from the election results by constituency table   */	
	public ArrayList<String> getPartyList() {

		ArrayList<String> partyList = new ArrayList<String>();

		Session session = null;
		try {
			session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			Query<String> query = session.createQuery("select distinct party.name FROM com.fordeideas.geuk.datamodel.Summary order by party.name");
			partyList = (ArrayList<String>) query.list();		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return partyList;
	}

}
