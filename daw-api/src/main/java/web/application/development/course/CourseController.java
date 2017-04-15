package web.application.development.course;

import java.util.List;

import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sebastian_daschner.siren4javaee.Entity;
import com.sebastian_daschner.siren4javaee.EntityReader;
import com.sebastian_daschner.siren4javaee.Siren;

import web.application.development.formatter.Formatter;

@RestController
public class CourseController {
	
	@Autowired //marks this as something that needs dependency injection, injects existing topicService
	private CourseService courseService;
	@Autowired
	private Formatter formatter;
	
	@RequestMapping(value="/courses", method=RequestMethod.GET) //maps URL /courses to method getAllCourses
	public ResponseEntity<Entity> getAllCourses() {
		JsonObject object = formatter.ReturnJSON(courseService.getAllCourses(), new Course());
		EntityReader entityReader = Siren.createEntityReader();
		Entity entity = entityReader.read(object);
		return new ResponseEntity<Entity>(entity, HttpStatus.OK);
	}
	
	@RequestMapping(value="/courses/{id}", method=RequestMethod.GET)
	public HttpEntity<Entity> getCourse(@PathVariable String id) {
		Course course = courseService.getCourse(id);
		JsonObject object = formatter.ReturnJSON(course);
		EntityReader entityReader = Siren.createEntityReader();
		Entity entity = entityReader.read(object);
		return new ResponseEntity<Entity>(entity, HttpStatus.OK);
	}
	
	@RequestMapping(value="/courses", method=RequestMethod.POST)
	public void addCourse(@RequestBody Course course) { //@RequestBody tells spring that the request pay load is going to contain a user
		courseService.addCourse(course);
	}
	
	@RequestMapping(value="/courses/{id}", method=RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course, @PathVariable String id) { //@RequestBody tells spring that the request pay load is going to contain a user
		courseService.updateCourse(id, course);
	}
	
	@RequestMapping(value="/courses/{id}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
	/*@RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.GET) //maps URL /topics to method getAllTopics
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCourses();
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.GET) //{} tells spring the containing part is a variable
	public Course getCourse(@PathVariable String courseId) { //annotation that maps {id} to String id
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.POST)
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) { //@RequestBody tells spring that the request pay load is going to contain a course
		course.setTopic(new Topic(topicId, "","", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course, @PathVariable String courseId, @PathVariable String topicId) { //@RequestBody tells spring that the request pay load is going to contain a topics
		course.setTopic(new Topic(topicId, "","", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String courseId) {
		courseService.deleteCourse(courseId);
	} */
}
