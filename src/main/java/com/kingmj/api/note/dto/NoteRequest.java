package com.kingmj.api.note.dto;

import lombok.Getter;

public class NoteRequest {

    @Getter
    public static class Create {

        private String title;

        private String content;

        private Integer weather;

        private Integer mode;

    }

    @Getter
    public static class Update {

        private String title;

        private String content;

    }

}
