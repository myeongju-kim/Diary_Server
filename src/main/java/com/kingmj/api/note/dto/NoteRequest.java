package com.kingmj.api.note.dto;

import lombok.Getter;

public class NoteRequest {

    @Getter
    public static class Create {

        private String title;

        private String content;

        private int weather;

        private int mode;

    }

    @Getter
    public static class Update {

        private Long id;

        private String title;

        private String content;

        private int weather;

        private int mode;

    }

}
