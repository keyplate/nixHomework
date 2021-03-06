package com.studentaccounting.app;

import com.studentaccounting.dao.StudentInfoService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        Metadata metadata = new MetadataSources(standardRegistry)
                .getMetadataBuilder()
                .build();

        try (SessionFactory sessionFactory = metadata.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            StudentInfoService studentInfoService = new StudentInfoService(session);
            System.out.println(studentInfoService.getStudentInfo(Long.parseLong(args[0])));
        }

    }
}
