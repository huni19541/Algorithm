import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
	private static class Course{
		private String subject;
		private double credit;
		private String grade;
		
		public Course(String subject, double credit, String grade){
			this.subject = subject;
			this.credit = credit;
			this.grade = grade;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Course[] courses = new Course[20];
		double sumCredit = 0.0;
		double sumGrade = 0.0;
		for(int i=0; i<20; i++) {
			String temp = br.readLine();
			String[] arr = temp.split(" ");
			courses[i] = new Course(arr[0], Double.parseDouble(arr[1]), arr[2]);
			
			if(courses[i].grade.equals("P")) continue;
			
			sumCredit += courses[i].credit;
			
			sumGrade += courses[i].credit * getGrade(courses[i].grade);
			
		}
		System.out.println(sumGrade / sumCredit);

	}
	
	public static double getGrade(String s) {
		double grade = 0.0;
		if(s.equals("A+")) grade = 4.5;
		else if(s.equals("A0")) grade = 4.0;
		else if(s.equals("B+")) grade = 3.5;
		else if(s.equals("B0")) grade = 3.0;
		else if(s.equals("C+")) grade = 2.5;
		else if(s.equals("C0")) grade = 2.0;
		else if(s.equals("D+")) grade = 1.5;
		else if(s.equals("D0")) grade = 1.0;
		
		return grade;
	}

}
