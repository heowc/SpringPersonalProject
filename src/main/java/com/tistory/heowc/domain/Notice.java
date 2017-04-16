package com.tistory.heowc.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "NOTICE")
@GenericGenerator(
        name = "NoticeSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "NOTICE_SEQ"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
public class Notice implements Serializable {

    @Id @Column(name = "NOTICE_IDX") @GeneratedValue(generator = "NoticeSequenceGenerator")
    private Long idx;

    @Column(name = "TITLE") @NotNull
    @NonNull
    private String title;

    @Column(name = "CONTENT") @NotNull
    @NonNull
    private String content;

    @Column(name = "CREATE_DATETIME") @NotNull
    private LocalDateTime createDateTime;

    @Column(name = "MODIFY_DATETIME") @NotNull
    private LocalDateTime modifyDateTime;

    @Column(name = "WRITER") @NotNull
    @NonNull
    private String writer;

    private Notice() {}
}
