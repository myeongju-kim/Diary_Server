package com.kingmj.api.note.dto;


import lombok.Builder;
import lombok.Getter;

public class NoteResponse {

    @Getter
    @Builder
    public static class Load {

        private Long id;

        private String title;

        private String date;

        private Integer weather;

        private Integer mode;

    }

    @Getter
    @Builder
    public static class Detail {

        private String date;

        private String title;

        private String content;


    }

}
