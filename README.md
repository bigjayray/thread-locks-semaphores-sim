# thread-locks-semaphores-sim

This project simulates threads, locks and semaphores.
This project was submitted as my solution for my Parallel and Distributed Programming course work.

- There are four kinds of threads: students, visitors, monitor and a one Lecturer per classroom. 
- Students must wait to enter classroom if class is running, enter, and then sitDown. 
- At some point, the Lecturer enters the classroom. 
- When the Lecturer is in the classroom, no one may enter, and the students may not leave. 
- Visitors may leave. 
- Once all students check in, the Lecturer can StartLecture. 
- After some time, the Lecturer leaves and all students can leave.

## Getting Started

### Installing Dependencies

#### Java 

Follow instructions to install the latest version of java for your platform in the [java docs](https://www.java.com/en/download/l)

#### My Environment

- java version "15.0.1" 2021-10-20
- Java(TM) SE Runtime Environment (build 15.0.1+9-18)
- Java HotSpot(TM) 64-Bit Server VM (build 15.0.1+9-18, mixed mode, sharing)
- IntelliJ IDEA 


## Running the application

#### Using JAR 
- Open a command prompt or terminal window
- Navigate to source directory out/artifacts/thread_locks_semaphores_sim
- To run the application, execute:

```bash
java -jar thread-locks-semaphores-sim.jar
```


## Side Notes

- student threads invoke enter, sitDown, and leave methods.
- The Lecturer thread invokes enter, startLecture and leave methods.
- visitor threads invoke enter, sitDown and leave method.
- While the Lecturer thread is in the classroom, no one may enter and student threads cannot not leave.
- The Lecturer thread cannot call startLecture method until all student threads who have entered have also called the sitDown method.
- At any point of time any classroom may have only one lecturer thread.
- Classroom capacity should not exceed limit. 
- Visitor threads are always low in count (less than 5).
- A monitor thread keep printing the status of each classroom
