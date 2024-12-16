package com.BusReservation.Repository;

import com.BusReservation.Entity.StopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopOrderRepository extends JpaRepository<StopOrder, Long> {
}