import 'database_helper.dart';
class Student {
  final int? id;
  final String? name;
  final int? roll;
  final String? div;
  Student(this.id, this.name, this.roll, this.div);
  Student.fromMap(Map<String, dynamic> map)
      :id = map['id'],
        name = map['name'],
        roll = map['roll'],
        div = map['div'];
  Map<String, dynamic> toMap() {
    return {
      DatabaseHelper.columnId: id,
      DatabaseHelper.columnName: name,
      DatabaseHelper.columnRoll: roll,
      DatabaseHelper.columnDiv: div,
    };
  }
}