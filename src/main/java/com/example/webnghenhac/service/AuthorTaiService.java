package com.example.webnghenhac.service;

import com.example.webnghenhac.dto.request.AuthorTaiCreationRequest;
import com.example.webnghenhac.dto.request.AuthorTaiUpdateRequest;
import com.example.webnghenhac.entity.AuthorTai;
import com.example.webnghenhac.exeception.AppException;
import com.example.webnghenhac.exeception.ErrorCode;
import com.example.webnghenhac.repository.AuthorTaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorTaiService {
    @Autowired
    private AuthorTaiRepository authorTaiRepository;

    public List<AuthorTai> findAll() {
        return authorTaiRepository.findAll();
    }

    public AuthorTai findById(UUID id) {
        return authorTaiRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.AUTHOR_NOT_FOUND));
    }

    public AuthorTai createAuthor(AuthorTaiCreationRequest request) {
        // Kiểm tra xem tác giả đã tồn tại chưa
        if (authorTaiRepository.existsByFullName(request.getFullName())) {
            throw new AppException(ErrorCode.AUTHOR_ALREADY_EXISTS);
        }
        System.out.println("isPublic: " + request.isPublic()); // In giá trị isPublic

        AuthorTai author = new AuthorTai();
        author.setFullName(request.getFullName());
        author.setBirthday(request.getBirthday());
        author.setDescription(request.getDescription());
        author.setImage(request.getImage()); // Thêm xử lý ảnh
        author.setPublic(Boolean.TRUE.equals(request.isPublic()));




        return authorTaiRepository.save(author);
    }

    public AuthorTai updateAuthor(UUID id, AuthorTaiUpdateRequest request) {
        AuthorTai author = findById(id);
        author.setFullName(request.getFullName());
        author.setBirthday(request.getBirthday());
        author.setDescription(request.getDescription());
        author.setImage(request.getImage()); // Thêm xử lý ảnh
        author.setPublic(request.isPublic());

        return authorTaiRepository.save(author);
    }

    public void deleteAuthor(UUID id) {
        if (!authorTaiRepository.existsById(id)) {
            throw new AppException(ErrorCode.AUTHOR_NOT_FOUND);
        }
        authorTaiRepository.deleteById(id);
    }
}
