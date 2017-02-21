package sg.edu.nus.clubmanagement.ClubFolder;

/**
 * Created by swarna on 4/8/2016.
 */
import java.util.*;

public class Club {

    private int                       numMembers;
    private ArrayList<Member>         members;
    private HashMap<String, Facility> facilities;
    private BookingRegister           bookings;

    public Club () {
        numMembers = 0;
        members = new ArrayList<Member> ();
        facilities = new HashMap<String, Facility> ();
        bookings = new BookingRegister ();
    }

    public Member getMember (int memberNum) {
        Iterator<Member> i = members.iterator ();
        while (i.hasNext ()) {
            Member m = i.next();
            if (m.getMemberNumber() == memberNum) {
                return m;
            }
        }
        return null;
    }

    public List<Member> getMembers () {

        return (new ArrayList<Member> (members));

    }

    public Member addMember (String surname, String firstName,
                             String secondName) {
        numMembers++;
        Member m = new Member (surname, firstName, secondName,
                numMembers);
        members.add (m);
        return m;
    }

    public void removeMember (int memberNum) {
        Member m = getMember (memberNum);
        if (m != null) {
            members.remove (m);
        }
    }

    public void showMembers () {
        Iterator<Member> i = members.iterator ();
        while (i.hasNext ()) {
            i.next().show ();
        }
    }


    public Facility getFacility (String name) {
        return facilities.get (name);
    }

    public List<Facility> getFacilities () {
        return (new ArrayList<Facility>(facilities.values()));
    }

    public void addFacility (String name, String description) {
        if (name == null) {
            return;
        }
        Facility f = new Facility (name, description);
        facilities.put (name, f);
    }

    public void removeFacility (String name) {
        facilities.remove (name);
    }

    public void showFacilities () {
        Iterator<Facility> i = getFacilities().iterator ();
        while (i.hasNext ()) {
            i.next().show ();
        }
    }


    public void addBooking (int memberNumber, String facName, Date startDate, Date endDate)
            throws BadBookingException {
        bookings.addBooking (getMember (memberNumber),
                getFacility (facName), startDate, endDate);
    }

    public void removeBooking (Booking booking) {
        bookings.removeBooking (booking);
    }

    public ArrayList<Booking> getBookings (String facName, Date startDate, Date endDate) {
        return bookings.getBookings (getFacility (facName), startDate, endDate);
    }

    public void showBookings (String facName, Date startDate, Date endDate) {
        ArrayList<Booking> b = getBookings (facName, startDate, endDate);
        Iterator<Booking> i = b.iterator();
        while (i.hasNext()) {
            i.next().show();
        }
    }


    public void show () {
        System.out.println ("Current Members:");
        showMembers ();
        System.out.println ();
        System.out.println ("Facilities:");
        showFacilities ();
    }
}
