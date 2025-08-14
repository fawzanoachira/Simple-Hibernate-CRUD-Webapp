package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class EmployeeManagementImp implements EmployeeManagement {

    @Override
    public int setEmployee(Employee employee) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Transaction beginTransaction = session.beginTransaction();
            session.persist(employee);
            beginTransaction.commit();

            session.close();
            sessionFactory.close();

            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

}
