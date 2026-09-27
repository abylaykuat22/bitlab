package servlets;

import db.DBCountriesConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.County;

@WebServlet(value = "/editCountry")
public class EditCountryServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    String name = req.getParameter("name");
    String shortName = req.getParameter("short_name");
    County county = new County();
    county.setId(id);
    county.setName(name);
    county.setShortName(shortName);
    DBCountriesConnector.editCountry(county);
    resp.sendRedirect("/countries");
  }
}
