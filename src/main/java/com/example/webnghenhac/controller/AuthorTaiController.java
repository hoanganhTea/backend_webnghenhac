package com.example.webnghenhac.controller;

import com.example.webnghenhac.dto.request.ApiResponse;
import com.example.webnghenhac.dto.request.AuthorTaiCreationRequest;
import com.example.webnghenhac.dto.request.AuthorTaiUpdateRequest;
import com.example.webnghenhac.dto.request.UserCreationRequest;
import com.example.webnghenhac.entity.AuthorTai;
import com.example.webnghenhac.entity.User;
import com.example.webnghenhac.service.AuthorTaiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/authors")
public class AuthorTaiController {
    @Autowired
    private AuthorTaiService authorTaiService;

    @GetMapping
    public List<AuthorTai> getAllAuthors() {
        return authorTaiService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorTai getAuthorById(@PathVariable("id") UUID id) {
        return authorTaiService.findById(id);
    }

    @PostMapping
    public ApiResponse<AuthorTai> createAuthor(@RequestBody @Valid AuthorTaiCreationRequest request) {
        ApiResponse<AuthorTai> apiResponse = new ApiResponse<>();
        apiResponse.setResult(authorTaiService.createAuthor(request));
        return apiResponse;
    }
   

    @PutMapping("/{id}")
    public AuthorTai updateAuthor(@PathVariable("id") UUID id, @RequestBody @Valid AuthorTaiUpdateRequest request) {
        return authorTaiService.updateAuthor(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id") UUID id) {
        authorTaiService.deleteAuthor(id);
        return ResponseEntity.ok("{\"message\": \"Author has been deleted\"}");
    }
}
