package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TimeEntryController {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

        this.timeEntryRepository = timeEntryRepository;
    }


    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
       TimeEntry t= timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(t, HttpStatus.CREATED);

    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable(name="id", required=true) long timeEntryId) {

        TimeEntry t = timeEntryRepository.find(timeEntryId);

        if ( t == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(t, HttpStatus.OK);
        }
    }
    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {

        List<TimeEntry> t= timeEntryRepository.list();
        //TimeEntry tt[] = new TimeEntry();

        return new ResponseEntity<>(t, HttpStatus.OK);
    }
   @RequestMapping(method = RequestMethod.PUT, path = "/time-entries/{id}")
    public ResponseEntity update(@PathVariable(name="id", required=true) long timeEntryId, @RequestBody TimeEntry expected) {


        TimeEntry t=timeEntryRepository.update(timeEntryId, expected);
        if (t == null)
        {
            return new ResponseEntity<>(t, HttpStatus.NOT_FOUND);
        }
        else
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable(name="id", required=true) long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
