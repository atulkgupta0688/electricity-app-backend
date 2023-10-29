package demobcgeb.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demobcgeb.models.applicant;
import demobcgeb.service.ebService;


@RestController
@CrossOrigin
@RequestMapping("/details")
public class ebController {
	
	@Autowired
	ebService ebServices;
	
	Logger log=LoggerFactory.getLogger(ebController.class);

	@GetMapping("/{id}")
	public ResponseEntity<?> getApplicantDetails(@PathVariable("id") int  id){
		try {
		List<applicant> appplicantInfo=ebServices.getApplicantDetails(id);
        // If everything is successful, return a success response
		return ResponseEntity.ok(appplicantInfo.get(0));
		} catch(Exception e) {
            // Handle the exception and return an internal server error response
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
		}
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<?> getAllApplicantDetails(){
		try {
         // If everything is successful, return a success response
		List<applicant> applicantInfo=ebServices.getAllApplicantDetails();
		return ResponseEntity.ok(applicantInfo);
		} catch(Exception e) {
            // Handle the exception and return an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
		}
		
	}
	
	@PostMapping("/addDetails")
	public ResponseEntity<?> postApplicantDetails(@RequestBody applicant applicantDetails){
		try {
         // If everything is successful, return a success response
		applicant applicantInfo=ebServices.postApplicantDetails(applicantDetails);
		return ResponseEntity.ok(applicantInfo);
		} catch(Exception e) {
            // Handle the exception and return an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
		}	
	}
	
	@PutMapping("/updateDetails")
	public ResponseEntity<?> updateApplicantDetails( @RequestBody applicant applicantDetails){
		try {
         // If everything is successful, return a success response
		applicant applicantInfo=ebServices.updateApplicantDetails(applicantDetails);
		return ResponseEntity.ok(applicantInfo);
		} catch(Exception e) {
            // Handle the exception and return an internal server error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
		}	
	}
	
	@GetMapping("/getChartDetails/{status}")
	public ResponseEntity<?> getApplicantDetails(@PathVariable("status") String  status){
		try {
        // If everything is successful, return a success response
		return ResponseEntity.ok(ebServices.getChartData(status));
		} catch(Exception e) {
            // Handle the exception and return an internal server error response
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
		}
	}
}
 