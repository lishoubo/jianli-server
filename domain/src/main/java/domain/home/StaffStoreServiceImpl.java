package domain.home;

import com.my.home.common.Result;
import com.my.home.common.StatusCode;
import com.my.home.domain.CouchDbService;
import com.my.home.service.StaffStoreService;
import com.my.home.service.model.Page;
import com.my.home.service.model.Staff;
import org.lightcouch.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("staffStoreService")
public class StaffStoreServiceImpl implements StaffStoreService {
    @Resource
    private CouchDbService couchDbService;

    public Result saveStaff(Staff staff) {
        Response response = couchDbService.save(staff);

        Result result = Result.result(StatusCode.SUCCESS);
        result.setData(response.getId());
        result.setSuccess(true);
        return result;
    }

    public Result queryPages(int currentPage, int pageSize) {
        // TODO 此处要实现couchDB的分页查询
        List<Staff> staffs = new ArrayList<Staff>();
        Staff staff1 = new Staff();
        staff1.setName("李守波");
        staff1.setGrade("5");
        staff1.setQualification("10");
        staff1.setProfessional("计算机");

        Staff staff2 = new Staff();
        staff2.setName("张璐");
        staff2.setGrade("3");
        staff2.setQualification("5");
        staff2.setProfessional("电子商务");

        Staff staff3 = new Staff();
        staff2.setName("张颖");
        staff2.setGrade("5");
        staff2.setQualification("10");
        staff2.setProfessional("测试");

        staffs.add(staff3);
        staffs.add(staff2);
        staffs.add(staff1);

        Page<Staff> page = new Page<Staff>();
        page.setPage(1);
        page.setPageSize(5);
        page.setPageTotal(3);
        page.setItems(staffs);

        Result result = Result.result(StatusCode.SUCCESS);
        result.setSuccess(true);
        result.setData(page);

        return result;
    }

}
