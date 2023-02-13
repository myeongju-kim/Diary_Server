package com.kingmj.api.note.service;

import com.kingmj.api.common.code.ServerCode;
import com.kingmj.api.common.dto.ApiResponse;
import com.kingmj.api.note.dto.NoteRequest;
import com.kingmj.api.note.entity.Note;
import com.kingmj.api.note.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    public NoteService(NoteRepository noteRepository){
        this.noteRepository=noteRepository;
    }
    public ApiResponse<Void> postNote(NoteRequest.Create data){
        //save note
        Note note=Note.builder()
                .title(data.getTitle())
                .content(data.getContent())
                .weather(data.getWeather())
                .mood(data.getMode())
                .date(LocalDateTime.now())
                .build();
        noteRepository.save(note);
        //return with success message
        return ApiResponse.<Void>builder()
                .code(ServerCode.POST_SUCCESS.getCode())
                .message(ServerCode.POST_SUCCESS.getMessage())
                .result(null)
                .build();
    }
}
