package com.jl.platform.domain.mongodb;

import java.util.Date;

import org.bson.Document;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.jl.platform.service.model.Staff;

/**
 * Created by lishoubo on 16/6/24.
 */
public class StaffMongoDBStoreTest {

	@Test
	public void test_modal() throws Exception {
		System.out.println(19 / 10);

	}

	@Test
	public void test_bench() throws Exception {
		Staff staff = new Staff();
		staff.setName("name");
		staff.setCreateDate(new Date().getTime());

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
			Document document = new Document(Document.parse(JSON
					.toJSONString(staff)));
		}
		System.out.println("Document:" + (System.currentTimeMillis() - begin));
	}
}