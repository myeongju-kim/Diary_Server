package com.kingmj.api.note.service.Impl;

import com.kingmj.api.common.code.ServerCode;
import com.kingmj.api.common.exception.NotFoundException;
import com.kingmj.api.note.dto.NoteRequest;
import com.kingmj.api.note.dto.NoteResponse;
import com.kingmj.api.note.entity.Note;
import com.kingmj.api.note.repository.NoteRepository;
import com.kingmj.api.note.service.NoteService;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private static int NOTE_COUNT = 6;

    private final NoteRepository noteRepository;

    @Override
    public void postNote(NoteRequest.Create data) {
        //save note
        noteRepository.save(Note.builder()
                                .title(data.getTitle())
                                .content(data.getContent())
                                .weather(data.getWeather())
                                .mood(data.getMode())
                                .build());

    }

    @Override
    public List<NoteResponse.Load> getNote(Integer page) {
        //pagination
        Pageable pageable = PageRequest.of(page, NOTE_COUNT, Sort.by("date").descending());
        Page<Note> notes = noteRepository.findAll(pageable);

        return notes.stream()
                    .map(note -> NoteResponse.Load.builder()
                                                  .id(note.getId())
                                                  .title(note.getTitle())
                                                  .date(note.getDate()
                                                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                                                  .weather(note.getWeather())
                                                  .mode(note.getMood())
                                                  .build())
                    .collect(Collectors.toList());

    }

    @Override
    public NoteResponse.Detail getDetail(Long id) {

        Note note = noteRepository.findById(id).orElseThrow(() -> new NotFoundException(ServerCode.NOT_FOUND_NOTE));

        return NoteResponse.Detail.builder()
                                  .date(note.getDate()
                                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                                  .title(note.getTitle())
                                  .content(note.getContent())
                                  .build();

    }
}
