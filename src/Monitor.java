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

//a thread class to monitor the class
public class Monitor extends Thread {

  //class variables
  private final ClassRoom classRoom1;
  private final ClassRoom classRoom2;
  private final ClassRoom classRoom3;
  private final ClassRoom classRoom4;

  //constructor
  public Monitor(ClassRoom classRoom1, ClassRoom classRoom2, ClassRoom classRoom3, ClassRoom classRoom4) {
    this.classRoom1 = classRoom1;
    this.classRoom2 = classRoom2;
    this.classRoom3 = classRoom3;
    this.classRoom4 = classRoom4;
  }

  public void run() {

    //run method with thread logic
    while (true) {

      //print the state of the class
      System.out.printf("%-15s  %-15s %-15s  %-15s %s \n", classRoom1.getClassName(),
          classRoom1.getLecturerName(),
          classRoom1.isInSession(), classRoom1.getnStudents(), classRoom1.getnVisitors());

      System.out.printf("%-15s  %-15s %-15s  %-15s %s \n", classRoom2.getClassName(),
          classRoom2.getLecturerName(),
          classRoom2.isInSession(), classRoom2.getnStudents(), classRoom2.getnVisitors());

      System.out.printf("%-15s  %-15s %-15s  %-15s %s \n", classRoom3.getClassName(),
          classRoom3.getLecturerName(),
          classRoom3.isInSession(), classRoom3.getnStudents(), classRoom3.getnVisitors());

      System.out.printf("%-15s  %-15s %-15s  %-15s %s \n", classRoom4.getClassName(),
          classRoom4.getLecturerName(),
          classRoom4.isInSession(), classRoom4.getnStudents(), classRoom4.getnVisitors());

      //prints an empty line
      System.out.println();

      //thread sleeps for 2 seconds
      try {
        sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
