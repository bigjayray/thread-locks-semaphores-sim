//imports
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

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

//class to simulate a classroom
public class ClassRoom {

  //class variables
  private final String className;
  //integers to keep count of threads in class
  private final AtomicInteger sSitting = new AtomicInteger(0);
  private final AtomicInteger nStudents = new AtomicInteger(0);
  private final AtomicInteger nVisitors = new AtomicInteger(0);
  //semaphores to control thread access
  private final Semaphore classControl;
  private final Semaphore vControl  = new Semaphore(5);
  private final Semaphore lControl = new Semaphore(1);
  private boolean inSession = false;
  private String lecturerName = null;
  private boolean lectureIn = false;
  private final Object lock = new Object();

  //constructor
  public ClassRoom(String className, int capacity) {
    this.className = className;
    this.classControl = new Semaphore(capacity);
  }

  //a method to simulate entering the class
  public void enter(Object o) {

      if (o instanceof Student) {
        try {
          classControl.acquire();
          synchronized (lock) {
            while (lectureIn) {
              lock.wait();
            }
          }
          nStudents.incrementAndGet();
        } catch (InterruptedException ignored) {
        }
      }

      if (o instanceof Visitor) {
        try {
          classControl.acquire();
          vControl.acquire();
          synchronized (lock) {
            while (lectureIn) {
              lock.wait();
            }
          }
          nVisitors.incrementAndGet();
        } catch (InterruptedException ignored) {
        }
      }

      if (o instanceof Lecturer) {
        try {
          lControl.acquire();
          lectureIn = true;
          lecturerName = ((Lecturer) o).getLecturerName();
        } catch (InterruptedException ignored) {
        }
      }

  }

  //a method to simulate leaving the class
  public void leave(Object o){

    if (o instanceof Student) {
      synchronized (lock) {
        if (lectureIn) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

        }
      }
      nStudents.decrementAndGet();
      sSitting.decrementAndGet();
      classControl.release();
    }

    if (o instanceof Visitor) {
      nVisitors.decrementAndGet();
      vControl.release();
      classControl.release();
    }

    if (o instanceof Lecturer) {
      lecturerName = null;
      this.lectureIn = false;
      this.inSession = false;
      synchronized (lock) {
        lock.notifyAll();
      }
      lControl.release();
    }

  }

  //a method to simulate sitting in the class
  public void sitDown(Object o) {
    if (o instanceof Student) {
      sSitting.incrementAndGet();
    }
  }

  //a method to simulate starting a lecture by a lecturer in the class
  public void startLecture() {
    if (nStudents.intValue() > 0 && sSitting.intValue() == nStudents.intValue()) {
        this.inSession = true;
    }
  }

  //a method to return state of the class
  public boolean isInSession() {
    return inSession;
  }

  //a method to return name of the class
  public String getClassName() {
    return className;
  }

  //a method to return number of students in the class
  public AtomicInteger getnStudents() {
    return nStudents;
  }

  //a method to return number of visitors in the class
  public AtomicInteger getnVisitors() {
    return nVisitors;
  }

  //a method to return the name of the lecturer in the class
  public String getLecturerName() {
    return lecturerName;
  }
}
