package vesit.ajayk.mc.practical4.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM Student")
    List<Student> getAll();
    @Query("SELECT * FROM Student WHERE id IN (:ids)")
    List<Student> loadAllByIds(int[] ids);
    @Query("SELECT * FROM Student WHERE name LIKE :name LIMIT 1")
    Student findByName(String name);
    @Insert
    void insertAll(Student... students);
    @Delete
    void delete(Student student);
}