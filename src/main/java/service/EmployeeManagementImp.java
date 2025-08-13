package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class EmployeeManagementImp implements EmployeeManagement {

    @Override
    public int setEmployee(Employee employee) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.persist(employee);
            session.close();
            sessionFactory.close();
            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

}
