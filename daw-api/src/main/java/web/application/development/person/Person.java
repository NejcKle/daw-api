package web.application.development.person;

import java.net.URI;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.sebastian_daschner.siren4javaee.*;

@Entity 
public class Person{

	@Id	//primary key
	private String id;
	private String user_type;
	private String name;
	private String email;
	private String number;
	
	public Person(String id, String user_type, String name, String email, String number) {
		super();
		this.id = id;
		this.user_type = user_type;
		this.name = name;
		this.email = email;
		this.number = number;
	}
	
	public Person() {
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return user_type;
	}

	public void setType(String type) {
		this.user_type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}