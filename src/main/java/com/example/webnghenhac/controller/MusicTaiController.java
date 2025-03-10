package com.example.webnghenhac.controller;

import com.example.webnghenhac.dto.request.MusicTaiRequest;
import com.example.webnghenhac.entity.MusicTai;
import com.example.webnghenhac.service.MusicTaiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*") // Cho phép tất cả frontend truy cập
@RestController
@RequestMapping("/music")
public class MusicTaiController {
    @Autowired
    private MusicTaiService musicTaiService;

    @GetMapping
    public List<MusicTai> getAllMusic() {
        return musicTaiService.findAll();
    }

    @GetMapping("/{id}")
    public MusicTai getMusicById(@PathVariable("id") UUID id) {
        return musicTaiService.findById(id);
    }

    @PostMapping
    public ResponseEntity<MusicTai> createMusic(@RequestBody @Valid MusicTaiRequest request) {
        return ResponseEntity.ok(musicTaiService.createMusic(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicTai> updateMusic(@PathVariable("id") UUID id, @RequestBody MusicTaiRequest request) {
        return ResponseEntity.ok(musicTaiService.updateMusic(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMusic(@PathVariable("id") UUID id) {
        musicTaiService.deleteMusic(id);
        return ResponseEntity.ok("{\"message\": \"Music has been deleted\"}");
    }
}
