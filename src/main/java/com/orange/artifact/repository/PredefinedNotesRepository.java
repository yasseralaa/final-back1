package com.orange.artifact.repository;

import com.orange.artifact.model.PredefinedNotes;
import com.orange.artifact.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredefinedNotesRepository  extends CrudRepository<PredefinedNotes,Integer>{

}
