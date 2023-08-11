package com.kingmj.api.note.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(length = 2000)
    private String content;

    private int weather;

    private int mood;

    @Builder.Default
    private boolean isDeleted = false;

    @Builder.Default
    private LocalDateTime insertDate = LocalDateTime.now();

    @Builder.Default
    private LocalDateTime updateDate = LocalDateTime.now();

    public void updateNote(String title, String content, int weather, int mood) {

        this.title = title;
        this.content = content;
        this.weather = weather;
        this.mood = mood;
        this.updateDate = LocalDateTime.now();
    }

    public void deleteNote(){

        this.isDeleted = true;
    }

}
