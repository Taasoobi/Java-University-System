
public class Faculty extends Person {
	String[] courses;
	Faculty(String fn, String ln, int mb, int db, int yb, String[] newCourse){
		super(fn,ln,mb,db,yb);
		courses = newCourse;
	}

}