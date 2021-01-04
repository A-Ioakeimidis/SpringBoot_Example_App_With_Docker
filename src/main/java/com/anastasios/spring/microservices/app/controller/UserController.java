package com.anastasios.spring.microservices.app.controller;

import com.anastasios.spring.microservices.app.beans.Post;
import com.anastasios.spring.microservices.app.beans.User;
import com.anastasios.spring.microservices.app.dao.PostRepository;
import com.anastasios.spring.microservices.app.dao.UserRepository;
import com.anastasios.spring.microservices.app.exeptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "/allusers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Uses HATEOAS concepts
    @GetMapping(path = "/finduser/{id}")
    public EntityModel<User> findUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        //HATEOAS
        //adds links using the methods, eg getAllUsers()
        EntityModel<User> resource = EntityModel.of(user.get());

        // Specifies which method in which class
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());


        //add link to method getAllUsers
        resource.add(linkTo.withRel("getAllUsers"));

        //return the resource
        return resource;
    }

    @GetMapping(path = "/users/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }
        return user.get().getPosts();
    }


    /**
     * @param user the user
     * @return saved User
     */
    @PostMapping(path = "/createuser")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        // @Valid used to validate the User (name, birthdate) passed into the method
        User savedUser = userRepository.save(user);

        // Will append to th URI the newly created users id
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    /**
     * @param id   the id of the user
     * @param post the users post
     * @return saved User
     */
    @PostMapping(path = "/users/{id}/posts")
    public ResponseEntity<User> createUserPost(@PathVariable Integer id, @RequestBody Post post) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }

        User user = userOptional.get();
        post.setUser(user);
        postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/deleteUserById/{id}")
    public void deleteUserById(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}