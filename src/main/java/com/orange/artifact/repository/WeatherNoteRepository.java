package com.orange.artifact.repository;

import com.orange.artifact.model.User;
import com.orange.artifact.model.WeatherNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface WeatherNoteRepository extends CrudRepository<WeatherNote,Integer> {
    public WeatherNote findByDate(Date date);
    public List<WeatherNote> findByUser(Integer userId);
}
