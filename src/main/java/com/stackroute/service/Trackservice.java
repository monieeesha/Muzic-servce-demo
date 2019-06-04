package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsExceptions;
import com.stackroute.exceptions.TrackNotFoundExceptions;

import java.util.List;

public interface Trackservice {

    public Track saveTrack(Track trackInfo)throws TrackAlreadyExistsExceptions;
    public List<Track> getAllTracks();
    public Track updateTrack(String id, String comment)throws TrackNotFoundExceptions;
    public Track deleteTrack(String trackId)throws TrackNotFoundExceptions;
    public Track findByTrackName(String name)throws TrackNotFoundExceptions;

}
