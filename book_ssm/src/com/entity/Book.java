package com.entity;

public class Book {
    private Integer id;

    private String name;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookintroduction() {
        return bookintroduction;
    }

    public void setBookintroduction(String bookintroduction) {
        this.bookintroduction = bookintroduction;
    }

    public String getBookcontent() {
        return bookcontent;
    }

    public void setBookcontent(String bookcontent) {
        this.bookcontent = bookcontent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    private String bookname;
    private String bookintroduction;// ÈºÆΩÈ…‹
    private String bookcontent;// ÈºÆƒ⁄»›
    private Integer status;// ÈºÆ◊¥Ã¨ 0 Èø‚ 0 Èº‹
    private Integer isDeleted;

    private String category;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookintroduction='" + bookintroduction + '\'' +
                ", bookcontent='" + bookcontent + '\'' +
                ", status=" + status +
                ", isDeleted=" + isDeleted +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", times='" + times + '\'' +
                ", imgsrc='" + imgsrc + '\'' +
                ", txtsrc='" + txtsrc + '\'' +
                '}';
    }

    private String author;

    private String times;

    private String imgsrc;

    private String txtsrc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times == null ? null : times.trim();
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc == null ? null : imgsrc.trim();
    }

    public String getTxtsrc() {
        return txtsrc;
    }

    public void setTxtsrc(String txtsrc) {
        this.txtsrc = txtsrc == null ? null : txtsrc.trim();
    }
}