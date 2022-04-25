package com.system.app.web.repo.tests;

import java.util.Date;

import com.system.app.web.beans.AtendType;
import com.system.app.web.beans.Atendimento;
import com.system.app.web.repo.AtendRepo;
import com.system.app.web.repo.AttTypeRepo;
import com.system.app.web.repo.DAOException;
import com.system.app.web.repo.ProductRepo;
import com.system.app.web.repo.UserRepo;

public class AtendimentoTest {

    public static void main(String[] args) {

        AtendRepo atendRepo = new AtendRepo();
        ProductRepo productRepo = new ProductRepo();
        UserRepo userRepo = new UserRepo();
        AttTypeRepo attTypeRepo = new AttTypeRepo();

        try {
            Atendimento atendimento = new Atendimento();
            atendimento.setProduct(productRepo.getByID(1));
            atendimento.setData(new Date());
            atendimento.setDescription("descricao");
            AtendType atendType = attTypeRepo.getByID(1);
            atendimento.setType(atendType);
            atendimento.setClient(userRepo.getByID(6));
            atendimento.setStatus("em andamento");
            atendRepo.save(atendimento);
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
