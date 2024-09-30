package com.boubyan.student_management.service.impl;

import com.boubyan.student_management.entity.CourseEntity;
import com.boubyan.student_management.entity.ScheduleEntity;
import com.boubyan.student_management.mapper.CourseMapper;
import com.boubyan.student_management.model.request.CourseRequest;
import com.boubyan.student_management.model.response.CourseResponse;
import com.boubyan.student_management.repository.CourseRepository;
import com.boubyan.student_management.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class DefaultCourseService implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final long EXPIRY_TIME = 5 ;

    @Override
    public List<CourseResponse> getAllCourses() {
        List<CourseResponse> courseResponseList = new ArrayList<>();
        courseResponseList = (List<CourseResponse>) redisTemplate.opsForValue().get("courseResponseList");
        if (courseResponseList ==null) {
            courseResponseList = CourseMapper.INSTANCE.mapToCourseResponseList(courseRepository.findAll());
            redisTemplate.opsForValue().set("courseResponseList", courseResponseList, EXPIRY_TIME, TimeUnit.MINUTES);
        }
        return courseResponseList;
    }

    @Transactional
    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {
        CourseEntity courseEntity =  CourseMapper.INSTANCE.mapToCourseEntity(courseRequest);
        courseEntity.getSchedule().setCourse(courseEntity);
        CourseEntity savedCourseEntity = courseRepository.save(courseEntity);
        return CourseMapper.INSTANCE.mapToCourseResponse(savedCourseEntity);
    }

    @Override
    public ResponseEntity<byte[]> generateCourseSchedulePdf(Long courseId) {

        byte[] pdfBytes = generateCourseSchedulePdfById(courseId);

        if (pdfBytes == null) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=course_schedule_" + courseId + ".pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

    private byte[] generateCourseSchedulePdfById(Long courseId) {
        Optional<CourseEntity> courseOptional = courseRepository.findById(courseId);

        if (!courseOptional.isPresent()) {
            return null; // Return null if course is not found
        }

        CourseEntity course = courseOptional.get();
        ScheduleEntity schedule = course.getSchedule();

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();

            // Add course and schedule details
            document.add(new Paragraph("Course Schedule for: " + course.getCourseName()));
            document.add(new Paragraph("Course Code: " + course.getCourseCode()));

            if (schedule != null) {
                document.add(new Paragraph("Start Date: " + schedule.getStartDate()));
                document.add(new Paragraph("End Date: " + schedule.getEndDate()));
                document.add(new Paragraph("Time Slot: " + schedule.getTimeSlot()));
                document.add(new Paragraph("Days of the Week: " + schedule.getDaysOfWeek()));
                document.add(new Paragraph("Location: " + schedule.getLocation()));
            } else {
                document.add(new Paragraph("Schedule: Not Available"));
            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }
}
