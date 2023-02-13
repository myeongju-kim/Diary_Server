package com.kingmj.api.note.controller;

import com.kingmj.api.account.service.JwtService;
import com.kingmj.api.common.dto.ApiResponse;
import com.kingmj.api.note.dto.NoteRequest;
import com.kingmj.api.note.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/note")
public class NoteController {
    private final NoteService noteService;
    private final JwtService jwtService;
    public NoteController(NoteService noteService, JwtService jwtService){
        this.noteService=noteService;
        this.jwtService = jwtService;
    }
    @PostMapping("")
    public ResponseEntity<ApiResponse<Void>> postNote(@RequestHeader(name="Authorization") String token, @RequestBody NoteRequest.Create data){
        jwtService.validateToken(token);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(noteService.postNote(data));
    }
}
