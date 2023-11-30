package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.example.dao.mapper.PlusUserMapper;
import com.example.entity.PlusUser;
import com.example.service.PlusUserService;
import com.example.service.RoleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

public class AppTest extends TestCase {
    static JsonMapper jsonMapper = new JsonMapper();

    static {
        jsonMapper.registerModule(new JavaTimeModule());
    }

    @Autowired
    PlusUserService psvc;
    @Autowired
    RoleService rsvc;
    @Autowired
    private PlusUserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<PlusUser> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

    @Test
    public void One() {
        System.out.println(("----- selectAll method test ------"));
        LambdaQueryWrapper<PlusUser> wrapper = new LambdaQueryWrapper<>();
        wrapper
                .like(PlusUser::getName, "J")        // %J%(String)
                .likeLeft(PlusUser::getName, "J")    // %J(String)
                .likeRight(PlusUser::getName, "n")   // n%(String)
                //       condition: 是否添加改行的查询条件， 如果传入false,where后就不加入此行条件
                .notLike(true, PlusUser::getName, "a");  //  AND name NOT LIKE ? ==> %a%(String)

        wrapper.clear();
        wrapper.select(PlusUser::getId, PlusUser::getName, PlusUser::getAge)
                .like(PlusUser::getName, "J")
                .orderByAsc(PlusUser::getId);

        wrapper = Wrappers.lambdaQuery();
        wrapper.eq(PlusUser::getId, 1);
        Wrappers.emptyWrapper().eq("id", 1);
        Wrappers.query();

        List<PlusUser> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
        Page<PlusUser> page = new Page<>(1, 2);
        System.out.println(psvc.page(page));
    }

    @Test
    public void testservice() throws JsonProcessingException {
        System.out.println(psvc.list(null));
        System.out.println(psvc.listMaps());
        System.out.println(rsvc.list(null));
        System.out.println(rsvc.listMaps());

        String s = jsonMapper.writeValueAsString(rsvc.list(null));
        System.out.println(s);
        s = jsonMapper.writeValueAsString(rsvc.listMaps());
        System.out.println(s);


        System.out.println("=====================================");
        Page<PlusUser> page = new Page<>(1, 2);
        page.addOrder(OrderItem.desc("id"));

        IPage<PlusUser> pa = psvc.page(page);
        System.out.println(jsonMapper.writeValueAsString(pa));
        System.out.println(jsonMapper.writeValueAsString(pa.getRecords()));

    }


    @Test
    void testOrderBy() {
        LambdaQueryWrapper<PlusUser> w = Wrappers.lambdaQuery();
        w.orderBy(true, false, PlusUser::getId);
        w.orderBy(true, true, PlusUser::getAge);
        List<PlusUser> plusUsers = userMapper.selectList(w);
        System.out.println(plusUsers);
    }

    @Test
    void testFunc() {
        LambdaQueryWrapper<PlusUser> w = Wrappers.lambdaQuery();
        w.func(it -> {
            if (true)
                it.eq(PlusUser::getId, 1);
            else
                it.eq(PlusUser::getId, 2);
        });
        List<PlusUser> plusUsers = userMapper.selectList(w);
        System.out.println(plusUsers);

        System.out.println("-=====================================");
        w = Wrappers.lambdaQuery();
        w.func(it -> {
            if (false)
                it.eq(PlusUser::getId, 1);
            else
                it.eq(PlusUser::getId, 2);
        });
        plusUsers = userMapper.selectList(w);
        System.out.println(plusUsers);
    }


    @Test
    void testSelect2() {
        LambdaQueryWrapper<PlusUser> w = Wrappers.lambdaQuery();
        // 1. select(String... sqlSelect)
//        w.select(PlusUser::getId,PlusUser::getName, PlusUser::getAge);
        // 2. select(Predicate<TableFieldInfo> predicate)
        w.select(PlusUser.class, i ->
                i.getProperty().startsWith("a")
        );
        List<PlusUser> plusUsers = userMapper.selectList(w);

        plusUsers.forEach(System.out::println);
    }

    @Test
    void testNoneID() {
//        id 没有注解
        //1726893795133427713
        //1726894133261369346
        PlusUser u = new PlusUser();
        u.setName("xs231121_0");
        u.setAge(23);
        u.setEmail("wxs_code@126.com");
        if (userMapper.insert(u) > 0)
            System.out.println(u);
    }

    @Test
    void testAutoID() {
        //IdType.AUTO, 数据库字段需要设置自增
        PlusUser u = new PlusUser();
        u.setName("xs231121_1");
        u.setAge(24);
        u.setEmail("wxs_code@126.com");
        if (userMapper.insert(u) > 0)
            System.out.println(u);
    }

    @Test
    void testINPUTID() {
        //IdType.INPUT,
        PlusUser u = new PlusUser();
        u.setName("xs231121_2");
        u.setAge(23);
        u.setEmail("wxs_code@126.com");
        if (userMapper.insert(u) > 0)
            System.out.println(u);

        Db.lambdaQuery(PlusUser.class).eq(PlusUser::getId, 1);
//        BeanUtils.copyProperties();
    }

    @Test
    void testEnumType() {
        List list = rsvc.list();
        list.forEach(System.out::println);
    }

    @Test
    void testPage() {
        int begin = 3, pagesize = 2;
        Page<PlusUser> page = new Page<>(begin, pagesize);
//        page = Page.of(begin,pagesize);
        page.addOrder(new OrderItem("id", false));
        IPage page1 = psvc.page(page);
        System.out.println("page1.getRecords() = " + page1.getRecords());
        page1.getRecords().forEach(System.out::println);
        /**
         * 2023-11-29 17:46:03.135  INFO 14532 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
         * 2023-11-29 17:46:03.288  INFO 14532 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
         * 2023-11-29 17:46:03.295 DEBUG 14532 --- [           main] c.e.d.m.P.selectPage_mpCount             : ==>  Preparing: SELECT COUNT(*) AS total FROM plususer
         * 2023-11-29 17:46:03.317 DEBUG 14532 --- [           main] c.e.d.m.P.selectPage_mpCount             : ==> Parameters:
         * 2023-11-29 17:46:03.338 DEBUG 14532 --- [           main] c.e.d.m.P.selectPage_mpCount             : <==      Total: 1
         * 2023-11-29 17:46:03.346 DEBUG 14532 --- [           main] c.e.d.mapper.PlusUserMapper.selectPage   : ==>  Preparing: SELECT id, name, age, email FROM plususer ORDER BY id DESC LIMIT ?,?
         * 2023-11-29 17:46:03.346 DEBUG 14532 --- [           main] c.e.d.mapper.PlusUserMapper.selectPage   : ==> Parameters: 4(Long), 2(Long)
         * 2023-11-29 17:46:03.348 DEBUG 14532 --- [           main] c.e.d.mapper.PlusUserMapper.selectPage   : <==      Total: 2
         * page1.getRecords() = [PlusUser{id=5, name='Billie', age=24, email='test5@baomidou.com'}, PlusUser{id=4, name='Sandy', age=21, email='test4@baomidou.com'}]
         * PlusUser{id=5, name='Billie', age=24, email='test5@baomidou.com'}
         * PlusUser{id=4, name='Sandy', age=21, email='test4@baomidou.com'}
         */
    }
}
