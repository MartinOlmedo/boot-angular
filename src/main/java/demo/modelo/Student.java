package demo.modelo;

import java.util.Date;

public class Student {
	private Long id;
    private String name;
    private String subject;
 
    public Student() {
    }
 
    public Student(Long id, String name, String subject) {
    	if( id != null )
    		this. id= id;
    	else{
    		String  str_lng= String.valueOf( (new Date()).getTime() );
    		Long lng = Long.valueOf(  str_lng.substring( str_lng.length()-7 )  );
    		this.id = lng;
    	}
    
        
        this.name = name;
        this.subject = subject;
    }
    
 
//    GETTERS AND SETTERS
 
    public Long getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getSubject() {
        return subject;
    }
 
    public void setSubject(String subject) {
        this.subject = subject;
    }
 
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
