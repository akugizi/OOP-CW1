
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class TriathlonResults {
    private String name;
    private String id;
    private int swimmingTime;
    private int cyclingTime;
    private int runningTime;

    
    public TriathlonResults(String name, String id, int swimmingTime, 
     int cyclingTime, int runningTime) {
        this.name = name;
        this.id = id;
        setSwimmingTime(swimmingTime);
        setCyclingTime(cyclingTime);
        setRunningTime(runningTime);
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSwimmingTime() {
        return swimmingTime;
    }

    public void setSwimmingTime(int swimmingTime) {
        if (swimmingTime < 0) {
            throw new IllegalArgumentException("Swimming time cannot be negative.");
        }
        this.swimmingTime = swimmingTime;
    }

    public int getCyclingTime() {
        return cyclingTime;
    }

    public void setCyclingTime(int cyclingTime) {
        if (cyclingTime < 0) {
            throw new IllegalArgumentException("Cycling time cannot be negative.");
        }
        this.cyclingTime = cyclingTime;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        if (runningTime < 0) {
            throw new IllegalArgumentException("Running time cannot be negative.");
        }
        this.runningTime = runningTime;
    }

 
    public int getTotalTime() {
        return swimmingTime + cyclingTime + runningTime;
    }

   
    public void displayDetails() {
        System.out.println("Participant Name: " + name);
        System.out.println("Participant ID: " + id);
        System.out.println("Total Time: " + getTotalTime() + " minutes");
    }
}

class EliteParticipant extends TriathlonResults {
    private String sponsorName;

    // Constructor
    public EliteParticipant(String name, String id, int swimmingTime,
    int cyclingTime, int runningTime, String sponsorName) {
        super(name, id, swimmingTime, cyclingTime, runningTime);
        this.sponsorName = sponsorName;
    }

    
    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

  
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Sponsor Name: " + sponsorName);
    }
}

class BeginnerParticipant extends TriathlonResults {

    // Constructor
    public BeginnerParticipant(String name, String id, 
     int swimmingTime, int cyclingTime, int runningTime) {
        super(name, id, swimmingTime, cyclingTime, runningTime);
    }

   
    @Override
    public void displayDetails() {
        super.displayDetails();
    }
}

public class Triathlon {

    public static void main(String[] args) {
        // Creating participants
        ArrayList<TriathlonResults> participants = new ArrayList<>();

        // Adding sample participants
        participants.add(new BeginnerParticipant("Alice", "ID001", 25, 40, 20));
        participants.add(new BeginnerParticipant("Bob", "ID002", 20, 35, 25));
        participants.add(new EliteParticipant("Charlie", "ID003", 30, 50, 30, "TechCorp"));
        participants.add(new EliteParticipant("Diana", "ID004", 28, 42, 18, "FitLife"));

        
        Collections.sort(participants, Comparator.comparingInt
        (TriathlonResults::getTotalTime));

        // Displaying participant details
        System.out.println("Participants and their details:");
        for (TriathlonResults participant : participants) {
            participant.displayDetails();
            System.out.println();
        }

        
        if (participants.size() > 0) {
            TriathlonResults fastest = participants.get(0);
            System.out.println("Fastest participant: " + fastest.getName()
            + " with total time " + fastest.getTotalTime() + " minutes");

            if (participants.size() > 1) {
                TriathlonResults secondFastest = participants.get(1);
                System.out.println("Second fastest participant: " +
              secondFastest.getName() + " with total time " + 
                        secondFastest.getTotalTime() + " minutes");
            }
        }

        // Handling the case where two participants have the same total time
        System.out.println("\nHandling participants with the same total time:");
        for (int i = 0; i < participants.size() - 1; i++) {
            if (participants.get(i).getTotalTime() == participants.get(i + 1).getTotalTime()) {
                System.out.println("Tied participants: " 
         + participants.get(i).getName() + " and " + participants.get(i + 1).getName() +
        " with total time: " + participants.get(i).getTotalTime() + " minutes");
            }
        }

        // Checking for invalid times
        try {
            participants.add(new BeginnerParticipant("Invalid", "ID005", -5, 20, 30)); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }}
    

