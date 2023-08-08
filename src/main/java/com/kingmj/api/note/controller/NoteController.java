package com.kingmj.api.note.controller;

import com.kingmj.api.common.code.ServerCode;
import com.kingmj.api.note.dto.NoteRequest;
import com.kingmj.api.note.dto.NoteResponse;
import com.kingmj.api.note.service.Impl.NoteServiceImpl;
import com.kingmj.api.util.ApiResponseEntity;
import com.kingmj.api.util.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteServiceImpl noteService;

    @Auth
    @PostMapping("")
    public ApiResponseEntity<Void> postNote(@RequestBody NoteRequest.Create data) {
        noteService.postNote(data);
        return ApiResponseEntity.success(HttpStatus.CREATED, ServerCode.POST_SUCCESS);
    }

    @GetMapping("")
    public ApiResponseEntity<List<NoteResponse.Load>> getNote(@RequestParam(name = "page") Integer page) {
        return ApiResponseEntity.success(HttpStatus.OK, ServerCode.LIST_SUCCESS, noteService.getNote(page));
    }

    @GetMapping("/{id}")
    public ApiResponseEntity<NoteResponse.Detail> getDetail(@PathVariable Long id) {
        return ApiResponseEntity.success(HttpStatus.OK, ServerCode.DETAIL_SUCCESS, noteService.getDetail(id));
    }

}
