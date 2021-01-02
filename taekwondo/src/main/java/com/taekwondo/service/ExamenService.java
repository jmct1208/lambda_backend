package com.taekwondo.service;

import java.util.List;

import com.taekwondo.model.Examen;
import com.taekwondo.model.ExamenDTO;

public interface ExamenService {
	
	public abstract ExamenDTO getExamenDto(int id);
	public abstract List<ExamenDTO> getExamenes();
	public abstract List<ExamenDTO> getExamenesAlumno(int id);
	public void createExamen(Examen examen);
	public void updateExamen(Examen examen, int id);
	public void addAlumno(int idExamen, int idAlumno);
	public void deleteAlumno(int idExamen, int idAlumno);
	public void deleteExamen(int id);

}
