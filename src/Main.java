/**
 *
 *
 * Jeremiah Idoko
 *
 * thread-locks-semaphores-sim
 *
 * simulation of a college and classrooms
 *
 */

//main class
public class Main {

  //main method
  public static void main(String[] args) {

    //prints the table header
    System.out.println("=========================================================================");
    System.out.printf("%-15s  %-15s %-15s  %-15s %s \n", "Classroom", "Lecturer","inSession","Students","Visitor");
    System.out.println("=========================================================================");


    //creates classroom objects
    ClassRoom w201 = new ClassRoom("W201", 60);
    ClassRoom w202 = new ClassRoom("W202", 60);
    ClassRoom w101 = new ClassRoom("W101", 20);
    ClassRoom js101 = new ClassRoom("JS101", 30);

    //creates an array of student threads
    Student[] students = new Student[150];

    //populates the students array and starts threads
    for (int i = 0; i < students.length; i++) {
      students[i] = new Student(w201, w202, w101, js101);
      students[i].start();
    }

    //creates an array of visitor threads
    Visitor[] visitors = new Visitor[30];

    //populates the visitors array and starts threads
    for (int i = 0; i < visitors.length; i++) {
      visitors[i] = new Visitor(w201, w202, w101, js101);
      visitors[i].start();
    }

    //creates lecturer threads
    Thread osama = new Lecturer(w201, w202, w101, js101, "Osama");
    Thread barry = new Lecturer(w101, js101, w201, w202, "Barry");
    Thread faheem = new Lecturer(w202, w202, js101, w201, "Faheem");
    Thread alex = new Lecturer(w201, w202, w101, js101, "Alex");
    Thread aqeel = new Lecturer(w101, js101, w201, w202, "Aqeel");
    Thread waseem = new Lecturer(w202, w202, js101, w201, "Waseem");

    //starts lecturer threads
    osama.start();barry.start();faheem.start();alex.start();aqeel.start();waseem.start();

    //creates monitor thread
    Thread monitor = new Monitor(w201, w202, w101, js101);

    //starts monitor thread
    monitor.start();

  }

}
