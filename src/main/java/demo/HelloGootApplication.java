package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import demo.modelo.Student;

@SpringBootApplication

@Configuration
@EnableAutoConfiguration
@ComponentScan("demo")
public class HelloGootApplication {
	
	public static List<Student> hmStudent;
	public static Map<Integer, String> subjects;
	
	static{
		hmStudent =  new ArrayList<Student>(); 
		subjects = new HashMap<Integer, String>();
		
		subjects.put(1, "matematicas");
		subjects.put(2, "geografia");
		subjects.put(3, "historia");
		subjects.put(4, "filosofia");
		subjects.put(5, "ingles");
		
		for( int i = 1; i<=5; i++ ){
			hmStudent.add( new Student(null, "Estudiante_"+i, subjects.get(i)) );
			try {Thread.sleep(5);} catch (InterruptedException e) {}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloGootApplication.class, args);
	}
	
	public static Student getStudentById(Long id){
		for (Student student : hmStudent) {
			if( student.getId().longValue() == id.longValue() )
				return student;
		}
		return null;
	}
	
	public static boolean removeStudentById(Long id){
		for( int i= 0; i<hmStudent.size(); i++ ){
			if( hmStudent.get(i).getId().longValue() == id.longValue() ){
				hmStudent.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public static Student addStudentToList(Student st){
		if(hmStudent.add(st)){
			return st;
		}
		return null;
		
	}
	
	
}
