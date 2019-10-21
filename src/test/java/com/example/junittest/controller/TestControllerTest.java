package com.example.junittest.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.junittest.design.mode.adapter.classes.GetCharge;
import com.example.junittest.design.mode.bridge.ImplementorA;
import com.example.junittest.design.mode.bridge.RefinedAbstraction;
import com.example.junittest.design.mode.builder.NutritionFacts;
import com.example.junittest.design.mode.builder.UserTo;
import com.example.junittest.design.mode.factory.abstractfac.AbstractDrinksFactory;
import com.example.junittest.design.mode.factory.abstractfac.AmericaDrinksFactory;
import com.example.junittest.design.mode.factory.abstractfac.ChinaDrinksFactory;
import com.example.junittest.design.mode.factory.basic.AmericaCoffeeFactory;
import com.example.junittest.design.mode.factory.basic.ChinaCoffeeFactory;
import com.example.junittest.design.mode.factory.basic.CoffeeFactory;
import com.example.junittest.design.mode.factory.mode.Coffee;
import com.example.junittest.design.mode.factory.mode.Drink;
import com.example.junittest.design.mode.factory.mode.Sodas;
import com.example.junittest.design.mode.factory.mode.Tea;
import com.example.junittest.design.mode.factory.simple.SimpleFactory;
import com.example.junittest.design.mode.prototype.Person;
import com.example.junittest.entity.Base;
import com.example.junittest.entity.Derived;
import com.example.junittest.entity.User;
import com.example.junittest.enume.ColorEnum;
import com.example.junittest.service.TestService;
import com.example.junittest.util.UnitConverFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestControllerTest {

    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private TestService testService;
    @Resource
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
        User user = new User("root", "root");
        //拦截器那边会判断用户是否登录，所以这里注入一个用户
        session.setAttribute("user", user);
    }

    @Test
    public void getTestInfo() {
        Assert.assertThat(testService.testMethod(), is("测试有用"));
    }

    @Test
    public void unitConver() {
        List<String> list = UnitConverFactory.produceElectricEnergy().getValueAndUnitMap("1000000000.999", "kW");
        log.info("value============================>>" + list.get(0));
        log.info("unit=============================>>" + list.get(1));
    }

    @Test
    public void checkMaxValue() {
        List<String[]> valueList = new ArrayList<>(2);
        String[] s1 = new String[]{"0.0", "220.00", "280.00", "700.00", "0.00", "0.00", "0.00", "0.00", "0.0"};
        String[] s2 = new String[]{"10.0", "230.00", "260.00", "700.00", "0.00", "0.00", "0.00", "900.00", "0.0"};
        valueList.add(s1);
        valueList.add(s2);
        BigDecimal max = new BigDecimal("0.00");
        for (String[] strAy : valueList) {
            for (String str : strAy) {
                BigDecimal newValue = new BigDecimal(str);
                if (max.compareTo(newValue) <= 0) {
                    max = newValue;
                }
            }
        }
        log.info(max.toString());
    }

    @Test
    public void checkMaxValue2() {
        String[] s1 = new String[]{"0.0", "220.00", "280.00", "700.00", "0.00", "0.00", "0.00", "0.00", "0.0"};
        String[] s2 = new String[]{"10.0", "230.00", "260.00", "700.00", "0.00", "0.00", "0.00", "900.00", "0.0"};
        String[][] s = new String[2][];
        s[0] = s1;
        s[1] = s2;
        List<String[]> s6 = Arrays.asList(s);

        s6.forEach(e -> {
            for (String s3 : e) {
                System.out.println(s3);
            }
        });

        s6.forEach(new Consumer<String[]>() {
            @Override
            public void accept(String[] strings) {
                for (String s3 : strings) {
                    System.out.println(s3);
                }
            }
        });
    }

    @Test
    public void test1() {
        Base b = new Derived();
        b.methodOne();
    }

    @Test
    public void test2() {
        List<String> names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(e -> {
            System.out.println(e);
            System.out.println("222");
        });
    }

    @Test
    public void test3() {
        for (ColorEnum entity : ColorEnum.values()) {
            log.info(entity + "," + entity.ordinal() + "name:" + entity.name());
        }
    }

    @Test
    public void test4() {
        Coffee latte = SimpleFactory.createInstance("latte");
        System.out.println("创建的咖啡实例为:" + latte.getName());
        Coffee cappuccino = SimpleFactory.createInstance("cappuccino");
        System.out.println("创建的咖啡实例为:" + cappuccino.getName());
    }

    static void print(Coffee[] c) {
        for (Coffee coffee : c) {
            System.out.println(coffee.getName());
        }
    }

    @Test
    public void test5() {
        CoffeeFactory chinaCoffeeFactory = new ChinaCoffeeFactory();
        Coffee[] chinaCoffees = chinaCoffeeFactory.createCoffee();
        System.out.println("中国咖啡工厂可以生产的咖啡有：");
        print(chinaCoffees);
        CoffeeFactory americaCoffeeFactory = new AmericaCoffeeFactory();
        Coffee[] americaCoffees = americaCoffeeFactory.createCoffee();
        System.out.println("美国咖啡工厂可以生产的咖啡有：");
        print(americaCoffees);
    }

    static void print(Drink drink) {
        if (drink == null) {
            System.out.println("产品：--");
        } else {
            System.out.println("产品：" + drink.getName());
        }
    }

    @Test
    public void test6() {
        AbstractDrinksFactory chinaDrinksFactory = new ChinaDrinksFactory();
        Coffee coffee = chinaDrinksFactory.createCoffee();
        Tea tea = chinaDrinksFactory.createTea();
        Sodas sodas = chinaDrinksFactory.createSodas();
        System.out.println("中国饮品工厂有如下产品：");
        print(coffee);
        print(tea);
        print(sodas);

        AbstractDrinksFactory americaDrinksFactory = new AmericaDrinksFactory();
        coffee = americaDrinksFactory.createCoffee();
        tea = americaDrinksFactory.createTea();
        sodas = americaDrinksFactory.createSodas();
        System.out.println("美国饮品工厂有如下产品：");
        print(coffee);
        print(tea);
        print(sodas);
    }

    @Test
    public void test7() {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        log.info(cocaCola.toString());
        UserTo userTo = UserTo.builder().userName("zhangsan").acct("24k纯帅").pswd("123").build();
        log.info(userTo.toString());
    }

    @Test
    public void test8() {
        Person person = new Person();
        person.setName("zhangsan");
        List<String> list = new ArrayList<>(2);
        list.add("111");
        list.add("222");
        person.setList(list);
        Person person2 = person.clone();
        person2.getList().add("333");
        log.info(String.valueOf(person == person2));
        log.info(person.toString());
        log.info(person2.toString());
    }

    @Test
    public void test9() {
        GetCharge getCharge = new GetCharge();
        getCharge.putChargerToPlug();
        getCharge.charging();
    }

    @Test
    public void test10() {
        GetCharge getCharge = new GetCharge();
        getCharge.putChargerToPlug();
        getCharge.charging();
    }

    @Test
    public void test11() {
        RefinedAbstraction refinedAbstraction = new RefinedAbstraction(new ImplementorA());
        refinedAbstraction.operation();

    }

    @Test
    public void test12() {
        Double f = 6.20;
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);

    }

    @Test
    public void test13() {
        //有一个字符串里面有中文和英文,如何切割时保证中文不被切割?(代码实现)　
        String str = "张三abc李四abc";
        String[] strAy = str.split("[a-zA-Z]");
        for (String str2 : strAy) {
            System.out.println(str2);
        }
    }

    @Test
    public void test14() {
        List<String> str = new ArrayList<>(2);
        List<String> str1 = new LinkedList<>();
        Vector<String> str2 = new Vector<>(10);
        Set<String> set1 = new HashSet<>(10);
        Hashtable<String, String> table = new Hashtable<>(10);
        Map<String,String> map = new HashMap<>(2);
        map.put("a","123");
        map.put("b","456");
        map.get("a");
        int num = 20 + (20 >> 1);
        System.out.println(num);
    }

    @Test
    public void test15() {
        String dateStr = "2012-12-12 12:12:12";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
        //MD5加密
        String str = "123456";
        String md5Str = SecureUtil.md5(str);
        System.out.println(md5Str);
    }
    @Test
    public void test16(){
        //查询mongo数据
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "time_stamp"));
        //查询条件
        Criteria criteria = Criteria.where("time_stamp").gte("1");
        query.addCriteria(criteria);
        log.info(query.toString());
        List<Map> pointMap = mongoTemplate.find(query, Map.class, "SE13_J01_yaoce");
    }

}