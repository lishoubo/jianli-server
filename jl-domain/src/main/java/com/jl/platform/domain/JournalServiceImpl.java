package com.jl.platform.domain;

import com.jl.platform.common.*;
import com.jl.platform.domain.couchdb.BaikeCouchDBStore;
import com.jl.platform.domain.couchdb.BuildingCouchDBStore;
import com.jl.platform.domain.couchdb.JournalCouchDBStore;
import com.jl.platform.domain.couchdb.StaffCouchDBStore;
import com.jl.platform.service.BaikeService;
import com.jl.platform.service.JournalService;
import com.jl.platform.service.form.JournalForm;
import com.jl.platform.service.model.Baike;
import com.jl.platform.service.model.Building;
import com.jl.platform.service.model.Journal;
import com.jl.platform.service.model.Staff;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lishoubo on 16/6/18.
 */
@Service("journalService")
public class JournalServiceImpl implements JournalService {
    @Resource
    private JournalCouchDBStore journalCouchDBStore;
    @Resource
    private StaffCouchDBStore staffCouchDBStore;
    @Resource
    private BuildingCouchDBStore buildingCouchDBStore;

    @Override
    public Result<String> save(JournalForm journalForm) {
        Staff staff = staffCouchDBStore.find(journalForm.getStaffName());
        if (staff == null) {
            return Result.create(StatusCode.NOT_FOUND_STAFF);
        }
        Building building = buildingCouchDBStore.find(journalForm.getBuildingName());
        if (staff == null) {
            return Result.create(StatusCode.NOT_FOUND_BUILDING);
        }
        building.setProcedure(Procedure.valueOf(journalForm.getProcedure()));

        Journal journal = new Journal();
        journal.setStaff(staff);
        journal.setBuilding(building);
        Result<Response> result = journalCouchDBStore.save(journal);
        if (!result.isSuccess()) {
            return Result.create(result.getCode(), result.getMessage());
        }
        return Result.create(result.getData().getId());
    }

    @Override
    public Result<Pagination<Journal>> query(PageQuery pageQuery) {
        return journalCouchDBStore.list(pageQuery);
    }
}
