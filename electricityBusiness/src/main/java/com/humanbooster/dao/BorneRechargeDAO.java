package com.humanbooster.dao;

import com.humanbooster.model.BorneRecharge;

public class BorneRechargeDAO extends GenericDAOImpl<BorneRecharge, Long> implements GenericDAO<BorneRecharge, Long> {
    public BorneRechargeDAO(boolean verbose) {
        super(BorneRecharge.class, verbose);
    }
}
