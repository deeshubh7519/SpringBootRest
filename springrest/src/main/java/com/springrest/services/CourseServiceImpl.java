package com.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	/* List<Course> list; */

	public CourseServiceImpl() {

		/*
		 * list = new ArrayList<>(); list.add(new Course(101, "JavaCore",
		 * "This Course Contain basic of java")); list.add(new Course(102,
		 * "Spring Boot", "This code contain Rest Api")); list.add(new Course(103,
		 * "Spring Rest", "This code contain Course Info"));
		 */
	}

	@Override
	public List<Course> getCourses() {

		/* return list; */
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseId) {

		/*
		 * Course c = null;
		 * 
		 * for (Course course : list) {
		 * 
		 * if (course.getId() == courseId) { c = course; break; } }
		 * 
		 * return c;
		 */

		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {

		/*
		 * list.add(course); return course;
		 */
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {

		/*
		 * list.forEach(e -> { if (e.getId() == course.getId()) {
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription()); }
		 * });
		 * 
		 * return course;
		 */

		courseDao.save(course);
		return course;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long courseId) {

		/*
		 * list = this.list.stream().filter(e -> e.getId() !=
		 * courseId).collect(Collectors.toList());
		 */

		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
	}

}
