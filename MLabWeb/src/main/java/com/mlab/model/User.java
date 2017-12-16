package com.mlab.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	private String username;//an  identifier
	private String emailAddress;
	private String mobileNumber;
	private String mobileOTP;
	private Boolean emailVerified;
	private String preferredLanguage;
	private String gender;
	private String currentResidentialAddress;
	private String residentialArea;
	private String preferredWorkingHours;
	private String preferredWorkingDays;
	private String healthIssues;
	private Boolean needTravelfacility;
	private Boolean knowDriving;
	private String experianceIn;
	private String labourExperiance;
	private Date dateOfbirth;
	private Integer additionType;//just steps
	private Date createdDate;
	private Date updatedDate;
	private Double rating;//shows rating out of 10
	private Long noOfRatedPerson;//show the count
	private String userType;//Owner or Labour
	private Long totalJobsApplied;//only for labours
	private Long totalJobsPublished;//only for owners
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMobileOTP() {
		return mobileOTP;
	}
	public void setMobileOTP(String mobileOTP) {
		this.mobileOTP = mobileOTP;
	}
	public Boolean getEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}
	public String getPreferredLanguage() {
		return preferredLanguage;
	}
	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCurrentResidentialAddress() {
		return currentResidentialAddress;
	}
	public void setCurrentResidentialAddress(String currentResidentialAddress) {
		this.currentResidentialAddress = currentResidentialAddress;
	}
	public String getResidentialArea() {
		return residentialArea;
	}
	public void setResidentialArea(String residentialArea) {
		this.residentialArea = residentialArea;
	}
	public String getPreferredWorkingHours() {
		return preferredWorkingHours;
	}
	public void setPreferredWorkingHours(String preferredWorkingHours) {
		this.preferredWorkingHours = preferredWorkingHours;
	}
	public String getPreferredWorkingDays() {
		return preferredWorkingDays;
	}
	public void setPreferredWorkingDays(String preferredWorkingDays) {
		this.preferredWorkingDays = preferredWorkingDays;
	}
	public String getHealthIssues() {
		return healthIssues;
	}
	public void setHealthIssues(String healthIssues) {
		this.healthIssues = healthIssues;
	}
	public Boolean getNeedTravelfacility() {
		return needTravelfacility;
	}
	public void setNeedTravelfacility(Boolean needTravelfacility) {
		this.needTravelfacility = needTravelfacility;
	}
	public Boolean getKnowDriving() {
		return knowDriving;
	}
	public void setKnowDriving(Boolean knowDriving) {
		this.knowDriving = knowDriving;
	}
	public String getExperianceIn() {
		return experianceIn;
	}
	public void setExperianceIn(String experianceIn) {
		this.experianceIn = experianceIn;
	}
	public String getLabourExperiance() {
		return labourExperiance;
	}
	public void setLabourExperiance(String labourExperiance) {
		this.labourExperiance = labourExperiance;
	}
	public Date getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(Date dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}
	public Integer getAdditionType() {
		return additionType;
	}
	public void setAdditionType(Integer additionType) {
		this.additionType = additionType;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Long getNoOfRatedPerson() {
		return noOfRatedPerson;
	}
	public void setNoOfRatedPerson(Long noOfRatedPerson) {
		this.noOfRatedPerson = noOfRatedPerson;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Long getTotalJobsApplied() {
		return totalJobsApplied;
	}
	public void setTotalJobsApplied(Long totalJobsApplied) {
		this.totalJobsApplied = totalJobsApplied;
	}
	public Long getTotalJobsPublished() {
		return totalJobsPublished;
	}
	public void setTotalJobsPublished(Long totalJobsPublished) {
		this.totalJobsPublished = totalJobsPublished;
	}

	
	
}
