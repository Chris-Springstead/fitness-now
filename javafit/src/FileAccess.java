// Write code to load the workouts from the provided workouts.csv file. The function should return a Workouts object.
import java.io.*;

public class FileAccess {
	public static Workouts loadWorkouts() {
	  Workouts inFile = new Workouts();
    // What is a try/catch block and why do we need one?
    // What is an exception?
	  
	  String file = Config.WORKOUTFILE;
	  String line = "";
	  
	  try (BufferedReader br = new BufferedReader(new FileReader(file))) { 
	    
	    
	    while ((line = br.readLine()) != null) {
	      
	      String[] temp = line.split(",");
	      inFile.addWorkout(temp[0], Workouts.Equipment.valueOf(temp[1]), Workouts.Muscle.valueOf(temp[2]),Workouts.Muscle.valueOf(temp[3]), temp[4], temp[5]);
	    }
	    
	  }
	  catch (FileNotFoundException e) {
	    e.printStackTrace();
	  }
	  catch (IOException e) {
	    e.printStackTrace();
	  }
	  return inFile;
  }
}
