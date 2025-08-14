package controller;

import java.io.IOException;

import entity.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EmployeeManagementImp;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Employee employee = new Employee(username, password);

        EmployeeManagementImp emplManImpl = new EmployeeManagementImp();
        int setEmployee = emplManImpl.setEmployee(employee);

        if (setEmployee == 1) {
            resp.sendRedirect("success.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }
}
