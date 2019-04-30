import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


// Bonus points: Create an icon (or find a public domain icon. Keep in mind federal Copyright law and TAMU's plagiarism policy and add it to the home screen window.
public class MainWindow {
  
  private final JFrame mainFrame = new JFrame(Config.APPLICATIONNAME);
  private final JDialog selectWorkout = new JDialog(mainFrame, "Select Workout");
  private JComboBox<String> cboType, cboGoal;
  private JSpinner spnDuration;
  private final Workouts workouts;
  private final EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups;

  MainWindow(Workouts workouts, EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups) {
    // Code goes here.
    this.workouts = workouts;
    this.muscleGroups = muscleGroups;
  }
  
  private void launchHomeScreen() {
    // Code goes here.
    mainFrame.setSize(600, 400);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setVisible(true);
    
    // layout
    GridLayout grid = new GridLayout(3, 0);
    mainFrame.setLayout(grid);
    
    // making buttons
    JButton upper = new JButton("Upper Body Workout");
    JButton lower = new JButton("Lower Body Workout");
    JButton whole = new JButton("Whole Body Workout");

    mainFrame.add(upper);
    mainFrame.add(lower);
    mainFrame.add(whole);
    
    // actionlistener for upper
    upper.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        upper.setVisible(false);
        lower.setVisible(false);
        whole.setVisible(false);
        showWorkouts(muscleGroups.get(Config.MuscleGroup.valueOf("UPPERBODY")));
      }
      
    });
    
    lower.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        upper.setVisible(false);
        lower.setVisible(false);
        whole.setVisible(false);
        showWorkouts(muscleGroups.get(Config.MuscleGroup.valueOf("LOWERBODY")));
      }
      
    });
    
    whole.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        upper.setVisible(false);
        lower.setVisible(false);
        whole.setVisible(false);
        showWorkouts(muscleGroups.get(Config.MuscleGroup.valueOf("WHOLEBODY")));
      }
      
    });
    
  }
  
  // This is the method your actionlistener should call. It should create and display a WorkoutsPanel.
  private void showWorkouts(ArrayList<Config.Muscle> muscles) {
  // Code goes here.
    WorkoutsPanel window = new WorkoutsPanel(muscles, workouts);
    BorderLayout border = new BorderLayout();
    mainFrame.setLayout(border);
    mainFrame.add(window, BorderLayout.CENTER);
  }
  
  public void showFrame() {
    this.launchHomeScreen();
  }
  
}
