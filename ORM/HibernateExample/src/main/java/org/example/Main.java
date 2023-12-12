package org.example;

import java.sql.SQLException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.example.main.EstudianteDAO;
import org.example.model.Estudiante;
import org.example.util.HibernateUtil;

public class Main {

	public static void main(String[] args) throws SQLException, InterruptedException {

		EstudianteDAO.initialConfigurationDB(false);

		// Added some sleep time after open and close session to clear terminal
		HibernateUtil.newSession().close();
		TimeUnit.SECONDS.sleep(5);

		Estudiante est1 = new Estudiante("Pedro",5.5 , new Date());
		Estudiante est2 = new Estudiante("Mario",7.5 , new Date());
		Estudiante est3 = new Estudiante("Fran", 8.5, new Date());
		Estudiante est4 = new Estudiante("Alfredo",1.90 , new Date());

		EstudianteDAO.createEstudiante(est1, est2, est3,est4);
		EstudianteDAO.getEstudiante(2);
		EstudianteDAO.getEstudianteByName("Fran");
		EstudianteDAO.listAllEstudiantes();
		EstudianteDAO.createEstudiante(est1);
		EstudianteDAO.deleteEstudiante(est4.getId());
		EstudianteDAO.deleteQueryEstudiante(est3);
		EstudianteDAO.listAllEstudiantes();
		EstudianteDAO.updateEstudiante(est2);
		EstudianteDAO.listAllEstudiantes();
		EstudianteDAO.deleteAllEstudiantes();
	}

}
