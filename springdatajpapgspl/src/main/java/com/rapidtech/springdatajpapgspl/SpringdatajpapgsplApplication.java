package com.rapidtech.springdatajpapgspl;

import com.rapidtech.springdatajpapgspl.model.Book;
import com.rapidtech.springdatajpapgspl.model.BookCategory;
import com.rapidtech.springdatajpapgspl.model.Course;
import com.rapidtech.springdatajpapgspl.model.Student;
import com.rapidtech.springdatajpapgspl.repository.BookCategoryRepository;
import com.rapidtech.springdatajpapgspl.repository.BookRepository;
import com.rapidtech.springdatajpapgspl.repository.CourseRepository;
import com.rapidtech.springdatajpapgspl.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringdatajpapgsplApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpapgsplApplication.class, args);
    }
}
/*public class SpringdatajpapgsplApplication implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(SpringdatajpapgsplApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpapgsplApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookCategoryRepository bookCategoryRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public void run(String... args) throws Exception {*/
//		Book book1 = new Book();
//		book1.setTitle("Spring Boot in Action");
//		book1.setWritter("Ridwanda Safatain");
//		book1.setIsbn("IS-99887766");
//
//		Book book2 = new Book();
//		book2.setTitle("Spring Boot REST");
//		book2.setWritter("Mickhael Mors");
//		book2.setIsbn("IS-8877665");

//		bookRepository.save(book1);
//		bookRepository.save(book2);

//		BookCategory bookCategory1 = new BookCategory();
//		bookCategory1.setName("Novel");
//		BookCategory bookCategory2 = new BookCategory();
//		bookCategory2.setName("History");
//		bookCategoryRepository.save(bookCategory1);
//		bookCategoryRepository.save(bookCategory2);

		/*
		BookCategory bookCategory = new BookCategory("Programming",
				new Book("Belajar Java","Ridwanda Safatain","ISBN-77886699"),
				new Book("Belajar Spring Boot","Mickhael Mors","ISBN-99887766")
		);
		bookCategoryRepository.save(bookCategory);
		LOG.info("---- Berhasil Menambah dan Menyimpan Kategori");
		*/

		/*
		List<Book> books = bookRepository.findAll();
		LOG.info("----> Book : " +books.get(0).getTitle() );
		LOG.info("----> Book : " +books.get(1).getTitle());

		List<Book> bookByWriter = bookRepository.findAllByWritterContaining("Ridwanda");
		LOG.info("----> Book By Writer : "+bookByWriter.get(0).getTitle());

		Book myBook = bookRepository.findByIsbn("IS-99887766");
		LOG.info("----> Book By ISBN : " +myBook.getTitle());

		List<Book> booksByIsbn = bookRepository.findAllByIsbnContaining("88");
		for	(Book book:booksByIsbn) {
			LOG.info("----> Books by ISBN : " + book.getTitle());
		}

		List<Book> nativeQuery = bookRepository.findALlByQueryNative();
		for	(Book book:nativeQuery) {
			LOG.info("----> Books Native : " + book.getTitle());
		}

		List<Book> booksWriterNative = bookRepository.findAllByWritterNative("Ridwanda Safatain");
		for	(Book book:booksWriterNative) {
			LOG.info("----> Books Writer Native : " + book.getTitle());
		}

		LOG.info("---- Berhasil Menyimpan : " +book1.getTitle());
		LOG.info("---- Berhasil Menyimpan : " +book2.getTitle());*/

		/*
		Long myId = Long.valueOf(1);
		Optional<BookCategory> bookCat = bookCategoryRepository.findById(Long.valueOf(3));
		Optional<Book> editBook = bookRepository.findById(2l);
		if(editBook.isPresent()){
			Book bookEdit = editBook.get();
			bookEdit.setBookCategory(bookCat.get());
			bookRepository.save(bookEdit);

			LOG.info("----> Edit Book Category Success");
		}
		else {
			LOG.info("----> Id book tidak ditemukan");
		}
		*/

//		List<Book> books = bookRepository.findAll();
//		for(Book book : books){
//			LOG.info("----> Book : " + book.getTitle() + " - Category : " + book.getBookCategory().getName());
//		}

//		Optional<BookCategory> bookCatOpt = bookCategoryRepository.findById(3l);
//
//		if(bookCatOpt.isPresent()){
//			BookCategory bookCat = bookCatOpt.get();
//			List<Book> lstBook = bookRepository.findAllByBookCategory(bookCat);
//			bookCat.setBooks(lstBook);
////			LOG.info("----> "+bookCat.getBooks().get(0).getTitle());
//			for (Book books : lstBook){
//				LOG.info("----> "+books.getTitle());
//			}
//		}

//		Student student1 = new Student();
//		student1.setName("John");
//		student1.setAge(20);
//
//		Student student2 = new Student("Tom",19);
//		studentRepository.save(student1);
//		studentRepository.save(student2);
//		LOG.info("----> Berhasil menambahkan data student");

//		Course course1 = new Course("Introduction to Spring Boot",12,1000);
//		Course course2 = new Course("Restful API with Spring Boot",15,1200);
//		Course course3 = new Course("Spring Boot Microservices",12,1500);
//
//		courseRepository.saveAll(Arrays.asList(course1,course2,course3));
//		LOG.info("----> Berhasil menambahkan data courses");

//		Student student1 = studentRepository.findById(1l).get();
//		Course course1 = courseRepository.findById(3l).get();
//
////		student1.getCourses().addAll(Arrays.asList(course1));
//		student1.getCourses().add(course1);
//		studentRepository.save(student1);


//		List<Student> students = studentRepository.findAll();
//		for (Student student : students){
//			LOG.info("----> student :"+student.getName());
//			for (Course course : student.getCourses()){
//				LOG.info("--------> "+course.getTitle());
//			}
//		}
//
//		List<Course> courses = courseRepository.findAll();
//		for (Course course:courses){
//			LOG.info("---->" +course.getTitle());
//			for (Student student:course.getStudents()){
//				LOG.info("--------> "+student.getName());
//			}
//		}
//
//	}
//}
