package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.modelo.Student;
import demo.modelo.Subject;

@SpringBootApplication
public class HelloGootApplication {
	
	public static List<Student> hmStudent;
	public static List<Subject> subjects;
	
	static{
		hmStudent =  new ArrayList<Student>(); 
		subjects = new ArrayList<Subject>(); 
		
		subjects.add( new Subject( "11", "matematicas" ) );
		subjects.add( new Subject("22", "geografia") );
		subjects.add( new Subject("33", "historia") );
		subjects.add( new Subject( "44", "filosofia" ) );
		subjects.add( new Subject("55", "ingles"));
		
		for( int i = 1; i<=5; i++ ){
			hmStudent.add( new Student(null, "Estudiante_"+i, subjects.get(i-1).getName()) );
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
