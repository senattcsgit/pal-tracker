package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private List<TimeEntry> timesheets = new ArrayList<>();
    int counter =0;

    public TimeEntry create(TimeEntry timeEntry) {

            counter++;
            timeEntry.setId(counter);
            timesheets.add(timeEntry);
            return timeEntry;



    }

    public TimeEntry find(long id) {

        for (TimeEntry t : timesheets)
        {
            if (t.getId() == id)
             return t;
        }

        return null;

    }


    public List<TimeEntry> list() {


          //  while (tl.iterator().hasNext())
         //   {
         //       System.out.println(tl.toArray());
         //   }


        return  timesheets;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {

           TimeEntry t= this.find(id);
           if (t != null)
           {
               timesheets.remove(t);
               timeEntry.setId(id);
               timesheets.add(timeEntry);

               return timeEntry;
           }
        return null;
    }

    public void delete(long id) {
        // tl.remove(id);
        TimeEntry t= this.find(id);
        if (t != null)
        {
            timesheets.remove(t);


        }
        return ;
    }
}
