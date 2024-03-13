package com.blogservice.blog.controlr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogservice.blog.entities.Post;
import com.blogservice.blog.entities.PostComment;
import com.blogservice.blog.model.PostCommentDto;
import com.blogservice.blog.model.PostDto;
import com.blogservice.blog.model.ResponseMessage;
import com.blogservice.blog.service.PostService;
import com.blogservice.blog.util.Constants;

@RestController
public class PostController {

	
	@Autowired
    private PostService postService;
	

    @PostMapping("/savePost")
    public ResponseEntity<ResponseMessage> savePost(@RequestBody PostDto userDto) {
    	ResponseMessage  res = postService.savePost(userDto);
    	if(res.getErrorCode() == Constants.ErrorCodes.TRANSACTION_SUCCESS) {
    		 return ResponseEntity.ok(res);
    	}
    	else {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
    	}
    }

    @PostMapping("/getPostByAuthor")
    public ResponseEntity<List<Post>> getPostByAuthor(@RequestBody Post userDto) {
    	return  ResponseEntity.ok(postService.getPostByAuthor(userDto));
    }
    
    
    @PostMapping("/addComment")
    public ResponseEntity<ResponseMessage> addComment(@RequestBody PostCommentDto postDto) {
    	ResponseMessage  res = postService.addComment(postDto);
    	if(res.getErrorCode() == Constants.ErrorCodes.TRANSACTION_SUCCESS) {
    		 return ResponseEntity.ok(res);
    	}
    	else {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
    	}
    }
    
    @PostMapping("/getCommentByPost")
    public ResponseEntity<List<PostComment>> getCommentByPost(@RequestBody Post userDto) {
    	return  ResponseEntity.ok(postService.getCommentByPost(userDto));
    }
}
