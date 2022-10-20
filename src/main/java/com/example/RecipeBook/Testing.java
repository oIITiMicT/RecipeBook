package com.example.RecipeBook;

import com.example.RecipeBook.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Testing {

    public void test() {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Permission.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Ingredient.class)
                .addAnnotatedClass(Message.class)
                .addAnnotatedClass(Picture.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Recipe.class)
                .addAnnotatedClass(Step.class)
                .addAnnotatedClass(Structure.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, 1L);
        System.out.println(user);
        session.getTransaction().commit();
    }

    public static void main(String[] args) {

    }
}
