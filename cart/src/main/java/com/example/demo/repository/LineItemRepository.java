package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LineItem;

public interface LineItemRepository extends JpaRepository<LineItem, Long> {
}