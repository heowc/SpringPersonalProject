package com.tistory.heowc.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "COMMENT")
public class Comment implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_IDX")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NOTICE_IDX")
    private Notice notice;

    private String content;

    private LocalDateTime createDateTime;

    private LocalDateTime modifyDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMAIL")
    private Member member;

    public Comment () {}
}
