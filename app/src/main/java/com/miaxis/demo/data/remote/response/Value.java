package com.miaxis.demo.data.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Value implements Serializable {

    @SerializedName("@odata.etag")
    @Expose
    private String odataEtag;
    @SerializedName("No")
    @Expose
    private String no;
    @SerializedName("First_Name")
    @Expose
    private String firstName;
    @SerializedName("Middle_Name")
    @Expose
    private String middleName;
    @SerializedName("Last_Name")
    @Expose
    private String lastName;
    @SerializedName("Initials")
    @Expose
    private String initials;
    @SerializedName("Job_Title")
    @Expose
    private String jobTitle;
    @SerializedName("Search_Name")
    @Expose
    private String searchName;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Address_2")
    @Expose
    private String address2;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("Post_Code")
    @Expose
    private String postCode;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Phone_No")
    @Expose
    private String phoneNo;
    @SerializedName("Mobile_Phone_No")
    @Expose
    private String mobilePhoneNo;
    @SerializedName("E_Mail")
    @Expose
    private String eMail;
    @SerializedName("Alt_Address_Code")
    @Expose
    private String altAddressCode;
    @SerializedName("Alt_Address_Start_Date")
    @Expose
    private String altAddressStartDate;
    @SerializedName("Alt_Address_End_Date")
    @Expose
    private String altAddressEndDate;
    @SerializedName("Picture@odata.mediaReadLink")
    @Expose
    private String pictureOdataMediaReadLink;
    @SerializedName("Birth_Date")
    @Expose
    private String birthDate;
    @SerializedName("Social_Security_No")
    @Expose
    private String socialSecurityNo;
    @SerializedName("Union_Code")
    @Expose
    private String unionCode;
    @SerializedName("Union_Membership_No")
    @Expose
    private String unionMembershipNo;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("Country_Code")
    @Expose
    private String countryCode;
    @SerializedName("Manager_No")
    @Expose
    private String managerNo;
    @SerializedName("Emplymt_Contract_Code")
    @Expose
    private String emplymtContractCode;
    @SerializedName("Statistics_Group_Code")
    @Expose
    private String statisticsGroupCode;
    @SerializedName("Employment_Date")
    @Expose
    private String employmentDate;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Inactive_Date")
    @Expose
    private String inactiveDate;
    @SerializedName("Cause_of_Inactivity_Code")
    @Expose
    private String causeOfInactivityCode;
    @SerializedName("Termination_Date")
    @Expose
    private String terminationDate;
    @SerializedName("Grounds_for_Term_Code")
    @Expose
    private String groundsForTermCode;
    @SerializedName("Global_Dimension_1_Code")
    @Expose
    private String globalDimension1Code;
    @SerializedName("Global_Dimension_2_Code")
    @Expose
    private String globalDimension2Code;
    @SerializedName("Resource_No")
    @Expose
    private String resourceNo;
    @SerializedName("Comment")
    @Expose
    private Boolean comment;
    @SerializedName("Last_Date_Modified")
    @Expose
    private String lastDateModified;
    @SerializedName("Date_Filter")
    @Expose
    private String dateFilter;
    @SerializedName("Global_Dimension_1_Filter")
    @Expose
    private String globalDimension1Filter;
    @SerializedName("Global_Dimension_2_Filter")
    @Expose
    private String globalDimension2Filter;
    @SerializedName("Cause_of_Absence_Filter")
    @Expose
    private String causeOfAbsenceFilter;
    @SerializedName("Total_Absence_Base")
    @Expose
    private Integer totalAbsenceBase;
    @SerializedName("Extension")
    @Expose
    private String extension;
    @SerializedName("Employee_No_Filter")
    @Expose
    private String employeeNoFilter;
    @SerializedName("Pager")
    @Expose
    private String pager;
    @SerializedName("Fax_No")
    @Expose
    private String faxNo;
    @SerializedName("Company_E_Mail")
    @Expose
    private String companyEMail;
    @SerializedName("Titles")
    @Expose
    private String titles;
    @SerializedName("Salespers_Purch_Code")
    @Expose
    private String salespersPurchCode;
    @SerializedName("No_Series")
    @Expose
    private String noSeries;
    @SerializedName("Last_Modified_Date_Time")
    @Expose
    private String lastModifiedDateTime;
    @SerializedName("Employee_Posting_Group")
    @Expose
    private String employeePostingGroup;
    @SerializedName("Bank_Branch_No")
    @Expose
    private String bankBranchNo;
    @SerializedName("Bank_Account_No")
    @Expose
    private String bankAccountNo;
    @SerializedName("IBAN")
    @Expose
    private String iban;
    @SerializedName("Balance")
    @Expose
    private Integer balance;
    @SerializedName("SWIFT_Code")
    @Expose
    private String sWIFTCode;
    @SerializedName("Application_Method")
    @Expose
    private String applicationMethod;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("Cost_Center_Code")
    @Expose
    private String costCenterCode;
    @SerializedName("Cost_Object_Code")
    @Expose
    private String costObjectCode;
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Job_Titles")
    @Expose
    private String jobTitles;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Payment_Mode")
    @Expose
    private String paymentMode;
    @SerializedName("Pay_Group_Code")
    @Expose
    private String payGroupCode;
    @SerializedName("Payroll_Structure")
    @Expose
    private String payrollStructure;
    @SerializedName("Annual_Basic")
    @Expose
    private Integer annualBasic;
    @SerializedName("Payment_Method")
    @Expose
    private String paymentMethod;
    @SerializedName("Bank_Code")
    @Expose
    private String bankCode;
    @SerializedName("Bank_Name")
    @Expose
    private String bankName;
    @SerializedName("Branch_Code")
    @Expose
    private String branchCode;
    @SerializedName("Branch_Name")
    @Expose
    private String branchName;
    @SerializedName("Account_No")
    @Expose
    private String accountNo;
    @SerializedName("Status_Code")
    @Expose
    private String statusCode;
    @SerializedName("Nationality")
    @Expose
    private String nationality;
    @SerializedName("Region")
    @Expose
    private String region;
    @SerializedName("Notch")
    @Expose
    private String notch;
    @SerializedName("Contribute_to_SSF_Employee")
    @Expose
    private Boolean contributeToSSFEmployee;
    @SerializedName("Contribute_to_SSF_Employer")
    @Expose
    private Boolean contributeToSSFEmployer;
    @SerializedName("Staff_No")
    @Expose
    private String staffNo;
    @SerializedName("Disability")
    @Expose
    private Boolean disability;
    @SerializedName("Marital_Status")
    @Expose
    private String maritalStatus;
    @SerializedName("Religion")
    @Expose
    private String religion;
    @SerializedName("Mode_of_Apointment")
    @Expose
    private String modeOfApointment;
    @SerializedName("First_Category_Level")
    @Expose
    private String firstCategoryLevel;
    @SerializedName("First_Category_Description")
    @Expose
    private String firstCategoryDescription;
    @SerializedName("Second_Category_Description")
    @Expose
    private String secondCategoryDescription;
    @SerializedName("Third_Category_Description")
    @Expose
    private String thirdCategoryDescription;
    @SerializedName("Fourth_Category_Description")
    @Expose
    private String fourthCategoryDescription;
    @SerializedName("Fifth_Category_Description")
    @Expose
    private String fifthCategoryDescription;
    @SerializedName("Second_Category_Level")
    @Expose
    private String secondCategoryLevel;
    @SerializedName("Third_Category_Level")
    @Expose
    private String thirdCategoryLevel;
    @SerializedName("Fourth_Category_Level")
    @Expose
    private String fourthCategoryLevel;
    @SerializedName("Fifth_Category_Level")
    @Expose
    private String fifthCategoryLevel;
    @SerializedName("Old_Basic")
    @Expose
    private Integer oldBasic;
    @SerializedName("Grade")
    @Expose
    private String grade;
    @SerializedName("Starting_date")
    @Expose
    private String startingDate;
    @SerializedName("Mothers_Name")
    @Expose
    private String mothersName;
    @SerializedName("Employee_Transaction")
    @Expose
    private Boolean employeeTransaction;
    @SerializedName("Promotion_Transaction")
    @Expose
    private Boolean promotionTransaction;
    @SerializedName("House_No")
    @Expose
    private String houseNo;
    @SerializedName("Place_of_Birth")
    @Expose
    private String placeOfBirth;
    @SerializedName("Step")
    @Expose
    private String step;
    @SerializedName("Basic")
    @Expose
    private Integer basic;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("Net")
    @Expose
    private Integer net;
    @SerializedName("Basic_GHc")
    @Expose
    private Integer basicGHc;
    @SerializedName("Sex")
    @Expose
    private String sex;
    @SerializedName("Person_Type")
    @Expose
    private String personType;
    @SerializedName("Assignment_No")
    @Expose
    private String assignmentNo;
    @SerializedName("Employement_Category")
    @Expose
    private String employementCategory;
    @SerializedName("Location")
    @Expose
    private String location;
    @SerializedName("Region_Description")
    @Expose
    private String regionDescription;
    @SerializedName("Organization")
    @Expose
    private String organization;
    @SerializedName("Salary_Grade_Description")
    @Expose
    private String salaryGradeDescription;
    @SerializedName("District")
    @Expose
    private String district;
    @SerializedName("Circuit")
    @Expose
    private String circuit;
    @SerializedName("Occupational_Group")
    @Expose
    private String occupationalGroup;
    @SerializedName("Employee_Type")
    @Expose
    private String employeeType;
    @SerializedName("Union_Description")
    @Expose
    private String unionDescription;
    @SerializedName("Status_Description")
    @Expose
    private String statusDescription;
    @SerializedName("Structure")
    @Expose
    private String structure;
    @SerializedName("Payroll")
    @Expose
    private String payroll;
    @SerializedName("Payroll_ID")
    @Expose
    private String payrollID;
    @SerializedName("Pay_Period")
    @Expose
    private String payPeriod;
    @SerializedName("Assignment_Status")
    @Expose
    private String assignmentStatus;
    @SerializedName("Assignment_Action_ID")
    @Expose
    private String assignmentActionID;
    @SerializedName("Payroll_Action_ID")
    @Expose
    private String payrollActionID;
    @SerializedName("Payroll_Action_Type")
    @Expose
    private String payrollActionType;
    @SerializedName("Creation_Date")
    @Expose
    private String creationDate;
    @SerializedName("Line_ID")
    @Expose
    private Integer lineID;
    @SerializedName("Balance_Load_Status")
    @Expose
    private String balanceLoadStatus;
    @SerializedName("Job_Title_Description")
    @Expose
    private String jobTitleDescription;
    @SerializedName("Employee_No")
    @Expose
    private Integer employeeNo;
    @SerializedName("Assignment_ID")
    @Expose
    private String assignmentID;
    @SerializedName("Fathers_Name")
    @Expose
    private String fathersName;
    @SerializedName("Parttime_Cont_trainee_End_Date")
    @Expose
    private String parttimeContTraineeEndDate;
    @SerializedName("User_ID")
    @Expose
    private String userID;
    @SerializedName("Management_Unit")
    @Expose
    private String managementUnit;
    @SerializedName("Check_Letter")
    @Expose
    private String checkLetter;
    @SerializedName("Posted")
    @Expose
    private Boolean posted;
    @SerializedName("Form_No")
    @Expose
    private String formNo;
    @SerializedName("Period_Code")
    @Expose
    private String periodCode;
    @SerializedName("Modified")
    @Expose
    private Boolean modified;
    @SerializedName("Supervisor_ID")
    @Expose
    private String supervisorID;
    @SerializedName("New_IPPD3_No")
    @Expose
    private String newIPPD3No;
    @SerializedName("District_Name")
    @Expose
    private String districtName;
    @SerializedName("Transaction_Type")
    @Expose
    private String transactionType;
    @SerializedName("Age")
    @Expose
    private Integer age;
    @SerializedName("Secondment")
    @Expose
    private Boolean secondment;
    @SerializedName("Maiden_Name")
    @Expose
    private String maidenName;
    @SerializedName("Employee_region")
    @Expose
    private String employeeRegion;
    @SerializedName("Employee_District")
    @Expose
    private String employeeDistrict;
    @SerializedName("National_ID")
    @Expose
    private Integer nationalID;
    @SerializedName("Disability_Details")
    @Expose
    private String disabilityDetails;
    @SerializedName("Disability_Start_Date")
    @Expose
    private String disabilityStartDate;
    @SerializedName("Licence_No")
    @Expose
    private String licenceNo;
    @SerializedName("Licence_Type")
    @Expose
    private String licenceType;
    @SerializedName("Service_No")
    @Expose
    private String serviceNo;
    @SerializedName("New_Pensioner_ID")
    @Expose
    private String newPensionerID;
    @SerializedName("Pension_Beneficiary_ID")
    @Expose
    private String pensionBeneficiaryID;
    @SerializedName("Pension_Start_Date")
    @Expose
    private String pensionStartDate;
    @SerializedName("Pension_Benefit_Type")
    @Expose
    private String pensionBenefitType;
    @SerializedName("Pensioner")
    @Expose
    private Boolean pensioner;
    @SerializedName("Locked")
    @Expose
    private Boolean locked;
    @SerializedName("InterStartPeriod")
    @Expose
    private Integer interStartPeriod;
    @SerializedName("InterEndPeriod")
    @Expose
    private Integer interEndPeriod;
    @SerializedName("EmploymentPeriod")
    @Expose
    private Integer employmentPeriod;
    @SerializedName("Interdicted")
    @Expose
    private Boolean interdicted;
    @SerializedName("EmpDateProcess")
    @Expose
    private Boolean empDateProcess;
    @SerializedName("InterEndDate")
    @Expose
    private String interEndDate;
    @SerializedName("LeaveEnd")
    @Expose
    private Boolean leaveEnd;
    @SerializedName("Unlocked")
    @Expose
    private Boolean unlocked;
    @SerializedName("To_be_processed")
    @Expose
    private Boolean toBeProcessed;
    @SerializedName("InterStartDate")
    @Expose
    private String interStartDate;
    @SerializedName("Processed")
    @Expose
    private Boolean processed;
    @SerializedName("Commuted_Pension")
    @Expose
    private Boolean commutedPension;
    @SerializedName("Disciplinary_Aword")
    @Expose
    private String disciplinaryAword;
    @SerializedName("Contribute_to_Old_SSF")
    @Expose
    private Boolean contributeToOldSSF;
    @SerializedName("Full_Contribution")
    @Expose
    private Boolean fullContribution;
    @SerializedName("Contract_Monthly_salary")
    @Expose
    private Integer contractMonthlySalary;
    @SerializedName("Occp_Social_Security_No")
    @Expose
    private String occpSocialSecurityNo;
    @SerializedName("Superanuation_Contr_No")
    @Expose
    private String superanuationContrNo;
    @SerializedName("District_of_Birth")
    @Expose
    private String districtOfBirth;
    @SerializedName("Country_of_Birth")
    @Expose
    private String countryOfBirth;
    @SerializedName("Region_of_Birth")
    @Expose
    private String regionOfBirth;
    @SerializedName("Parttime_ContractEndPeriod")
    @Expose
    private Integer parttimeContractEndPeriod;
    @SerializedName("Pension_Type")
    @Expose
    private String pensionType;
    @SerializedName("Organisation_Group")
    @Expose
    private String organisationGroup;
    @SerializedName("In_Cogent")
    @Expose
    private Boolean inCogent;
    @SerializedName("Emp_New_Emp")
    @Expose
    private Boolean empNewEmp;
    @SerializedName("Counter")
    @Expose
    private Integer counter;
    @SerializedName("terminate")
    @Expose
    private Boolean terminate;
    @SerializedName("origional_hire_date")
    @Expose
    private String origionalHireDate;
    @SerializedName("Hv_1_month_arrears_Aug")
    @Expose
    private Boolean hv1MonthArrearsAug;
    @SerializedName("In_Joel")
    @Expose
    private Boolean inJoel;
    @SerializedName("New_Job_Title")
    @Expose
    private String newJobTitle;
    @SerializedName("Nominee")
    @Expose
    private Boolean nominee;
    @SerializedName("Duplicate")
    @Expose
    private Integer duplicate;
    @SerializedName("PAID")
    @Expose
    private Boolean paid;
    @SerializedName("linked_to_widow")
    @Expose
    private Boolean linkedToWidow;
    @SerializedName("Modified_By")
    @Expose
    private String modifiedBy;
    @SerializedName("Period")
    @Expose
    private String period;
    @SerializedName("Ghana_Card")
    @Expose
    private String ghanaCard;

    public String getOdataEtag() {
        return odataEtag;
    }

    public void setOdataEtag(String odataEtag) {
        this.odataEtag = odataEtag;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMobilePhoneNo() {
        return mobilePhoneNo;
    }

    public void setMobilePhoneNo(String mobilePhoneNo) {
        this.mobilePhoneNo = mobilePhoneNo;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAltAddressCode() {
        return altAddressCode;
    }

    public void setAltAddressCode(String altAddressCode) {
        this.altAddressCode = altAddressCode;
    }

    public String getAltAddressStartDate() {
        return altAddressStartDate;
    }

    public void setAltAddressStartDate(String altAddressStartDate) {
        this.altAddressStartDate = altAddressStartDate;
    }

    public String getAltAddressEndDate() {
        return altAddressEndDate;
    }

    public void setAltAddressEndDate(String altAddressEndDate) {
        this.altAddressEndDate = altAddressEndDate;
    }

    public String getPictureOdataMediaReadLink() {
        return pictureOdataMediaReadLink;
    }

    public void setPictureOdataMediaReadLink(String pictureOdataMediaReadLink) {
        this.pictureOdataMediaReadLink = pictureOdataMediaReadLink;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSocialSecurityNo() {
        return socialSecurityNo;
    }

    public void setSocialSecurityNo(String socialSecurityNo) {
        this.socialSecurityNo = socialSecurityNo;
    }

    public String getUnionCode() {
        return unionCode;
    }

    public void setUnionCode(String unionCode) {
        this.unionCode = unionCode;
    }

    public String getUnionMembershipNo() {
        return unionMembershipNo;
    }

    public void setUnionMembershipNo(String unionMembershipNo) {
        this.unionMembershipNo = unionMembershipNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getManagerNo() {
        return managerNo;
    }

    public void setManagerNo(String managerNo) {
        this.managerNo = managerNo;
    }

    public String getEmplymtContractCode() {
        return emplymtContractCode;
    }

    public void setEmplymtContractCode(String emplymtContractCode) {
        this.emplymtContractCode = emplymtContractCode;
    }

    public String getStatisticsGroupCode() {
        return statisticsGroupCode;
    }

    public void setStatisticsGroupCode(String statisticsGroupCode) {
        this.statisticsGroupCode = statisticsGroupCode;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(String inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getCauseOfInactivityCode() {
        return causeOfInactivityCode;
    }

    public void setCauseOfInactivityCode(String causeOfInactivityCode) {
        this.causeOfInactivityCode = causeOfInactivityCode;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getGroundsForTermCode() {
        return groundsForTermCode;
    }

    public void setGroundsForTermCode(String groundsForTermCode) {
        this.groundsForTermCode = groundsForTermCode;
    }

    public String getGlobalDimension1Code() {
        return globalDimension1Code;
    }

    public void setGlobalDimension1Code(String globalDimension1Code) {
        this.globalDimension1Code = globalDimension1Code;
    }

    public String getGlobalDimension2Code() {
        return globalDimension2Code;
    }

    public void setGlobalDimension2Code(String globalDimension2Code) {
        this.globalDimension2Code = globalDimension2Code;
    }

    public String getResourceNo() {
        return resourceNo;
    }

    public void setResourceNo(String resourceNo) {
        this.resourceNo = resourceNo;
    }

    public Boolean getComment() {
        return comment;
    }

    public void setComment(Boolean comment) {
        this.comment = comment;
    }

    public String getLastDateModified() {
        return lastDateModified;
    }

    public void setLastDateModified(String lastDateModified) {
        this.lastDateModified = lastDateModified;
    }

    public String getDateFilter() {
        return dateFilter;
    }

    public void setDateFilter(String dateFilter) {
        this.dateFilter = dateFilter;
    }

    public String getGlobalDimension1Filter() {
        return globalDimension1Filter;
    }

    public void setGlobalDimension1Filter(String globalDimension1Filter) {
        this.globalDimension1Filter = globalDimension1Filter;
    }

    public String getGlobalDimension2Filter() {
        return globalDimension2Filter;
    }

    public void setGlobalDimension2Filter(String globalDimension2Filter) {
        this.globalDimension2Filter = globalDimension2Filter;
    }

    public String getCauseOfAbsenceFilter() {
        return causeOfAbsenceFilter;
    }

    public void setCauseOfAbsenceFilter(String causeOfAbsenceFilter) {
        this.causeOfAbsenceFilter = causeOfAbsenceFilter;
    }

    public Integer getTotalAbsenceBase() {
        return totalAbsenceBase;
    }

    public void setTotalAbsenceBase(Integer totalAbsenceBase) {
        this.totalAbsenceBase = totalAbsenceBase;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmployeeNoFilter() {
        return employeeNoFilter;
    }

    public void setEmployeeNoFilter(String employeeNoFilter) {
        this.employeeNoFilter = employeeNoFilter;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getCompanyEMail() {
        return companyEMail;
    }

    public void setCompanyEMail(String companyEMail) {
        this.companyEMail = companyEMail;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getSalespersPurchCode() {
        return salespersPurchCode;
    }

    public void setSalespersPurchCode(String salespersPurchCode) {
        this.salespersPurchCode = salespersPurchCode;
    }

    public String getNoSeries() {
        return noSeries;
    }

    public void setNoSeries(String noSeries) {
        this.noSeries = noSeries;
    }

    public String getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(String lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public String getEmployeePostingGroup() {
        return employeePostingGroup;
    }

    public void setEmployeePostingGroup(String employeePostingGroup) {
        this.employeePostingGroup = employeePostingGroup;
    }

    public String getBankBranchNo() {
        return bankBranchNo;
    }

    public void setBankBranchNo(String bankBranchNo) {
        this.bankBranchNo = bankBranchNo;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getSWIFTCode() {
        return sWIFTCode;
    }

    public void setSWIFTCode(String sWIFTCode) {
        this.sWIFTCode = sWIFTCode;
    }

    public String getApplicationMethod() {
        return applicationMethod;
    }

    public void setApplicationMethod(String applicationMethod) {
        this.applicationMethod = applicationMethod;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getCostObjectCode() {
        return costObjectCode;
    }

    public void setCostObjectCode(String costObjectCode) {
        this.costObjectCode = costObjectCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitles() {
        return jobTitles;
    }

    public void setJobTitles(String jobTitles) {
        this.jobTitles = jobTitles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPayGroupCode() {
        return payGroupCode;
    }

    public void setPayGroupCode(String payGroupCode) {
        this.payGroupCode = payGroupCode;
    }

    public String getPayrollStructure() {
        return payrollStructure;
    }

    public void setPayrollStructure(String payrollStructure) {
        this.payrollStructure = payrollStructure;
    }

    public Integer getAnnualBasic() {
        return annualBasic;
    }

    public void setAnnualBasic(Integer annualBasic) {
        this.annualBasic = annualBasic;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNotch() {
        return notch;
    }

    public void setNotch(String notch) {
        this.notch = notch;
    }

    public Boolean getContributeToSSFEmployee() {
        return contributeToSSFEmployee;
    }

    public void setContributeToSSFEmployee(Boolean contributeToSSFEmployee) {
        this.contributeToSSFEmployee = contributeToSSFEmployee;
    }

    public Boolean getContributeToSSFEmployer() {
        return contributeToSSFEmployer;
    }

    public void setContributeToSSFEmployer(Boolean contributeToSSFEmployer) {
        this.contributeToSSFEmployer = contributeToSSFEmployer;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public Boolean getDisability() {
        return disability;
    }

    public void setDisability(Boolean disability) {
        this.disability = disability;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getModeOfApointment() {
        return modeOfApointment;
    }

    public void setModeOfApointment(String modeOfApointment) {
        this.modeOfApointment = modeOfApointment;
    }

    public String getFirstCategoryLevel() {
        return firstCategoryLevel;
    }

    public void setFirstCategoryLevel(String firstCategoryLevel) {
        this.firstCategoryLevel = firstCategoryLevel;
    }

    public String getFirstCategoryDescription() {
        return firstCategoryDescription;
    }

    public void setFirstCategoryDescription(String firstCategoryDescription) {
        this.firstCategoryDescription = firstCategoryDescription;
    }

    public String getSecondCategoryDescription() {
        return secondCategoryDescription;
    }

    public void setSecondCategoryDescription(String secondCategoryDescription) {
        this.secondCategoryDescription = secondCategoryDescription;
    }

    public String getThirdCategoryDescription() {
        return thirdCategoryDescription;
    }

    public void setThirdCategoryDescription(String thirdCategoryDescription) {
        this.thirdCategoryDescription = thirdCategoryDescription;
    }

    public String getFourthCategoryDescription() {
        return fourthCategoryDescription;
    }

    public void setFourthCategoryDescription(String fourthCategoryDescription) {
        this.fourthCategoryDescription = fourthCategoryDescription;
    }

    public String getFifthCategoryDescription() {
        return fifthCategoryDescription;
    }

    public void setFifthCategoryDescription(String fifthCategoryDescription) {
        this.fifthCategoryDescription = fifthCategoryDescription;
    }

    public String getSecondCategoryLevel() {
        return secondCategoryLevel;
    }

    public void setSecondCategoryLevel(String secondCategoryLevel) {
        this.secondCategoryLevel = secondCategoryLevel;
    }

    public String getThirdCategoryLevel() {
        return thirdCategoryLevel;
    }

    public void setThirdCategoryLevel(String thirdCategoryLevel) {
        this.thirdCategoryLevel = thirdCategoryLevel;
    }

    public String getFourthCategoryLevel() {
        return fourthCategoryLevel;
    }

    public void setFourthCategoryLevel(String fourthCategoryLevel) {
        this.fourthCategoryLevel = fourthCategoryLevel;
    }

    public String getFifthCategoryLevel() {
        return fifthCategoryLevel;
    }

    public void setFifthCategoryLevel(String fifthCategoryLevel) {
        this.fifthCategoryLevel = fifthCategoryLevel;
    }

    public Integer getOldBasic() {
        return oldBasic;
    }

    public void setOldBasic(Integer oldBasic) {
        this.oldBasic = oldBasic;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public Boolean getEmployeeTransaction() {
        return employeeTransaction;
    }

    public void setEmployeeTransaction(Boolean employeeTransaction) {
        this.employeeTransaction = employeeTransaction;
    }

    public Boolean getPromotionTransaction() {
        return promotionTransaction;
    }

    public void setPromotionTransaction(Boolean promotionTransaction) {
        this.promotionTransaction = promotionTransaction;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Integer getBasic() {
        return basic;
    }

    public void setBasic(Integer basic) {
        this.basic = basic;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getNet() {
        return net;
    }

    public void setNet(Integer net) {
        this.net = net;
    }

    public Integer getBasicGHc() {
        return basicGHc;
    }

    public void setBasicGHc(Integer basicGHc) {
        this.basicGHc = basicGHc;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getAssignmentNo() {
        return assignmentNo;
    }

    public void setAssignmentNo(String assignmentNo) {
        this.assignmentNo = assignmentNo;
    }

    public String getEmployementCategory() {
        return employementCategory;
    }

    public void setEmployementCategory(String employementCategory) {
        this.employementCategory = employementCategory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getSalaryGradeDescription() {
        return salaryGradeDescription;
    }

    public void setSalaryGradeDescription(String salaryGradeDescription) {
        this.salaryGradeDescription = salaryGradeDescription;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public String getOccupationalGroup() {
        return occupationalGroup;
    }

    public void setOccupationalGroup(String occupationalGroup) {
        this.occupationalGroup = occupationalGroup;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getUnionDescription() {
        return unionDescription;
    }

    public void setUnionDescription(String unionDescription) {
        this.unionDescription = unionDescription;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getPayroll() {
        return payroll;
    }

    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }

    public String getPayrollID() {
        return payrollID;
    }

    public void setPayrollID(String payrollID) {
        this.payrollID = payrollID;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public String getAssignmentActionID() {
        return assignmentActionID;
    }

    public void setAssignmentActionID(String assignmentActionID) {
        this.assignmentActionID = assignmentActionID;
    }

    public String getPayrollActionID() {
        return payrollActionID;
    }

    public void setPayrollActionID(String payrollActionID) {
        this.payrollActionID = payrollActionID;
    }

    public String getPayrollActionType() {
        return payrollActionType;
    }

    public void setPayrollActionType(String payrollActionType) {
        this.payrollActionType = payrollActionType;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getLineID() {
        return lineID;
    }

    public void setLineID(Integer lineID) {
        this.lineID = lineID;
    }

    public String getBalanceLoadStatus() {
        return balanceLoadStatus;
    }

    public void setBalanceLoadStatus(String balanceLoadStatus) {
        this.balanceLoadStatus = balanceLoadStatus;
    }

    public String getJobTitleDescription() {
        return jobTitleDescription;
    }

    public void setJobTitleDescription(String jobTitleDescription) {
        this.jobTitleDescription = jobTitleDescription;
    }

    public Integer getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(String assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getParttimeContTraineeEndDate() {
        return parttimeContTraineeEndDate;
    }

    public void setParttimeContTraineeEndDate(String parttimeContTraineeEndDate) {
        this.parttimeContTraineeEndDate = parttimeContTraineeEndDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getManagementUnit() {
        return managementUnit;
    }

    public void setManagementUnit(String managementUnit) {
        this.managementUnit = managementUnit;
    }

    public String getCheckLetter() {
        return checkLetter;
    }

    public void setCheckLetter(String checkLetter) {
        this.checkLetter = checkLetter;
    }

    public Boolean getPosted() {
        return posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public String getPeriodCode() {
        return periodCode;
    }

    public void setPeriodCode(String periodCode) {
        this.periodCode = periodCode;
    }

    public Boolean getModified() {
        return modified;
    }

    public void setModified(Boolean modified) {
        this.modified = modified;
    }

    public String getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(String supervisorID) {
        this.supervisorID = supervisorID;
    }

    public String getNewIPPD3No() {
        return newIPPD3No;
    }

    public void setNewIPPD3No(String newIPPD3No) {
        this.newIPPD3No = newIPPD3No;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSecondment() {
        return secondment;
    }

    public void setSecondment(Boolean secondment) {
        this.secondment = secondment;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getEmployeeRegion() {
        return employeeRegion;
    }

    public void setEmployeeRegion(String employeeRegion) {
        this.employeeRegion = employeeRegion;
    }

    public String getEmployeeDistrict() {
        return employeeDistrict;
    }

    public void setEmployeeDistrict(String employeeDistrict) {
        this.employeeDistrict = employeeDistrict;
    }

    public Integer getNationalID() {
        return nationalID;
    }

    public void setNationalID(Integer nationalID) {
        this.nationalID = nationalID;
    }

    public String getDisabilityDetails() {
        return disabilityDetails;
    }

    public void setDisabilityDetails(String disabilityDetails) {
        this.disabilityDetails = disabilityDetails;
    }

    public String getDisabilityStartDate() {
        return disabilityStartDate;
    }

    public void setDisabilityStartDate(String disabilityStartDate) {
        this.disabilityStartDate = disabilityStartDate;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getNewPensionerID() {
        return newPensionerID;
    }

    public void setNewPensionerID(String newPensionerID) {
        this.newPensionerID = newPensionerID;
    }

    public String getPensionBeneficiaryID() {
        return pensionBeneficiaryID;
    }

    public void setPensionBeneficiaryID(String pensionBeneficiaryID) {
        this.pensionBeneficiaryID = pensionBeneficiaryID;
    }

    public String getPensionStartDate() {
        return pensionStartDate;
    }

    public void setPensionStartDate(String pensionStartDate) {
        this.pensionStartDate = pensionStartDate;
    }

    public String getPensionBenefitType() {
        return pensionBenefitType;
    }

    public void setPensionBenefitType(String pensionBenefitType) {
        this.pensionBenefitType = pensionBenefitType;
    }

    public Boolean getPensioner() {
        return pensioner;
    }

    public void setPensioner(Boolean pensioner) {
        this.pensioner = pensioner;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Integer getInterStartPeriod() {
        return interStartPeriod;
    }

    public void setInterStartPeriod(Integer interStartPeriod) {
        this.interStartPeriod = interStartPeriod;
    }

    public Integer getInterEndPeriod() {
        return interEndPeriod;
    }

    public void setInterEndPeriod(Integer interEndPeriod) {
        this.interEndPeriod = interEndPeriod;
    }

    public Integer getEmploymentPeriod() {
        return employmentPeriod;
    }

    public void setEmploymentPeriod(Integer employmentPeriod) {
        this.employmentPeriod = employmentPeriod;
    }

    public Boolean getInterdicted() {
        return interdicted;
    }

    public void setInterdicted(Boolean interdicted) {
        this.interdicted = interdicted;
    }

    public Boolean getEmpDateProcess() {
        return empDateProcess;
    }

    public void setEmpDateProcess(Boolean empDateProcess) {
        this.empDateProcess = empDateProcess;
    }

    public String getInterEndDate() {
        return interEndDate;
    }

    public void setInterEndDate(String interEndDate) {
        this.interEndDate = interEndDate;
    }

    public Boolean getLeaveEnd() {
        return leaveEnd;
    }

    public void setLeaveEnd(Boolean leaveEnd) {
        this.leaveEnd = leaveEnd;
    }

    public Boolean getUnlocked() {
        return unlocked;
    }

    public void setUnlocked(Boolean unlocked) {
        this.unlocked = unlocked;
    }

    public Boolean getToBeProcessed() {
        return toBeProcessed;
    }

    public void setToBeProcessed(Boolean toBeProcessed) {
        this.toBeProcessed = toBeProcessed;
    }

    public String getInterStartDate() {
        return interStartDate;
    }

    public void setInterStartDate(String interStartDate) {
        this.interStartDate = interStartDate;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Boolean getCommutedPension() {
        return commutedPension;
    }

    public void setCommutedPension(Boolean commutedPension) {
        this.commutedPension = commutedPension;
    }

    public String getDisciplinaryAword() {
        return disciplinaryAword;
    }

    public void setDisciplinaryAword(String disciplinaryAword) {
        this.disciplinaryAword = disciplinaryAword;
    }

    public Boolean getContributeToOldSSF() {
        return contributeToOldSSF;
    }

    public void setContributeToOldSSF(Boolean contributeToOldSSF) {
        this.contributeToOldSSF = contributeToOldSSF;
    }

    public Boolean getFullContribution() {
        return fullContribution;
    }

    public void setFullContribution(Boolean fullContribution) {
        this.fullContribution = fullContribution;
    }

    public Integer getContractMonthlySalary() {
        return contractMonthlySalary;
    }

    public void setContractMonthlySalary(Integer contractMonthlySalary) {
        this.contractMonthlySalary = contractMonthlySalary;
    }

    public String getOccpSocialSecurityNo() {
        return occpSocialSecurityNo;
    }

    public void setOccpSocialSecurityNo(String occpSocialSecurityNo) {
        this.occpSocialSecurityNo = occpSocialSecurityNo;
    }

    public String getSuperanuationContrNo() {
        return superanuationContrNo;
    }

    public void setSuperanuationContrNo(String superanuationContrNo) {
        this.superanuationContrNo = superanuationContrNo;
    }

    public String getDistrictOfBirth() {
        return districtOfBirth;
    }

    public void setDistrictOfBirth(String districtOfBirth) {
        this.districtOfBirth = districtOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getRegionOfBirth() {
        return regionOfBirth;
    }

    public void setRegionOfBirth(String regionOfBirth) {
        this.regionOfBirth = regionOfBirth;
    }

    public Integer getParttimeContractEndPeriod() {
        return parttimeContractEndPeriod;
    }

    public void setParttimeContractEndPeriod(Integer parttimeContractEndPeriod) {
        this.parttimeContractEndPeriod = parttimeContractEndPeriod;
    }

    public String getPensionType() {
        return pensionType;
    }

    public void setPensionType(String pensionType) {
        this.pensionType = pensionType;
    }

    public String getOrganisationGroup() {
        return organisationGroup;
    }

    public void setOrganisationGroup(String organisationGroup) {
        this.organisationGroup = organisationGroup;
    }

    public Boolean getInCogent() {
        return inCogent;
    }

    public void setInCogent(Boolean inCogent) {
        this.inCogent = inCogent;
    }

    public Boolean getEmpNewEmp() {
        return empNewEmp;
    }

    public void setEmpNewEmp(Boolean empNewEmp) {
        this.empNewEmp = empNewEmp;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Boolean getTerminate() {
        return terminate;
    }

    public void setTerminate(Boolean terminate) {
        this.terminate = terminate;
    }

    public String getOrigionalHireDate() {
        return origionalHireDate;
    }

    public void setOrigionalHireDate(String origionalHireDate) {
        this.origionalHireDate = origionalHireDate;
    }

    public Boolean getHv1MonthArrearsAug() {
        return hv1MonthArrearsAug;
    }

    public void setHv1MonthArrearsAug(Boolean hv1MonthArrearsAug) {
        this.hv1MonthArrearsAug = hv1MonthArrearsAug;
    }

    public Boolean getInJoel() {
        return inJoel;
    }

    public void setInJoel(Boolean inJoel) {
        this.inJoel = inJoel;
    }

    public String getNewJobTitle() {
        return newJobTitle;
    }

    public void setNewJobTitle(String newJobTitle) {
        this.newJobTitle = newJobTitle;
    }

    public Boolean getNominee() {
        return nominee;
    }

    public void setNominee(Boolean nominee) {
        this.nominee = nominee;
    }

    public Integer getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(Integer duplicate) {
        this.duplicate = duplicate;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getLinkedToWidow() {
        return linkedToWidow;
    }

    public void setLinkedToWidow(Boolean linkedToWidow) {
        this.linkedToWidow = linkedToWidow;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getGhanaCard() {
        return ghanaCard;
    }

    public void setGhanaCard(String ghanaCard) {
        this.ghanaCard = ghanaCard;
    }

}