package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsExceptions;
import com.stackroute.exceptions.TrackNotFoundExceptions;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "music")
@Service
@Primary
public class Trackserviceimpl  implements  Trackservice {

    private TrackRepository trackRepository;

    public void simulateDelay()
    {
        try {
            Thread.sleep(3000l);
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }

    }

    @Autowired
    public  Trackserviceimpl(TrackRepository trackRepository)
    {
        this.trackRepository=trackRepository;
    }
    @CachePut
    @Override
    public Track saveTrack(Track trackInfo)throws TrackAlreadyExistsExceptions {

        if(trackRepository.existsById(trackInfo.getTrackId()))
        {
            throw  new TrackAlreadyExistsExceptions("trackInfo already exists");
        }
        Track savedtrack=trackRepository.save(trackInfo);
        if(savedtrack==null)
        {
            throw  new TrackAlreadyExistsExceptions("trackInfo already exists");
        }
        return savedtrack;
    }

    @Cacheable
    @Override
    public List<Track> getAllTracks() {

        simulateDelay();
        List<Track> tracklist =(List<Track>)trackRepository.findAll();
        return tracklist;
    }

    @CachePut
    @Override
    public Track updateTrack(String id, String comment)throws TrackNotFoundExceptions
    {
         Track trackInfo;
        if (trackRepository.existsById(id))
        {
            trackInfo =trackRepository.findById(id).get();
            trackInfo.setTrackcmnt(comment);
            trackRepository.save(trackInfo);
        }
        else
            {
            throw new TrackNotFoundExceptions("no trackInfo found to update");
           }


        return trackInfo;
    }

    @CachePut
    @Override
    public Track deleteTrack(String trackId)throws TrackNotFoundExceptions
    {
         Track trackInfo =null;
        if (trackRepository.existsById(trackId))
        {

            trackInfo =trackRepository.findById(trackId).get();
            trackRepository.deleteById(trackId);
        }
        else
            {

            throw  new TrackNotFoundExceptions("no trackInfo found to delete");
            }
        return trackInfo;

    }

    @Override
    public Track findByTrackName(String name)throws TrackNotFoundExceptions
    {

        Track trackInfo =trackRepository.findByTrackName(name);
        if(trackInfo ==null)
        {

            throw  new TrackNotFoundExceptions("no trackInfo found to display");

        }
        return trackInfo;

    }

}
