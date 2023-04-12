package com.aucasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aucasa.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
