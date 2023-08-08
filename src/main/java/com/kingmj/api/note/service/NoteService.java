package com.kingmj.api.note.service;

import com.kingmj.api.common.code.ServerCode;
import com.kingmj.api.common.dto.ApiResponse;
import com.kingmj.api.note.dto.NoteRequest;
import com.kingmj.api.note.dto.NoteResponse;
import com.kingmj.api.note.entity.Note;
import com.kingmj.api.note.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public void postNote(NoteRequest.Create data) {
        //save note
        Note note = Note.builder()
                        .title(data.getTitle())
                        .content(data.getContent())
                        .weather(data.getWeather())
                        .mood(data.getMode())
                        .date(LocalDateTime.now())
                        .build();

        noteRepository.save(note);

    }

    public List<NoteResponse.Load> getNote(Integer page) {

        List<NoteResponse.Load> lists = new ArrayList<>();
        //pagination
        Pageable pageable = PageRequest.of(page, 6, Sort.by("date").descending());
        Page<Note> notes = noteRepository.findAll(pageable);

        for (Note note : notes) {
            lists.add(NoteResponse.Load.builder()
                                       .id(note.getId())
                                       .title(note.getTitle())
                                       .date(note.getDate()
                                                 .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                                       .weather(note.getWeather())
                                       .mode(note.getMood())
                                       .build());
        }

        return lists;

    }

    public NoteResponse.Detail getDetail(Long id) {

        Note note = noteRepository.findById(id).orElse(null);

        return NoteResponse.Detail.builder()
                                  .date(note.getDate()
                                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                                  .title(note.getTitle())
                                  .content(note.getContent())
                                  .build();

    }
}
