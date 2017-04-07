package com.tistory.heowc.web.api;

import com.tistory.heowc.domain.Notice;
import com.tistory.heowc.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notice")
public class NoticeController {

    @Autowired NoticeService service;

    @PostMapping
    public void insert(@RequestBody Notice notice) {
        service.insert(notice);
    }

    @DeleteMapping
    public void delete(@RequestParam Long idx) {
        service.delete(idx);
    }

    @PutMapping
    public void update(@RequestBody Notice notice) {
        service.update(notice);
    }

    @GetMapping
    public Page<Notice> save(@RequestParam(required = false, defaultValue = "0") Integer size,
                             @RequestParam(required = false, defaultValue = "")  String  type,
                             @RequestParam(required = false, defaultValue = "")  String  keyword) {
        return service.getNotice(size, type, keyword);
    }
}
