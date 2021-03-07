import java.util.List;

public class Student {
	
		private String name;
		private Long year;
		private String program;
		private List<String> courses;
		
		
		
		public Student(String name, Long year, String program, List<String> courses) {
			super();
			this.name = name;
			this.year = year;
			this.program = program;
			this.courses = courses;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getYear() {
			return year;
		}
		public void setYear(Long year) {
			this.year = year;
		}
		public String getProgram() {
			return program;
		}
		public void setProgram(String program) {
			this.program = program;
		}
		public List<String> getCourses() {
			return courses;
		}
		public void setCourses(List<String> courses) {
			this.courses = courses;
		}
		
		@Override
		public String toString() {
			String show = name + " " + year + " " + program + "\n";
			for (String string : courses) {
				show += string +"\n";
			}
			return show;
		}
	
}
