package bitlab.servlet;

import bitlab.db.BrandDB;
import bitlab.db.ItemDB;
import bitlab.entity.Brand;
import bitlab.entity.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/item") // http://localhost:8080/item
public class ItemServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<Brand> brands = BrandDB.findAll();
    List<Item> items = ItemDB.findAll();
    req.setAttribute("brandter", brands);
    req.setAttribute("zattar", items);
    req.getRequestDispatcher("item.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("name");
    String description = req.getParameter("description");
    Double price = Double.parseDouble(req.getParameter("price"));
    Long brandId = Long.parseLong(req.getParameter("brandId"));

    Brand brand = new Brand();
    brand.setId(brandId);

    Item item = new Item();
    item.setName(name);
    item.setDescription(description);
    item.setPrice(price);
    item.setBrand(brand);

    ItemDB.createItem(item);
    resp.sendRedirect("/item");
  }
}
