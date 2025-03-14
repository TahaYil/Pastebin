package com.taa.okullab.controller;


import com.taa.okullab.dto.PastebinDto;
import com.taa.okullab.entity.Pastebin;
import com.taa.okullab.service.PastebinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pastebin")
@CrossOrigin
public class PastebinController {

    private final PastebinService pastebinService;

    public PastebinController(PastebinService pastebinService) {
        this.pastebinService = pastebinService;
    }

    @GetMapping("/{hash}")
    public ResponseEntity<Pastebin>  getPastebin(@PathVariable String hash) {
        return ResponseEntity.ok(pastebinService.getByHash(hash));
    }
    @GetMapping("/gelAll")
    public ResponseEntity<List<Pastebin>> getAllPastebin() {
        return ResponseEntity.ok(pastebinService.getPastebinList());
    }

    @PostMapping("/create")
    public  ResponseEntity<String> create(@RequestBody PastebinDto pastebinDto) {
        Pastebin pastebin = new Pastebin();
        String hash= pastebinService.generatePastebin(pastebinDto);
        return ResponseEntity.ok(hash);
    }


}
