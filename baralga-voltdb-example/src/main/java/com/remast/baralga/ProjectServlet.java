package com.remast.baralga;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(value="/project")
public class ProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String driver = "org.voltdb.jdbc.Driver";
        String url = "jdbc:voltdb://localhost:21212";
        String sql = "SELECT id, title, description FROM project";

        try {
            // Load driver. Create connection.
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);

            // create a statement
            Statement query = conn.createStatement();
            ResultSet results = query.executeQuery(sql);

            final PrintWriter writer = response.getWriter();
            writer.println("[");
            while (results.next()) {
                writer.println(String.format("{ \"id\": %s, \"title\": \"%s\" }", results.getInt("id"), results.getString("title")));
            }
            writer.println("]");

            //Close statements, connections, etc.
            query.close();
            results.close();
            conn.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

}
