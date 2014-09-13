package com.remast.baralga;

import com.remast.baralga.model.Project;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectRepository {

    String driver = "org.voltdb.jdbc.Driver";
    String url = "jdbc:voltdb://localhost:21212";

    public List<Project> findAll() {
    return Collections.emptyList();
    }

    public Project save(Project project) {
        try {
            final String id = UUID.randomUUID().toString();

            // Load driver. Create connection.
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);

            CallableStatement procedure = conn.prepareCall("{call PROJECT.insert(?, ?, ?, ?)}");
            procedure.setString(1, id);
            procedure.setString(2, project.getTitle());
            procedure.setString(3, project.getDescription());
            procedure.setInt(4, 1);

            ResultSet results = procedure.executeQuery();
            while (results.next()) {
                System.out.printf("Id: %s!\n", results.getInt(1));
            }

            project.setId(id);
            return project;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Project findById(String id) {
        try {
            // Load driver. Create connection.
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);

            // create a statement
            PreparedStatement query = conn.prepareStatement("SELECT * FROM project WHERE ID = ?");
            query.setString(1, id);;
            ResultSet results = query.executeQuery();

            while (results.next()) {
                Project project = new Project();
                project.setId(results.getString("id"));
                project.setTitle(results.getString("title"));
                project.setDescription(results.getString("description"));
                return project;
            }
            return null;

            //Close statements, connections, etc.
//            query.close();
            //            results.close();
            //            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
