package com.stackroute.repository;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackNotFoundExceptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TrackRepository extends JpaRepository<Track,String>
{
    @Query("select t from Track t where LOWER(t.trackname)=Lower(:name)")
    public Track findByTrackName(String name);
}
