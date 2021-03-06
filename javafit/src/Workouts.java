import java.util.ArrayList; // We choose ArrayList over Vector because...? 
/**
* Use the provided enumerations and code framework to create our workouts class.
* This class should contain all the functionality we need to interact with our workout list.
* Minimize duplication of code by writing helper functions as needed.
* 
* Do not change any of the provided code, although you can, and should, add to it as needed. 
* (E.G. Do not make private attributes public, or change the parameters of a function.)
*/

public class Workouts {

  // Use the Refactor functionality in Eclipse to rename "muscle" to "Muscle" to match our naming convention.
  public enum Muscle {ABS, BACK, BICEPS, CHEST, FOREARM, GLUTES, LOWERLEG, SHOULDER, TRICEPS, UPPERLEG, NONE} // Why didn't I have to declare this static?
  public enum Equipment {BARBELL, BODYWEIGHT, DUMBBELL, CABLE, HAMMERSTRENGTH}
  private final ArrayList<Workout> workoutList = new ArrayList<Workout>();

	// This is a nested class, also known as an inner class. Why do we use a nested class?
	// You will need to create a number of methods for the inner class. You are not limited to 
	// only the methods listed inside this class.
	private class Workout {
		private String name;
		private Equipment equipment;
		private Muscle primaryMuscle;
		private Muscle secondaryMuscle;
		private String desc;
		private String reminders;
	
		Workout(String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders) {
		  // constructor that initializes the values in the class to the corresponding arguments passed into the constructor
		  this.name = name;
		  this.equipment = equipment;
		  this.primaryMuscle = primaryMuscle;
		  this.secondaryMuscle = secondaryMuscle;
		  this.desc = desc;
		  this.reminders = reminders;
		}
		
		// How do we get the name of an enumeration value?
		
		public String[] toStringArray() {
		  // makes a string array that contains information for a workout at a specific index of the workoutList
		  String[] temp = new String[6];
		  temp[0] = this.name;
		  temp[1] = this.equipment.toString();
		  temp[2] = this.primaryMuscle.toString();
		  temp[3] = this.secondaryMuscle.toString();
		  temp[4] = this.desc;
		  temp[5] = this.reminders;
		  return temp;
		}
		
	}
	
	
  // This function adds a new workout to the Workouts object.
  public final void addWorkout(String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders) {
    // creates new instance of a Workout class
    Workout newWorkout = new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
    // adds new instance to the workout list
    workoutList.add(newWorkout);
  }
  
  // This function adds a workout to the Workouts object.
  public final void addWorkout(Workout workout) {
    workoutList.add(workout);
  }
  
  // This list returns a new Workouts object that contains only the workouts that contain the
  // Equipment value that is provided as an argument. The programmer has an option to get
  // Workouts that only have the Muscle in the PrimaryMuscle attribute, or to also look
  // in the secondaryMuscle category.
  public final Workouts getWorkoutsByMuscle(Muscle m, boolean includeSecondary) {
	  // What is short-circuit evaluation?
    Workouts canWorkout = new Workouts();
    for (int i = 0; i < workoutList.size(); i++) {
      if (m == workoutList.get(i).primaryMuscle) {
        canWorkout.addWorkout(workoutList.get(i));
      }
      else if (includeSecondary) {
        if (m == workoutList.get(i).secondaryMuscle) {
          canWorkout.addWorkout(workoutList.get(i));
        }
      }
    }
    return canWorkout;
  }
	
	// This list returns a new Workouts object that contains only the workouts that contain the
	// Equipment value that is provided as an argument.
  public final Workouts getWorkoutsByEquipment(Equipment e) {
    Workouts doableWorkouts = new Workouts();
    for (int i = 0; i < workoutList.size(); i++) {
      if (e == workoutList.get(i).equipment) {
        doableWorkouts.addWorkout(workoutList.get(i));
      }
    }
    return doableWorkouts;
  }
	
  // This returns a new Workouts object that contains only the workouts that contain an Equipment
  // value that is in the provided ArrayList of Equipment.
  public final Workouts getWorkoutsByEquipment(ArrayList<Equipment> e) {
    // making new ArrayList to hold data
    Workouts equipWorkouts = new Workouts(); 
    
    // nested loops to compare all the elements in both of the lists
    for (int i = 0; i < workoutList.size(); i++) {
       for (int j = 0; j < e.size(); j++) {
         if (e.get(j) == workoutList.get(i).equipment) {
           equipWorkouts.addWorkout(workoutList.get(i));
         }
       }
     }
    return equipWorkouts;
  }
	
  // This method returns an ArrayList of Strings. Each String is a name of a workout in our Workouts list.
  public final ArrayList<String> getNames() {
    ArrayList<String> posWorkouts = new ArrayList<String>();
    for (int i = 0; i < workoutList.size(); i++) {
      posWorkouts.add(workoutList.get(i).name); 
    }
    return posWorkouts;
  }
 
  // This method returns all the information of the Workouts as an ArrayList of String arrays, 
  // one entry in the ArrayList per Workout. The String array should contain the workout's Name, 
  // Equipment, Primary and Secondary Muscles, Description, and Reminders. All of these should be strings.
  public final ArrayList<String[]> getFullInformation() {
    // need to make a toString function for the class Workout
    ArrayList<String[]> fullInfo = new ArrayList<String[]>();
    // need to fill temp with needed values
    for (int i = 0; i < workoutList.size(); i++) {
      fullInfo.add(workoutList.get(i).toStringArray());
    }
    return fullInfo;
  }
}
