package com.system.app.web.repo.tests;

import com.system.app.web.beans.AtendType;
import com.system.app.web.repo.AttTypeRepo;

public class AtendimentoTeste {
    public static void main(String[] args) {
        AtendType atendType = new AtendType();
        atendType.setName("tipo");

        try {
            AttTypeRepo atendRepo = new AttTypeRepo();
            atendRepo.save(atendType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
