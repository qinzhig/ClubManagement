package sg.edu.nus.clubmanagement.ClubFolder;

/**
 * Created by swarna on 4/8/2016.
 */
public class Facility implements Comparable<Facility> {

    private String name;
    private String description;

    public Facility (String name) {
        this (name, null);
    }

    public Facility (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName () {
        return name;
    }

    public String getDescription () {
        return description;
    }

    public boolean equals(Object facility) {
        if (facility instanceof Facility) {
            Facility fac = (Facility) facility;
            if (this.getName().equals(fac.getName()))
                if (this.getDescription() == null)
                    if (fac.getDescription() == null)
                        return true;
                    else return false;
                else if (fac.getDescription() != null)
                    if (this.getDescription().equals(fac.getDescription()))
                        return true;

        }
        return false;
    }

    public String toString () {
        String fullName = name;
        if (description != null) {
            fullName += " (" + description + ")";
        }
        return (fullName);
    }

    public void show () {
        System.out.println (this);
    }

    // Added so that Facilities can be sorted alphabetically
    public int compareTo (Facility other) {
        return (getName().compareTo(other.getName()));
    }
}
