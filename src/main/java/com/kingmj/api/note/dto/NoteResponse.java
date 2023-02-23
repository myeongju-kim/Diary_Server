package com.kingmj.api.note.dto;


import lombok.Builder;
import lombok.Getter;

public class NoteResponse {
    @Builder
    @Getter
    public static class Load{
        private Long id;
        private String title;
        private String date;
        private Integer weather;
        private Integer mode;
    }
    @Builder
    @Getter
    public static class Detail{
        private String date;
        private String title;
        private String content;
    }
}
