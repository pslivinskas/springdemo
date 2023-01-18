package lt.povilas.springdemo.controller;

import lt.povilas.springdemo.repository.model.ProductLines;
import lt.povilas.springdemo.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/productlinetemplate")
public class ProductLineTemplateController {

    @Autowired
    private ProductLineService productLineService;

    // http://localhost:8080/productlinetemplate/
    @GetMapping(path = "/test")
    public String getTestPage() {
        return "/test/test_page";
    }

    // http://localhost:8080/productlinetemplate/firstpage_productlines/productline

    @GetMapping(path = "/firstpage_productlines/productline/{name}")
    public String getProductLineWithFirstPage(Model model, @PathVariable String name) {

        ProductLines productLines = productLineService.getProductLineByName(name);
        model.addAttribute("product_line", productLines.getProductLine());
        model.addAttribute("text_description", productLines.getTextDescription());
        model.addAttribute("html_description", productLines.getHtmlDescription());

        return "/test/firstpage_productlines";
    }

    // http://localhost:8080/productlinetemplate/firstpage_productlines/productline/all
    @GetMapping(path = "/firstpage_productlines/productline/all")
    public String getAllProductLines(Model model) {

        List<ProductLines> productLinesList = productLineService.getAllProductLines();
        model.addAttribute("key_productLine_list", productLinesList);
        return "/test//firstpage_productlines_list";
    }
}