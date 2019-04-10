package us.aaron.controller;

import us.aaron.model.Item;
import us.aaron.model.ItemCatalog;
import us.aaron.model.ItemDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet")
public class BillController extends HttpServlet {
    private String RESULT_PAGE = "bill.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        // Get an array of Cookies associated with the this domain
        cookies = request.getCookies();
        PrintWriter out = response.getWriter();
        List<Item> items = new ArrayList();
        items.add(new Item(0," ",0.0,false," "," "));
        if( cookies != null ) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.print(cookie.getValue());
                if (cookie.getName().equals("cartItem")) {
                    items = orderedItems( cookie.getValue( ));
                }
            }
        }
        request.setAttribute("catalog", items);

        RequestDispatcher view =
            request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    protected List<Item> orderedItems(String itemsNumbers) {
        List<Item> items = new ArrayList<>();
        ItemDaoImpl cat = new ItemDaoImpl();
        String[] nums = itemsNumbers.split(",");
        for (int i=0;i<nums.length;i++) {
            if (nums[i].length() > 0)
                items.add(cat.getItem(Integer.parseInt(nums[i])));
        }
        return items;
    }
}