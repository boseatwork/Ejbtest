package com.mycompany.hello;

import com.mycompany.ejb.*;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.*;
import java.util.ArrayList;

@Named(value = "courseWeb")
@SessionScoped
public class CourseWeb implements Serializable {
    private String name;
    private String code;
    private String level;
    private String language;
    private String teacher;
    private int courseId;
    private List<Course2> courses;
    private List<Course2> searchList;
    private List<LocalDate> courseDates;
    
    @Inject
    private CourseRegistry courseRegistry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public CourseRegistry getCourseRegistry() {
        return courseRegistry;
    }

    public void setCourseRegistry(CourseRegistry courseRegistry) {
        this.courseRegistry = courseRegistry;
    }
    
    public List<Course2> getCourses() {
        System.out.println("getCourses");
        courses = courseRegistry.getCourses();
        for(Course2 c: courses) System.out.println(c.getName());
        return courses;
    }
    
    public List<LocalDate> getCourseDates(){
        courseDates = new ArrayList<>();
        LocalDate today = LocalDate.now();
        courseDates.add(today);
        for (int x = 1; x <= 10; x++){
            courseDates.add(today.minusDays(x));
        }
        return courseDates;
    }
    
    public List<Course2> getSearchList() {
        System.out.println("getSearchList");
        return searchList;
    }
      
    public void addCourse() {
        System.out.println("addCourse");
        courseRegistry.addCourse(name, code, level, language, teacher);
        name = "";
        code = "";
        level = "";
        language = "";
        teacher = "";
    }
    
    public void prepareChange() {
        System.out.println("prepareChange");
        Course2 course = courseRegistry.getFromDB(courseId);
        this.name = course.getName();
        this.code = course.getCode();
        this.level = course.getLevel();
        this.language = course.getLanguage();
        this.teacher = course.getTeacher();
    }
    
    public void change() {
        System.out.println("change");
        courseRegistry.change(courseId, name, code, level, language, teacher);
        name = "";
        code = "";
        level = "";
        language = "";
        teacher = "";
    }
    
    public void removeCourse() {
        System.out.println("removeCourse");
        courseRegistry.removeCourse(courseId);
    }

     public void doSearch() {
        if (name==null) return;
        System.out.println("doSearch");
        searchList = courseRegistry.searchCourses(name, code);
     }
}
