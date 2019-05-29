package com.example.demo.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;

@Service//("customerService")
public class MockCustomerServiceImpl implements CustomerService {
	// サンプル用のMock実装であるため、
    // synchronized等の同期処理は一切おこなわない。
    private Map<Integer, Customer> customerMap
                            = new LinkedHashMap<Integer, Customer>();

    private int nextId = 1;

    private boolean isExists(int id) {
        return customerMap.containsKey(id);
    }

    public List<Customer> findAll() {
        return new ArrayList<Customer>(customerMap.values());
    }

    public Customer findById(int id) throws Exception {
        if (!isExists(id)) {
            throw new Exception();
        }
        return customerMap.get(id);
    }

    public Customer register(Customer customer) {
        customer.setId(nextId++);
        customerMap.put(customer.getId(), customer);

        return customer;
    }

    public void update(Customer customer) throws Exception {
        if (!isExists(customer.getId())) {
            throw new Exception();
        }
        customerMap.put(customer.getId(), customer);
    }

    public void delete(int id) throws Exception {
        if (!isExists(id)) {
            throw new Exception();
        }
        customerMap.remove(id);
    }

    public boolean isFreeEmailCustomer(Customer customer) {
        // この実装では、
        // Customer#isFreeEmailを呼び出してその結果を返すだけ
        return customer.isFreeEmail();
    }

    @PostConstruct
    public void initCustomer() {
        nextId = 1;

        register(new Customer("太郎", "東京都新宿区", "taro@aa.bb.cc"));
        register(new Customer("次郎", "東京都豊島区", "jiro@aa.bb.cc"));
        register(new Customer("三郎", "東京都板橋区", "sabu@aa.bb.cc"));
    }
}
