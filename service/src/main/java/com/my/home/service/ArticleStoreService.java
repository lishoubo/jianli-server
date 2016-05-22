package com.my.home.service;

import com.my.home.common.Result;
import com.my.home.service.model.Article;

/**
 * Created by lishoubo on 16/5/20.
 */
public interface ArticleStoreService {
    Result saveArticle(Article article);
}
