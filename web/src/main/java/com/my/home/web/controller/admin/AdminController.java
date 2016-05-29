package com.my.home.web.controller.admin;

import com.my.home.common.Result;
import com.my.home.common.StatusCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lishoubo on 16/5/21.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @RequestMapping("/articles")
    public Result addArticle() {
        return Result.result(StatusCode.SUCCESS);
    }
}
