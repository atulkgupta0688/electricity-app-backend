package demobcgeb.service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demobcgeb.controller.ebController;
import demobcgeb.models.applicant;
import demobcgeb.repo.applicantRepository;

@Service
public class ebService{
	
	@Autowired
	private applicantRepository appRepo ;
	
	Logger log=LoggerFactory.getLogger(ebService.class);

	public List<applicant> getApplicantDetails(int id) {
		//Find details of particular Applicant based on ID field
		return appRepo.findByID(id);
	}
	
	public Map<String, Integer> getChartData(String status) {
		//Get Chart Data
		Map<String, Integer> monthCounts = new HashMap<>();
		monthCounts.put("January", 0);
        monthCounts.put("February", 0);
        monthCounts.put("March", 0);
        monthCounts.put("April", 0);
        monthCounts.put("May", 0);
        monthCounts.put("June", 0);
        monthCounts.put("July", 0);
        monthCounts.put("August", 0);
        monthCounts.put("September", 0);
        monthCounts.put("October", 0);
        monthCounts.put("November", 0);
        monthCounts.put("December", 0);
		List<applicant> applicants=getAllApplicantDetails();
		List<applicant> filteredApplicants = new ArrayList<>();
		for (applicant app: applicants) {
			if (app.getStatus().equals(status)) {
	            filteredApplicants.add(app);
	        }
		}
		for(applicant app2: filteredApplicants) {
			String monthName = getMonth(app2.getDate_of_Application());
            if (monthCounts.containsKey(monthName)) {
                monthCounts.put(monthName, monthCounts.get(monthName) + 1);
            }
		}
		return monthCounts;
	}
	
	public String getMonth(String S) {
	    // Split the date string using a hyphen
	    String[] dateParts = S.split("-");
	    String[] monthNames = {
	            "Invalid", "January", "February", "March", "April", "May", "June",
	            "July", "August", "September", "October", "November", "December"
	        };
	    // Assuming the parts are in the order day, month, year
	    int day = Integer.parseInt(dateParts[0]);
	    int month = Integer.parseInt(dateParts[1]);
	    int year = Integer.parseInt(dateParts[2]);

	    return monthNames[month];
	}
	
	
	
	public List<applicant> getAllApplicantDetails() {
		//Return information of all users
		return appRepo.findAll();
	}
	
	public applicant postApplicantDetails(applicant detail) {
		int lastID = getLastApplicantID();
		detail.setID(lastID);
		log.info("Payload{}",detail);
		//Return information of all users
		return appRepo.save(detail);
	}
	
	public applicant updateApplicantDetails(applicant detail) {
		 
		applicant existingApplicant = appRepo.findByID(detail.getID()).get(0);
		log.info("Existing Applicant:::{}", existingApplicant.getState());
		if(existingApplicant != null) {
		log.info("GOING INSIDE");
		if (detail.getStatus() != null) {
            existingApplicant.setStatus(detail.getStatus());
        }

        if (detail.getReviewer_Comments() != null) {
            existingApplicant.setReviewer_Comments(detail.getReviewer_Comments());
        }
        if (detail.getApplicant_Name() != null) {
            existingApplicant.setApplicant_Name(detail.getApplicant_Name());
        }
        if (detail.getGender() != null) {
            existingApplicant.setGender(detail.getGender());
        }
        if (detail.getDistrict() != null) {
            existingApplicant.setDistrict(detail.getDistrict());
        }
        if (detail.getState() != null) {
            existingApplicant.setState(detail.getState());
        }
        if (detail.getPincode() != 0) {
            existingApplicant.setPincode(detail.getPincode());
        }
        if (detail.getOwnership() != null) {
            existingApplicant.setOwnership(detail.getOwnership());
        }
        if (detail.getiD_Number() != null) {
            existingApplicant.setiD_Number(detail.getiD_Number());
        }
        if (detail.getCategory() != null) {
            existingApplicant.setCategory(detail.getCategory());
        }
        if (detail.getLoad_Applied() != 0) {
            existingApplicant.setLoad_Applied(detail.getLoad_Applied());
        }
        if (detail.getDate_of_Application() != null) {
            existingApplicant.setDate_of_Application(detail.getDate_of_Application());
        }
        if (detail.getModified_Date() != null) {
            existingApplicant.setModified_Date(detail.getModified_Date());
        }
        if (detail.getReviewer_ID() != null) {
            existingApplicant.setReviewer_ID(detail.getReviewer_ID());
        }
        if (detail.getReviewer_Name() != null) {
            existingApplicant.setReviewer_Name(detail.getReviewer_Name());
        }
        if (detail.getReviewer_Comments() != null) {
            existingApplicant.setReviewer_Comments(detail.getReviewer_Comments());
        }
        if(detail.getDate_of_Approval()!= null) {
        	existingApplicant.setDate_of_Approval(detail.getDate_of_Approval());
        }
        log.info("SET STATE:::{}", existingApplicant.getState());
        // Save Updated details of user
      	return appRepo.save(existingApplicant);
		}
		throw new NullPointerException("The value is null");
	}
	
	public int getLastApplicantID() {
        List<applicant> applicants = appRepo.findAll();
        if (!applicants.isEmpty()) {
            applicants.sort(Comparator.comparingInt(applicant::getID).reversed());
            return applicants.get(0).getID()+1;
        }
        return 0; // Default value if no applicants exist
    }

}
