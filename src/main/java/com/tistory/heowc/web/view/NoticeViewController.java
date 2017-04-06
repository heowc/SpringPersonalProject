package com.tistory.heowc.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("notice")
public class NoticeViewController {

    @GetMapping
    public String noticeView() {
        return "notice";
    }
}
