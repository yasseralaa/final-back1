package com.orange.artifact.services;


import com.orange.artifact.errorhandling.EntityNotFoundException;
import com.orange.artifact.model.PredefinedNotes;
import com.orange.artifact.repository.PredefinedNotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("predefinedNoteServices")
@Transactional
public class PredefinedNoteServices {


    @Autowired
    PredefinedNotesRepository predefinedNotesDao;

    public List<PredefinedNotes> getAllpredefinedNotes() {
        return (List<PredefinedNotes>) predefinedNotesDao.findAll();
    }

    public PredefinedNotes findpredefinedNotes(Integer id) throws EntityNotFoundException {
        PredefinedNotes predefinedNotes = predefinedNotesDao.findById(id).get();
        if (predefinedNotes == null) {
            throw new EntityNotFoundException(PredefinedNotes.class, "id", predefinedNotes.getId().toString());
        }
        return predefinedNotes;
    }

    public void updatepredefinedNotes(String messageNote, PredefinedNotes predefinedNote) {
        predefinedNote.setMessage(messageNote);
        predefinedNotesDao.save(predefinedNote);
    }
}
