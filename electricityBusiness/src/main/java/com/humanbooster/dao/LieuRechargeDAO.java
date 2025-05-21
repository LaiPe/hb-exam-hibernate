package com.humanbooster.dao;

import com.humanbooster.model.LieuRecharge;

public class LieuRechargeDAO extends GenericDAOImpl<LieuRecharge, Long> implements GenericDAO<LieuRecharge, Long> {
    public LieuRechargeDAO(boolean verbose) {
        super(LieuRecharge.class, verbose);
    }
}
