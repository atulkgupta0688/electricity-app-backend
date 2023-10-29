package demobcgeb.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection="applicant_info")
public class applicant {
		@Id
		public ObjectId id;
	    public int ID;
	    public String Applicant_Name;
	    @Field("Gender") 
	    public String gender;
	    @Field("District") 
	    public String district;
	    @Field("State") 
	    public String state;
	    @Field("Pincode") 
	    public int pincode;
	    @Field("Ownership") 
	    public String ownership;
	    @Field("GovtID_Type") 
	    public String govtID_Type;
	    @Field("ID_Number") 
	    public Long iD_Number;
	    @Field("Category") 
	    public String category;
	    @Field("Load_Applied (in KV)") 
	    public int load_Applied;
	    @Field("Date_of_Application") 
	    public String date_of_Application;
	    @Field("Date_of_Approval") 
	    public String date_of_Approval;
	    public String getDate_of_Approval() {
			return date_of_Approval;
		}
		public void setDate_of_Approval(String date_of_Approval) {
			this.date_of_Approval = date_of_Approval;
		}
		@Field("Modified_Date") 
	    public String modified_Date;
	    @Field("Status") 
	    public String status;
	    @Field("Reviewer_ID") 
	    public Long reviewer_ID;
	    @Field("Reviewer_Name") 
	    public String reviewer_Name;
	    @Field("Reviewer_Comments") 
	    public String reviewer_Comments;
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public String getApplicant_Name() {
			return Applicant_Name;
		}
		public void setApplicant_Name(String applicant_Name) {
			Applicant_Name = applicant_Name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}
		public String getOwnership() {
			return ownership;
		}
		public void setOwnership(String ownership) {
			this.ownership = ownership;
		}
		public String getGovtID_Type() {
			return govtID_Type;
		}
		public void setGovtID_Type(String govtID_Type) {
			this.govtID_Type = govtID_Type;
		}
		public Long getiD_Number() {
			return iD_Number;
		}
		public void setiD_Number(Long iD_Number) {
			this.iD_Number = iD_Number;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public int getLoad_Applied() {
			return load_Applied;
		}
		public void setLoad_Applied(int load_Applied) {
			this.load_Applied = load_Applied;
		}
		public String getDate_of_Application() {
			return date_of_Application;
		}
		public void setDate_of_Application(String date_of_Application) {
			this.date_of_Application = date_of_Application;
		}
		public String getModified_Date() {
			return modified_Date;
		}
		public void setModified_Date(String modified_Date) {
			this.modified_Date = modified_Date;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Long getReviewer_ID() {
			return reviewer_ID;
		}
		public void setReviewer_ID(Long reviewer_ID) {
			this.reviewer_ID = reviewer_ID;
		}
		public String getReviewer_Name() {
			return reviewer_Name;
		}
		public void setReviewer_Name(String reviewer_Name) {
			this.reviewer_Name = reviewer_Name;
		}
		public String getReviewer_Comments() {
			return reviewer_Comments;
		}
		public void setReviewer_Comments(String reviewer_Comments) {
			this.reviewer_Comments = reviewer_Comments;
		}
}
