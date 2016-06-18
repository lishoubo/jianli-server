package com.jl.platform.service;

import com.jl.platform.common.Result;
import com.jl.platform.service.model.Article;

/**
 * Created by lishoubo on 16/5/20.
 */
public interface ArticleStoreService {
    Result saveArticle(Article article);
}
