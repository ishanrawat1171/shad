package net.codejava.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.DAO.RrfDao;
import net.codejava.DAO.UpdateExam;

import net.codejava.model.Member;
import net.codejava.model.Rrf;
import net.codejava.model.listofexam;
 
@Service
@Transactional
public class Updaterrfservices {
 @Autowired
    private RrfDao repo;
     
    public List<Rrf> listAll() {
        return repo.findAll();
    }
     
    public void save(Rrf lia) {
        repo.save(lia);
    }
     
    public Rrf get(int Sno) {
        return repo.findById(Sno);
    }
  
}