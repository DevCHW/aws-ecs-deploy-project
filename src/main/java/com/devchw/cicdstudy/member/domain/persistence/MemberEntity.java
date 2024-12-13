package com.devchw.cicdstudy.member.domain.persistence;

public class MemberEntity {
    private Long id;
    private String name;
    private int age;

    public MemberEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
