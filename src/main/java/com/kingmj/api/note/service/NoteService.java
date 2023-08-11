package com.kingmj.api.note.service;

import com.kingmj.api.note.dto.NoteRequest;
import com.kingmj.api.note.dto.NoteResponse;

import java.util.List;

public interface NoteService {

    void postNote(NoteRequest.Create data);

    List<NoteResponse.Load> getNote(Integer page);

    NoteResponse.Detail getDetail(Long id);
}
