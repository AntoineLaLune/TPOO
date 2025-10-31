package fr.bts.iris.slam.school;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
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
    void shouldRefuseIncorectIdOnStudentParameters() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU1", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU22", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU4444", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("S123", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("123", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("stu000", "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU 000", "last_name", "first_name", 18, "last_name.first_name@email.com"));
    }

    @Test
    void shouldRefuseNullOrEmptyIdOnStudentParameters() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student(null, "last_name", "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("", "last_name", "first_name", 18, "last_name.first_name@email.com"));
    }

    // === CONSTRUCTOR LAST NAME ===

    @Test
    void shouldRefuseNullOrEmptyLast_nameOnStudentParameters() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", null, "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "", "first_name", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", " ", "first_name", 18, "last_name.first_name@email.com"));
    }

    @Test
    void shouldRefuseLast_nameSmallerThan2OnStudentParameters() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "A", "first_name", 18, "last_name.first_name@email.com"));
    }

    // === CONSTRUCTOR FIRST NAME ===

    @Test
    void shouldRefuseNullOrEmptyFirst_nameOnStudentParameters() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", null, 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "", 18, "last_name.first_name@email.com"));
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", " ", 18, "last_name.first_name@email.com"));
    }

    @Test
    void shouldRefuseFirst_nameSmallerThan2OnStudentParameters() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "A", 18, "last_name.first_name@email.com"));
    }

    // === CONSTRUCTOR AGE ===

    @Test
    void shouldRefuseAgeSmallerThan16OnStudentParameters() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "A", 15, "last_name.first_name@email.com"));
    }

    @Test
    void shouldRefuseAgeBiggerThan65OnStudentParameters() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "A", 66, "last_name.first_name@email.com"));
    }

    // === CONSTRUCTOR EMAIL ===

    @Test
    void shouldRefuseEmailWithoutAddressSignOnStudentParameters() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "A", 18, "last_name.first_nameemail.com"));
    }

    @Test
    void shouldRefuseEmailWithoutDotAfterAddressSignOnStudentParameters() {
        // ARRANGE + ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> student = new Student("STU000", "last_name", "A", 18, "last_name.first_name@emailcom"));
    }

    // === NOTE ===

    @Test
    void shouldBe0OnNumberOfNotesOnNewStudentCreated() {
        // ACT + ARRANGE
        student = new Student("STU000", "last_name", "first_name", 18, "last_name.first_name@email.com");

        // ASSERT
        assertEquals(0, student.getNotes().size());
    }

    @Test
    void shouldAddNoteToStudent() {
        // ARRANGE
        double note = 10;

        // ACT
        student.addNote(note);

        // ASSERT
        assertEquals(10, student.getNotes());
    }

    @Test
    void shouldAddMultipleNoteToStudent() {
        // ARRANGE
        double note = 10;
        double second_note = 10;

        // ACT
        student.addNote(note);
        student.addNote(second_note);


        // ASSERT
        assertEquals(10, student.getNotes().get(0));
        assertEquals(10, student.getNotes().get(1));
    }
}
