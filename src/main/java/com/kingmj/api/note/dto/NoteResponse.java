package com.kingmj.api.note.dto;


import lombok.Builder;
import lombok.Getter;

public class NoteResponse {
    @Builder
    @Getter
    public static class Load{
        private String title;
        private String content;
        private String date;
        private Integer weather;
        private Integer mode;
    }
}
