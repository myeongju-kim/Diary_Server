package com.kingmj.api.note.controller;

import com.kingmj.api.common.dto.ApiResponse;
import com.kingmj.api.note.dto.NoteRequest;
import com.kingmj.api.note.dto.NoteResponse;
import com.kingmj.api.note.service.NoteService;
import com.kingmj.api.util.Auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
public class NoteController {
    private final NoteService noteService;
    public NoteController(NoteService noteService){
        this.noteService=noteService;
    }
    @PostMapping("")
    @Auth
    public ResponseEntity<ApiResponse<Void>> postNote(@RequestBody NoteRequest.Create data){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(noteService.postNote(data));
    }
    @GetMapping("")
    public ResponseEntity<ApiResponse<List<NoteResponse.Load>>> getNote(@RequestParam(name="page") Integer page){
        return ResponseEntity.status(HttpStatus.OK)
                .body(noteService.getNote(page));
    }
}
