import 'package:path/path.dart';
import 'student.dart';
import 'package:sqflite/sqflite.dart';
class DatabaseHelper {
  static const _databaseName = "studentdb.db";
  static const _databaseVersion = 1;
  static const table = 'student_table';
  static const columnId = 'id';
  static const columnName = 'name';
  static const columnRoll = 'roll';
  static const columnDiv = 'div';
  DatabaseHelper._privateConstructor();
  static final DatabaseHelper instance = DatabaseHelper._privateConstructor();
  static Database? _database;
  Future<Database?> get database async {
    if (_database != null) {
      return _database;
    }
    _database = await _initDatabase();
    return _database;
  }
  _initDatabase() async {
    String path = join(await getDatabasesPath(), _databaseName);
    return await openDatabase(path,
        version: _databaseVersion,
        onCreate: _onCreate);
  }
  Future _onCreate(Database db, int version) async {
    await db.execute('''
CREATE TABLE $table (
$columnId INTEGER PRIMARY KEY AUTOINCREMENT,
$columnName TEXT NOT NULL,
$columnRoll INTEGER NOT NULL,
$columnDiv TEXT NOT NULL
)
''');
  }
  Future<int> insert(Student student) async {Database? db = await instance.database;
  return await db!.insert(table, {'name': student.name, 'roll': student.roll, 'div': student.div});
  }
  Future<List<Map<String, dynamic>>> queryAllRows() async {
    Database? db = await instance.database;
    return await db!.query(table);
  }
  Future<List<Map<String, dynamic>>> queryRows(name) async {
    Database? db = await instance.database;
    return await db!.query(table, where: "$columnName LIKE '%$name%'");
  }
  Future<int?> queryRowCount() async {
    Database? db = await instance.database;
    return Sqflite.firstIntValue(await db!.rawQuery('SELECT COUNT(*) FROM $table'));
  }

  Future<int> update(Student student) async {
    Database? db = await instance.database;
    int id = student.toMap()['id'];
    return await db!.update(table, student.toMap(), where: '$columnId = ?', whereArgs: [id]);
  }
  Future<int> delete(int id) async {
    Database? db = await instance.database;
    return await db!.delete(table, where: '$columnId = ?', whereArgs: [id]);
  }
}