package student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// 1. 테스트 실행 순서를 @Order 어노테이션으로 제어하도록 설정
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentManagerTest {
    
    // 2. @BeforeAll은 static 메서드여야 하므로 객체도 static으로 선언합니다.
    static StudentManager manager;

    @BeforeAll
    static void setUpAll() {
        manager = new StudentManager();
    }

    // [순서 1] 학생 추가 테스트 -> 이제 "홍길동"이 등록된 상태가 됩니다.
    @Test
    @Order(1)
    void testAddStudent() {
        manager.addStudent("홍길동");
        assertTrue(manager.hasStudent("홍길동"));
    }

    // [순서 2] 중복 추가 예외 처리 -> "홍길동"이 이미 있으므로 예외가 발생해야 합니다.
    @Test
    @Order(2)
    void testDuplicateAddStudentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addStudent("홍길동");
        });
    }

    // [순서 3] 학생 제거 테스트 -> "홍길동"을 지웁니다. 이제 리스트는 비어있게 됩니다.
    @Test
    @Order(3)
    void testRemoveStudent() {
        manager.removeStudent("홍길동");
        assertFalse(manager.hasStudent("홍길동"));
    }

    // [순서 4] 존재하지 않는 학생 제거 예외 처리 -> 앞서 "홍길동"을 지웠거나 없는 학생을 지우므로 예외가 발생합니다.
    @Test
    @Order(4)
    void testNonExistentRemoveStudentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeStudent("임꺽정");
        });
    }
}
