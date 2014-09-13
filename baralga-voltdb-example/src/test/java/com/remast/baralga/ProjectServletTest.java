package com.remast.baralga;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectServletTest {

    @Test
    public void testDoPost() throws Exception {
    ProjectServlet projectServlet = new ProjectServlet();
        projectServlet.doPost(null, null);
    }
}
