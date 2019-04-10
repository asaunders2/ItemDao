package us.aaron.controller;

import us.aaron.model.Item;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class DeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Enumeration paramNames = request.getParameterNames();
        String paramName;
        String deleteId = "";
        Cookie[] cookies = null;
        String ids = "";

        while(paramNames.hasMoreElements()) {
            paramName = (String)paramNames.nextElement();
            if(paramName.equals("deleteItem")) {
                String[] paramValues = request.getParameterValues(paramName);
                // Read single valued data
                if (paramValues.length == 1) {
                    deleteId = paramValues[0];
                }
            }
        }


        // Get an array of Cookies associated with the this domain
        cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("cartItem")){
                String[] nums = cookie.getValue().split(",");
                for (int i = 0; i < nums.length; i++){
                    if (!deleteId.equals(nums[i])){
                        ids += nums[i] + ",";
                    }
                }
            }
        }
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("cartItem")){
                cookie.setMaxAge(0);
            }
        }

        Cookie items = new Cookie("cartItem", ids);
        // Set expiry date after 24 Hrs for both the cookies.
        items.setMaxAge(60*60*24);
        response.addCookie( items );

        String site = new String("cart.go");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }
}
