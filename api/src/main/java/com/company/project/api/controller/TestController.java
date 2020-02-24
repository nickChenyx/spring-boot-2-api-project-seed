package com.company.project.api.controller;

import com.company.project.common.service.IGoldHistoryService;
import com.company.project.persistence.account.entity.GoldHistory;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nickChen
 * @date 2020-02-23
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private IGoldHistoryService goldHistoryService;

    @GetMapping("/str")
    public String getStr() {
        return "str";
    }


    @GetMapping("/gold")
    public GoldHistory findHistory() {
        List<GoldHistory> list = goldHistoryService.list();

        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @GetMapping("/gold/{id}")
    public GoldHistory findHistory(@PathVariable Long id) {
        GoldHistory history = goldHistoryService.getById(id);

        return history;
    }
}
