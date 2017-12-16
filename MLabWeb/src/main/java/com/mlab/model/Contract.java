package com.mlab.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Contract.findAll", query="SELECT c FROM Contract c")
public class Contract implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	@ManyToOne
	@JoinColumn(name="contract_owner")
	private User user;

	//bi-directional many-to-one association to UserContract
	@OneToMany(mappedBy="contract", fetch=FetchType.EAGER)
	private Set<UserContract> userContracts;
	
	private String contractName;
	
	private Date publishedDate;
	
	private Date fromDate;
	
	private Date toDate;
	
	private Long noOfResources;
	
	private Double wage;//Labour per day
	
	private Boolean enabledBid;
	
	private Double bidPercentage;
	
	private Boolean eanbledOfferValidty;
	
	private Date offerValidDate;
	
	private Boolean enabledLabourRating;
	
	private Double labourRating;
	
	private Boolean enabledPreferredLanguage;
	
	private String preferredLanguage;
	
	private Double contractRating;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Long getNoOfResources() {
		return noOfResources;
	}
	public void setNoOfResources(Long noOfResources) {
		this.noOfResources = noOfResources;
	}
	public Double getWage() {
		return wage;
	}
	public void setWage(Double wage) {
		this.wage = wage;
	}
	public Boolean getEnabledBid() {
		return enabledBid;
	}
	public void setEnabledBid(Boolean enabledBid) {
		this.enabledBid = enabledBid;
	}
	public Double getBidPercentage() {
		return bidPercentage;
	}
	public void setBidPercentage(Double bidPercentage) {
		this.bidPercentage = bidPercentage;
	}
	public Boolean getEanbledOfferValidty() {
		return eanbledOfferValidty;
	}
	public void setEanbledOfferValidty(Boolean eanbledOfferValidty) {
		this.eanbledOfferValidty = eanbledOfferValidty;
	}
	public Date getOfferValidDate() {
		return offerValidDate;
	}
	public void setOfferValidDate(Date offerValidDate) {
		this.offerValidDate = offerValidDate;
	}
	public Boolean getEnabledLabourRating() {
		return enabledLabourRating;
	}
	public void setEnabledLabourRating(Boolean enabledLabourRating) {
		this.enabledLabourRating = enabledLabourRating;
	}
	public Double getLabourRating() {
		return labourRating;
	}
	public void setLabourRating(Double labourRating) {
		this.labourRating = labourRating;
	}
	public Boolean getEnabledPreferredLanguage() {
		return enabledPreferredLanguage;
	}
	public void setEnabledPreferredLanguage(Boolean enabledPreferredLanguage) {
		this.enabledPreferredLanguage = enabledPreferredLanguage;
	}
	public String getPreferredLanguage() {
		return preferredLanguage;
	}
	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}
	public Double getContractRating() {
		return contractRating;
	}
	public void setContractRating(Double contractRating) {
		this.contractRating = contractRating;
	}
	
}
