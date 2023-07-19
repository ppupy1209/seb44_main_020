package com.moovda_project.moovda.module.staff.repository;

import com.moovda_project.moovda.module.staff.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Long> {
    Staff findByName(String name);
}
