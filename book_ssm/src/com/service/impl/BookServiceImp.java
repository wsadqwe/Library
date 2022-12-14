package com.service.impl;

import com.dao.BookMapper;
import com.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImp {
    @Autowired
    private BookMapper BookMapper;

    public void update(Book Book) {
        this.BookMapper.updateByPrimaryKeySelective(Book);
    }

    public void del(String id) {
        this.BookMapper.deleteByPrimaryKey(Integer.parseInt(id));
    }

    public Book selectById(String id) {
        return this.BookMapper.selectByPrimaryKey(Integer.parseInt(id))
                ;
    }

    public int add(Book Book) {

        List<Book> collect2 = queryAll().stream().filter(x -> x.getId().equals(Book.getId())).collect(Collectors.toList());

        if (!collect2.isEmpty()) {
            return 1;
        }


        this.BookMapper.insertSelective(Book)
        ;
        return 0;
    }

    public List<Book> queryAll() {
        return BookMapper.queryAll();
    }
}
