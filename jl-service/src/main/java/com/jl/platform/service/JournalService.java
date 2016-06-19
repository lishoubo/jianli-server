package com.jl.platform.service;

import com.jl.platform.common.PageQuery;
import com.jl.platform.common.Pagination;
import com.jl.platform.common.Result;
import com.jl.platform.service.form.JournalForm;
import com.jl.platform.service.model.Journal;

public interface JournalService {

    Result<String> save(JournalForm journalForm);

    Result<Pagination<Journal>> query(PageQuery pageQuery);
}
