package ru.krista.testwork.servlet.model;

import java.util.ArrayList;
import java.util.List;

public class EntityForResponse {
private int date;
private String federalDistrict;
private String subject;
private String nameHospital;
private String nameDisease;
private int  patients;
private int  issued;
private int  trend;
//changed to git hab show
public EntityForResponse( int date, String federalDistrict, String subject, 
		                            String nameHospital, String nameDisease,
		                                  int patients, int issued, int trend) 
  {	
	this.date = date;
	this.federalDistrict = federalDistrict;
	this.subject = subject;
	this.nameHospital = nameHospital;
	this.nameDisease = nameDisease;
	this.patients = patients;
	this.issued = issued;
	this.trend = trend;
}

@Override
public String toString() {
	return "EntityForResponse [date=" + date + ", federalDistrict=" + federalDistrict + ", subject=" + subject
			+ ", nameHospital=" + nameHospital + ", nameDisease=" + nameDisease + ", patients=" + patients + ", issued="
			+ issued + ", trend=" + trend + "]";
}

public EntityForResponse() {
	// TODO Auto-generated constructor stub
}




public String getFederalDistrict() {
	return federalDistrict;
}
public void setFederalDistrict(String federalDistrict) {
	this.federalDistrict = federalDistrict;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public int getDate() {
	return date;
}
public void setDate(int date) {
	this.date = date;
}
public String getNameHospital() {
	return nameHospital;
}
public void setNameHospital(String nameHospital) {
	this.nameHospital = nameHospital;
}
public String getNameDisease() {
	return nameDisease;
}
public void setNameDisease(String nameDisease) {
	this.nameDisease = nameDisease;
}
public int getPatients() {
	return patients;
}
public void setPatients(int patients) {
	this.patients = patients;
}
public int getIssued() {
	return issued;
}
public void setIssued(int issued) {
	this.issued = issued;
}
public int getTrend() {
	return trend;
}
public void setTrend(int trend) {
	this.trend = trend;
}
public List<String> getEntityAsList(EntityForResponse obj) {
	List<String> returnList = new ArrayList<>();
	returnList.add(String.valueOf(obj.getDate()));
	returnList.add(obj.getFederalDistrict());
	returnList.add(obj.getSubject());
	returnList.add(obj.getNameHospital());
	returnList.add(obj.getNameDisease());
	returnList.add(String.valueOf(obj.getPatients()));
	returnList.add(String.valueOf(obj.getIssued()));
	returnList.add(String.valueOf(obj.getTrend()));
	
	return returnList;
	
}
}
