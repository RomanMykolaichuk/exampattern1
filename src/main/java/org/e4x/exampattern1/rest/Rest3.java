/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.e4x.exampattern1.rest;

import java.util.ArrayList;
import org.e4x.exampattern1.files.FilesReadWrite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Rest3 {

    @GetMapping("/file3")
     public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Book1") String name, Model model/*, ArrayList<Goods> goods*/) {
        model.addAttribute("name", name);
        FilesReadWrite frw = new FilesReadWrite("classpath:config/" + name + ".txt");
        String[] content1;
        content1 = frw.readFile().split(";");
        model.addAttribute("content", content1);
        model.addAttribute("size", content1.length);

        /*for (int i = 0; i < content1.length / 6; i++) {
            goods.add(new User(content1[i * 6 + 1],
                    content1[i * 6 + 2], content1[i * 6 + 5]));

        }
        goodsRepository.saveAll(goods);
        model.addAttribute("goods", goodsRepository.findAll());*/

        return "index";
    }

}
