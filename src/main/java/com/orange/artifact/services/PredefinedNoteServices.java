package com.orange.artifact.services;


import com.orange.artifact.model.PredefinedNotes;
import com.orange.artifact.repository.PredefinedNotesRepository;
import com.orange.artifact.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public PredefinedNotes findpredefinedNotes(Integer id) {
        return predefinedNotesDao.findById(id).get();
    }

    public void updatepredefinedNotes(String messageNote, PredefinedNotes predefinedNote) {
        predefinedNote.setMessage(messageNote);
        predefinedNotesDao.save(predefinedNote);
    }
}
