package com.blogservice.blog.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.blogservice.blog.entities.Post;
import com.blogservice.blog.entities.PostComment;
import com.blogservice.blog.entities.TagModel;
import com.blogservice.blog.entities.UserModel;
import com.blogservice.blog.model.PostCommentDto;
import com.blogservice.blog.model.PostDto;
import com.blogservice.blog.model.ResponseMessage;
import com.blogservice.blog.repo.PostCommentRepo;
import com.blogservice.blog.repo.PostRepo;
import com.blogservice.blog.repo.TagRepo;
import com.blogservice.blog.repo.UserModelRepo;
import com.blogservice.blog.util.Constants;

@Service
public class PostService {

	@Autowired
	PostRepo postRepo;

	@Autowired
	PostCommentRepo commentRepo;
	
	@Autowired
	TagRepo tagRepo;

	public ResponseMessage savePost(PostDto userDto) {
		try {
			
			Post post = Post.builder()
							.authorId(userDto.getAuthorId())
							.content(userDto.getContent())
							.title(userDto.getTitle())
							.build();
			
			
			Set<TagModel> tags = createTags(userDto.getTags());
	        post.setTags(tags);
	        
			postRepo.save(post);
			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.TRANSACTION_SUCCESS).errorMessage("Success")
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.TRANSACTION_SUCCESS).errorMessage("Success")
					.build();
		}
	}
	
	private Set<TagModel> createTags(List<Long> tagValues) {
        Set<TagModel> tags = new HashSet<>();
        for (Long tagId :tagValues) {
            TagModel tag = tagRepo.findById(tagId).orElseThrow(() -> new RuntimeException("Tag not found: " + tagId));
            tags.add(tag);
        }
        return tags;
    }

	public List<Post> getPostByAuthor(Post userDto) {
		Optional<List<Post>> postOp = Optional.ofNullable(postRepo.findByAuthorId(userDto.getAuthorId()));
		if (postOp.isEmpty()) {
			return null;
		} else {
			return (List<Post>) postOp.get();
		}

	}

	public ResponseMessage addComment(PostCommentDto postDto) {
		try {
			Optional<Post> optionalPost = postRepo.findById(postDto.getPostId());
			if (optionalPost.isPresent()) {
				Post post = optionalPost.get();
				
				PostComment comment = new PostComment();
				comment.setComment(postDto.getComment());
				comment.setPost(post);

				commentRepo.save(comment);

				return ResponseMessage.builder().errorCode(Constants.ErrorCodes.TRANSACTION_SUCCESS)
						.errorMessage("Success").build();
			} else {
				return ResponseMessage.builder().errorCode(Constants.ErrorCodes.POST_NOT_FOUND)
						.errorMessage("Post not found").build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMessage.builder().errorCode(Constants.ErrorCodes.TRANSACTION_FAILED)
					.errorMessage("Failed to add comment").build();
		}
	}

	public List<PostComment> getCommentByPost(Post postDto) {
		Optional<List<PostComment>> postOp = Optional.ofNullable(commentRepo.findByPost_PostId(postDto.getPostId()));
		if (postOp.isEmpty()) {
			return null;
		} else {
			return (List<PostComment>) postOp.get();
		}
	}
	
}
