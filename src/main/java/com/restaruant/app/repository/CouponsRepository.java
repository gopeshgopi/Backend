package com.restaruant.app.repository;

import com.restaruant.app.entity.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponsRepository extends JpaRepository<Coupons,String> {
}
