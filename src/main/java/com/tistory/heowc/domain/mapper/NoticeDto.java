package com.tistory.heowc.domain.mapper;

import com.tistory.heowc.domain.Member;
import lombok.Data;

import java.time.LocalDateTime;

public class NoticeDto {

    @Data
    public static class Notice {
        private Long idx;

        private String title;

        private LocalDateTime createDateTime;

        private LocalDateTime modifyDateTime;

        private Member member;
    }
}
