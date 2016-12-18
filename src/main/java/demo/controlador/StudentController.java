package demo.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.HelloGootApplication;
import demo.modelo.Student;

@RestController
@RequestMapping(value="/rest/student")
public class StudentController {

	// getAll
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Student> getAllStudents(){
		return HelloGootApplication.hmStudent;
	}
	
	// add Student
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Student addStudent( @RequestBody Student _student ){
		
		if( !"".equals(_student.getName()) && !"".equals(_student.getSubject()) ){
			Student st = new Student(null, _student.getName() , _student.getSubject()); 
			HelloGootApplication.hmStudent.add( st );
			
			return st;
		}
		
		return null;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public Student updateStudent( @RequestBody Student _student ) throws Exception{
		Student st = HelloGootApplication.getStudentById(_student.getId() ) ;
		if( st != null ){
			if( !"".equals(_student.getName()) && !"".equals(_student.getSubject()) ){
				HelloGootApplication.removeStudentById( st.getId() );
				Student stAfterUPdate = HelloGootApplication.addStudentToList( new Student(st.getId(), _student.getName() , _student.getSubject())  );
				return stAfterUPdate;
			}
			
		}else{
			throw new Exception("NO existe el estudiante que intentas actualizar");
		}
		
		return null;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public boolean deleteStudent(@PathVariable Long id)throws Exception{
		Student st = HelloGootApplication.getStudentById( id ) ;
		if( st != null ){
			HelloGootApplication.removeStudentById( st.getId() );
			return true;
		}else{
			throw new Exception("NO existe el estudiante que intentas borrar");
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Student getStudentById(@PathVariable Long id)throws Exception{
		Student st = HelloGootApplication.getStudentById( id ) ;
		if( st != null ){
			return st;
		}else{
			throw new Exception("NO existe el estudiante que intentas consultar");
		}
	}
	
	@RequestMapping(value="/getSubjects", method=RequestMethod.GET)
	public Map<Integer,String> getSubjects(){
		return HelloGootApplication.subjects;
		
	}
}
