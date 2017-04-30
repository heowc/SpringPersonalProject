package com.tistory.heowc.domain.mapper;

import com.tistory.heowc.domain.Member;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoticeDto {

    private Long idx;

    private String title;

    private LocalDateTime createDateTime;

    private LocalDateTime modifyDateTime;

    private Member member;
}
