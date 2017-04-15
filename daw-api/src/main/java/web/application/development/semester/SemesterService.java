package web.application.development.semester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemesterService {
	
	@Autowired //injects instance of semesterRepository
	private SemesterRepository semesterRepository;

	public List<Semester> getAllSemesters() {
		List<Semester> semesters = new ArrayList<>();
		semesterRepository.findAll().forEach(semesters::add);
		return semesters;
	}
	
	public Semester getSemester(String semesterId) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return semesterRepository.findOne(semesterId);
	}

	public void addSemester(Semester semester) {
		semesterRepository.save(semester);
	}
	
	public void updateSemester(String id, Semester semester) {
		semesterRepository.save(semester);
	}

	public void deleteSemester(String id) {
		semesterRepository.delete(id);
	}
}
