package com.campusVirtual.mapper;



public class CourseMapper {
    /* 

    @Autowired
    ICourseService cursoService;

    public Course cursoDtoToCurso(CourseDto cursoDto) {
        Course nuevoCurso = new Course(cursoDto.getNombre());
        return nuevoCurso;
    }

    public CourseDto cursoToCursoDto(Course curso){
       CourseDto cursoDto= new CourseDto(curso.getId(),curso.getNombre());

       return cursoDto;
    }

    public List<CourseDto> manyCursoToCursoDto(List<Course>  cursos) {
        List<CourseDto> cursosDtos = new ArrayList<>();
        
        for (Course curso : cursos) {
            cursosDtos.add(
                cursoToCursoDto(curso)
            );
        }

        return cursosDtos;
    }
    


    public List<CourseDto> manyAlumnoEnCursoToCursoDto(List<StudentInCourse> alumnoEnCurso) {
        List<CourseDto> cursosDto = new ArrayList<CourseDto>();

        for (StudentInCourse aec : alumnoEnCurso) {
            cursosDto.add(
                cursoToCursoDto(aec.getCurso())
            );
        }
        
        return cursosDto;
    }


    public List<CourseDto> manyProfesorEnCursoToCursoDto(List<ProfessorInCourse> profesorEnCurso) {
        List<CourseDto> cursosDto = new ArrayList<CourseDto>();
        
        for (ProfessorInCourse pec : profesorEnCurso) {
            cursosDto.add(
                cursoToCursoDto(pec.getCurso())
            );
        }
        
        return cursosDto;
    }
*/
}
