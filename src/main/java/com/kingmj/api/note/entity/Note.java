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

    private Integer weather;

    private Integer mood;

    private LocalDateTime date;

}
