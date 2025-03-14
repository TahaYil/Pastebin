package com.taa.okullab.service;


import com.taa.okullab.dao.PastebinDao;
import com.taa.okullab.dto.PastebinDto;
import com.taa.okullab.entity.Pastebin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PastebinService {

    private final PastebinDao pastebinDao;

    public PastebinService(PastebinDao pastebinDao) {
        this.pastebinDao = pastebinDao;
    }


    public String codeGenerate(){
        String hash = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        return hash;
    }
//!!!!! api ları yaz !!!
    public String generatePastebin(PastebinDto pastebinDto){
        String hash=codeGenerate();
        Pastebin pastebin=new Pastebin();
        pastebin.setHash(hash);
        pastebin.setName(pastebinDto.getName());
        pastebin.setContent(pastebinDto.getContent());
        pastebin.setDescription(pastebinDto.getDestcription());
        pastebin.setExpireDate(pastebinDto.getExpireDate());



        pastebinDao.save(pastebin);
        return hash;
    }
    public List<Pastebin> getPastebinList(){
        List<Pastebin> list=new ArrayList<>();
        list=pastebinDao.findAll().stream()
                .filter(pastebin ->pastebin.getExpireDate().after(new Date())||pastebin.getExpireDate()==null)
                .collect(Collectors.toList());;
        return list;
    }
    public Pastebin getByHash(String hash){
        return pastebinDao.findByHash(hash);
    }
}
