package com.stackroute.applicationstartwithprefill;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class newseed implements CommandLineRunner {

   @Value("${track1.id}")
    private String id;
    @Value("${track1.name}")
    private String tname;
    @Value("${track1.comment}")
   private String tcmnt;

    Track track=new Track();
    @Autowired
    TrackRepository trackRepository;

    @Override
    public void run(String... args) throws Exception
    {

        track.setTrackId(id);
        track.setTrackname(tname);
        track.setTrackcmnt(tcmnt);
        trackRepository.save(track);
    }
}
