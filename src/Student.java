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

//a thread class to simulate a student
public class Student extends Thread {

  //class variables
  private final ClassRoom classRoom1;
  private final ClassRoom classRoom2;
  private final ClassRoom classRoom3;
  private final ClassRoom classRoom4;

  //constructor
  public Student(ClassRoom classRoom1, ClassRoom classRoom2, ClassRoom classRoom3, ClassRoom classRoom4) {
    this.classRoom1 = classRoom1;
    this.classRoom2 = classRoom2;
    this.classRoom3 = classRoom3;
    this.classRoom4 = classRoom4;
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

      //thread sleeps to permit more threads to enter before sitting
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      //thread sits in class
      classRoom.sitDown(this);

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

}
