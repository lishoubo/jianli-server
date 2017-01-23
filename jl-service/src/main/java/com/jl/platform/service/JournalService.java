package com.jl.platform.service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.dao.model.Journal;
import com.jl.platform.form.JournalForm;

public interface JournalService {

    Result<String> save(JournalForm journalForm);

    Result<Pagination<Journal>> pageQuery(PageQuery pageQuery);

    Result delete(String id);

    Result update(JournalForm journalForm);

    Result queryById(String id);
}
