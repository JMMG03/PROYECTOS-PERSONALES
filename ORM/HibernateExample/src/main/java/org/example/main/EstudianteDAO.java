package org.example.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.example.model.Estudiante;
import org.example.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

public class EstudianteDAO {

	 public static void initialConfigurationDB(boolean cleanInstallation) {
	        try {
	            if (cleanInstallation) {
	                Configuration configuration = new Configuration()
	                        .configure("hibernate-" + HibernateUtil.hibernateType + "-" + HibernateUtil.database + ".cfg.xml");

	                String url = configuration.getProperty("hibernate.connection.url");
	                String user = configuration.getProperty("hibernate.connection.username");
	                String password = configuration.getProperty("hibernate.connection.password");

	                try (Connection connection = DriverManager.getConnection(url, user, password)) {
	                    String dropTableSQL = "DROP TABLE IF EXISTS Estudiantes;";
	                    try (Statement statement = connection.createStatement()) {
	                        statement.executeUpdate(dropTableSQL);

	                        String createTableSQL = "CREATE TABLE Estudiantes (" +
	                                "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
	                                "nombre VARCHAR(20) DEFAULT NULL," +
	                                "nota DOUBLE DEFAULT NULL," +
	                                "created_at DATETIME DEFAULT NULL" +
	                                ");";
	                        statement.executeUpdate(createTableSQL);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Maneja o registra la excepción según sea necesario
	        }
	    }

    public static void createEstudiante(Estudiante... estudiantes) {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("-------------------- crearEstudiante ---------------------");
        System.out.println("----------------------------------------------------------");

        Session session = HibernateUtil.newSession();
        session.beginTransaction();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == 0) { 
                session.persist(estudiante);
                System.out.println("INSERT - " + estudiante.toString());
            } else {
                // Manejar el caso en que la entidad ya existe
                System.out.println("El estudiante con ID " + estudiante.getId() + " ya existe en la base de datos.");
            }
        }

        session.getTransaction().commit();
        session.close();
    }

    public static Estudiante getEstudiante(int id) {
        try {
            System.out.println("\n----------------------------------------------------------");
            System.out.println("---------------------- obtenerEstudiante -----------------------");
            System.out.println("----------------------------------------------------------");

            Session session = HibernateUtil.newSession();

            try {
                Estudiante est = session.get(Estudiante.class, id);
                System.out.println("GET - " + est.toString());
                return est;
            } catch (Exception e) {
                e.printStackTrace(); // Handle or log the exception as needed
                return null;
            } finally {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception as needed
            return null;
        }
    }

    public static List<Estudiante> getEstudianteByName(String nombre) {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("------------------- ObtenerNombreEstudiante -------------------");
        System.out.println("----------------------------------------------------------");

        Session session = HibernateUtil.newSession();
        Query<Estudiante> query = session.createQuery("FROM Estudiante where nombre = :nombre", Estudiante.class);
        query.setParameter("nombre", nombre);
        List<Estudiante> estudiantes = query.list();
        for (Estudiante est : estudiantes) {
            System.out.println("NOMBRE - " + est.toString());
        }
        session.close();
        return estudiantes;
    }

    public static List<Estudiante> listAllEstudiantes() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("-------------------- ListarTodosLosAlumnos --------------------");
        System.out.println("----------------------------------------------------------");

        Session session = HibernateUtil.newSession();
        Query<Estudiante> queryEstudiantes = session.createQuery("FROM Estudiante", Estudiante.class);
        List<Estudiante> estudiantes = queryEstudiantes.list();
        for (Estudiante est : estudiantes) {
            System.out.println("QUERY - " + est.toString());
        }
        session.close();

        return estudiantes;
    }

    public static void updateEstudiante(Estudiante est) {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("--------------------- actualizarEstudiante ---------------------");
        System.out.println("----------------------------------------------------------");

        est.setNombre("Lucas");

        Session session = HibernateUtil.newSession();
        session.beginTransaction();
        session.merge(est);
        session.getTransaction().commit();

        System.out.println("UPDATE - " + est.toString());
        session.close();
    }

    public static void deleteEstudiante(Estudiante est) {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("------------------ borrarEstudiante (est) ------------------");
        System.out.println("----------------------------------------------------------");

        Session session = HibernateUtil.newSession();
        session.beginTransaction();
        session.remove(est);
        session.getTransaction().commit();

        System.out.println("REMOVE - " + est.toString());
        session.close();
    }

    public static void deleteEstudiante(int id) {
        Estudiante est = getEstudiante(id);
        deleteEstudiante(est);
    }

    public static void deleteQueryEstudiante(Estudiante est) {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("------------------- deleteQueryEstudiante ------------------");
        System.out.println("----------------------------------------------------------");

        Session session = HibernateUtil.newSession();

        String hql = "delete Estudiante where id = :id";
        MutationQuery q = session.createMutationQuery(hql);
        q.setParameter("id", est.getId());

        session.beginTransaction();
        q.executeUpdate();
        session.getTransaction().commit();

        System.out.println("DELETE - " + est.toString());

        session.close();
    }
    public static void deleteAllEstudiantes() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("----------------- borrarTodosLosEstudiantes -----------------");
        System.out.println("----------------------------------------------------------");

        Session session = HibernateUtil.newSession();
        session.beginTransaction();

        String hql = "delete from Estudiante";
        Query<?> query = session.createQuery(hql);
        int deletedCount = query.executeUpdate();

        session.getTransaction().commit();

        System.out.println("DELETE ALL - Se eliminaron " + deletedCount + " estudiantes.");
        session.close();
    }

}
