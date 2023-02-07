package sg.edu.nus.iss.day12_workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.day12_workshop.model.Item;
import sg.edu.nus.iss.day12_workshop.service.ItemService;

@Controller
@RequestMapping(path = {"/shoppingCart"})
public class ItemController {

    @Autowired
    ItemService itmSvc;

    @GetMapping(produces = "text/html")
    public String displayCart(Model model) {
        List<Item> items = itmSvc.retrieveItemList();
        model.addAttribute("cartItems", items);
        return "cartList";
    }

}
