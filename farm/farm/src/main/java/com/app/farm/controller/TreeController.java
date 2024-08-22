package com.app.farm.controller;

import com.app.farm.model.Tree;
import com.app.farm.model.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/trees")
public class TreeController {

//    @Autowired
//    private GroupService groupService;
//
//    @Autowired
//    private GroupRepository groupRepository;
//

    @Autowired
    private  TreeRepository treeRepository;


    public TreeController(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    @GetMapping("/all")
    public List getGroups(){
        return treeRepository.findAll();
    }

    @GetMapping("/test")
    public ResponseEntity<String> getTest(){

        return ResponseEntity.ok("TestAll");
    }

    @GetMapping("/{id}/{name}")
    List<Tree> getTree(@PathVariable String id,
                       @PathVariable String name) {
        return treeRepository.findByIdAndName(id,name);
    }


//    @PostMapping("/tree")
//    Tree createTree(@RequestBody Tree newTree) throws URISyntaxException {
//        return treeRepository.save(newTree);
//    }

    @PostMapping("/tree")
    ResponseEntity createTree(@RequestBody Tree newTree) throws URISyntaxException {
        treeRepository.save(newTree);
        return  ResponseEntity.created(new URI("/trees/" + newTree.getId())).body(newTree);
    }


    @PutMapping("/update/{id}/{name}")
    public ResponseEntity updateTree(@PathVariable String id,
                                     @PathVariable String name,
                                     @RequestBody Tree tree) {
        List<Tree> listTrees = treeRepository.findByIdAndName(id,name);
        Tree currentTree = listTrees.get(0);
        currentTree.setName(tree.getName());
        currentTree = treeRepository.save(tree);
        return ResponseEntity.ok(currentTree);
    }


    @DeleteMapping("remove/{id}")
    public ResponseEntity deleteClient(@PathVariable String id) {
        treeRepository.deleteById(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }


}
