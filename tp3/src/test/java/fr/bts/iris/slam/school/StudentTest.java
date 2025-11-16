package fr.bts.iris.slam.school;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
    }

    // === CONSTRUCTOR GLOBAL ===

    @Test
    void shouldCreateStudentWithValidParameters() {
        // ACT + ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");

        // ASSERT
        assertEquals("STU000", student.getId());
        assertEquals("last_name", student.getLast_name());
        assertEquals("first_name", student.getFirst_name());
        assertEquals(18, student.getAge());
        assertEquals("last_name.first_name@email.com", student.getEmail());
    }

    // === CONSTRUCTOR ID ===

    @Test
    void shouldRefuseNoDigitInId() {
        // ARRANGE + ACT + ASSERT
        IllegalArgumentException error_message = assertThrows(IllegalArgumentException.class, () -> student = new Student("STU", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertEquals("Student ID must match pattern STU### (e.g., STU001)", error_message.getMessage());
    }

    @Test
    void shouldRefuseToShortId() {
        // ARRANGE + ACT + ASSERT
        IllegalArgumentException error_message = assertThrows(IllegalArgumentException.class, () -> student = new Student("STU1", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertEquals("Student ID must match pattern STU### (e.g., STU001)", error_message.getMessage());
    }

    @Test
    void shouldRefuseToLongId() {
        // ARRANGE + ACT + ASSERT
        IllegalArgumentException error_message = assertThrows(IllegalArgumentException.class, () -> student = new Student("STU4444", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertEquals("Student ID must match pattern STU### (e.g., STU001)", error_message.getMessage());
    }

    @Test
    void shouldRefuseBeginningMissingId() {
        // ARRANGE + ACT + ASSERT
        IllegalArgumentException error_message = assertThrows(IllegalArgumentException.class, () -> student = new Student("123", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertEquals("Student ID must match pattern STU### (e.g., STU001)", error_message.getMessage());
    }

    @Test
    void shouldRefuseLowerCaseId() {
        // ARRANGE + ACT + ASSERT
        IllegalArgumentException error_message = assertThrows(IllegalArgumentException.class, () -> student = new Student("stu000", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertEquals("Student ID must match pattern STU### (e.g., STU001)", error_message.getMessage());
    }

    @Test
    void shouldRefuseNoDigitInI2d() {
        // ARRANGE + ACT + ASSERT
        IllegalArgumentException error_message = assertThrows(IllegalArgumentException.class, () -> student = new Student("STU", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertEquals("Student ID must match pattern STU### (e.g., STU001)", error_message.getMessage());
    }

    @Test
    void shouldRefuseSpaceInId() {
        // ARRANGE + ACT + ASSERT
        IllegalArgumentException error_message = assertThrows(IllegalArgumentException.class, () -> student = new Student("STU 000", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertEquals("Student ID must match pattern STU### (e.g., STU001)", error_message.getMessage());
    }

    @Test
    void shouldRefuseNullOrEmptyId() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student(null, "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("", "last_name", "first_name", 18, "last_name.first_name@email.com"));
    }

    // === CONSTRUCTOR LAST NAME ===

    @Test
    void shouldRefuseNullOrEmptyLast_name() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", null, "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "", "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", " ", "first_name", 18, "last_name.first_name@email.com"));
    }

    @Test
    void shouldRefuseLast_nameSmallerThan2() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "A", "first_name", 18, "last_name.first_name@email.com"));
    }

    // === CONSTRUCTOR FIRST NAME ===

    @Test
    void shouldRefuseNullOrEmptyFirst_name() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", null, 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", " ", 18, "last_name.first_name@email.com"));
    }

    @Test
    void shouldRefuseFirst_nameSmallerThan2() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "A", 18, "last_name.first_name@email.com"));
    }

    // === CONSTRUCTOR AGE ===

    @Test
    void shouldRefuseAgeSmallerThan16() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "A", 15, "last_name.first_name@email.com"));
    }

    @Test
    void shouldRefuseAgeBiggerThan65() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "A", 66, "last_name.first_name@email.com"));
    }

    // === CONSTRUCTOR EMAIL ===

    @Test
    void shouldRefuseEmailWithoutAddressSign() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "A", 18, "last_name.first_nameemail.com"));
    }

    @Test
    void shouldRefuseEmailWithoutDotAfterAddressSign() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "A", 18, "last_name.first_name@emailcom"));
    }

    // === CONSTRUCTOR GRADE ===

    @Test
    void shouldBe0OnNumberOfGradesOnNewStudentCreated() {
        // ACT + ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");

        // ASSERT
        assertEquals(0, student.getGrades().size());
    }

    // === ADD GRADE ===

    @Test
    void shouldAddGradeToStudent() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = 10;

        // ACT
        student.addGrade(grade);

        // ASSERT
        // assertTrue(Arrays.equals(student.getGrades().toArray(), new Double[]{10.0}));
        // assertArrayEquals(new Double[]{10.0}, student.getGrades().toArray());
        assertIterableEquals(List.of(10.0), student.getGrades());
    }

    @Test
    void shouldAddMultipleGradeToStudent() {
        // ARRANGE
        double grade = 10;
        double second_grade = 10;
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");

        // ACT
        student.addGrade(grade);
        student.addGrade(second_grade);

        // ASSERT
        assertIterableEquals(List.of(10.0, 10.0), student.getGrades());
    }

    @Test
    void shouldRefuseToAddGradeLowerThan0ToStudent() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = -1;

        // ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(grade));
    }

    @Test
    void shouldRefuseToAddGradeSuperiorThan20ToStudent() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = 21;

        // ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(grade));
    }

    // === AVERAGE GRADE ===

    @Test
    void shouldAverageGrade() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = 10;

        // ACT
        student.addGrade(grade);

        // ASSERT
        assertEquals(10.0, student.getAverage());
    }

    @Test
    void shouldAverageMultipleGrade() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = 0;
        double second_grade = 20;

        // ACT
        student.addGrade(grade);
        student.addGrade(second_grade);

        // ASSERT
        assertEquals(10.0, student.getAverage());
    }

    @Test
    void shouldNotAverageWhenGradeIsEmpty() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");

        // ACT + ASSERT
        assertThrows(IllegalStateException.class, () -> student.getAverage());
    }

    // === PASSING GRADE ===

    @Test
    void shouldPassWhenGradeIsOrBiggerThan10() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = 10;

        // ACT
        student.addGrade(grade);

        // ASSERT
        assertTrue(student.hasPassingGrade());
    }

    @Test
    void shouldNotPassWhenGradeIsLowerThan10() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = 9.9;

        // ACT
        student.addGrade(grade);

        // ASSERT
        assertFalse(student.hasPassingGrade());
    }

    @Test
    void shouldNotPassWhenThereIsNoGrade() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");

        // ASSERT
        assertFalse(student.hasPassingGrade());
    }

    // === METHODS GETTER ===

    @Test
    void shouldGetFullName() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");

        // ASSERT
        assertEquals("last_name first_name", student.getFullName());
    }

    @Test
    void shouldGetMultipleGradeCount() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = 0;
        double second_grade = 20;

        // ACT
        student.addGrade(grade);
        student.addGrade(second_grade);

        // ASSERT
        assertEquals(2, student.getGradeCount());
    }

    @Test
    void shouldGet0FromGradeCountIfEmpty() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");

        // ASSERT
        assertEquals(0, student.getGradeCount());
    }

    @Test
    void shouldGetBestGrade() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = 12;
        double second_grade = 14;
        double third_grade = 11;

        // ACT
        student.addGrade(grade);
        student.addGrade(second_grade);
        student.addGrade(third_grade);

        // ASSERT
        assertEquals(14, student.getBestGrade());
    }

    @Test
    void shouldGet0FromBestGradeIfEmpty() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");

        // ASSERT
        assertEquals(0.0, student.getBestGrade());
    }

    @Test
    void shouldGetWorstGrade() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = 13;
        double second_grade = 11;
        double third_grade = 16;

        // ACT
        student.addGrade(grade);
        student.addGrade(second_grade);
        student.addGrade(third_grade);

        // ASSERT
        assertEquals(11, student.getWorstGrade());
    }

    @Test
    void shouldGet0FromWorstGradeIfEmpty() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");

        // ASSERT
        assertEquals(0.0, student.getWorstGrade());
    }

    @Test
    void shouldGrades() {
        // ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = 0;
        double second_grade = 20;

        // ACT
        student.addGrade(grade);
        student.addGrade(second_grade);

        // ASSERT
        assertIterableEquals(List.of(0.0, 20.0), student.getGrades());
    }

    @Test
    void shouldNotModifyGrades() {
        // ARRANGE
        Student student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");
        double grade = 15;
        double second_grade = 20;

        // ACT
        student.addGrade(grade);
        List<Double> notes = student.getGrades();
        notes.add(second_grade);

        // ASSERT
        assertIterableEquals(List.of(15.0), student.getGrades());
    }

}
