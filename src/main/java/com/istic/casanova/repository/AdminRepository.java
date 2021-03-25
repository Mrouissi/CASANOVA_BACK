package com.istic.casanova.repository;

import com.istic.casanova.model.Admin;

import javax.transaction.Transactional;

@Transactional
public interface AdminRepository extends AbstractRepository<Admin>{
}
