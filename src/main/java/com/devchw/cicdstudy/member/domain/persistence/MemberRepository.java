package com.devchw.cicdstudy.member.domain.persistence;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepository {

    private final Map<Long, MemberEntity> storage = new HashMap<>();
    private static Long sequence = 0L;

    public MemberEntity save(MemberEntity member) {
        member.setId(++sequence);
        storage.put(member.getId(), member);
        return storage.get(member.getId());
    }

    public Optional<MemberEntity> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<MemberEntity> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(Long memberId) {
        storage.remove(memberId);
    }

    public void clear() {
        storage.clear();
    }

    public MemberEntity merge(MemberEntity member, Long memberId) {
        storage.put(memberId, member);
        return storage.get(memberId);
    }

    @PostConstruct
    public void init() {
        save(new MemberEntity("userA", 29));
        save(new MemberEntity("userB", 30));
        save(new MemberEntity("userC", 31));
        save(new MemberEntity("userD", 32));
        save(new MemberEntity("userE", 33));
    }
}
