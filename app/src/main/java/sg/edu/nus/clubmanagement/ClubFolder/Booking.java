package sg.edu.nus.clubmanagement.ClubFolder;

/**
 * Created by swarna on 4/8/2016.
 */
import java.util.*;
import java.text.*;

public class Booking {

    //public static final String DATE_FORMAT = "d-MMM-yyyy";
    //public static final String TIME_FORMAT = "d-MMM-yyyy H:mm";

    public static final String DATE_FORMAT = "dd MMM yyyy";
    public static final String TIME_FORMAT = "dd MMM yyyy H:mm";

    private Member   member;
    private Facility facility;
    private Date     startDate;
    private Date     endDate;

    public Booking (Member member, Facility facility, Date startDate, Date endDate)
            throws BadBookingException {

        String error = null;
        if (member == null)
            error = "No member specified";
        else if (facility == null)
            error = "No facility specified";
        else if ((startDate == null) || (endDate == null))
            error = "Missing date";
        else if (startDate.after(endDate))
            error = "Start date is earlier than end date";
        if (error != null)
            throw new BadBookingException (error);

        this.member = member;
        this.facility = facility;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Member getMember () {
        return member;
    }

    public Facility getFacility () {
        return facility;
    }

    public Date getStartDate () {
        return startDate;
    }

    public Date getEndDate () {
        return endDate;
    }

    public boolean overlaps (Booking other) {
        boolean status = true;
        if (this.facility != other.getFacility ()) {
            status = false;
        } else if (startDate.getTime() >= other.getEndDate().getTime()) {
            status = false;
        } else if (other.getStartDate().getTime() >= endDate.getTime()) {
            status = false;
        }
        return (status);
    }

    private static DateFormat tf = new SimpleDateFormat (TIME_FORMAT);

    public String toString () {
        return ("Booking: " + facility.getName ()
                + " (" + member + "): " + tf.format(startDate)
                + " to " + tf.format(endDate));
    }

    public void show () {
        System.out.println (this);
    }
}

