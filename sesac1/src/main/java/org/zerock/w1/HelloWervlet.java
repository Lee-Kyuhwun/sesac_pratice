package org.zerock.w1;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hellowServlet", value = "/hello-servlet")
public class HelloWervlet extends HttpServlet {

    private String message;


    public void init() {
        message="Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");

        // Use a PrintWriter to send text data to the client who has made a request to the servlet
        PrintWriter out = response.getWriter();

        // Begin generating the HTML response
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + message + "</h1>");

        out.println("</body></html>");
    }

    public void destroy() {
        // This function is called when the servlet is terminated by the server
        // You can add clean-up code here if needed. It's the last method called before destroying servlet
        System.out.println("Servlet is being destroyed");
    }
}