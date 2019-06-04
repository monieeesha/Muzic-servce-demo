package com.stackroute.applicationstartwithprefill;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config.properties")
public class Seed implements ApplicationListener<ContextRefreshedEvent> {
    Track track=new Track();
    @Autowired
    TrackRepository trackRepository;
    @Autowired
    private Environment environment;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {

        track.setTrackId(environment.getProperty("track2.id"));
        track.setTrackname(environment.getProperty("track2.name"));
        track.setTrackcmnt(environment.getProperty("track2.comment"));
        trackRepository.save(track);
    }
}
