package demobcgeb.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import demobcgeb.models.applicant;

public interface applicantRepository extends MongoRepository<applicant, String>{
	
	List<applicant> findByID(int ID);

}
