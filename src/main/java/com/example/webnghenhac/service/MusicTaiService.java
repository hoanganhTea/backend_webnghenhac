package com.example.webnghenhac.service;

import com.example.webnghenhac.dto.request.MusicTaiRequest;
import com.example.webnghenhac.entity.AuthorTai;
import com.example.webnghenhac.entity.MusicTai;
import com.example.webnghenhac.exeception.AppException;
import com.example.webnghenhac.exeception.ErrorCode;
import com.example.webnghenhac.repository.AuthorTaiRepository;
import com.example.webnghenhac.repository.MusicTaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MusicTaiService {
    @Autowired
    private MusicTaiRepository musicTaiRepository;

    @Autowired
    private AuthorTaiRepository authorTaiRepository;

    public List<MusicTai> findAll() {
        return musicTaiRepository.findAll();
    }

    public MusicTai findById(UUID id) {
        return musicTaiRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MUSIC_NOT_FOUND));
    }

    public MusicTai createMusic(MusicTaiRequest request) {
        AuthorTai author = authorTaiRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new AppException(ErrorCode.AUTHOR_NOT_FOUND));

        MusicTai music = new MusicTai();
        music.setAuthor(author);
        music.setName(request.getName());
        music.setLink(request.getLink());
        music.setDescription(request.getDescription());
        music.setImage(request.getImage()); // Thêm xử lý image
        music.setPublic(request.isPublic());
        music.setPremium(request.isPremium());
        music.setPurchasePrice(request.getPurchasePrice());

        return musicTaiRepository.save(music);
    }

    public MusicTai updateMusic(UUID id, MusicTaiRequest request) {
        MusicTai music = findById(id);

        AuthorTai author = authorTaiRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new AppException(ErrorCode.AUTHOR_NOT_FOUND));

        music.setAuthor(author);
        music.setName(request.getName());
        music.setLink(request.getLink());
        music.setDescription(request.getDescription());
        music.setImage(request.getImage()); // Thêm xử lý image
        music.setPublic(request.isPublic());
        music.setPremium(request.isPremium());
        music.setPurchasePrice(request.getPurchasePrice());

        return musicTaiRepository.save(music);
    }

    public void deleteMusic(UUID id) {
        if (!musicTaiRepository.existsById(id)) {
            throw new AppException(ErrorCode.MUSIC_NOT_FOUND);
        }
        musicTaiRepository.deleteById(id);
    }
}
