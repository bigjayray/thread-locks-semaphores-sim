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

//a thread class to simulate a lecturer
public class Lecturer extends Thread {

  //class variables
  private final ClassRoom classRoom1;
  private final ClassRoom classRoom2;
  private final ClassRoom classRoom3;
  private final ClassRoom classRoom4;
  private final String lecturerName;

  //constructor
  public Lecturer(ClassRoom classRoom1, ClassRoom classRoom2, ClassRoom classRoom3, ClassRoom classRoom4, String lecturerName) {
    this.classRoom1 = classRoom1;
    this.classRoom2 = classRoom2;
    this.classRoom3 = classRoom3;
    this.classRoom4 = classRoom4;
    this.lecturerName = lecturerName;
  }

  //run method with thread logic
  public void run() {

    //class variable
    ClassRoom classRoom;

    //an infinite loop to simulate student entering different classes
    while (true) {

      //to generate a random integer
      int randomNum = 1 + (int)(Math.random() * ((4 - 1) + 1));

      //condition to determine which class to enter
      if (randomNum == 1) {
        classRoom = classRoom1;
      } else if (randomNum == 2) {
        classRoom = classRoom2;
      } else if (randomNum == 3) {
        classRoom = classRoom3;
      } else {
        classRoom = classRoom4;
      }

      //thread enters class
      classRoom.enter(this);

      //thread sleeps to permit more threads to enter before starting lecture
      try {
        sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      //thread starts lecture
      classRoom.startLecture();

      //thread sleeps before attempting to leave
      try {
        sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      //thread leaves class
      classRoom.leave(this);

    }

  }

  //a method to return the name of the lecturer
  public String getLecturerName() {
    return lecturerName;
  }

}
