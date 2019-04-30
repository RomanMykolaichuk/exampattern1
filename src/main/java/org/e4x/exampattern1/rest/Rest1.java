/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.e4x.exampattern1.rest;

import org.e4x.exampattern1.files.FilesReadWrite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Rest1 {

    @GetMapping("/file")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "file1") String name, Model model) {
        model.addAttribute("name", name);
        FilesReadWrite frw = new FilesReadWrite("classpath:config/" + name + ".txt");
        String[] content1;
        content1 = frw.readFile().split("####");
        model.addAttribute("content", content1);
        model.addAttribute("size", content1.length);
        return "file";
    }

}
