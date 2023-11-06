import 'package:flutter/material.dart';
import 'student.dart';
import 'database_helper.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Sqlite',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final dbHelper = DatabaseHelper.instance;
  List<Student> students = [];
  List<Student> studentByName = [];
  TextEditingController nameController = TextEditingController();
  TextEditingController rollController = TextEditingController();
  TextEditingController divController = TextEditingController();
  TextEditingController idUpdateController = TextEditingController();
  TextEditingController nameUpdateController = TextEditingController();
  TextEditingController rollUpdateController = TextEditingController();
  TextEditingController divUpdateController = TextEditingController();
  TextEditingController idDeleteController = TextEditingController();
  TextEditingController queryController = TextEditingController();
  final GlobalKey<ScaffoldState> _scaffoldKey = GlobalKey<ScaffoldState>();

  void _showMessageInScaffold(String message) {
    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
      content: Text(message),
    ));
  }

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 5,
      child: Scaffold(
        key: _scaffoldKey,
        appBar: AppBar(
          bottom: const TabBar(
            tabs: [
              Tab(
                text: "Insert",
              ),
              Tab(
                text: "View",
              ),
              Tab(
                text: "Query",
              ),
              Tab(
                text: "Update",
              ),
              Tab(
                text: "Delete",
              ),
            ],
          ),
          title: const Text('Flutter SQLite Student DB Example'),
        ),
        body: TabBarView(
          children: [
            Center(
              child: Column(
                children: <Widget>[
                  Container(
                    padding: const EdgeInsets.all(20),
                    child: TextField(
                      controller: nameController,
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Student Name',
                      ),
                    ),
                  ),
                  Container(
                    padding: const EdgeInsets.all(20),
                    child: TextField(
                      controller: rollController,
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Roll No',
                      ),
                    ),
                  ),
                  Container(
                    padding: const EdgeInsets.all(20),
                    child: TextField(
                      controller: divController,
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Division',
                      ),
                    ),
                  ),
                  ElevatedButton(
                    child: const Text('Insert Student Details'),
                    onPressed: () {
                      String name = nameController.text;
                      int roll = int.parse(rollController.text);
                      String div = divController.text;
                      _insert(name, roll, div);
                    },
                  ),
                ],
              ),
            ),
            ListView.builder(
              padding: const EdgeInsets.all(20),
              itemCount: students.length + 1,
              itemBuilder: (BuildContext context, int index) {
                if (index == students.length) {
                  return ElevatedButton(
                    child: const Text('Refresh'),
                    onPressed: () {
                      setState(() {
                        _queryAll();
                      });
                    },
                  );
                }
                return SizedBox(
                  height: 60,
                  child: Center(
                    child: Text(
                      'ID: ${students[index].id}, NAME: ${students[index].name}, ROLL: ${students[index].roll}, DIV: ${students[index].div}',
                      style: const TextStyle(fontSize: 18),
                    ),
                  ),
                );
              },
            ),
            Center(
              child: SingleChildScrollView(
                  child: ConstrainedBox(
                constraints: const BoxConstraints(),
                child: Column(
                  children: <Widget>[
                    Container(
                      padding: const EdgeInsets.all(20),
                      height: 100,
                      child: TextField(
                        controller: queryController,
                        decoration: const InputDecoration(
                          border: OutlineInputBorder(),
                          labelText: 'NAME',
                        ),
                        onChanged: (text) {
                          if (text.length >= 2) {
                            setState(() {
                              _query(text);
                            });
                          } else {
                            setState(() {
                              studentByName.clear();
                            });
                          }
                        },
                      ),
                    ),
                    SizedBox(
                      height: 300,
                      child: ListView.builder(
                        padding: const EdgeInsets.all(8),
                        itemCount: studentByName.length,
                        itemBuilder: (BuildContext context, int index) {
                          return Container(
                            height: 50,
                            margin: const EdgeInsets.all(2),
                            child: Center(
                              child: Text(
                                'ID: ${studentByName[index].id}, NAME: ${studentByName[index].name}, ROLL NO: ${studentByName[index].roll}, DIV: ${studentByName[index].div}',
                                style: const TextStyle(fontSize: 18),
                              ),
                            ),
                          );
                        },
                      ),
                    ),
                  ],
                ),
              )),
            ),
            Center(
              child: Column(
                children: <Widget>[
                  Container(
                    padding: const EdgeInsets.all(20),
                    child: TextField(
                      controller: idUpdateController,
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Student ID',
                      ),
                    ),
                  ),
                  Container(
                    padding: const EdgeInsets.all(20),
                    child: TextField(
                      controller: nameUpdateController,
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'NAME',
                      ),
                    ),
                  ),
                  Container(
                    padding: const EdgeInsets.all(20),
                    child: TextField(
                      controller: rollUpdateController,
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'ROLL NO',
                      ),
                    ),
                  ),
                  Container(
                    padding: const EdgeInsets.all(20),
                    child: TextField(
                      controller: divUpdateController,
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'DIVISION',
                      ),
                    ),
                  ),
                  ElevatedButton(
                    child: const Text('Update Student Details'),
                    onPressed: () {
                      int id = int.parse(idUpdateController.text);
                      String name = nameUpdateController.text;
                      int roll = int.parse(rollUpdateController.text);
                      String div = divUpdateController.text;
                      _update(id, name, roll, div);
                    },
                  ),
                ],
              ),
            ),
            Center(
              child: Column(
                children: <Widget>[
                  Container(
                    padding: const EdgeInsets.all(20),
                    child: TextField(
                      controller: idDeleteController,
                      decoration: const InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Student ID',
                      ),
                    ),
                  ),
                  ElevatedButton(
                    child: const Text('Delete'),
                    onPressed: () {
                      int id = int.parse(idDeleteController.text);
                      _delete(id);
                    },
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  void _insert(name, roll, div) async {
// row to insert
    Map<String, dynamic> row = {
      DatabaseHelper.columnName: name,
      DatabaseHelper.columnRoll: roll,
      DatabaseHelper.columnDiv: div,
    };
    Student student = Student.fromMap(row);
    final id = await dbHelper.insert(student);
    _showMessageInScaffold('inserted row id: $id');
  }

  void _queryAll() async {
    final allRows = await dbHelper.queryAllRows();
    students.clear();
    for (var row in allRows) {
      students.add(Student.fromMap(row));
    }
    _showMessageInScaffold('Query done.');
    setState(() {});
  }

  void _query(name) async {
    final allRows = await dbHelper.queryRows(name);
    studentByName.clear();
    for (var row in allRows) {
      studentByName.add(Student.fromMap(row));
    }
  }

  void _update(id, name, roll, div) async {
    Student student = Student(id, name, roll, div);
    final rowsAffected = await dbHelper.update(student);
    _showMessageInScaffold('updated $rowsAffected row(s)');
  }

  void _delete(id) async {
    final rowsDeleted = await dbHelper.delete(id);
    _showMessageInScaffold('deleted $rowsDeleted row(s): row $id');
  }
}
