package com.jl.platform.domain.mongodb;

import com.alibaba.fastjson.JSON;
import com.jl.platform.service.model.Staff;
import org.bson.Document;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by lishoubo on 16/6/24.
 */
public class StaffMongoDBStoreTest {

    @Test
    public void test_modal() throws Exception {
        StaffMongoDBStore staffMongoDBStore = new StaffMongoDBStore();
        staffMongoDBStore.afterPropertiesSet();

    }

    @Test
    public void test_bench() throws Exception {
        Staff staff = new Staff();
        staff.setType("type");
        staff.setName("name");
        staff.setGrade("grade");
        staff.setProfessional("profefe");
        staff.setQualification("quqfefe");
        staff.setCreateTime(new Date());

        int times = 10000;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            String json = JSON.toJSONString(staff);
            Document document = new Document();
            document.putAll(JSON.parseObject(json));
        }
        System.out.println("fastjson:" + (System.currentTimeMillis() - begin));


        begin = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Document document = new Document(Document.parse(JSON.toJSONString(staff)));
        }
        System.out.println("Document:" + (System.currentTimeMillis() - begin));
    }
}