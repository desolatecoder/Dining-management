package com.ctsdms.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctsdms.project.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{

}
