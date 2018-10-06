package ru.krista.testwork.servlet.dao;


import java.util.List;

import ru.krista.testwork.servlet.model.EntityForResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBUtils {
 
	public static List<EntityForResponse> getReportByDate(Connection conn, String date)   {
		List<EntityForResponse>  reportList = new ArrayList<EntityForResponse>();
		String sql = "SELECT statistics.date, t1.name, t2.name,  hospital.name, disease.name, statistics.patients, statistics.issued,"
				+ " (statistics.issued - statistics.patients) AS trend "
				+ "FROM statistics, hospital, disease, territory AS t1, territory AS t2  "
				+ "WHERE statistics.date = ? AND statistics.hospital_id = hospital.id AND"
				+ " hospital.terr_id = t1.id AND statistics.disease_id = disease.id AND t2.id=t1.parent_id";
	
		PreparedStatement prstm=null;
		ResultSet rs=null;
		try {
			prstm = conn.prepareStatement(sql);
			prstm.setString(1, date);
		    rs = prstm.executeQuery();
		    while(rs.next()) {
		    	
		    	int  date1 = rs.getInt("statistics.date");
		    	
		    	String subject = rs.getString("t1.name");
		    	
		    	String federalDistrict = rs.getString("t2.name");
		    	
		    	
		    	String nameHospital =rs.getString("hospital.name");
		    	
		    	String nameDisease =rs.getString("disease.name");
		    	
		    	int patients =rs.getInt("statistics.patients");
		    	
		    	int issued =rs.getInt("statistics.issued");
		    	
		    	int trend =rs.getInt("trend");
		    	EntityForResponse reportEntity = new EntityForResponse(date1, federalDistrict, subject,  nameHospital, nameDisease, patients, issued, trend );		
		    	
		    	reportList.add(reportEntity);
		    }
		    return reportList;
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	
		
		
	}
	public static List<EntityForResponse> getReportByDate(Connection conn, int date) throws SQLException {
		List<EntityForResponse>  list = new ArrayList<EntityForResponse>();
		String sql = "SELECT  t1.name, t2.name, statistics.date, hospital.name, disease.name, statistics.patients, statistics.issued,"
				+ " (statistics.issued - statistics.patients) AS trend "
				+ "FROM statistics, hospital, disease, territory AS t1, territory AS t2  "
				+ "WHERE statistics.date = ? AND statistics.hospital_id = hospital.id AND"
				+ " hospital.terr_id = t1.id AND statistics.disease_id = disease.id AND t2.id=t1.parent_id";
		
		PreparedStatement prstm = conn.prepareStatement(sql);
		prstm.setInt(1, date);
		ResultSet rs = prstm.executeQuery();
		
		
		while(rs.next()) {

			int  date1 = rs.getInt("statistics.date");
			
			String subject = rs.getString("t1.name");
			
			String federalDistrict = rs.getString("t2.name");
						
			String nameHospital =rs.getString("hospital.name");
			
			String nameDisease =rs.getString("disease.name");
			
			int patients =rs.getInt("statistics.patients");
			
			int issued =rs.getInt("statistics.issued");
			
			int trend =rs.getInt("trend");
			EntityForResponse report = new EntityForResponse(date1, federalDistrict, subject,  nameHospital, nameDisease, patients, issued, trend );		
			
			list.add(report);
		}
		return list;
				
	}
	public static String getLastMonth(Connection conn)  {
		
		String sql = "SELECT MAX(date) AS maxDate FROM statistics ";
		String month ="";
		try (PreparedStatement prstm = conn.prepareStatement(sql))
		 {
			ResultSet rs;				
			rs = prstm.executeQuery();			
		while(rs.next()) {
			
		int  result = rs.getInt("maxDate");
			 month = String.valueOf(result); 
			 month.substring(4,month.length()-2);			
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage().toString());
		}			
		return month;
	}
}
