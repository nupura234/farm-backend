package com.app.farm.controller;


import com.app.farm.model.Plot;
import com.app.farm.model.PlotRepository;
import com.app.farm.model.Tree;
import com.app.farm.model.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

//GET /api/v1/plots : returns a list of plots along with their properties
//GET /api/v1/plots/<id>: returns information about a single plot with ID=<id>
//POST /api/v1/plots: create a new plot with the necessary properties
//PUT /api/v1/plots/<id>: update the plot properties with ID=<id>
//DELETE /api/v1/plots/<id>: delete plot with ID=<id>

@RestController
@RequestMapping("api/v1/plots")
public class PlotController {

    @Autowired
    private PlotRepository plotRepository;


    public PlotController(PlotRepository plotRepository) {
        this.plotRepository = plotRepository;
    }

    @GetMapping("/all")
    public List getGroups(){
        return plotRepository.findAll();
    }

    @GetMapping("/{id}/{area}")
    List<Plot> getPlot(@PathVariable String id,
                       @PathVariable String area) {
        return plotRepository.findByIdAndArea(id,area);
    }

    @PostMapping("/plot")
    ResponseEntity createPlot(@RequestBody Plot newPlot) throws URISyntaxException {
        plotRepository.save(newPlot);
        return  ResponseEntity.created(new URI("/plots/" + newPlot.getPlotid())).body(newPlot);
    }


    @PutMapping("/update/{id}/{area}")
    public ResponseEntity updatePlot(@PathVariable String id,
                                     @PathVariable String area,
                                     @RequestBody Plot plot) {
        List<Plot> listPlots = plotRepository.findByIdAndArea(id,area);
        Plot currentTree = listPlots.get(0);
        currentTree.setPlotid(plot.getPlotid());
        currentTree = plotRepository.save(plot);
        return ResponseEntity.ok(currentTree);
    }


    @DeleteMapping("remove/{id}")
    public ResponseEntity deletePlot(@PathVariable String id) {
        plotRepository.deleteById(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }


}
